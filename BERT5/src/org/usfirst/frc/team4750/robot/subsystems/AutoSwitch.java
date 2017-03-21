/**
 * 
 */
package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.AutoMode;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author mkopack
 * This models the mechanical 5 position switch that we use to select between autonomous modes
 */
public class AutoSwitch extends Subsystem {

	DigitalInput highinput;
	DigitalInput midinput;
	DigitalInput lowinput;
	
	
	private static int value;
	public AutoSwitch() {
		highinput = new DigitalInput(RobotMap.SELECTOR_HIGH_DIO);
		midinput = new DigitalInput(RobotMap.SELECTOR_MID_DIO);
		lowinput = new DigitalInput(RobotMap.SELECTOR_LOW_DIO);
	}
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public AutoMode getMode() {
		
		/**
		 * HIGH    MID    LOW     SWITCHPOS
		 * T        T      F         1
		 * T        F      F         2
		 * T        F      T         3
		 * F        F      T         4
		 * F        T      T         5
		 */
			
		boolean highval = highinput.get();
		boolean midval = midinput.get();
		boolean lowval = lowinput.get();
		int switchpos=0;
		
		if(highval && midval && ! lowval) switchpos =1;
		else if(highval && !midval && !lowval) switchpos = 2;
		else if(highval && !midval && lowval) switchpos = 3;
		else if(!highval && !midval && lowval) switchpos = 4;
		else if(!highval && midval && lowval) switchpos = 5;
		else switchpos =1;
		//Now that we know which position our switch is in, let's assign the proper autogroup to execute.
		
		/*
		 * Position 1 - Facing center of arena, start on Right side. Go to rightmost gear delivery, then move towards center of arena
		 * Position 2 - Facing center of arena, start at middle. Deliver to center gear delivery location
		 * Position 3 - Facing center of arena, start at left side, delivery to left gear delivery location, then move towards center of arena
		 * Position 4 - Facing center of arena, start at left side, delivery to left gear delivery location, then go to shooting
	 	 * Position 5 - do nothing
	 	 */
		
		
		if(switchpos ==1){
			SmartDashboard.putNumber("AutoSwitch.Position", switchpos);
			return AutoMode.MOVE_FORWARD;
		}else if(switchpos == 2){
			SmartDashboard.putNumber("AutoSwitch.Position", switchpos);
			return AutoMode.START_LEFT_SIDE_RED;
		}else if(switchpos == 3){
			SmartDashboard.putNumber("AutoSwitch.Position", switchpos);
			return AutoMode.START_RIGHT_SIDE_RED;
		}else if(switchpos == 4){
			SmartDashboard.putNumber("AutoSwitch.Position", switchpos);
			return AutoMode.START_RIGHT_SIDE_BLUE;
		}else if(switchpos == 5){
			SmartDashboard.putNumber("AutoSwitch.Position", switchpos);
			return AutoMode.START_LEFT_SIDE_BLUE;
		}
		
		
		
		SmartDashboard.putBoolean("AutoSwitch.High",highval);
		SmartDashboard.putBoolean("AutoSwitch.Mid",midval);
		SmartDashboard.putBoolean("AutoSwitch.low",lowval);
		
		SmartDashboard.putNumber("AutoSwitch.Position", switchpos);
		
		return null;
	}

}
