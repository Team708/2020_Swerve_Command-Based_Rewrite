package org.usfirst.frc.team708.robot;
/*
For instantiation of all buttons and joystick controls
Integrate with commands when commands are wrote
*/

import org.usfirst.frc.team708.robot.Xbox;

public class OI{
        //joystick instantiation
        public static final Xbox driver   = new Xbox(0);
        public static final Xbox operator = new Xbox(1);

        //button instantiation
        public static final int SHIFT_TO_HANGER = operator.leftCenterClick;

    public OI(){
        driver.setDeadband(0.2);
        operator.setDeadband(0.2);

        //controls -> turn into commands**
        // if(operator.leftCenterClick.wasPressed()) {
        //     intake.shiftToHanger();
        //     operator.rumble(1.0, 1.0);
        // }
        // else if(operator.rightCenterClick.wasPressed()) {
        //     intake.lockHanger();
        //     operator.rumble(1.0, 1.0);
        // }
        // else if (operator.leftBumper.wasPressed()) {
        //     shooter.stopShooter();
        //     shooter.feederOff();
        //     hopper.stopMotor();
        //     intake.StopMotorIntake();
        //     operator.rumble(1.0, 1.0);
        // }
        // else if (operator.startButton.wasPressed()){
        //     spinner.spinnerRotateThreeTimes();
        //     operator.rumble(1.0, 1.0);
        // }
        // else if(operator.yButton.wasPressed()){
        //     shooter.shootShort();
        //     operator.rumble(1.0, 1.0);
        // }
        // else if (operator.bButton.wasPressed()){
        //     spinner.spinnerRotateOneColor();
        //     operator.rumble(1.0, 1.0);
        // }
        // else if(operator.POV0.wasPressed())
        //     intake.toHanger();
        // else if(operator.POV90.wasPressed())
        //     intake.toColorFromIntake();
        // else if(operator.POV180.wasPressed())
        //     intake.toIntake();            
        // else if(operator.POV270.wasPressed())
        //     intake.toColorFromHanger();
        // else if(operator.backButton.wasPressed())
        //     shooter.feederUnload();
        // else if(operator.xButton.wasPressed())
        //     hopper.moveMotorCounterClockwise();
        // else if(operator.aButton.wasPressed())
        //     intake.toggleMotorIntake();
        // else if(operator.rightTrigger.wasPressed()){  //isBeingPressed
        //     shooter.shootLong();
        //     operator.rumble(1.0, 1.0);
        //     // shooter.shootAuto();
        // }
        // else if(operator.rightBumper.wasPressed()){ //isBeingPressed
        //     shooter.feederOn();
        //     operator.rumble(1.0, 1.0);
        // }
        // else if (Math.abs(operator.getY(Hand.kLeft)) >= .3)
        //     intake.moveHanger(operator.getY(Hand.kLeft));
        // else {
        //     if (intake.stopHanger) intake.stopHanger();
        //  }
        
        // if (intake.inIntakePosition && !shooter.shooting) shooter.feederPreLoad();
        // driver.update();

		// if(driver.yButton.wasPressed())
		// 	swerve.rotate(0);
		// else if(driver.bButton.wasPressed())
		// 	swerve.rotate(90);
        // else if(driver.aButton.wasPressed())
		// 	swerve.rotate(180);
        // else if(driver.xButton.wasPressed())
        //     swerve.rotate(270);
        // else if(driver.rightBumper.wasPressed())
        //     swerve.rotate(72);
        // else if(driver.startButton.wasPressed()){
        //     swerve.wheelBrake();
        //     driver.rumble(1.0, 1.0);
        // }
        // else if(driver.backButton.wasPressed()){
        //     driver.rumble(1.0, 1.0);
        //     swerve.temporarilyDisableHeadingController();
        //     swerve.zeroSensors(new RigidTransform2d(new Translation2d(Constants.ROBOT_HALF_LENGTH, Constants.kAutoStartingCorner.y() + Constants.ROBOT_HALF_WIDTH), Rotation2d.fromDegrees(0)));
        //     turret.resetTurret();
        // }
        // else if(driver.leftBumper.wasPressed()) {
        //     driver.rumble(1.0, 1.0);
        //     if (Math.abs(Pigeon.getInstance().getAngle().getDegrees())>60) {
        //         swerve.rotate(0);
        //     }
        //     visionprocessor.findTarget();
    }
}