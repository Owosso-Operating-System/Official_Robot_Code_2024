// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**Method: ScoringSubsystem
   * Parameters: None
   * Variables used: scorer
   * What it does: Assigns the scorer variable its output port
   *  */
public class ScoringSubsystem extends SubsystemBase {
  // create new CAN Motor objects
  public CANSparkMax scorerL;
  public CANSparkMax scorerR;

  public ScoringSubsystem() {
    //initialize the CAN motors
    scorerL = new CANSparkMax(9, MotorType.kBrushless);
    scorerR = new CANSparkMax(10, MotorType.kBrushless);
  }
}
