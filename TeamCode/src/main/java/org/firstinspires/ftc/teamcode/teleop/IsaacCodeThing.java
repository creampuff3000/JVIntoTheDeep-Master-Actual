//package org.firstinspires.ftc.teamcode.teleop;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.exception.RobotCoreException;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
//import org.firstinspires.ftc.teamcode.Projects.HWMap;
//
//@TeleOp(name = "Isaac")
//public class IsaacCodeThing extends LinearOpMode {
//    public HWMap robot = new HWMap();
//
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//        robot.init(hardwareMap);
//
//        double speed = .9;
//        waitForStart();
//        boolean isSpinning = false;
//        while (opModeIsActive()) {
//            boolean aButtonHeld = false;
//            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
//            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
//            double rx = -gamepad1.right_stick_x;
//
//            // Denominator is the largest motor power (absolute value) or 1
//            // This ensures all the powers maintain the same ratio, but only when
//            // at least one is out of the range [-1, 1]
//            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
//            double frontLeftPower = (y + x + rx) / denominator;
//            double backLeftPower = (y - x + rx) / denominator;
//            double frontRightPower = (y - x - rx) / denominator;
//            double backRightPower = (y + x - rx) / denominator;
//
//            robot.frontLeftDrive.setPower(frontLeftPower * speed);
//            robot.backLeftDrive.setPower(backLeftPower * speed);
//            robot.frontRightDrive.setPower(frontRightPower * speed);
//            robot.backRightDrive.setPower(backRightPower * speed);
////            robot.slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        }
//    }
//}
////             Teleop Code goes here         }
//// Code a program that allows the robot to slide up using slideMotor 0.6 speed, and then drive backwards for 500 milliseconds at max speed.
//// Variables: backLeftDrive, frontLeftDrive,backRightDrive,backLeftDrive,slideMotor
//if (gamepad.a){
//    robot.slideMotor.setPower(0.6);
//    sleep(900);
//    robot.slideMotor.setPower(0);
//}
//if (gamepad.right_trigger == 1){
//    robot.backLeftDrive.setPower(-1);
//    robot.frontLeftDrive.setPower(-1);
//    robot.backRightDrive.setPower(-1);
//    robot.frontRightDrive.setPower(-1);
//    sleep(500);
//    robot.backLeftDrive.setPower(0);
//    robot.frontLeftDrive.setPower(0);
//    robot.backRightDrive.setPower(0);
//    robot.frontRightDrive.setPower(0);
//}
//}
