package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;
import org.firstinspires.ftc.teamcode.Projects.HWMap;

@Autonomous(name = "BasicAuto")

public class BasicAUTO extends LinearOpMode{
    enum Parking{
        Blue,
        Red
    }
    Gamepad currentGamepad1 = new Gamepad();
    Gamepad previousGamepad1 = new Gamepad();
    public HWMap robot = new HWMap();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map
        robot.init(hardwareMap);
        Parking Alliance = Parking.Blue;



        int direction = 1;
        int otherDirection = -1;
        boolean isBlue = true;
        //we wish you a merry christmas, we wish you a merry christmas, we wish you a merry christmas, and a happy new year

        while(!isStarted()){
            // only the ghost of programmers past know why tf this is set up this way
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);
            if (currentGamepad1.right_bumper && !previousGamepad1.right_bumper){

                isBlue = !isBlue;
            }
            if (isBlue){

                Alliance = Parking.Blue;
            }
            else{

                Alliance = Parking.Red;
            }
            telemetry.addData("Parking",Alliance);
            telemetry.update();
        }
        waitForStart(); //wait for play button to be pressed
        // BackRed Autonomous
        if (Alliance == BasicAUTO.Parking.Blue){
            robot.frontRightDrive.setPower(1);
            robot.backRightDrive.setPower(-1);
            robot.frontLeftDrive.setPower(-1);
            robot.backLeftDrive.setPower(1);
            sleep(1000);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);


        }
        else{
            robot.frontRightDrive.setPower(-1);
            robot.backRightDrive.setPower(1);
            robot.frontLeftDrive.setPower(1);
            robot.backLeftDrive.setPower(-1);
            sleep(1000);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(10);
            robot.frontRightDrive.setPower(1);
            robot.backRightDrive.setPower(1);
            robot.frontLeftDrive.setPower(1);
            robot.backLeftDrive.setPower(1);
            sleep(1000);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(10);
            robot.frontRightDrive.setPower(1);
            robot.backRightDrive.setPower(1);
            robot.frontLeftDrive.setPower(-1);
            robot.backLeftDrive.setPower(-1);
            sleep(500);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(10);
            robot.frontRightDrive.setPower(-1);
            robot.backRightDrive.setPower(-1);
            robot.frontLeftDrive.setPower(1);
            robot.backLeftDrive.setPower(1);
            sleep(500);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(10);
            robot.frontRightDrive.setPower(-1);
            robot.backRightDrive.setPower(-1);
            robot.frontLeftDrive.setPower(-1);
            robot.backLeftDrive.setPower(-1);
            sleep(1000);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);

        }


    }


    // Autonomous code starts here

}