
package org.usfirst.frc.team3459.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3459.robot.RobotMap;
import org.usfirst.frc.team3459.robot.PT_RobotDrive;

/**
 * Don't change the name of this or it won't work. (The manifest looks for "Robot")
 */
public class Robot extends IterativeRobot {
	
	/*
	 * Member variables go here 
	 */
	PT_RobotDrive driveTrain;
	Joystick leftDriveStick;
	Joystick rightDriveStick;
	Joystick commandStick;
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        driveTrain = new PT_RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        driveTrain.setBackwards(true);
        leftDriveStick = new Joystick(RobotMap.driverStationDriveStickLeft);
        rightDriveStick = new Joystick(RobotMap.driverStationDriveStickRight);
        commandStick = new Joystick(RobotMap.driverStationCommandStick);
    }
    
    /**
     * This function is called periodically during operator control (approx 20ms)
     */
    public void teleopPeriodic() {
    	double leftDriveSpeed = leftDriveStick.getY();
    	double rightDriveSpeed = rightDriveStick.getY();
    	// Set Drivetrain motors
    	if(commandStick.getTrigger()){
    		// this causes the drive speed to be sent to both wheels as the same
    		// to make going forward and backwards easier.
    		double driveSpeed = commandStick.getY();
    		// so we don't destroy the field AGAIN by making it less sensitive in the middle
    		driveSpeed = driveSpeed / 2;
    		
    		driveTrain.arcadeDrive(driveSpeed, 0.0);
    	}
    	else if(leftDriveStick.getTrigger() || rightDriveStick.getTrigger()){
    		driveTrain.tankDrive(leftDriveSpeed, rightDriveSpeed);
    	}
    	else{
    		driveTrain.tankDrive(leftDriveSpeed / 2, rightDriveSpeed / 2);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run(); // This makes sure the values of items are correct on the driver station during test mode.   
    }
    
}
