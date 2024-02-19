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

  //Creates new DriveTrain Object named driveTrain
  public final DriveTrain driveTrain;
  public final XboxController controller;

  public LineUp(DriveTrain driveTrain, XboxController controller) {
    this.driveTrain = driveTrain;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.mecDrive.setSafetyEnabled(false);
  }

  /* Called every time the scheduler runs while the command is scheduled.
     Creates an if statement so that if the reflective tape is greater 
     than 1 or less than -1, the robot shuffles to the right or to the
     left respectively
  */
  @Override
  public void execute() {
    //detects AprilTags from the limelight
    if(LimeLight.getX() > 1){
      driveTrain.mecDrive.driveCartesian(0, -.2, 0);
    }
    if(LimeLight.getX() < -1){
      driveTrain.mecDrive.driveCartesian(0, .2, 0);
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