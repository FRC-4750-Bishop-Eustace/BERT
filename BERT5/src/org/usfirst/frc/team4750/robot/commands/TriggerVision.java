/**
 * 
 */
package org.usfirst.frc.team4750.robot.commands;

import org.usfirst.frc.team4750.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author mkopack
 *
 */
public class TriggerVision extends Command {

	
	public void execute() {
		System.out.println("TriggerVision");
		SmartDashboard.putDouble("Offset Angle", Robot.vision.getHeadingOffset());
	}
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// only execute the one time so quit.
		return true;
	}

}
