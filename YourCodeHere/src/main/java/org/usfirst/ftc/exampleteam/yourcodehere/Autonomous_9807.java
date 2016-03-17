package org.usfirst.ftc.exampleteam.yourcodehere;
import com.qualcomm.robotcore.hardware.*;
import org.swerverobotics.library.*;
import org.swerverobotics.library.interfaces.*;
/**
 * Created by hsrobotics on 11/12/2015.
 */

@Autonomous(name="autonomous 9807 Blueside")
public class Autonomous_9807 extends SynchronousOpMode {
    double Drive_Power=.5;
    double Turn_Power =.5;
    boolean Code= false;
    public void Drive_Forward_Time(double power , long time) throws InterruptedException
    {
        LeftMotor.setPower(-power);
        RightMotor.setPower(-power);
        Thread.sleep(time);
    }
    public void Turn_Left(long time) throws InterruptedException
    {
        LeftMotor.setPower(-Turn_Power);
        RightMotor.setPower(Turn_Power);
        Thread.sleep(time);
    }

    public void Turn_Right( long time) throws InterruptedException
    {
        LeftMotor.setPower(Turn_Power);
        RightMotor.setPower(-Turn_Power);
        Thread.sleep(time);
    }

    public void Reverse() throws InterruptedException
    {
        LeftMotor.setPower(Drive_Power);
        RightMotor.setPower(Drive_Power);
        Thread.sleep(1000);
    }
    DcMotor LeftMotor = null;
    DcMotor RightMotor = null;

    @Override public void main() throws InterruptedException{

        this.LeftMotor=hardwareMap.dcMotor.get("ldrive");
        this.RightMotor=hardwareMap.dcMotor.get("rdrive");

        LeftMotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();



            Drive_Forward_Time(.5,1600);

            Turn_Right(1000);

            Drive_Forward_Time(-1,1000);








            


      


    }//main

}//Autonomous_9807





