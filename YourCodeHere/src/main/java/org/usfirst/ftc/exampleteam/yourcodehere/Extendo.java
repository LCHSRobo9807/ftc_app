package org.usfirst.ftc.exampleteam.yourcodehere;


        import com.qualcomm.robotcore.hardware.*;
        import org.swerverobotics.library.*;
        import org.swerverobotics.library.interfaces.*;
/**
 * Created by hsrobotics on 3/17/2016.
 */
@TeleOp(name="extendo")
public class Extendo extends SynchronousOpMode
{
    DcMotor drive_l =null;
    DcMotor drive_r = null;
    DcMotor arm1 = null;
    DcMotor extend1=null;


    public void main() throws InterruptedException
{
    this.drive_l=this.hardwareMap.dcMotor.get("drive_l");
    this.drive_r= this.hardwareMap.dcMotor.get("drive_r");
    this.arm1=this.hardwareMap.dcMotor.get("T_E");
    this.extend1=this.hardwareMap.dcMotor.get("M_E");
    drive_l.setDirection(DcMotor.Direction.REVERSE);


    waitForStart();

    while(opModeIsActive())
    {
        if(updateGamepads())
        {  drive_l.setPower(gamepad1.left_stick_y);
            drive_r.setPower(gamepad1.right_stick_y);

         }
        else if(gamepad1.a)
        {
            arm1.setPower(1);

        }
        else if(gamepad1.b)
        {
          arm1.setPower(-1);
        }
        else if(gamepad1.x)
        {

            extend1.setPower(-1);
        }

        else if(gamepad1.y)
        {
            extend1.setPower(1);

        }
        else
        {
            arm1.setPower(0);
            extend1.setPower(0);
        }
    }//while

    telemetry.update();
    idle();
}//main
}//extendo
