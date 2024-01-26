// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class Climb extends Command {
  //makes a variable to use in the class
  private final ClimbSubsystem climbSubsystem;
  private final XboxController controller;
  /*Method: Climb
   * Parameters: climbSubsystem, XboxController
   * Variables used: climbSubsystem and controller
   * What it does: Takes the controller outputs, passes the values to mecDrive
   **/
  public Climb(ClimbSubsystem climbSubsystem, XboxController controller) {
    this.climbSubsystem = climbSubsystem;
    this.controller =  controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climbSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  //takes the input of the controller and uses it to move the lift arm up or down depending on the controller input 
  public void execute() {
    if (controller.getRawAxis(2) > 0.1){
      ClimbSubsystem.climb.set(controller.getRawAxis(2));
    }else if(controller.getRawAxis(3) > 0.1){
      ClimbSubsystem.climb.set(-controller.getRawAxis(3));
    }else{
      ClimbSubsystem.climb.set(0);
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
