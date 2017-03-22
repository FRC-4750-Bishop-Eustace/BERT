package org.usfirst.frc.team4750.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4750.robot.commands.AutoMove;
import org.usfirst.frc.team4750.robot.commands.DeliverGearLeftSideBlue;
import org.usfirst.frc.team4750.robot.commands.DeliverGearLeftSideRed;
import org.usfirst.frc.team4750.robot.commands.DeliverGearRightSideBlue;
import org.usfirst.frc.team4750.robot.commands.DeliverGearRightSideRed;
import org.usfirst.frc.team4750.robot.commands.DeliverGearStraight;
import org.usfirst.frc.team4750.robot.commands.TurnToHeading;
import org.usfirst.frc.team4750.robot.subsystems.Agitator;
import org.usfirst.frc.team4750.robot.subsystems.AutoSwitch;
import org.usfirst.frc.team4750.robot.subsystems.Camera;
import org.usfirst.frc.team4750.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4750.robot.subsystems.Intake;
import org.usfirst.frc.team4750.robot.subsystems.Lifter;
import org.usfirst.frc.team4750.robot.subsystems.Shooter;
import org.usfirst.frc.team4750.robot.subsystems.GearDetector;
import org.usfirst.frc.team4750.robot.subsystems.GripPipeline;
import org.usfirst.frc.team4750.robot.subsystems.IMU;
import org.usfirst.frc.team4750.robot.subsystems.PegDetector;
import org.usfirst.frc.team4750.robot.subsystems.RelaySwitch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain(
			   RobotMap.FRONT_LEFT_MOTOR,
			   RobotMap.BACK_LEFT_MOTOR,
			   RobotMap.FRONT_RIGHT_MOTOR,
			   RobotMap.BACK_RIGHT_MOTOR);

	//this defines the subsystems so they can be called along with their subclasses
	public static final Shooter shooter = new Shooter();
	public static final Intake intake = new Intake();
	public static final Agitator agitator = new Agitator();
	public static final Lifter lifter = new Lifter();
	//public static final Camera camera = new Camera();
	public static final GearDetector gear = new GearDetector();
	public static final PegDetector peg = new PegDetector();
	public static final RelaySwitch relay = new RelaySwitch();
	public static final IMU imu = new IMU();

	public static OI oi;
	public static final AutoSwitch autoswitch = new AutoSwitch();

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	public static int cameraposition = 0;
	
	AutoMode autoMode;
	
	public static UsbCamera camera;
	public static GripPipeline vision;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		//sets up camera
		camera = CameraServer.getInstance().startAutomaticCapture(0);
		camera.setResolution(640, 480);
		vision = new GripPipeline();
		
		//Set the mode we're going to run in Autonomous...
		// Normally we'd read this from the mechanical switch
		autoMode = Robot.autoswitch.getMode();
		
		// Ok, see which position the switch is in
		switch(autoMode){
		
			//start middle
			case MOVE_FORWARD:
				autonomousCommand = new DeliverGearStraight();
				break;
				
			//Start left side on Red
			case START_LEFT_SIDE_RED:
				autonomousCommand = new DeliverGearLeftSideRed();
				break;
				
			//start right side on Red
			case START_RIGHT_SIDE_RED:
				autonomousCommand = new DeliverGearRightSideRed();
				break;
				
			//start right side on Blue
			case START_RIGHT_SIDE_BLUE:
				autonomousCommand = new DeliverGearRightSideBlue();
				break;
				
			//start left side on Blue
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
		// start running the autonomous command group that was created
		SmartDashboard.putBoolean("Robot.autonomousInit()",true);
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putBoolean("Robot.autonomousPeriodic()",true);
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		// if we didn't previously initialize (because in testing we skipped the autonomous mode)
		// go ahead and initialize it now.
		//if(!camera.isInitialized())
			//camera.init();
		
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
		
		// if there's a peg AND we have a gear loaded, turn the LED ring ON, ready to retrieve.
		if(Robot.peg.Output() == true && Robot.gear.Output()) 
			Robot.relay.relaySwitch(true);
		else {
			// otherwise turn it off
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
