package org.usfirst.frc.team4750.robot.subsystems;

import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Agitator extends Subsystem {

	// Defines motors
	VictorSP agitatorMotor = new VictorSP(RobotMap.AGITATOR_MOTOR);
	VictorSP agitatorMotor2 = new VictorSP(RobotMap.AGITATOR_MOTOR2);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void setAgitatorSpeed(double speed) {
		// Sets motor speed from RobotMap
		agitatorMotor.set(speed);
	}

	public void setAgitator2Speed(double speed) {
		// Sets motor speed from RobotMap
		agitatorMotor2.set(speed);
	}

}
