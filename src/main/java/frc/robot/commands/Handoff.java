// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.HandoffSubsystem;

public class Handoff extends Command {
  /** Creates a new HandOff. */
  // Creates new HandOff Object named handoff
 public final HandoffSubsystem handoffSubsystem;

  // Creates new XboxController Object named controller
  public final XboxController controller;

    /**Method: HandOff
   * Parameters: handOffSubsystem and XboxController
   * Variables used: handOffSubsystem and controller
   * What it does: Assigns the parameter handOffSubsystem to HandOffsubsystem
   *               Assigns the parameter XboxController to controller
   *               Uses addRequirements to tie handOffSubsystem to handOff
   *  */

  public Handoff(HandoffSubsystem handoffSubsystem, XboxController controller) {
    this.handoffSubsystem= handoffSubsystem;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(handoffSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

    /**Method:Handoff
   * Parameters: None
   * Variables used: handoffSubsystems and controller
   * What it does: Takes the controller outputs, passes the values to handoff
   *  */
  @Override
  public void execute() {
    //IDK, fill in later
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
