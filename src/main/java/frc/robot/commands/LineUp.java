// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.LimeLight;
import frc.robot.subsystems.DriveTrain;

public class LineUp extends Command {

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  //Creates new DriveTrain Object named driveTrain
  public final DriveTrain driveTrain;
  public final XboxController controller;
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  double tx = table.getEntry("tx").getDouble(0.0);

  public LineUp(DriveTrain driveTrain, XboxController controller) {
    this.driveTrain = driveTrain;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  /* Called every time the scheduler runs while the command is scheduled.
     Creates an if statement so that if the reflective tape is greater 
     than 1 or less than -1, the robot shuffles to the right or to the
     left respectively
  */
  @Override
  public void execute() {
    //detects reflective materials from the limelight
    double headingError = -tx;
    double steeringAdjust = 0.0;

    if(table.getValue("tid").getDouble() == 15 || table.getValue("tid").getDouble() == 6){
        if (Math.abs(headingError) > 1.0) {
          if (headingError < 0) {
            steeringAdjust = 0.00375 * headingError + 0.01;
          } else {
            steeringAdjust = 0.00375 * headingError - 0.05;
          }
        }
        driveTrain.mecDrive.driveCartesian(0, steeringAdjust, 0);
    }else{
      driveTrain.mecDrive.driveCartesian(0, 0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}