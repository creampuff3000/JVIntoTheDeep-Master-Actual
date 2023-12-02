package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;
import org.firstinspires.ftc.teamcode.Projects.HWMap;

@Autonomous(name = "VeryBasicAutonomous")

public class BASICAUTONOMOUS extends LinearOpMode {
    enum Parking {
        FBlue,
        BBlue,
        BRed,
        FRed,
    }

    Gamepad currentGamepad1 = new Gamepad();
    Gamepad previousGamepad1 = new Gamepad();
    public HWMap robot = new HWMap();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map

        robot.init(hardwareMap);
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

        if (Alliance == BASICAUTONOMOUS.Parking.FBlue) {
            sleep(12000);
            robot.frontRightDrive.setPower(1);
            robot.backRightDrive.setPower(-1);
            robot.frontLeftDrive.setPower(-1);
            robot.backLeftDrive.setPower(1);
            sleep(125);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(500);
            robot.frontRightDrive.setPower(-1);
            robot.backRightDrive.setPower(-1);
            robot.frontLeftDrive.setPower(-1);
            robot.backLeftDrive.setPower(-1);
            sleep(1650);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(500);
            robot.frontRightDrive.setPower(1);
            robot.backRightDrive.setPower(-1);
            robot.frontLeftDrive.setPower(-1);
            robot.backLeftDrive.setPower(1);
            sleep(500);
            robot.frontRightDrive.setPower(-0.4);
            robot.backRightDrive.setPower(-0.4);
            robot.frontLeftDrive.setPower(-0.4);
            robot.backLeftDrive.setPower(-0.4);
            sleep(800);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(100);
            robot.slideMotor.setPower(0.8);
            sleep(1800); //used to be 1200
            robot.slideMotor.setPower(0);
            sleep(500);
            robot.outtakeServo.setPosition(1);
            sleep(1000);
            robot.outtakeServo.setPosition(0);
            sleep(1000);
            robot.slideMotor.setPower(-0.8);
            sleep(1500); //used to be 800
            robot.slideMotor.setPower(0);
            sleep(500);
        }
        if (Alliance == BASICAUTONOMOUS.Parking.FRed) {
            sleep(12000);
            robot.frontRightDrive.setPower(-1);
            robot.backRightDrive.setPower(1);
            robot.frontLeftDrive.setPower(1);
            robot.backLeftDrive.setPower(-1);
            sleep(125);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(500);
            robot.frontRightDrive.setPower(-1);
            robot.backRightDrive.setPower(-1);
            robot.frontLeftDrive.setPower(-1);
            robot.backLeftDrive.setPower(-1);
            sleep(1650);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(100);
            robot.frontRightDrive.setPower(-1);
            robot.backRightDrive.setPower(1);
            robot.frontLeftDrive.setPower(1);
            robot.backLeftDrive.setPower(-1);
            sleep(435);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(200);
            robot.frontRightDrive.setPower(-0.4);
            robot.backRightDrive.setPower(-0.4);
            robot.frontLeftDrive.setPower(-0.4);
            robot.backLeftDrive.setPower(-0.4);
            sleep(800);
            robot.frontRightDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(200);
            robot.slideMotor.setPower(0.8);
            sleep(1800); //used to be 1200
            robot.slideMotor.setPower(0);
            sleep(500);
            robot.outtakeServo.setPosition(1);
            sleep(1000);
            robot.outtakeServo.setPosition(0);
            sleep(1000);
            robot.slideMotor.setPower(-0.8);
            sleep(1500); //used to be 800
            robot.slideMotor.setPower(0);
            sleep(500);
        }

