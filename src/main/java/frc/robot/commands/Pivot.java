// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PivotSubsystem;

public class Pivot extends Command {
  /** Creates a new Pivot. */
  // Creates new Pivot Object named Pivot
 public final PivotSubsystem pivotSubsystem;

  // Creates new XboxController Object named controller
  public final XboxController controller;

    /**Method: Pivot
   * Parameters: PivotSubsystem and XboxController
   * Variables used: PivotSubsystem and controller
   * What it does: Assigns the parameter PivotSubsystem to Pivotsubsystem
   *               Assigns the parameter XboxController to controller
   *               Uses addRequirements to tie PivotSubsystem to Pivot
   *  */

  public Pivot(PivotSubsystem pivotSubsystem, XboxController controller) {
    this.pivotSubsystem = pivotSubsystem;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(pivotSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

    /**Method:Pivot
   * Parameters: None
   * Variables used: PivotSubsystems and controller
   * What it does: Takes the controller outputs, passes the values to Pivot
   *  */
  @Override
  public void execute() {
    //Adjust if Limit Switches are used
    //Uses up and down of right stick on controller 2 to set speed of pivot arm
    if(controller.getRawAxis(5) > 0.2 || controller.getRawAxis(5) < -0.2){
      pivotSubsystem.pivot.set(controller.getRawAxis(5)*.25);
    }else{
      pivotSubsystem.pivot.set(0);
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
