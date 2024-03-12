// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ConveyorBelt;

public class Conveyor extends Command {
  /** Creates a new Belt. */
  // Creates new Belt Object named Belt
 public final ConveyorBelt conveyorBelt;

  // Creates new XboxController Object named controller
  public final XboxController controller;

    /**Method: Belt
   * Parameters: ConveyorBelt and XboxController
   * Variables used: ConveyorBelt and controller
   * What it does: Assigns the parameter ConveyorBelt to ConveyorBelt
   *               Assigns the parameter XboxController to controller
   *               Uses addRequirements to tie ConveyorBelt to Belt
   *  */

  public Conveyor(ConveyorBelt conveyorBelt, XboxController controller) {
    this.conveyorBelt = conveyorBelt;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(conveyorBelt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

    /**Method:Belt
   * Parameters: None
   * Variables used: ConveyorBelts and controller
   * What it does: Takes the controller outputs, passes the values to Belt
   *  */
  @Override
  public void execute() {
    //Adjust if Limit Switches are used
    //Uses up and down of right stick on controller 2 to set speed of Belt arm
    if(controller.getRawAxis(5) > 0.2 || controller.getRawAxis(5) < -0.2){
      conveyorBelt.belt.set(controller.getRawAxis(5)*.25);
    }else{
      conveyorBelt.belt.set(0);
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
