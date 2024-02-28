// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ScoringSubsystem;

public class Scoring extends Command {
  // Creates new ScoringSubsystem Object named scoringSubsystem
  public final ScoringSubsystem scoringSubsystem;
  // Creates new XboxController Object named controller
  public final XboxController controller;

    /**Method: Scorer
   * Parameters: ScoringSubsystem and XboxController
   * Variables used: scoringSubsystem and controller
   * What it does: Assigns the parameter ScoringSubsystem to scoringSubsystem
   *               Assigns the parameter XboxController to controller
   *               Uses addRequirements to tie ScoringSubsystem to Scorer
   *  */

  public Scoring(ScoringSubsystem scoringSubsystem, XboxController controller) {
    this.scoringSubsystem = scoringSubsystem;
    this.controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(scoringSubsystem);
  }

  /**Method: Scoring
  * Parameters: None
  * Variables used: scoringSubsystems and controller
  * What it does: Takes the controller outputs, passes the values to Scoring
  *  */
  @Override
  public void execute() {
    if(controller.getRightBumper() == true) {
      // While Right Bumper is held, the scorer speed is 1
      scoringSubsystem.scorerL.set(-1);
      scoringSubsystem.scorerR.set(1);
    } else if(controller.getLeftBumper() == true) {
      // While Left Bumper is held, the scorer speed is -1
      scoringSubsystem.scorerL.set(1);
      scoringSubsystem.scorerR.set(-1);
    } else {
      // Otherwise, the scorer speed is set to 0
      scoringSubsystem.scorerL.set(0);
      scoringSubsystem.scorerR.set(0);
    }
  }
}
