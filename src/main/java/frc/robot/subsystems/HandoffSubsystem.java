// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**Method: HandoffSubsystem
   * Parameters: None
   * Variables used: handoff
   * What it does: Assigns the handoff variables its output port
   *  */
public class HandoffSubsystem extends SubsystemBase {
  /** Creates a new HandoffSubsystem. */
public static CANSparkMax handoff;

  public HandoffSubsystem() {
    //initalize the CAN motor
    handoff = new CANSparkMax(7, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
