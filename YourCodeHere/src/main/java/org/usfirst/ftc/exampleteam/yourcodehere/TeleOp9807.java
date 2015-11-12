package org.usfirst.ftc.exampleteam.yourcodehere;

import com.qualcomm.robotcore.hardware.*;
import org.swerverobotics.library.*;
import org.swerverobotics.library.interfaces.*;

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
   // DcMotor motor3 = null;
    //DcMotor slingshot=null;


    @Override public void main() throws InterruptedException
    {
        /* Initialize our hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names you assigned during the robot configuration
         * step you did in the FTC Robot Controller app on the phone.
         */
        this.motorLeft = this.hardwareMap.dcMotor.get("ldrive");
        this.motorRight = this.hardwareMap.dcMotor.get("rdrive");
        //legacy motor
       // this.motor3 = this.hardwareMap.dcMotor.get("winch");
        //this.slingshot= this.hardwareMap.dcMotor.get("slingshot");


        //set motor channel to run without encoders
       // motorLeft.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
       // motorRight.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        //reverse Left motor
        //motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorRight.setDirection(DcMotor.Direction.REVERSE);

  

        // Wait for the game to start
        waitForStart();

        // telOp Code below...
        while (opModeIsActive())
        {
            if (updateGamepads())
            {
                // tank drive
                motorLeft.setPower(gamepad1.left_stick_y);
                motorRight.setPower(gamepad1.right_stick_y);

              //  motor3.setPower(gamepad2.left_stick_y);
                //slingshot.setPower(gamepad2.right_stick_y);


                //servo commands
              /*  if(gamepad1.a)
                {
                    servoArm.setPosition(ARM_MIN);
                }
                else if (gamepad1.b)
                {
                    servoArm.setPosition(ARM_MAX);
                }*/

            }//if updateGamepads

            telemetry.update();
            idle();
        }//while opModeActive

    }//main
}//MyFirstOpMode