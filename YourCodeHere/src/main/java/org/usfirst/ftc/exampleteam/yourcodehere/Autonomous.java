package org.usfirst.ftc.exampleteam.yourcodehere;
import com.qualcomm.robotcore.hardware.*;
import org.swerverobotics.library.*;
import org.swerverobotics.library.interfaces.*;
/**
 * Created by hsrobotics on 11/12/2015.
 */

@TeleOp(name="Crappy Auto code that probably doesnt work")
public class Autonomous extends SynchronousOpMode {

    DcMotor LeftMotor= null;
    DcMotor RightMotor=null;

    @Override public void main() throws InterruptedException{

        this.LeftMotor=hardwareMap.dcMotor.get("ldrive");
        this.RightMotor=hardwareMap.dcMotor.get("rdrive");

        LeftMotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        while(opModeIsActive()) {

            LeftMotor
        }
        }


    }

}
