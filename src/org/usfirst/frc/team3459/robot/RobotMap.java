package org.usfirst.frc.team3459.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// These are backwards of normal robot because the "back" is what all teams are
	// using as the "front"
    public static int leftMotor = 1;
    public static int rightMotor = 0;
 // for drive station ports
    public static int driverStationDriveStickLeft = 0;
    public static int driverStationDriveStickRight = 1;
}
