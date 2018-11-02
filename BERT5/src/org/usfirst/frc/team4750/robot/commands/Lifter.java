package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Lifter extends Command {

  String ONE = "P168.L1.C11";
  String TWO = "P331.L13.C85";
  String THREE = "P46.L14.C56";
  String FOUR = "P97.L3.C6";
  String FIVE = "P222.L3.C5";
  String SIX = "P356.L8.C19";
  String SEVEN = "P403.L17.C40";
  String EIGHT = "P248.L16.C21";
  String NINE = "P62.L22.C57";
  String TEN = "P12.L1.C61";
  String ELEVEN = "P415.L12.C3";
	
	protected void execute(){
		System.out.println("Nigel Smart" + this);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end(){
    step10();
	}
}
