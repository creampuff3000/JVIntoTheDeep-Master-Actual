package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Projects.HWMap;

@TeleOp(name = "TestTeleop")
public class TestTeleop extends LinearOpMode {
    public HWMap robot = new HWMap();


    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        double speed = .9;
        waitForStart();
        boolean isSpinning = false;

        while (opModeIsActive()) {

            if (gamepad1.a == true) {
                robot.tiltServo.setPosition(1);
            }

            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = -(y + x + rx) / denominator;
            double backLeftPower = -(y - x + rx) / denominator;
            double frontRightPower = -(y - x - rx) / denominator;
            double backRightPower = -(y + x - rx) / denominator;

            robot.frontLeftDrive.setPower(frontLeftPower * speed);
            robot.backLeftDrive.setPower(backLeftPower * speed);
            robot.frontRightDrive.setPower(frontRightPower * speed);
            robot.backRightDrive.setPower(backRightPower * speed);
            // robot.outtakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            // Teleop Code goes here
            if (gamepad1.right_bumper == true) {
                double a = robot.tiltServo.getPosition();
                if (a == 0) {
                    robot.tiltServo.setPosition(1);
                } else if (a == 1) {
                    robot.tiltServo.setPosition(0);
                }
            }
            if (gamepad1.left_bumper == true) {
                double b = robot.rotateServo.getPosition();
                if (b == 0) {
                    robot.rotateServo.setPosition(1);
                } else if (b == 1) {
                    robot.rotateServo.setPosition(0);
                }
            }
            if (gamepad1.y == true) {
                double b = robot.outtakeServo.getPosition();
                if (b == 0) {
                    robot.outtakeServo.setPosition(1);
                } else if (b == 1) {
                    robot.outtakeServo.setPosition(0);
                }
            }
            if (gamepad1.a == true) {
                robot.intakeMotor.setPower(0.8);
            }
                if (gamepad1.dpad_down == true) {
                    robot.slideMotor.setTargetPosition(0);
                }
                if (gamepad1.dpad_left == true) {
                    robot.slideMotor.setTargetPosition(500);
                }
                if (gamepad1.dpad_right == true) {
                    robot.slideMotor.setTargetPosition(1000);
                }
                if (gamepad1.dpad_up == true) {
                    robot.slideMotor.setTargetPosition(1500);
                }
        }
    }
}



