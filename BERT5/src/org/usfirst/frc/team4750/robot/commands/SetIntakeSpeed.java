package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SetIntakeSpeed extends Command {

	protected void execute(){
		// this sets the speed of the intake based on what is set in the RobotMap
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_MOTOR_SPEED);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		// so it stops at the end
		Robot.intake.setIntakeSpeed(0);
	}

}
