// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Class: ClimbSubsystem
   * Creates a new ClimbSubsystem.
   *
   *  */
public class ClimbSubsystem extends SubsystemBase {
  // creates a new CAN Motor object
  public static CANSparkMax climb;

/**Method: ClimbSubsystem
   * Parameters: None
   * Variables used: climb
   * What it does: Assigns the CANSparkMax variables their output ports
   *  */
  public ClimbSubsystem() {
    // initalize the CAN Motors
    climb = new CANSparkMax(9,MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
