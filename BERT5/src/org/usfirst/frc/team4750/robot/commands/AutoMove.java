package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.Robot;

import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class AutoMove extends Command {
	
	Timer timer;
	double leftSpeed, rightSpeed;
	float distance, wantDistance;
	AHRS ahrs;
	
	public AutoMove(double leftSpeed, double rightSpeed, float distance) {
		requires(Robot.driveTrain);
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
		this.distance = distance;
		//this.driveTime = driveTime;
		//timer = new Timer();
		try{
			ahrs = new AHRS(SerialPort.Port.kUSB);
			ahrs.resetDisplacement();
		}catch (Exception ex ) {
            System.out.println("Error instantiating navX-MXP:  "+ex.getMessage());
            SmartDashboard.putString("TurnToHeading.IMU Setup error", ex.getMessage());
    	}
		
	
		//SmartDashboard.putBoolean("AutoMove.AutoMove()", true);
		
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {	
		//timer.start();
		//SmartDashboard.getNumber("Timer:", timer.get());
		SmartDashboard.putBoolean("AutoMove.initialize()", true);
		ahrs.resetDisplacement();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.setLeftDriveMotor(leftSpeed);
		Robot.driveTrain.setRightDriveMotor(rightSpeed);
		wantDistance = ahrs.getDisplacementY();
		SmartDashboard.putNumber("DisplacementY", ahrs.getDisplacementY());
		SmartDashboard.putBoolean("AutoMove.execute()", true);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		SmartDashboard.putBoolean("AutoMove.isFinished()", true);
		if(wantDistance > distance) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		SmartDashboard.putBoolean("AutoMove.end()", true);
		Robot.driveTrain.setDriveMotors(0 , 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		SmartDashboard.putBoolean("AutoMove.interrupted()", true);
	}
}