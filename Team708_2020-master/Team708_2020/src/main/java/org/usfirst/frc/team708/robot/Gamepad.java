package org.usfirst.frc.team708.robot;

import org.usfirst.frc.team708.robot.util.libs.Util;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;

import edu.wpi.first.wpilibj.buttons.*;
// import org.usfirst.frc.team708.robot.util.Gamepad;
import org.usfirst.frc.team708.robot.util.triggers.*;

//Xbox.java has original code
/**
 * Modification of Xbox class to work with command-based rewrite
 * @author Lance Hartman
 */
public class Gamepad extends Joystick{

    private double PRESS_THRESHOLD    = 0.15;
    private double axis_deadband      = 0.1;
    private double trigger_deadband   = 0.1;
	  private boolean rumbling          = false;

	  public static final int leftStick_X 	= 0;
    public static final int leftStick_Y 	= 1;
    public static final int leftTrigger 	= 2;
    public static final int rightTrigger 	= 3;
    public static final int rightStick_X 	= 4;
    public static final int rightStick_Y 	= 5;
    public static final int dpadAxis 		  = 6;
    
  //boolean buttons:
    public static final int button_A 		  = 1;
    public static final int button_B 		  = 2;
    public static final int button_X 		  = 3;
    public static final int button_Y 		  = 4;
    public static final int button_L_Shoulder 	= 5;
    public static final int button_R_Shoulder 	= 6;
    public static final int button_Back 	= 7;
    public static final int button_Start 	= 8;
    public static final int button_LeftStick 	  = 9;
	  public static final int button_RightStick 	= 10;
    public static final int POV_0   = -4;
    public static final int POV_90  = -5;
    public static final int POV_180 = -6;
    public static final int POV_270 = -7;

    private int port;

    public Gamepad(int port)   { 
    super(port);
    this.port = port;
   }

   	public void setDeadband(double deadband){
		axis_deadband = deadband;
	}
  
    public double getXAxis(Hand hand) {
        if (hand.equals(Hand.kLeft)) {
          return Util.deadBand(getRawAxis(0), axis_deadband);
        } else {
          return Util.deadBand(getRawAxis(4), axis_deadband);
        }
	  }
	  
    public double getYAxis(Hand hand) {
        if (hand.equals(Hand.kLeft)) {
          return Util.deadBand(getRawAxis(1), axis_deadband);
        } else {
          return Util.deadBand(getRawAxis(5), axis_deadband);
        }
	  }
	  
    public double getTriggerAxis(Hand hand) {
        if (hand.equals(Hand.kLeft)) {
          return Util.deadBand(getRawAxis(2), PRESS_THRESHOLD);
        } else {
          return Util.deadBand(getRawAxis(3), PRESS_THRESHOLD);
        }
      }

    public boolean triggerIsBeingPressed(Hand hand){
      return getTriggerAxis(hand) > trigger_deadband;
    }

      /**
     * Get the value of a gamepad axis, adjusting
     * for a dead zone.
     * @param axis
     * @return 
     */
    public double getAxis(int axis){
      double val = getRawAxis(axis);
      if(Math.abs(val) <= axis_deadband) return 0; 
      
      //flip the y axes on both joysticks
        //they naturally read negative for upward motion, but they should read positive
      if (axis == Gamepad.rightStick_Y || axis == Gamepad.leftStick_Y) return -val;
      else return val;
      }
    
    public void rumble(double rumblesPerSecond, double numberOfSeconds){
    	if(!rumbling){
    		RumbleThread r = new RumbleThread(rumblesPerSecond, numberOfSeconds);
    		r.start();
    	}
	}
	
    public boolean isRumbling(){
    	return rumbling;
	}
	
