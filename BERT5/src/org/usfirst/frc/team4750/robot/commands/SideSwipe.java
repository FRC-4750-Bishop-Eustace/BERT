package org.usfirst.frc.team4750.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4750.robot.Robot;

public class SideSwipe extends Command {
	int move;
	Timer timer;
	double drivetime;
	boolean leftorRight;
	int cameracenter;
	
	public SideSwipe(){
		requires(Robot.driveTrain);
		cameracenter = 320;
	}

	protected void initialize(){
		move = Robot.vision.peg;
		drivetime = .05*move;
		timer.start();
	}
	
	protected void execute(){
		if(move>cameracenter){
			Robot.driveTrain.driveSideways(-.2);
			leftorRight = true;
		}else{
			Robot.driveTrain.driveSideways(.2);
			leftorRight = false;
		}
	}
	
	@Override
	protected boolean isFinished() {
		if(timer.get()>drivetime) return true;
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		if(leftorRight == true){
			Robot.driveTrain.driveSideways(.2);
		}else if(leftorRight == false){
			Robot.driveTrain.driveSideways(-.2);
		}
	}

}
