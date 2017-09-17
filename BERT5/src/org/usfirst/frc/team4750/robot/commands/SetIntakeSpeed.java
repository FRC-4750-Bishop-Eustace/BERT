package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SetIntakeSpeed extends Command {

	protected void execute() {
		// Sets motor speed from RobotMap
		Robot.intake.setIntakeSpeed(RobotMap.INTAKE_MOTOR_SPEED);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// Sets motor speed to 0
		Robot.intake.setIntakeSpeed(0);
	}

}
