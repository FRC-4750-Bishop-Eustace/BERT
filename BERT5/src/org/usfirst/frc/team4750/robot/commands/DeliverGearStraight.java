package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DeliverGearStraight extends CommandGroup {

	public DeliverGearStraight(){
		addSequential(new TrackGear());
		addSequential(new AutoMove(.295, -.295, 1.8f));
		addSequential(new WaitForGear());
	}

	
	public void initialize() {
		System.out.println("Executing DeliverGearStraight!!!");
	}
}
