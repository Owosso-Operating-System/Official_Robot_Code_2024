// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.PIDTurn;
import frc.robot.subsystems.*;

public class GyroAuton extends Command {
  /** Creates a new GyroAuton. */
  //Makes a variable named driveTrain
  private DriveTrain driveTrain;
  private IntakeSubsystem intakeSubsystem;
  private PivotSubsystem pivotSubsystem;
  private ScoringSubsystem scoringSubsystem;
  private PIDTurn pidTurn;
  private Pigeon2 gyro;

  public GyroAuton(DriveTrain driveTrain,IntakeSubsystem intakeSubsystem, PivotSubsystem pivotSubsystem, ScoringSubsystem scoringSubsystem, PIDTurn pidTurn, Pigeon2 gyro) {
    this.driveTrain = driveTrain;
    this.intakeSubsystem = intakeSubsystem;
    this.pivotSubsystem = pivotSubsystem;
    this.scoringSubsystem = scoringSubsystem;
    this.pidTurn = pidTurn;
    this.gyro = gyro;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain, intakeSubsystem, pivotSubsystem, scoringSubsystem);
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
    driveTrain.mecDrive.driveCartesian(0, -.5, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(2);
    //Stops the robot and sets the scorer to full speed for .1 second
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
    scoringSubsystem.scorer.set(1);
    Timer.delay(.1);
    //Stops the scorer and moves the robot back at 1/10 speed for .2 seconds
    scoringSubsystem.scorer.set(0);
    driveTrain.mecDrive.driveCartesian(-.1, 0, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(.2);
    //Stops the robot moving back and rotates left for .3 seconds
    if(Pigeon2.getYaw >= -90)
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, -90));
    Timer.delay(.3);
    //Stops the robot moves the pivot down for .3 seconds
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
    pivotSubsystem.pivot.set(.5);
    Timer.delay(.3);
    //Sets the intake speed to -1 for .1 seconds to pick up a note
    intakeSubsystem.intake.set(1);
    Timer.delay(.1);
    //Stops the intake and rotates right for .3 seconds
    intakeSubsystem.intake.set(0);
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(.3);
    //Moves foreward at a 1/10 of teh speed for .2 seconds
    driveTrain.mecDrive.driveCartesian(.1, 0, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(.2);
    //Stops the robot and sets the scorer to speed to 1 for .1 second
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
    scoringSubsystem.scorer.set(1);
    Timer.delay(.1);
    //Stops the scorer and moves the robot left for 2.784 seconds
    scoringSubsystem.scorer.set(0);
    driveTrain.mecDrive.driveCartesian(0, -.5, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(2.784);
    //Stops the robot
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
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
