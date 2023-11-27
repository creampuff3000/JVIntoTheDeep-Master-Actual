package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;
import org.firstinspires.ftc.teamcode.Projects.HWMap;

@Autonomous(name = "SlightlyAuton")
public class SlightlyLessBasicAuton extends LinearOpMode {
    enum Parking {
        FBlue,
        BBlue,
        BRed,
        FRed,
    }

    Gamepad currentGamepad1 = new Gamepad();
    Gamepad previousGamepad1 = new Gamepad();
    public HWMap robot = new HWMap();
    public void poweringthing(){
        robot.backRightDrive.setPower(0.7);
        robot.backLeftDrive.setPower(0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.frontLeftDrive.setPower(0.7);
    }
    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map

        robot.init(hardwareMap);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontRightDrive.setTargetPosition(0);
        robot.frontLeftDrive.setTargetPosition(0);
        robot.backRightDrive.setTargetPosition(0);
        robot.backLeftDrive.setTargetPosition(0);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Parking Alliance = Parking.FBlue;

        int direction = 1;
        int otherDirection = -1;

        boolean isFBlue = false;
        boolean isBBlue = false;
        boolean isFRed = false;
        boolean isBRed = false;
        // hi
        // Autonomous code starts here

        while (!isStarted()) {
            // uygiufougoijpiuhitfjfstuhhdstersuyrukuy;oyg

            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);
            if (currentGamepad1.right_bumper && !previousGamepad1.right_bumper) {

                isFBlue = true;
                isBBlue = false;
                isFRed = false;
                isBRed = false;
            }
            if (currentGamepad1.left_bumper && !previousGamepad1.left_bumper) {

                isFBlue = false;
                isBBlue = false;
                isFRed = true;
                isBRed = false;
            }
            if (currentGamepad1.left_trigger != 0) {

                isFBlue = false;
                isBBlue = false;
                isFRed = false;
                isBRed = true;
            }
            if (currentGamepad1.right_trigger != 0) {

                isFBlue = false;
                isBBlue = true;
                isFRed = false;
                isBRed = false;
            }

            if (isFBlue) {

                Alliance = Parking.BBlue;
            }
            if (isBBlue) {

                Alliance = Parking.FRed;
            }
            if (isFRed) {

                Alliance = Parking.BRed;
            }
            if (isBRed) {

                Alliance = Parking.FBlue;
            }
            telemetry.addData("Parking", Alliance);
            telemetry.update();
        }
        waitForStart(); //wait for play button to be pressed

        if (Alliance == SlightlyLessBasicAuton.Parking.FBlue) {
            robot.backRightDrive.setTargetPosition(3290);
            robot.backLeftDrive.setTargetPosition(3290);
            robot.frontRightDrive.setTargetPosition(3290);
            robot.frontRightDrive.setTargetPosition(3290);
            poweringthing();
            robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            sleep(12000);
//            robot.frontRightDrive.setPower(0.8);
//            robot.backRightDrive.setPower(0.8);
//            robot.frontLeftDrive.setPower(1);
//            robot.backLeftDrive.setPower(1);
//            sleep(650);
//            robot.frontRightDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(500);
//            robot.frontRightDrive.setPower(-1);
//            robot.backRightDrive.setPower(-1);
//            robot.frontLeftDrive.setPower(1);
//            robot.backLeftDrive.setPower(1);
//            sleep(410);
//            robot.frontRightDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(500);
//            robot.frontRightDrive.setPower(-1);
//            robot.backRightDrive.setPower(-1);
//            robot.frontLeftDrive.setPower(-1);
//            robot.backLeftDrive.setPower(-1);
//            sleep(2060);
//            robot.frontRightDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(800);
//            robot.slideMotor.setPower(0.4);
//            sleep(1200);
//            robot.slideMotor.setPower(0);
//            sleep(500);
//            robot.outtakeServo.setPosition(1);
//            sleep(1000);
//            robot.outtakeServo.setPosition(0);
//            sleep(1000);
//            robot.slideMotor.setPower(-0.6);
//            sleep(800);
//            robot.slideMotor.setPower(0);
//            sleep(500);
        }
        if (Alliance == SlightlyLessBasicAuton.Parking.FRed) {
//            sleep(12000);
//            robot.frontRightDrive.setPower(1);
//            robot.backRightDrive.setPower(1);
//            robot.frontLeftDrive.setPower(0.8);
//            robot.backLeftDrive.setPower(0.8);
//            sleep(650);
//            robot.frontRightDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(500);
//            robot.frontRightDrive.setPower(1);
//            robot.backRightDrive.setPower(1);
//            robot.frontLeftDrive.setPower(-1);
//            robot.backLeftDrive.setPower(-1);
//            sleep(387);
//            robot.frontRightDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(500);
//            robot.frontRightDrive.setPower(-1);
//            robot.backRightDrive.setPower(-1);
//            robot.frontLeftDrive.setPower(-1);
//            robot.backLeftDrive.setPower(-1);
//            sleep(2060);
//            robot.frontRightDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(800);
//            robot.slideMotor.setPower(0.4);
//            sleep(1200);
//            robot.slideMotor.setPower(0);
//            sleep(500);
//            robot.outtakeServo.setPosition(1);
//            sleep(1000);
//            robot.outtakeServo.setPosition(0);
//            sleep(1000);
//            robot.slideMotor.setPower(-0.6);
//            sleep(800);
//            robot.slideMotor.setPower(0);
//            sleep(500);
        }

        if (Alliance == SlightlyLessBasicAuton.Parking.BRed) {
//            robot.backRightDrive.setPower(0.8);
//            robot.backLeftDrive.setPower(1);
//            robot.frontLeftDrive.setPower(1);
//            robot.frontRightDrive.setPower(0.8);
//            sleep(800);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.frontRightDrive.setPower(0);
//            sleep(500);
//            robot.backRightDrive.setPower(1);
//            robot.backLeftDrive.setPower(-1);
//            robot.frontLeftDrive.setPower(-1);
//            robot.frontRightDrive.setPower(1);
//            sleep(420);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.frontRightDrive.setPower(0);
//            sleep(500);
//            robot.backRightDrive.setPower(-0.7);
//            robot.backLeftDrive.setPower(-0.7);
//            robot.frontLeftDrive.setPower(-0.7);
//            robot.frontRightDrive.setPower(-0.7);
//            sleep(1500);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.frontRightDrive.setPower(0);
//            sleep(500);
//            robot.slideMotor.setPower(0.4);
//            sleep(1200);
//            robot.slideMotor.setPower(0);
//            sleep(500);
//            robot.outtakeServo.setPosition(1);
//            sleep(1000);
//            robot.outtakeServo.setPosition(0);
//            sleep(1000);
//            robot.slideMotor.setPower(-0.6);
//            sleep(800);
//            robot.slideMotor.setPower(0);
//            sleep(500);
//            robot.frontRightDrive.setPower(-0.7);
//            robot.frontLeftDrive.setPower(0.7);
//            robot.backRightDrive.setPower(0.7);
//            robot.backLeftDrive.setPower(-0.7);
//            sleep(800);
//            robot.frontRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(987);
//            robot.frontRightDrive.setPower(-0.5);
//            robot.frontLeftDrive.setPower(-0.5);
//            robot.backRightDrive.setPower(-0.5);
//            robot.backLeftDrive.setPower(-0.5);
//            sleep(300);
//            robot.frontRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(50);
        }

        if (Alliance == SlightlyLessBasicAuton.Parking.BBlue) {

        }
    }
}

