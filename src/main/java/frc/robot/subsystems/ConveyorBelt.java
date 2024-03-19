// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**Method: PivotSubsystem
   * Parameters: None
   * Variables used: Pivot
   * What it does: Assigns the Pivot variables its output port
   *  */
public class ConveyorBelt extends SubsystemBase {
  /** Creates a new PivotSubsystem. */
  public CANSparkMax belt;

  public ConveyorBelt() {
    //initalize the CAN motor
    belt = new CANSparkMax(7, MotorType.kBrushless);
  }
}