	//code for rumble, creates a new thread and rumbles
    public class RumbleThread extends Thread{
    	public double rumblesPerSec = 1;
    	public long interval = 500;
    	public double seconds = 1;
    	public double startTime = 0;
    	public RumbleThread(double rumblesPerSecond, double numberOfSeconds){
    		rumblesPerSec = rumblesPerSecond;
    		seconds = numberOfSeconds;
    		interval =(long) (1/(rumblesPerSec*2)*1000);
    	}
    	public void run(){
    		rumbling = true;
    		startTime = Timer.getFPGATimestamp();
    		try{
    			while((Timer.getFPGATimestamp() - startTime) < seconds){
		    		setRumble(RumbleType.kLeftRumble, 1);
		    		setRumble(RumbleType.kRightRumble, 1);
		    		sleep(interval);
		    		setRumble(RumbleType.kLeftRumble, 0);
		    		setRumble(RumbleType.kRightRumble, 0);
		    		sleep(interval);
    			}
    		}catch (InterruptedException e) {
				rumbling = false;
				e.printStackTrace();
			}
    		rumbling = false;
    	}
    }
	
	//Useless class to us as of now
    // public class ButtonCheck{
    // 	boolean buttonCheck = false;
    // 	boolean buttonActive = false;
    // 	boolean longPressActive = false;
    // 	boolean hasBeenPressed = false;
    // 	private double buttonStartTime = 0;
    // 	private int buttonNumber;
    // 	public ButtonCheck(int id){
    // 		buttonNumber = id;
    // 	}
    // 	public void update(){
    // 		if(buttonNumber > 0){
    // 			buttonCheck = getRawButton(buttonNumber);
    // 		}else{
    // 			switch(buttonNumber){
    // 				case LEFT_TRIGGER:
    // 					buttonCheck = getTriggerAxis(Hand.kLeft) > 0;
    // 					break;
    // 				case RIGHT_TRIGGER:
    // 					buttonCheck = getTriggerAxis(Hand.kRight) > 0;
    // 					break;
    // 				case POV_0:
    // 					buttonCheck = (getPOV() == 0);
    // 					break;
    // 				case POV_90:
    // 					buttonCheck = (getPOV() == 90);
    // 					break;
    // 				case POV_180:
    // 					buttonCheck = (getPOV() == 180);
    // 					break;
    // 				case POV_270:
    // 					buttonCheck = (getPOV() == 270);
    // 					break;
    // 				default:
    // 					buttonCheck = false;
    // 					break;
    // 			}
    // 		}
    // 		if(buttonCheck){
	//     		if(buttonActive){
	//     			if(System.currentTimeMillis() - buttonStartTime > 2500)  //250 jnp
	//     				longPressActive = true;
	//     		}else{
	//     			buttonActive = true;
	//     			buttonStartTime = System.currentTimeMillis();
	//     		}
    // 		}else{
    // 			if(buttonActive){
    // 				buttonActive = false;
    // 				if(longPressActive){
    // 					hasBeenPressed = false;
    // 					longPressActive = false;
    // 				}else{
    // 					hasBeenPressed = true;
    // 				}
    // 			}
    // 		}
    // 	}
    // 	public boolean wasPressed(){
    // 		if(hasBeenPressed){
    // 			hasBeenPressed = false;
    // 			return true;
    // 		}
    // 		return false;
    // 	}
    // 	public boolean longPressed(){
    // 		return longPressActive;
    // 	}
    // 	public boolean isBeingPressed(){
    // 		return buttonActive;
    // 	}
	// }
	
	//TODO check if uncommented; shouldn't be if waiting threads...
    // public void update(){
    // 	aButton.update();
    // 	bButton.update();
    // 	xButton.update();
    // 	yButton.update();
    // 	startButton.update();
    // 	backButton.update();
    // 	leftBumper.update();
    // 	rightBumper.update();
    // 	leftCenterClick.update();
    // 	rightCenterClick.update();
    // 	leftTrigger.update();
    // 	rightTrigger.update();
    // 	POV0.update();
    // 	POV90.update();
    // 	POV180.update();
    // 	POV270.update();
    // }
}