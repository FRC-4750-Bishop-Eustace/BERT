package org.usfirst.frc.team4750.robot.subsystems;

import org.opencv.core.Mat;
import org.usfirst.frc.team4750.robot.Robot;
import org.usfirst.frc.team4750.robot.RobotMap;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Camera extends Subsystem {

	// Defines cameras
	UsbCamera camera1;
	UsbCamera camera2;
	UsbCamera currcamera;

	boolean initialized = false;

	// Current camera number
	int currcameranumber;

	CvSink cvSink; // Grabs the frame from camera
	CvSource outputStream; // Pushes the frame to dashboard

	Mat image = new Mat(); // Holds the current frame

	VideoThread videothread;

	/**
	 * Constructor
	 */
	public Camera() {
		camera1 = new UsbCamera("USB Camera 1", RobotMap.CAMERA2);
		camera2 = new UsbCamera("USB Camera 2", RobotMap.CAMERA1);

		// Start with current camera
		currcamera = camera1;
		currcameranumber = 1;

	}

	/**
	 * Call this to get the cameras working after they've done their initial
	 * setup
	 */
	public void init() {
		// setting up FPS and Resolution
		camera2.setVideoMode(PixelFormat.kMJPEG, 160, 120, 10); // Microsoft
																// Lifecam 3000

		camera1.setVideoMode(PixelFormat.kMJPEG, 320, 240, 15); // Logitech C170

		// NOTE, might not need this next line! Might be causing it to add an
		// extra stream we don't need.
		CameraServer.getInstance().addCamera(currcamera);

		// Creates thread to stream video
		videothread = new VideoThread();
		videothread.start();
		initialized = true;
	}

	/**
	 * Call this to see if we're done initializing the camera system.
	 * 
	 * @return true if it's initialized, false if it's not.
	 */
	public boolean isInitialized() {
		return initialized;
	}

	/**
	 * Changes between the available cameras with wrap around
	 */
	public void cycle() {

		// Change to the next camera number
		currcameranumber++;
		if (currcameranumber > 2) {
			currcameranumber = 1;
		}

		// Change the current camera to the current camera number
		if (currcameranumber == 1) {
			currcamera = camera1;
		} else if (currcameranumber == 2) {
			currcamera = camera1;
		}
		// videothrea.switchCam();

		// Cycle the camera position to change the drive angle
		Robot.cameraposition++;
		if (Robot.cameraposition == 2) {
			Robot.cameraposition = 0;
		}
		if (Robot.cameraposition == 0) {
			SmartDashboard.putString("CameraDirection", "Front");
		}
		if (Robot.cameraposition == 1) {
			SmartDashboard.putString("CameraDirection", "Back");
		}
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	/**
	 * This is a thread that will run on the side and handle the processing of
	 * the images. Once we get it started, it'll keep streaming the video from
	 * whatever camera currcamera is pointing at. Just for safety sake, we'll
	 * stop the thread (let it fall out of the while loop) and then throw away
	 * this instance of the thread, and then we'll set up a new thread once
	 * currcamera has switched over to the next camera in the cycle.
	 *
	 */
	private class VideoThread extends Thread {

		// Creates boolean
		public boolean isFinished;

		/**
		 * Constructor. Do any setup work prior to starting the thread.
		 */
		public VideoThread() {
			// Put stream on dashboard
			cvSink = CameraServer.getInstance().getVideo(currcamera);
			outputStream = CameraServer.getInstance().putVideo("Current View", 160, 120);

		}

		/**
		 * Call this to switch to tell the streaming thread to switch to the new
		 * camera.
		 */
		public void oldswitchCam() {
			cvSink = CameraServer.getInstance().getVideo(currcamera);
		}

		/**
		 * Call this to switch to tell the streaming thread to switch to the new
		 * camera.
		 */
		public void switchCam() {
			setFinished();
			cvSink = CameraServer.getInstance().getVideo(currcamera);
			start();
		}

		/**
		 * Call this when you want the thread to stop.
		 */
		public void setFinished() {
			isFinished = true;
		}

		/**
		 * This is what gets called once the thread is going
		 */
		public void run() {
			System.out.println("Video Thread Started...");
			cvSink.setEnabled(true);
			outputStream.setConnected(true);
			// If not finished
			while (!isFinished) {
				// Streams camera feed
				cvSink.grabFrame(image);
				outputStream.putFrame(image);
			}
			System.out.println("Video Thread Done...");
			// Adds ability for testing
			cvSink.setEnabled(false);
			outputStream.setConnected(false);
		}
	}

}