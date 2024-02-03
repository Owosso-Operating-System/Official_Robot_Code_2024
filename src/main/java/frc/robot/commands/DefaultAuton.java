// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class DefaultAuton extends Command {
  /** Creates a new DefaultAuton. */
  //Makes a variable named driveTrain
  private DriveTrain driveTrain;
  private ScoringSubsystem scoringSubsystem;
  private PivotSubsystem pivotSubsystem;
  public DefaultAuton(DriveTrain driveTrain, ScoringSubsystem scoringSubsystem, PivotSubsystem pivotSubsystem) {
    this.driveTrain = driveTrain;
    this.scoringSubsystem = scoringSubsystem;
    this.pivotSubsystem = pivotSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    /* 
    //Set the driveTrain speed to -0.2
    driveTrain.mecDrive.driveCartesian(-.2, 0, 0);
    //Waits for 5 seconds
    Timer.delay(5);
    //Stops the robot 
    driveTrain.mecDrive.driveCartesian(0, 0, 0);
    //Runs isFinished
    isFinished();
    */
    //Moves the robot left at half speed for 2 seconds
    driveTrain.mecDrive.driveCartesian(0, -.5, 0);
    Timer.delay(2);
    //Stops the robot and sets the scorer to full speed for .1 second
    driveTrain.mecDrive.driveCartesian(0, 0, 0);
    scoringSubsystem.scorer.set(1);
    Timer.delay(.1);
    //Stops the scorer and moves the robot back at 1/10 speed for .2 seconds
    scoringSubsystem.scorer.set(0);
    driveTrain.mecDrive.driveCartesian(-.1, 0, 0);
    Timer.delay(.2);
    //Stops the robot moving back and rotates left for .3 seconds
    driveTrain.mecDrive.driveCartesian(0, 0, -.5);
    Timer.delay(.3);
    //Stops the robot moves the pivot down for .3 seconds
    driveTrain.mecDrive.driveCartesian(0, 0, 0);
    pivotSubsystem.pivot.set(.5);
    Timer.delay(.3);
    //Sets the scorer speed to -1 for .1 seconds to pick up a note
    scoringSubsystem.scorer.set(-1);
    Timer.delay(.1);
    //Stops the scorer and rotates right for .3 seconds
    scoringSubsystem.scorer.set(0);
    driveTrain.mecDrive.driveCartesian(0, 0, .5);
    Timer.delay(.3);
    //Moves foreward at a 1/10 of teh speed for .2 seconds
    driveTrain.mecDrive.driveCartesian(.1, 0, 0);
    Timer.delay(.2);
    //Stops the robot and sets the scorer to speed to 1 for .1 second
    driveTrain.mecDrive.driveCartesian(0, 0, 0);
    scoringSubsystem.scorer.set(1);
    Timer.delay(.1);
    //Stops the scorer and moves the robot left for 2.784 seconds
    scoringSubsystem.scorer.set(0);
    driveTrain.mecDrive.driveCartesian(0, -.5, 0);
    Timer.delay(2.784);
    //Stops the robot
    driveTrain.mecDrive.driveCartesian(0, 0, 0);
    //Runs isFinished 
    isFinished();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
