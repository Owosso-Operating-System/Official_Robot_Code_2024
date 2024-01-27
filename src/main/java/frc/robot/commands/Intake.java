// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends Command {
  /** Creates a new Intake. */
  // Creates new IntakeSubsystem Object named intakeSubsystem
  public final IntakeSubsystem intakeSubsystem;

  // Creates new XboxController Object named controller
  public final XboxController controller;

    /**Method: Intake
   * Parameters: IntakeSubsystem and XboxController
   * Variables used: intakeSubsystem and controller
   * What it does: Assigns the parameter IntakeSubsystem to intakeSubsystem
   *               Assigns the parameter XboxController to controller
   *               Uses addRequirements to tie IntakeSubsystem to Intake
   *  */

  public Intake(IntakeSubsystem intakeSubsystem, XboxController controller) {
    this.intakeSubsystem = intakeSubsystem;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

    /**Method: Intake
   * Parameters: None
   * Variables used: intakeSubsystem.intake and controller
   * What it does: Takes the controller outputs, passes the values to intake
   *  */
  @Override
  public void execute() {
    // While A is held, the intake speed is 1, otherwise it is 0
    if(controller.getAButton() == true){
      intakeSubsystem.intake.set(1);
    }else if (controller.getBButton() == true){
      intakeSubsystem.intake.set(-1);
    }else{
      intakeSubsystem.intake.set(0);
    }// While B is held, the intake speed is -1, otherwise it is 0
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
