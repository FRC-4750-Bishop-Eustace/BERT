package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lifting extends Command {
	
	
	protected void execute(){
		RobotMap.LIFTER_MOTOR_SPEED = Robot.oi.driveStick.getRawAxis(2);
				
		if(Robot.oi.driveStick.getRawAxis(2) >= .5 ){
			//this tells the robot to start lifting at the speed set at that var
			Robot.lifter.setLifterSpeed(RobotMap.LIFTER_MOTOR_SPEED);
			}
		else{
			Robot.lifter.setLifterSpeed(0);
			}
				
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end(){
		//this makes sure the lifter stops when it is ended
		Robot.lifter.setLifterSpeed(0);
	}
}
