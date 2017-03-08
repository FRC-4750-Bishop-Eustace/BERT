/**
 * 
 */
package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Use this to perform a controlled automatic turn to a given heading.
 * 
 * The basic idea here is to take in an amount to turn in degrees.
 * Then, use what's called a PID controller to control how fast we need the motors to turn to 
 * change the heading. The closer we are to the target heading the slower we command the motors
 * so we don't overshoot.
 * 
 */
public class TurnToHeading extends Command {

	float offset;
	float targetheading;
	float startheading;
	float lastheadingread;
	
	float displacement;
	float difference;
	
	
	/**
	 * Constructor.
	 * @param offset degrees we need to turn to reach goal. Often this will come from the vision system. 
	 * Negative numbers indicate a left turn, positive are a right turn.
	 */
	public TurnToHeading(float offset) {
		requires(Robot.imu);
		requires(Robot.driveTrain);
		this.offset = offset;
	}
	
	
	@Override
	protected void initialize() {
		System.out.println("Executing TurnToHeading..."+offset);
		Robot.imu.reset();
		System.out.println("IMU Reset...");
	}
	
	
	//@Override
	protected void oldinitialize() {
		System.out.println("Executing TurnToHeading..."+offset);
		Robot.imu.reset();
		
		SmartDashboard.putBoolean("TurnToHeading.IMUCalibrated", true);
		System.out.println("IMU calibrated");
		// READ FROM IMU!!! Note, the heading returned here is absolute!!! Not relative.
		startheading = Robot.imu.getHeading();
		
		targetheading = startheading + offset;
		// handle the under/overflow conditions where we cross 360/0
		if(targetheading < 0)
			targetheading = 360+targetheading;
		if(targetheading > 360)
			targetheading = targetheading-360;
		System.out.println("TurnToHeading.CurrentHeading"+ startheading);
		System.out.println("TurnToHeading.TargetHeading"+ targetheading);
		System.out.println("TurnToHeading.Offset"+ offset);
		SmartDashboard.putNumber("TurnToHeading.CurrentHeading", startheading);
		SmartDashboard.putNumber("TurnToHeading.TargetHeading", targetheading);
		SmartDashboard.putNumber("TurnToHeading.Offset", offset);
	}
	
	@Override
	protected void execute() {
		displacement = Robot.imu.getHeading();
		
		// Displacement    Offset   Difference   Speed Direction
		//    -30            -60       -30                Left
		//     30            60         30                Right
		//     62            60         -2                Left
		//     -70           -60        10                Right
		
		/// offset - displacement
		difference = offset-displacement;
		
		// the farther off the target we are, the higher we need to set the motors
		// speed/1.0 = degreesofftarget/180;
		float speed = (offset/180.0f) *1.0f;

		// note that there IS a minimum power setting or else we won't turn at all (motors will stall)
		// so if we're commanding less than say .25, set it to .25 and then adjust the sign to match what it was.
		if(Math.abs(speed) < .25) {
			if(speed<0)
				speed=-0.25f;
			else
				speed=0.25f;
		}
		SmartDashboard.putNumber("TurnToHeading.Displacement", displacement);
		SmartDashboard.putNumber("TurnToHeading.Offset", offset);
		SmartDashboard.putNumber("TurnToHeading.Speed", speed);
		Robot.driveTrain.setDriveMotors(speed, speed);
	}
	
	// Called repeatedly when this Command is scheduled to run
	//@Override
	protected void oldexecute() {
		
		SmartDashboard.putString("TurnToHeading.IMU Setup?", "Running");
		// read the current value from the IMU.
		lastheadingread = Robot.imu.getHeading(); // READ FROM IMU
		
		// find the difference between where we are now and where we're trying to get to
		
		/*
		 * Target     Last     Offset
		 * -------    ----     ------
		 * 340         10       -30
		 *  10        340        30
		 * 120        190       -70
		 * 190        120        70   
		 */
		
		/*  If absolute value of Target - currentheading < 180 then offset = target-currentheading.
		 * 	else 
		 * 		if target-heading > 0  then offset = target-heading-360
		 * 		else if target-heading < 0 then offset = target - heading + 360.
		 * 		else if target-heading == 0 then offset = 0;
		 */

		if(Math.abs(targetheading - lastheadingread) < 180) {
			offset = targetheading - lastheadingread;
		} else {
			if(targetheading - lastheadingread > 0) {
				offset = targetheading - lastheadingread-360;
			} else if(targetheading - lastheadingread < 0) {
				offset = targetheading - lastheadingread+360;
			}
			else
				offset = 0;
		}
		
		
		// the farther off the target we are, the higher we need to set the motors
		// speed/1.0 = degreesofftarget/180;
		float speed = (offset/180.0f) *1.0f;

		// note that there IS a minimum power setting or else we won't turn at all (motors will stall)
		// so if we're commanding less than say .2, set it to .2 and then adjust the sign to match what it was.
		if(Math.abs(speed) < .25) {
			if(speed<0)
				speed=-0.25f;
			else
				speed=0.25f;
		}
		// now tell it to turn!
		SmartDashboard.putNumber("TurnToHeading.CurrentHeading", lastheadingread);
		SmartDashboard.putNumber("TurnToHeading.TargetHeading", targetheading);
		SmartDashboard.putNumber("TurnToHeading.Offset", offset);
		SmartDashboard.putNumber("TurnToHeading.Speed", speed);
		//System.out.println("TargetHeading:"+targetheading+"  Currentheading:"+lastheadingread+"   Offset:"+offset+"  Speed:"+speed);
		Robot.driveTrain.setDriveMotors(speed, speed);
	}
	
	
	@Override
	protected boolean isFinished() {
		
		// see if we're within 2 degrees of the target. That should be close enough.
		if(Math.abs(difference)<2.0) {
			// close enough!
			return true;
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	//@Override
	protected boolean oldisFinished() {
		// TODO Auto-generated method stub
		// if we're within 2 degrees of the target,
		if (Math.abs(offset) <2.0) {
			//close enough!
			System.out.println("Done turning! Offset="+offset);
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// let's stop
		Robot.driveTrain.setDriveMotors(0.0, 0.0);
		SmartDashboard.putString("TurnToHeading.IMU", "ENDED!!!");
		System.out.println("Done turning! Difference= "+difference);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		SmartDashboard.putBoolean("TurnToHeading.interrupted()", true);
	}
}
