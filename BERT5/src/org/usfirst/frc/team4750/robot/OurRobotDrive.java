/**
 * 
 */
package org.usfirst.frc.team4750.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 * @author mkopack
 *
 */
public class OurRobotDrive extends edu.wpi.first.wpilibj.RobotDrive {

	double cubicConstant = 0.1; 
	
	
	public OurRobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

	public void mecanumDrive_Cartesian(double x, double y, double z, int heading) {
		super.mecanumDrive_Cartesian(cubeValue(x), cubeValue(y), cubeValue(z), heading);
	}
	
	
	private double cubeValue(double value) {
		return (value * cubicConstant) + (1 - cubicConstant) * (value * value * value);
	}

}
