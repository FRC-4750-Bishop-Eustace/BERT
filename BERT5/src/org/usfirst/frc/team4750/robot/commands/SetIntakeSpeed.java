package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SetIntakeSpeed extends Command {

	protected void execute(){
		Robot.intake.setIntakeSpeed(RobotMap.INATKE_MOTOR_SPEED);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.intake.setIntakeSpeed(0);
	}

}
