// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.subsystems.DriveTrain;

/** Class: PIDMath
   * Creates PID command.
   * The class calculates the direction needed to face foreward.
   *  */

public class PIDTurn {
    //creates the kP, kI and, kD variables and assigns their numerical values
    static double kP = 0.00375;
    static double kI = 0.0000026345;
    static double kD = 0.0004965;
    
    //creates the proportional, integral and, derivative variables
    static double proportional;
    static double integral;
    static double derivative;
    
    //creates the kAngleSetpoint and SpeedLimit variables
    static double kAngleSetpoint;
    static double speedLimit = 0.10;
    
    //creates the error, totalError, and lastError variables and sets their numerical values to 0
    static double error = 0;
    static double totalError = 0;
    static double lastError = 0;

    //creates the speed variable and sets its numerical value to 0
    static double speed = 0;

    public static double getSpeed(DriveTrain driveTrain, int setAngle){
    
        //Takes all of the preveous variables and takes the gyro values and puts them through this function 
        // allow the robot to smoothly travel to a specific angle

        //Takes angle at point called in commands and makes set angle
        kAngleSetpoint = setAngle;
       
        //Sets last error to the last recorded error value
        lastError = error;
        //Sets error to set angle - the current gyro angle of pitch
        error = kAngleSetpoint - DriveTrain.gyro.getYaw().getValueAsDouble();
        //Sets total error to equal all error add together
        totalError += error;
     
        //Sets proptional value
        proportional = error * kP;
        //Sets integral value
        integral = totalError * kI;
        //Sets derivative value
        derivative = (error - lastError) * kD;
    
        //Sets output speed value
        double output = proportional + integral + derivative;
    
        //Sets a speed limit
        speedLimit = Math.copySign(speedLimit, output);

        if(output > 0){
            //If the output is greater than speedlimit, use speedlimit
            speed = output > speedLimit ? speedLimit : output;
        }
        else{
            //If output is less than negative speedlimit, go negative speedlimit
            speed = output < speedLimit ? speedLimit : output;
        }
        return speed;
        }
}