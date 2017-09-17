/**
 * 
 */
package org.usfirst.frc.team4750.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author mkopack
 *
 */
public class IMU extends Subsystem {

	AHRS ahrs; // navX-MXP IMU

	/**
	 * 
	 */
	public IMU() {
		// Resets IMU
		try {
			System.out.println("IMU Instantiating");
			// Communicates w/navX-MXP via the I2C Bus. */
			ahrs = new AHRS(SerialPort.Port.kUSB);
			ahrs.reset();
			System.out.println("IMU Setup...");

		} catch (Exception ex) {
			System.out.println("Error instantiating navX-MXP:  " + ex.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	/**
	 * resets the yaw, which should also reset the fusedheading value. So
	 * whichever direction the robot is facing is 0.
	 */
	public void reset() {
		ahrs.reset();
		ahrs.zeroYaw();
	}

	/**
	 * Returns the fused heading from the IMU. This should be the RELATIVE
	 * heading since the last reset
	 * 
	 * @return Relative heading since the last reset (which should be when the
	 *         command was set.
	 */
	public float getHeading() {
		// return ahrs.getFusedHeading();
		return ahrs.getYaw();
	}

}
