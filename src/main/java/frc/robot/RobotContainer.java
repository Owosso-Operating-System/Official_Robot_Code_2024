// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DefaultAuton;
import frc.robot.commands.Climb;
import frc.robot.commands.Drive;
import frc.robot.commands.GyroAuton;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.commands.Intake;
import frc.robot.commands.Pivot;
import frc.robot.commands.Scoring;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.ScoringSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Create new driveTrain Object
  private final DriveTrain driveTrain;
  //Create new ClimbSubsystem Object
  private final ClimbSubsystem climbSubsystem;
  // Create new intakeSubsystem Object
  private final IntakeSubsystem intakeSubsystem;
  //Create new scoringSubsystem Object
  private final ScoringSubsystem scoringSubsystem;
  //Create new PivotSubsystem Object
  private final PivotSubsystem pivotSubsystem;
  //Create new controller Object
  private final XboxController controller0;
  private final XboxController controller1;

  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // add in new driveTrain
    driveTrain = new DriveTrain();
    // add in new climbSubsystem
    climbSubsystem = new ClimbSubsystem();
    // add in new intakeSubsystem
    intakeSubsystem = new IntakeSubsystem();
    // add in new scoringSubsystem
    scoringSubsystem = new ScoringSubsystem();
    // add in new pivotSubsystem
    pivotSubsystem = new PivotSubsystem();
    // add in new controllers
    controller0 = new XboxController(0);
    controller1 = new XboxController(1);

    // set Default Command for driveTrain passing in the driveTrain and controller0
    driveTrain.setDefaultCommand(new Drive(driveTrain, controller0));
    // set Default Command for climbSubsystem passing in the climbSubsystem and controller0
    climbSubsystem.setDefaultCommand(new Climb(climbSubsystem, controller0));
    // set Default Command for intakeSubsystem passing in the intakeSubsystem and controller0
    intakeSubsystem.setDefaultCommand(new Intake(intakeSubsystem, controller0));
    // set Default Command for scoringSubsystem passing in the scoringSubsystem and controller0
    scoringSubsystem.setDefaultCommand(new Scoring(scoringSubsystem, controller0));
    // set Default Command for pivotSubsystem passing in the pivotSubsystem and the controller1
    pivotSubsystem.setDefaultCommand(new Pivot(pivotSubsystem, controller1));
    // Configure the button bindings  
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(controller0, XboxController.Button.kB.value).whileTrue(new Intake(intakeSubsystem, controller0));
    new JoystickButton(controller0, XboxController.Button.kA.value).whileTrue(new Intake(intakeSubsystem, controller0));
    new JoystickButton(controller0, XboxController.Button.kX.value).whileTrue(new Intake(intakeSubsystem, controller0));
    new JoystickButton(controller0, XboxController.Button.kRightBumper.value).whileTrue(new Scoring(scoringSubsystem,controller0));
    new JoystickButton(controller0, XboxController.Button.kLeftBumper.value).whileTrue(new Scoring(scoringSubsystem,controller0));
  }

   /**Method: GetAutonomousCommand
   * Parameters: N/A
   * Variables used: autonName
   * What it does: Gets the string from the dashboard 
   *               so the correct auton is run.
   *  */

  public Command getAutonomousCommand() {
    // Makes the string of autons that we use in the drop down and sets the default
    String autoName = SmartDashboard.getString("Auto Selector", "Default");

    // Adds the cases to the drop down
    switch(autoName){
      //cases go here
      case "Default":
        return new DefaultAuton(driveTrain, intakeSubsystem, pivotSubsystem, scoringSubsystem);

      case "Gyro":
        return new GyroAuton(driveTrain, intakeSubsystem, pivotSubsystem, scoringSubsystem);
    }
    return null;
  }
}
