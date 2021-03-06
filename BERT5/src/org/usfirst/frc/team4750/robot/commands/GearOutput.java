package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;
/**
 *
 */
public class GearOutput extends Command {
	public GearOutput() {
		// Use requires() here to declare subsystem dependencies
		//requires(Robot.exampleSubsystem);
		requires(Robot.gear);
	}
	
	AnalogInput input = new AnalogInput(RobotMap.GEAR_SENSOR);

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		Robot.gear.Output();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
