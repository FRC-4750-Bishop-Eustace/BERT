package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DeliverGearStraight extends CommandGroup {

	public DeliverGearStraight(){
		addSequential(new AutoMove(.3, -.3, 2.6f));
		addSequential(new WaitForGear());
	}

	
	public void initialize() {
		System.out.println("Executing DeliverGearStraight!!!");
	}
}
