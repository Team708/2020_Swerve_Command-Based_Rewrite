/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team708.robot.commands.buttonCommands;

import org.usfirst.frc.team254.lib.util.math.RigidTransform2d;
import org.usfirst.frc.team254.lib.util.math.Translation2d;
import org.usfirst.frc.team254.lib.util.math.Rotation2d;
import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.OI;
import org.usfirst.frc.team708.robot.Robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ResetEverything extends InstantCommand {
  public ResetEverything() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    OI.driver.rumble(1.0, 1.0);
        Robot.swerve.temporarilyDisableHeadingController();
        Robot.swerve.zeroSensors(new RigidTransform2d(new Translation2d(Constants.ROBOT_HALF_LENGTH, Constants.kAutoStartingCorner.y() + Constants.ROBOT_HALF_WIDTH), Rotation2d.fromDegrees(0)));
        Robot.turret.resetTurret();;
  }
}
