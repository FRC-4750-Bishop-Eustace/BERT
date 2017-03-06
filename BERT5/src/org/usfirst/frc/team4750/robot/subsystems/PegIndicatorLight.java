/**
 * 
 */
package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author mkopack
 * indicator light to let the human player know they can pull the gear.
 */
public class PegIndicatorLight extends Subsystem {

	DigitalOutput light = new DigitalOutput(RobotMap.PEG_STATUS_LIGHT);
	
	
	/**
	 * 
	 */
	public PegIndicatorLight() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public PegIndicatorLight(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		light.set(false);
	}

	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Turns the light on or off
	 * @param onoff true turns light on, false turns it off.
	 */
	public void setLight(boolean onoff) {
		light.set(onoff);
	}

}
