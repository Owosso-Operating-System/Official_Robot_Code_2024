// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**Method: IntakeSubsystem
   * Parameters: None
   * Variables used: intake
   * What it does: Assigns the intake variables its output port
   *  */
public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
public static CANSparkMax intake;
public static CANSparkMax drop;

  public IntakeSubsystem() {
    //initalize the CAN motor
    intake = new CANSparkMax(6, MotorType.kBrushless);
    drop = new CANSparkMax(7, MotorType.kBrushless);
    //inverts the motor
    intake.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
