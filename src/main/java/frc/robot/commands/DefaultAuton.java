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
  private HandoffSubsystem handoffSubsystem;
  public DefaultAuton(DriveTrain driveTrain, ScoringSubsystem scoringSubsystem, HandoffSubsystem handoffSubsystem) {
    this.driveTrain = driveTrain;
    this.scoringSubsystem = scoringSubsystem;
    this.handoffSubsystem = handoffSubsystem;
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
    driveTrain.mecDrive.driveCartesian(0, -.5, 0);
    Timer.delay(2);
    driveTrain.mecDrive.driveCartesian(0, 0, 0);
    scoringSubsystem.scorer.set(1);
    Timer.delay(.1);
    scoringSubsystem.scorer.set(0);
    driveTrain.mecDrive.driveCartesian(-.1, 0, 0);
    Timer.delay(.2);
    driveTrain.mecDrive.driveCartesian(0, 0, -.5);
    Timer.delay(.3);
    driveTrain.mecDrive.driveCartesian(0, 0, 0);
    handoffSubsystem.handoff.set(.5);
    Timer.delay(.3);
    scoringSubsystem.scorer.set(-1);
    Timer.delay(.1);
    scoringSubsystem.scorer.set(0);
    driveTrain.mecDrive.driveCartesian(0, 0, .5);
    Timer.delay(.3);
    driveTrain.mecDrive.driveCartesian(.1, 0, 0);
    Timer.delay(.2);
    driveTrain.mecDrive.driveCartesian(0, 0, 0);
    scoringSubsystem.scorer.set(1);
    Timer.delay(.1);
    scoringSubsystem.scorer.set(0);
    driveTrain.mecDrive.driveCartesian(0, -.5, 0);
    Timer.delay(2.784);
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