        if (Alliance == BASICAUTONOMOUS.Parking.BRed) {
            robot.backRightDrive.setPower(0.9);
            robot.backLeftDrive.setPower(1);
            robot.frontLeftDrive.setPower(1);
            robot.frontRightDrive.setPower(0.9);
            sleep(750);
            robot.backRightDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.frontRightDrive.setPower(0);
            sleep(500);
            robot.backRightDrive.setPower(1);
            robot.backLeftDrive.setPower(-1);
            robot.frontLeftDrive.setPower(-1);
            robot.frontRightDrive.setPower(1);
            sleep(400);
            robot.backRightDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.frontRightDrive.setPower(0);
            sleep(500);
            robot.backRightDrive.setPower(-0.4);
            robot.backLeftDrive.setPower(-0.4);
            robot.frontLeftDrive.setPower(-0.4);
            robot.frontRightDrive.setPower(-0.4);
            sleep(3000);
            robot.backRightDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.frontRightDrive.setPower(0);
            sleep(500);
            robot.slideMotor.setPower(0.8);
            sleep(1800);
            robot.slideMotor.setPower(0);
            sleep(500);
            robot.outtakeServo.setPosition(1);
            sleep(750);
            robot.outtakeServo.setPosition(0);
            sleep(1500);
            robot.slideMotor.setPower(-0.8);
            sleep(1500);
            robot.slideMotor.setPower(0);
            sleep(500);
            robot.frontRightDrive.setPower(0.7);
            robot.frontLeftDrive.setPower(0.7);
            robot.backRightDrive.setPower(0.7);
            robot.backLeftDrive.setPower(0.7);
            sleep(500);
            robot.frontRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(500);
            robot.frontRightDrive.setPower(0.7);
            robot.frontLeftDrive.setPower(-0.7);
            robot.backRightDrive.setPower(-0.7);
            robot.backLeftDrive.setPower(0.7);
            sleep(1300);
            robot.frontRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(987);
            robot.frontRightDrive.setPower(-0.5);
            robot.frontLeftDrive.setPower(-0.5);
            robot.backRightDrive.setPower(-0.5);
            robot.backLeftDrive.setPower(-0.5);
            sleep(1400);
            robot.frontRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
            sleep(50);
        }

        if (Alliance == BASICAUTONOMOUS.Parking.BBlue) {
            robot.frontRightDrive.setPower(0.7);
            robot.frontLeftDrive.setPower(-0.7);
            robot.backRightDrive.setPower(-0.7);
            robot.backLeftDrive.setPower(0.7);
            sleep(2400);
            robot.frontRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.backRightDrive.setPower(0);
            robot.backLeftDrive.setPower(0);
//            robot.backRightDrive.setPower(1);
//            robot.backLeftDrive.setPower(0.9);
//            robot.frontLeftDrive.setPower(0.9);
//            robot.frontRightDrive.setPower(1);
//            sleep(800);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.frontRightDrive.setPower(0);
//            sleep(500);
//            robot.backRightDrive.setPower(-1);
//            robot.backLeftDrive.setPower(1);
//            robot.frontLeftDrive.setPower(1);
//            robot.frontRightDrive.setPower(-1);
//            sleep(450);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.frontRightDrive.setPower(0);
//            sleep(500);
//            robot.backRightDrive.setPower(-0.4);
//            robot.backLeftDrive.setPower(-0.4);
//            robot.frontLeftDrive.setPower(-0.4);
//            robot.frontRightDrive.setPower(-0.4);
//            sleep(3000);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.frontRightDrive.setPower(0);
//            sleep(500);
//            robot.slideMotor.setPower(0.8);
//            sleep(1800);
//            robot.slideMotor.setPower(0);
//            sleep(500);
//            robot.outtakeServo.setPosition(1);
//            sleep(1000);
//            robot.outtakeServo.setPosition(0);
//            sleep(1000);
//            robot.slideMotor.setPower(-0.8);
//            sleep(1500);
//            robot.slideMotor.setPower(0);
//            sleep(500);
//            robot.frontRightDrive.setPower(0.7);
//            robot.frontLeftDrive.setPower(0.7);
//            robot.backRightDrive.setPower(0.7);
//            robot.backLeftDrive.setPower(0.7);
//            sleep(500);
//            robot.frontRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(500);
//            robot.frontRightDrive.setPower(-0.7);
//            robot.frontLeftDrive.setPower(0.7);
//            robot.backRightDrive.setPower(0.7);
//            robot.backLeftDrive.setPower(-0.7);
//            sleep(1300);
//            robot.frontRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(987);
//            robot.frontRightDrive.setPower(-0.5);
//            robot.frontLeftDrive.setPower(-0.5);
//            robot.backRightDrive.setPower(-0.5);
//            robot.backLeftDrive.setPower(-0.5);
//            sleep(1400);
//            robot.frontRightDrive.setPower(0);
//            robot.frontLeftDrive.setPower(0);
//            robot.backRightDrive.setPower(0);
//            robot.backLeftDrive.setPower(0);
//            sleep(50);
        }
    }
}

