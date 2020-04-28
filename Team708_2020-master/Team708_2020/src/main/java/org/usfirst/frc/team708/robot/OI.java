package org.usfirst.frc.team708.robot;

/*
For instantiation of all buttons and joystick controls
Integrate with commands when commands are wrote
*/

import org.usfirst.frc.team708.robot.util.libs.Util;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team708.robot.Gamepad;
import org.usfirst.frc.team708.robot.util.Gamepad_Old;
import org.usfirst.frc.team708.robot.util.triggers.*;
import org.usfirst.frc.team708.robot.commands.buttonCommands.*;

public class OI{

        //joystick instantiation
        public static final Gamepad driver   = new Gamepad(0);
        public static final Gamepad operator = new Gamepad(1);

        //TODO check that buttons are correctly assigned
        //assigning integers to correct button names
        //buttons for driver
        public static final int ROTATE_TO_180 = Gamepad.button_A;
        public static final int ROTATE_TO_90 = Gamepad.button_B;
        public static final int ROTATE_TO_270 = Gamepad.button_X;
        public static final int ROTATE_TO_0 = Gamepad.button_Y;
        public static final int BRAKE_MODE = Gamepad.button_Start;
        public static final int RESET_EVERYTHING = Gamepad.button_Back;
        public static final int MANUAL_VISION_CONTROL = Gamepad.button_L_Shoulder;
        public static final int ROTATE_TO_72 = Gamepad.button_R_Shoulder;
        // public static final int leftCenterClick = Gamepad.button_LeftStick;
        // public static final int rightCenterClick = Gamepad.button_RightStick;
        // public static final int POV0 = Gamepad.POV_0;
        // public static final int POV90 = Gamepad.POV_90;
        // public static final int POV180 = Gamepad.POV_180;
        // public static final int POV270 = Gamepad.POV_270;

        //buttons for operator
        public static final int TOGGLE_MOTOR_INTAKE = Gamepad.button_A;
        public static final int SPINNER_ROTATE_ONE_COLOR = Gamepad.button_B;
        public static final int MOVE_HOPPER_COUNTER_CLOCKWISE = Gamepad.button_X;
        public static final int SHOOT_SHORT = Gamepad.button_Y;
        public static final int SPINNER_ROTATE_THREE_TIMES = Gamepad.button_Start;
        public static final int FEEDER_UNLOAD = Gamepad.button_Back;
        public static final int EVERYTHING_OFF = Gamepad.button_L_Shoulder;
        public static final int FEEDER_ON = Gamepad.button_R_Shoulder;
        public static final int SHIFT_TO_HANGER = Gamepad.button_LeftStick;
        public static final int LOCK_HANGER = Gamepad.button_RightStick;
        public static final int TO_HANGER = Gamepad.POV_0;
        public static final int TO_COLOR_FROM_INTAKE = Gamepad.POV_90;
        public static final int TO_INTAKE = Gamepad.POV_180;
        public static final int TO_COLOR_FROM_HANGER = Gamepad.POV_270;

        //Trigger assignments
        //DRIVER
        public static final int LOW_SPEED_MODE = Gamepad.leftTrigger;
        public static final int RIGHT_TRIGGER = Gamepad.rightTrigger;

        //OPERATOR
        //public static final int LEFT_TRIGGER;
        public static final int SHOOT_LONG = Gamepad.rightTrigger;

    
        //BUTTONS
        //Driver - Label Correctly
        public Button rotateTo180 = new JoystickButton(driver, ROTATE_TO_180);
        public Button rotateTo90 = new JoystickButton(driver, ROTATE_TO_90);
        public Button rotateTo270 = new JoystickButton(driver, ROTATE_TO_270);
        public Button rotateTo0 = new JoystickButton(driver, ROTATE_TO_0);
        public Button brakeMode = new JoystickButton(driver, BRAKE_MODE);
        public Button resetEverything = new JoystickButton(driver, RESET_EVERYTHING);
        public Button manualVisionControl = new JoystickButton(driver, MANUAL_VISION_CONTROL);
        public Button rotateTo72 = new JoystickButton(driver, ROTATE_TO_72);
        // public Button leftCenterClick = new JoystickButton(driver, Gamepad.button_LeftStick);
        // public Button rightCenterClick = new JoystickButton(driver, Gamepad.button_RightStick);
        // public Button POV0 = new JoystickButton(driver, Gamepad.POV_0);
        // public Button POV90 = new JoystickButton(driver, Gamepad.POV_90);
        // public Button POV180 = new JoystickButton(driver, Gamepad.POV_180);
        // public Button POV270 = new JoystickButton(driver, Gamepad.POV_270);

