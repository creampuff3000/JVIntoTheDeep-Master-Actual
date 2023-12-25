//package org.firstinspires.ftc.teamcode.auton;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.exception.RobotCoreException;
//import org.firstinspires.ftc.teamcode.Projects.HWMap;
//
//@Autonomous(name = "FRED Auton")
//public class FREDAuton extends LinearOpMode {
//
//
//    Gamepad currentGamepad1 = new Gamepad();
//    Gamepad previousGamepad1 = new Gamepad();
//    public HWMap robot = new HWMap();
//
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//        //initialize hardware map
//
//        robot.init(hardwareMap);
//
////        robot.frontRightDrive.setTargetPosition(0);
////        robot.frontLeftDrive.setTargetPosition(0);
////        robot.backRightDrive.setTargetPosition(0);
////        robot.backLeftDrive.setTargetPosition(0);
////        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        robot.frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////        robot.frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////        robot.backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////        robot.backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//
//        int direction = 1;
//        int otherDirection = -1;
//
//
//        // hi
//        // Autonomous code starts here
//
//        while (!isStarted()) {
//            // uygiufougoijpiuhitfjfstuhhdstersuyrukuy;oyg
//
//
//        }
//        waitForStart(); //wait for play button to be pressed
//
//
////            sleep(12000);
////            robot.frontRightDrive.setPower(1);
////            robot.backRightDrive.setPower(1);
////            robot.frontLeftDrive.setPower(0.8);
////            robot.backLeftDrive.setPower(0.8);
////            sleep(650);
////            robot.frontRightDrive.setPower(0);
////            robot.backRightDrive.setPower(0);
////            robot.frontLeftDrive.setPower(0);
////            robot.backLeftDrive.setPower(0);
////            sleep(500);
////            robot.frontRightDrive.setPower(1);
////            robot.backRightDrive.setPower(1);
////            robot.frontLeftDrive.setPower(-1);
////            robot.backLeftDrive.setPower(-1);
////            sleep(387);
////            robot.frontRightDrive.setPower(0);
////            robot.backRightDrive.setPower(0);
////            robot.frontLeftDrive.setPower(0);
////            robot.backLeftDrive.setPower(0);
////            sleep(500);
////            robot.frontRightDrive.setPower(-1);
////            robot.backRightDrive.setPower(-1);
////            robot.frontLeftDrive.setPower(-1);
////            robot.backLeftDrive.setPower(-1);
////            sleep(2060);
////            robot.frontRightDrive.setPower(0);
////            robot.backRightDrive.setPower(0);
////            robot.frontLeftDrive.setPower(0);
////            robot.backLeftDrive.setPower(0);
////            sleep(800);
////            robot.slideMotor.setPower(0.4);
////            sleep(1200);
////            robot.slideMotor.setPower(0);
////            sleep(500);
////            robot.outtakeServo.setPosition(1);
////            sleep(1000);
////            robot.outtakeServo.setPosition(0);
////            sleep(1000);
////            robot.slideMotor.setPower(-0.6);
////            sleep(800);
////            robot.slideMotor.setPower(0);
////            sleep(500);
////        }
//
