package org.usfirst.frc.team4750.robot;

import org.usfirst.frc.team4750.robot.commands.Lifting;
import org.usfirst.frc.team4750.robot.commands.SetIntakeSpeed;
import org.usfirst.frc.team4750.robot.commands.SetShooterSpeed;
import org.usfirst.frc.team4750.robot.commands.SwitchCamera;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//Variables for cubing of the inputs
	public double driveStickXcube, driveStickYcube, driveStickTwistcube;
	
	//Define the Joystick
	public Joystick driveStick = new Joystick(RobotMap.DRIVE_STICK_USB_PORT);
	
	
	//Joystick buttons
	Button shootButton = new JoystickButton(driveStick, 1);
	Button intakeButton = new JoystickButton(driveStick, 2);
	Button lifterButton = new JoystickButton(driveStick, 3);
	Button cameraButton = new JoystickButton(driveStick, 5);
	//Button relayButton= new JoystickButton(driveStick, 5);
		
	public OI(){		
		//where the commands for the buttons are placed
		shootButton.toggleWhenPressed(new SetShooterSpeed());
		intakeButton.toggleWhenPressed(new SetIntakeSpeed());
		lifterButton.whileHeld(new Lifting());
		cameraButton.whenReleased(new SwitchCamera());
	}
}
