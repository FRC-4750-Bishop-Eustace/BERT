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
	public static final int LIFTER_MOTOR = 0; 
	public static final int FRONT_LEFT_MOTOR = 1;
	public static final int BACK_LEFT_MOTOR = 4;
	public static final int FRONT_RIGHT_MOTOR = 2;
	public static final int BACK_RIGHT_MOTOR = 3;
	public static final int INTAKE_MOTOR = 5;
	public static final int SHOOTER_MOTOR = 6;
	public static final int AGITATOR_MOTOR = 7;
	
	
	//Motor Speeds; + is forward - is backwards; adjust speeds here and only here, everything else will follow
	public static final double SHOOTER_MOTOR_SPEED = .85;
	public static final double INTAKE_MOTOR_SPEED = -1;
	public static final double LIFTER_MOTOR_SPEED = 1; 
	public static final double AGITATOR_MOTOR_SPEED = -1;

	
	public static final int SELECTOR_HIGH_DIO = 1;  // (On switch, closest to the middle)
	public static final int SELECTOR_MID_DIO =2; // (on switch, between edge and middle)
	public static final int SELECTOR_LOW_DIO = 3; // (on switch, edge)

	//Timers
	public static final double REACH_TIME = 2;
	public static final double TURN_TIME = 2;

	//Cameras
	public static final int CAMERA1 = 0;
	public static final int CAMERA2 = 1;
	public static final int CAMERA3 = 2;
	public static final int CURRCAMERA = 3;
	
	//Analog Sensors
	public static final int GEAR_SENSOR = 0;
	public static final int RANGE_SENSOR = 1;
	
	//Digital Sensors
	public static final int PEG_SENSOR = 0;

}
