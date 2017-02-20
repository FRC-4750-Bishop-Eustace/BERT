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
 * @author mkopack
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
	AHRS ahrs; // navX-MXP IMU
	
	/**
	 * Constructor.
	 * @param offset degrees we need to turn to reach goal. Often this will come from the vision system. 
	 * Negative numbers indicate a left turn, positive are a right turn.
	 */
	public TurnToHeading(float offset) {
		this.offset = offset;
	}
	
	@Override
	protected void initialize() {
		SmartDashboard.putBoolean("TurnToHeading.IMUCalibrated", false);
		//do a reset of the IMU here
		try
		{
			SmartDashboard.putString("TurnToHeading.IMU Setup?", "Instantiating");
            /* Communicate w/navX-MXP via the I2C Bus.                                       */			
            ahrs = new AHRS(SerialPort.Port.kUSB);
            ahrs.reset();
            SmartDashboard.putString("TurnToHeading.IMU Setup?", "Setup");
            
        } catch (Exception ex ) {
            System.out.println("Error instantiating navX-MXP:  "+ex.getMessage());
            SmartDashboard.putString("TurnToHeading.IMU Setup error", ex.getMessage());
    	}
		
		//read the IMU, store the value into startheading
		/*
		while(ahrs.isCalibrating()) {
			// do nothing, wait.
		}
		*/
		// done calibrating..
		SmartDashboard.putBoolean("TurnToHeading.IMUCalibrated", true);
		// READ FROM IMU!!!
		startheading = ahrs.getFusedHeading();
		
		targetheading = startheading + offset;
		// handle the under/overflow conditions where we cross 360/0
		if(targetheading < 0)
			targetheading = 360+targetheading;
		if(targetheading > 360)
			targetheading = targetheading-360;
		SmartDashboard.putNumber("TurnToHeading.CurrentHeading", startheading);
		SmartDashboard.putNumber("TurnToHeading.TargetHeading", targetheading);
		SmartDashboard.putNumber("TurnToHeading.Offset", offset);
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {		
		SmartDashboard.putString("TurnToHeading.IMU Setup?", "Running");
		// read the current value from the IMU.
		lastheadingread = ahrs.getFusedHeading(); // READ FROM IMU
		
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
		float speed = offset/180.0f;

		// note that there IS a minimum power setting or else we won't turn at all (motors will stall)
		// so if we're commanding less than say .2, set it to .2 and then adjust the sign to match what it was.
		if(Math.abs(speed) < .3) {
			if(speed<0)
				speed=-0.3f;
			else
				speed=0.3f;
		}
		// now tell it to turn!
		SmartDashboard.putNumber("TurnToHeading.CurrentHeading", lastheadingread);
		SmartDashboard.putNumber("TurnToHeading.TargetHeading", targetheading);
		SmartDashboard.putNumber("TurnToHeading.Offset", offset);
		SmartDashboard.putNumber("TurnToHeading.Speed", speed);
		//System.out.println("TargetHeading:"+targetheading+"  Currentheading:"+lastheadingread+"   Offset:"+offset+"  Speed:"+speed);
		Robot.driveTrain.setDriveMotors(speed, -1.0*speed);
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// if we're within 2 degrees of the target,
		if (Math.abs(offset) <2.0) {
			//close enough!
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// let's stop
		Robot.driveTrain.setDriveMotors(0.0, 0.0);
		SmartDashboard.putString("TurnToHeading.IMU Setup?", "ENDED!!!");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		SmartDashboard.putBoolean("TurnToHeading.interrupted()", true);
	}
}
