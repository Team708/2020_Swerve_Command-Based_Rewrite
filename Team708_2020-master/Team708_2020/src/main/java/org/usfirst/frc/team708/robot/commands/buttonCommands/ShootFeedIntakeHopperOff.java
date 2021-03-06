package org.usfirst.frc.team708.robot.commands.buttonCommands;
//make real package

import org.usfirst.frc.team708.robot.Robot;
import org.usfirst.frc.team708.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

public class ShootFeedIntakeHopperOff extends Command {

    // private Translation2d driveVector;

    public ShootFeedIntakeHopperOff(){
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.shooter.stopShooter();
        Robot.shooter.feederOff();
        Robot.hopper.stopMotor();
        Robot.intake.StopMotorIntake();
        OI.operator.rumble(1.0, 1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true; 
    }

    // Called once after isFinished returns true
    protected void end() {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
