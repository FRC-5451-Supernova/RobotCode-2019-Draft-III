/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.IntakeDefault;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Intake extends Subsystem {
  
  public SpeedController motor_lift = new Spark(1);
  public SpeedController motor_collector = new Spark(2);
  
  public double global_lift_speed = 0.8;
  
  public Intake() {
    super();
    motor_lift.setInverted(true);
    motor_collector.setInverted(true);
  }
  
  public void liftAt(double vel) {
    motor_lift.set(global_lift_speed * vel);
  }

  public void collectAt(double vel) {
    motor_collector.set(vel);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeDefault());
  }
}
