package org.usfirst.frc.team4750.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.commands.DeliverGearLeftSideBlue;
import org.usfirst.frc.team4750.robot.commands.DeliverGearLeftSideRed;
import org.usfirst.frc.team4750.robot.commands.DeliverGearRightSideBlue;
import org.usfirst.frc.team4750.robot.commands.DeliverGearRightSideRed;
import org.usfirst.frc.team4750.robot.commands.DeliverGearStraight;
import org.usfirst.frc.team4750.robot.subsystems.Agitator;
import org.usfirst.frc.team4750.robot.subsystems.AutoSwitch;
import org.usfirst.frc.team4750.robot.subsystems.Camera;
import org.usfirst.frc.team4750.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4750.robot.subsystems.Intake;
import org.usfirst.frc.team4750.robot.subsystems.Lifter;
import org.usfirst.frc.team4750.robot.subsystems.Shooter;
import org.usfirst.frc.team4750.robot.subsystems.GearDetector;
import org.usfirst.frc.team4750.robot.subsystems.IMU;
import org.usfirst.frc.team4750.robot.subsystems.PegDetector;
import org.usfirst.frc.team4750.robot.subsystems.RelaySwitch;
import org.usfirst.frc.team4750.robot.subsystems.ServoMotor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// Instantiates drive train
	public static final DriveTrain driveTrain = new DriveTrain(RobotMap.FRONT_LEFT_MOTOR, RobotMap.BACK_LEFT_MOTOR,
			RobotMap.FRONT_RIGHT_MOTOR, RobotMap.BACK_RIGHT_MOTOR);

	// Defines subsystems
	public static final Shooter shooter = new Shooter();
	public static final Intake intake = new Intake();
	public static final Agitator agitator = new Agitator();
	public static final Lifter lifter = new Lifter();
	public static final Camera camera = new Camera();
	public static final GearDetector gear = new GearDetector();
	public static final PegDetector peg = new PegDetector();
	public static final RelaySwitch relay = new RelaySwitch();
	public static final IMU imu = new IMU();
	public static final ServoMotor gearServo = new ServoMotor();
	public static final AutoSwitch autoSwitch = new AutoSwitch();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	public static int cameraposition = 0;

	AutoMode autoMode;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();

		// Sets autonomous mode to switch mode
		autoMode = Robot.autoSwitch.getMode();

		// Assigns autonomous mode depending on switch mode
		switch (autoMode) {

		// Start middle
		case MOVE_FORWARD:
			autonomousCommand = new DeliverGearStraight();
			break;

		// Start left side Red
		case START_LEFT_SIDE_RED:
			autonomousCommand = new DeliverGearLeftSideRed();
			break;

		// Start right side Red
		case START_RIGHT_SIDE_RED:
			autonomousCommand = new DeliverGearRightSideRed();
			break;

		// Start right side Blue
		case START_RIGHT_SIDE_BLUE:
			autonomousCommand = new DeliverGearRightSideBlue();
			break;

		// Start left side Blue
		case START_LEFT_SIDE_BLUE:
			autonomousCommand = new DeliverGearLeftSideBlue();
			break;
		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		// Runs autonomous command
		SmartDashboard.putBoolean("Robot.autonomousInit()", true);
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putBoolean("Robot.autonomousPeriodic()", true);
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

		// Initialize camera
		// In case of skipping autonomous mode
		if (!camera.isInitialized())
			camera.init();

		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		// If there is a peg and the gear is loaded
		if (Robot.peg.Output() == true && Robot.gear.Output())
			// Turns relay switch (LED) on
			Robot.relay.relaySwitch(true);
		else {
			// Turns relay switch (LED) off
			Robot.relay.relaySwitch(false);
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
