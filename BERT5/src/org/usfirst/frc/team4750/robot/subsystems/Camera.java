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

public class Camera extends Subsystem  {
	//defining cameras
	UsbCamera camera1;
	UsbCamera camera2;
	UsbCamera currcamera;
	
	boolean initialized = false;
	
	// Let's us keep track of which camera # is active
	int currcameranumber;
	
	CvSink cvSink; // pulls the frame from the camera
    CvSource outputStream; // pushes the frame to the dashboard
    
    Mat image = new Mat(); // holds the current frame
    
    VideoThread videothread;
    
    /**
     * Constructor
     */
	public Camera(){
		camera1 = new UsbCamera("USB Camera 1", RobotMap.CAMERA2);
		camera2 = new UsbCamera("USB Camera 2", RobotMap.CAMERA1);
		
		// start out with camera1 (which is the one used for CV anyhow
		currcamera = camera1;
		currcameranumber = 1;
		
	}
	
	/**
	 * Call this to get the cameras working after they've done their initial setup
	 */
	public void init() {
		//setting up FPS and Resolution
		camera2.setVideoMode(PixelFormat.kMJPEG, 160,120,10); // plug this one into the RoboRio, other one into the Hub.
	    
	    camera1.setVideoMode(PixelFormat.kMJPEG, 320,240,15); // THIS IS THE LOGITECH CAMERA!!! USE FOR VISION! THIS GOES IN HUB!
	    
	    
	    // Ok, now we need to set up the thread that Streams the video
	    CameraServer.getInstance().addCamera(currcamera);
	    videothread = new VideoThread();
	    videothread.start();
	    initialized=true;
	}
	
	/**
	 * Call this to see if we're done initializing the camera system.
	 * @return true if it's initialized, false if it's not.
	 */
	public boolean isInitialized() {
		return initialized;
	}
	
	/**
	 * Changes between the available cameras with wrap around
	 */
	public void cycle(){
		
		
		// increment to the next 
		currcameranumber++;
		if(currcameranumber>2) 
			currcameranumber = 1;
		
		// change currcamera to point to the newly active camera.
		if(currcameranumber == 1){
			currcamera = camera1;
		}else if(currcameranumber == 2){
			currcamera = camera2;
		}
		videothread.switchCam();
		
		
		// cycle the camera position (out of 4 stages) to change the drive angle
		// we will also need to do switching of the servos for the camera modes.
		Robot.cameraposition++;
		if(Robot.cameraposition==4) 
			Robot.cameraposition=0;
		SmartDashboard.putInt("CameraDirection", Robot.cameraposition*-90);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * This is a thread that will run on the side and handle the processing of the images. 
	 * Once we get it started, it'll keep streaming the video from whatever camera currcamera 
	 * is pointing at. Just for safety sake, we'll stop the thread (let it fall out of the while loop)
	 * and then throw away this instance of the thread, and then we'll set up a new thread once currcamera
	 * has switched over to the next camera in the cycle.
	 *
	 */
	private class VideoThread extends Thread {
	
		// This one indicates whether the thread should keep running or not.
		public boolean done;
		
		/**
		 * Constructor. Do any setup work prior to starting the thread.
		 */
		public VideoThread() {
			// get the camera working
			cvSink = CameraServer.getInstance().getVideo(currcamera);
			outputStream = CameraServer.getInstance().putVideo("Current View", 160, 120);
		    
		}
		
		public void switchCam() {	
			cvSink = CameraServer.getInstance().getVideo(currcamera);
		}
		/**
		 * Call this when you want the thread to stop.
		 */
		public void setDone() {
			done = true;
		}
		
		
		/**
		 * This is what gets called once the thread is going
		 */
		public void run() {
			cvSink.setEnabled(true);
			outputStream.setConnected(true);
			// keep doing whatever's in the while until we're told to stop.
			while(!done) {
				//streams camera feed
				cvSink.grabFrame(image);
				outputStream.putFrame(image);
			}
		}		
	}

}
	
