package org.usfirst.frc.team4750.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4750.robot.OurRobotDrive;
import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.commands.MecDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;


public class DriveTrain extends Subsystem {
	//motors
	private VictorSP f_rightMotor;
	private VictorSP f_leftMotor;
	private VictorSP b_rightMotor;
	private VictorSP b_leftMotor;
	
	//Drive
	private RobotDrive robotDrive;
		
	
	
	public DriveTrain(int frontLeftMotorPort, int backLeftMotorPort, int frontRightMotorPort, int backRightMotorPort){
		//puts motors into there ports.
		f_leftMotor = new VictorSP(frontLeftMotorPort);
		b_leftMotor = new VictorSP(backLeftMotorPort);
		f_rightMotor = new VictorSP(frontRightMotorPort);
		b_rightMotor = new VictorSP(backRightMotorPort);
		
		//sets up the where the robot calls each motor, with ramped joystick input
		robotDrive = new OurRobotDrive(f_leftMotor, b_leftMotor, f_rightMotor, b_rightMotor);
	}
	
	
	public void controllerDrive(Joystick i) {
		//sets up the joystick and which axis controls what. (x,y,rotation,gyro)
		//we pass inputs that are cube so we have better control when we make fine adjustments.
		robotDrive.mecanumDrive_Cartesian(i.getX(), i.getY(),i.getThrottle(), Robot.cameraposition*-180);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here. Links Subsystem to Command.
		setDefaultCommand(new MecDrive());
	}
	
	public void setLeftDriveMotor(double speed){
		//sets speed for left motors
		f_leftMotor.set(speed);
		b_leftMotor.set(speed);
	}
	public void setRightDriveMotor(double speed){
		//sets speed for right motors. must be inverted.
		f_rightMotor.set(-speed);
		b_rightMotor.set(-speed);
	}
	public void setDriveMotors(double leftspeed, double rightspeed) {
		//this is for use within other classes to set speeds.
		setLeftDriveMotor(leftspeed);
		setRightDriveMotor(rightspeed);
	}
}
