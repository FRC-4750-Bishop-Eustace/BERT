package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lifting extends Command {
	
	protected void execute(){
		//this tells the robot to start lifting at the speed set at that var
		Robot.lifter.setLifterSpeed(RobotMap.LIFTER_MOTOR_SPEED);
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
