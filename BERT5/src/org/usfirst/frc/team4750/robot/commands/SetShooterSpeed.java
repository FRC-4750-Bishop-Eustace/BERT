package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetShooterSpeed extends Command {

	protected void execute(){
		// sets the shooter speed as per RobotMap
		Robot.shooter.setShooterSpeed(RobotMap.SHOOTER_MOTOR_SPEED);
		Robot.agitator.setAgitatorSpeed(RobotMap.AGITATOR_MOTOR_SPEED);
		Robot.agitator.setAgitator2Speed(RobotMap.AGITATOR2_MOTOR_SPEED);
		// used for debugging
		SmartDashboard.putBoolean("is SetShooterSpeed running?" , true);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		// so it stops when it is over
		Robot.shooter.setShooterSpeed(0);
		Robot.agitator.setAgitatorSpeed(0);
		Robot.agitator.setAgitator2Speed(0);
	}

}