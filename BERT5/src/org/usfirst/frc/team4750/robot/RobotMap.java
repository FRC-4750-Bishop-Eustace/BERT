package org.usfirst.frc.team4750.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Joystick ports(USB) Check the driver station
	public static int DRIVE_STICK_USB_PORT = 0;
	
	
	//Motor ports(PWM) 
	public static final int LIFTER_MOTOR =0;
	public static final int FRONT_LEFT_MOTOR = 1;
	public static final int BACK_LEFT_MOTOR = 4;
	public static final int FRONT_RIGHT_MOTOR = 2;
	public static final int BACK_RIGHT_MOTOR = 3;
	public static final int INTAKE_MOTOR = 5;
	
	//Motor Speeds
	public static final double INATKE_MOTOR_SPEED = -.5;
	public static double LIFTER_MOTOR_SPEED = 0;


	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