        //Operator
        public Button toggleMotorIntake = new JoystickButton(operator, TOGGLE_MOTOR_INTAKE);
        public Button spinnerRotateOneColor = new JoystickButton(operator, SPINNER_ROTATE_ONE_COLOR);
        public Button moveHopperCounterClockwise = new JoystickButton(operator, MOVE_HOPPER_COUNTER_CLOCKWISE);
        public Button shootShort = new JoystickButton(operator, SHOOT_SHORT);
        public Button spinnerRotateThreeTimes = new JoystickButton(operator, SPINNER_ROTATE_THREE_TIMES);
        public Button feederUnload = new JoystickButton(operator, FEEDER_UNLOAD);
        public Button everythingOff = new JoystickButton(operator, EVERYTHING_OFF);
        public Button feederOn = new JoystickButton(operator, FEEDER_ON);
        public Button shiftToHanger = new JoystickButton(operator, SHIFT_TO_HANGER);
        public Button lockHanger = new JoystickButton(operator, LOCK_HANGER);
        public Button toHanger = new JoystickButton(operator, TO_HANGER);
        public Button toColorFromIntake = new JoystickButton(operator, TO_COLOR_FROM_INTAKE);
        public Button toIntake = new JoystickButton(operator, TO_INTAKE);
        public Button toColorFromHanger = new JoystickButton(operator, TO_COLOR_FROM_HANGER);

        //TODO TRIGGERS - check to make sure AxisDown/AxisUp is correct - Label Correctly
        //Driver
        public Trigger leftTrigger = new AxisDown(driver, LOW_SPEED_MODE);
        // public Trigger rightTrigger;

        //Operator
        // public Trigger leftTrigger;
        public Trigger shootLong = new AxisDown(operator, SHOOT_LONG);

    public OI(){

        driver.setDeadband(0.2);
        operator.setDeadband(0.2);

        //driver
        rotateTo180.whenPressed(new RotateTo180());
        rotateTo90.whenPressed(new RotateTo90());
        rotateTo270.whenPressed(new RotateTo270());
        rotateTo0.whenPressed(new RotateTo0());
        brakeMode.whenPressed(new BrakeMode());
        resetEverything.whenPressed(new ResetEverything());
        manualVisionControl.whenPressed(new ManualVisionControl());
        rotateTo72.whenPressed(new RotateTo72());

        //operator
        toggleMotorIntake.whenPressed(new ToggleIntakeMotor());
        spinnerRotateOneColor.whenPressed(new SpinOneColor());
        moveHopperCounterClockwise.whenPressed(new MoveHopperCounterClockwise());
        shootShort.whenPressed(new ShootShort());
        spinnerRotateThreeTimes.whenPressed(new SpinThreeTimes());
        feederUnload.whenPressed(new UnloadFeeder());
        everythingOff.whenPressed(new EverythingOff());
        feederOn.whenPressed(new FeederOn());
        shiftToHanger.whenPressed(new ToHanger());
        lockHanger.whenPressed(new LockHanger());
        toHanger.whenPressed(new ToHanger());
        toColorFromIntake.whenPressed(new ToColorFromIntake());
        toIntake.whenPressed(new ToIntake());
        toColorFromHanger.whenPressed(new ToColorFromHanger());


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


        // TODO ....yes
        // // else if (Math.abs(operator.getY(Hand.kLeft)) >= .3)
        // //     intake.moveHanger(operator.getY(Hand.kLeft));
        // // else {
        // //     if (intake.stopHanger) intake.stopHanger();
        // //  }
        
        // // if (intake.inIntakePosition && !shooter.shooting) shooter.feederPreLoad();
        // // driver.update();



		// // if(driver.yButton.wasPressed())
		// // 	swerve.rotate(0);
		// // else if(driver.bButton.wasPressed())
		// // 	swerve.rotate(90);
        // // else if(driver.aButton.wasPressed())
		// // 	swerve.rotate(180);
        // // else if(driver.xButton.wasPressed())
        // //     swerve.rotate(270);
        // // else if(driver.rightBumper.wasPressed())
        // //     swerve.rotate(72);
        // // else if(driver.startButton.wasPressed()){
        // //     swerve.wheelBrake();
        // //     driver.rumble(1.0, 1.0);
        // // }
        // // else if(driver.backButton.wasPressed()){
        // //     driver.rumble(1.0, 1.0);
        // //     swerve.temporarilyDisableHeadingController();
        // //     swerve.zeroSensors(new RigidTransform2d(new Translation2d(Constants.ROBOT_HALF_LENGTH, Constants.kAutoStartingCorner.y() + Constants.ROBOT_HALF_WIDTH), Rotation2d.fromDegrees(0)));
        // //     turret.resetTurret();
        // // }
        // // else if(driver.leftBumper.wasPressed()) {
        // //     driver.rumble(1.0, 1.0);
        // //     if (Math.abs(Pigeon.getInstance().getAngle().getDegrees())>60) {
        // //         swerve.rotate(0);
        // //     }
        // //     visionprocessor.findTarget();
        // // }
    }
}