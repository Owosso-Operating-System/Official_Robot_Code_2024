// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.PIDTurn;
import frc.robot.subsystems.*;

public class PIDAuton extends Command {
  /** Creates a new PIDAuton. */
  //Makes a variable named driveTrain
  private DriveTrain driveTrain;
  private IntakeSubsystem intakeSubsystem;
  private ConveyorBelt conveyorBelt;
  private ScoringSubsystem scoringSubsystem;
  private Pigeon2 gyro;

  public PIDAuton(DriveTrain driveTrain,IntakeSubsystem intakeSubsystem, ConveyorBelt conveyorBelt, ScoringSubsystem scoringSubsystem, Pigeon2 gyro) {
    this.driveTrain = driveTrain;
    this.intakeSubsystem = intakeSubsystem;
    this.conveyorBelt = conveyorBelt;
    this.scoringSubsystem = scoringSubsystem;
    this.gyro = gyro;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain, intakeSubsystem, conveyorBelt, scoringSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Safety is disabled
    driveTrain.mecDrive.setSafetyEnabled(false);

    //Moves the robot left at half speed for 2 seconds
    driveTrain.mecDrive.driveCartesian(0, -.5, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(2);
    //Stops the robot and sets the scorer to full speed for .1 second
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
    scoringSubsystem.scorerL.set(1);
    scoringSubsystem.scorerR.set(1);
    Timer.delay(.1);
    //Stops the scorer and moves the robot back at 1/10 speed for .2 seconds
    scoringSubsystem.scorerL.set(0);
    scoringSubsystem.scorerR.set(0);
    driveTrain.mecDrive.driveCartesian(-.1, 0, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(.2);
    //Stops the robot moving back and rotates left for .3 seconds
    while(gyro.getYaw().getValue() >= -90){
      driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, -90));
    }
    //Stops the robot moves the Belt down for .3 seconds
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, -90));
    conveyorBelt.belt.set(.5);
    Timer.delay(.3);
    //Sets the intake speed to -1 for .1 seconds to pick up a note
    intakeSubsystem.intake.set(1);
    Timer.delay(.1);
    //Stops the intake and rotates right for .3 seconds
    intakeSubsystem.intake.set(0);
    while(gyro.getYaw().getValue() <= 0){
      driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
    }
    //Moves foreward at a 1/10 of teh speed for .2 seconds
    driveTrain.mecDrive.driveCartesian(.1, 0, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(.2);
    //Stops the robot and sets the scorer to speed to 1 for .1 second
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
    scoringSubsystem.scorerL.set(1);
    scoringSubsystem.scorerR.set(1);
    Timer.delay(.1);
    //Stops the scorer and moves the robot left for 2.784 seconds
    scoringSubsystem.scorerL.set(0);
    scoringSubsystem.scorerR.set(0);
    driveTrain.mecDrive.driveCartesian(0, -.5, PIDTurn.getSpeed(driveTrain, 0));
    Timer.delay(2.784);
    //Stops the robot
    driveTrain.mecDrive.driveCartesian(0, 0, PIDTurn.getSpeed(driveTrain, 0));
    //Runs isFinished 
    isFinished();

  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
