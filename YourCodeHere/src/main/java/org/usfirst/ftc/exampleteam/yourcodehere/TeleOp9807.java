package org.usfirst.ftc.exampleteam.yourcodehere;

import com.qualcomm.robotcore.hardware.*;
import org.swerverobotics.library.*;
import org.swerverobotics.library.interfaces.*;

import java.util.concurrent.TimeUnit;

/**
 * A skeletal example of a do-nothing first OpMode. Go ahead and change this code
 * to suit your needs, or create sibling OpModes adjacent to this one in the same
 * Java package.
 */
@TeleOp(name="TeleOpTankOnly") //name to appear in Driver Station OpMode selection
//@Disabled  //if you un-comment this, it will keep from showing on DriverStation

    public class TeleOp9807 extends SynchronousOpMode
{
    /* Declare here any fields you might find useful. */
    DcMotor motorLeft = null;
    DcMotor motorRight = null;
   DcMotor arm = null;
    DcMotor pull= null;
    Servo Finger1= null;
    Servo Finger2=null;
    Servo hook = null;
    Servo CR_wheel=null;



    @Override public void main() throws InterruptedException
    {
        /* Initialize our hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names you assigned during the robot configuration
         * step you did in the FTC Robot Controller app on the phone.
         */
        this.motorLeft = this.hardwareMap.dcMotor.get("ldrive");
        this.motorRight = this.hardwareMap.dcMotor.get("rdrive");
        this.arm = this.hardwareMap.dcMotor.get("arm");
        this.hook=this.hardwareMap.servo.get("hook");
        this.Finger1=this.hardwareMap.servo.get("Finger1");
        this.Finger2=this.hardwareMap.servo.get("Finger2");
        this.CR_wheel=this.hardwareMap.servo.get("CR_wheel");
        this.pull=this.hardwareMap.dcMotor.get("pull");


        //reverse right motor
        motorRight.setDirection(DcMotor.Direction.REVERSE);

  

        // Wait for the game to start
        waitForStart();

        // telOp Code below...
        while (opModeIsActive())
        {
            
            if (updateGamepads())
            {
                // GAMEPAD1 Controls
                motorRight.setPower(gamepad1.left_stick_y);
                motorLeft.setPower(gamepad1.right_stick_y);

                if(gamepad1.a)
                {
                    hook.setPosition(1);

                }
                else if(gamepad1.b)
                {
                    hook.setPosition(0);

                }


                //GAMEPAD2 Controls
                if (gamepad2.a)
                {
                    Finger1.setPosition(1);
                    Finger2.setPosition(0);
                } else if (gamepad2.b) {
                    Finger1.setPosition(0.2);
                    Finger2.setPosition(.8);

                }




                if (gamepad2.right_bumper)
                {
                    pull.setPower(-.35);
                    CR_wheel.setPosition(1);
                }
                else if (gamepad2.left_bumper)
                {
                    pull.setPower(1);
                    CR_wheel.setPosition(0);
                }
                else
                {
                    pull.setPower(0);
                    
                }
                arm.setPower(gamepad2.left_stick_y*=.25);






            }//if updateGamepads

            telemetry.update();
            idle();
        }//while opModeActive

    }//main
}//MyFirstOpMode