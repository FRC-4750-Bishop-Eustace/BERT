package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	// defines motor
	VictorSP shooterMotor = new VictorSP(RobotMap.SHOOTER_MOTOR);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void setShooterSpeed(double speed){
	//for debugging
	SmartDashboard.putBoolean("is Shooter running", true);
	
	// set the speed to a placeholder
	shooterMotor.set(speed);
	}

}
