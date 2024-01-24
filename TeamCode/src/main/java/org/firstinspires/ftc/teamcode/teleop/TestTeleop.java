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
        boolean slowMode = false;
        waitForStart();
        boolean isSpinning = false;
        double speed = 1;
        while (opModeIsActive()) {
            double p = 0;
            if (gamepad1.left_bumper == true)
            {
                if (p == 0)
                {
                    slowMode = true;
                    p = 1;
                }
                if (p == 1)
                {
                    slowMode = false;
                    p = 0;
                }
            }
            if (slowMode == true)
            {
                speed = 0.1;
            }
            else
            {
                speed = 1;
            }
            boolean aButtonHeld = false;
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            robot.frontLeftDrive.setPower(frontLeftPower * speed);
            robot.backLeftDrive.setPower(backLeftPower * speed);
            robot.frontRightDrive.setPower(frontRightPower * speed);
            robot.backRightDrive.setPower(backRightPower * speed);

            robot.frontRightDrive.setTargetPosition(0);
            robot.frontLeftDrive.setTargetPosition(0);
            robot.backRightDrive.setTargetPosition(0);
            robot.backLeftDrive.setTargetPosition(0);
            robot.slide1.setTargetPosition(0);
            robot.slide2.setTargetPosition(0);
            robot.frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.slide1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.slide2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.slide1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.slide2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // outtake
            if (gamepad2.right_trigger == 1) {
                double outtake1Pos = robot.leftOuttakeServo.getPosition();
                double outtake2Pos = robot.rightOuttakeServo.getPosition();
                if (outtake1Pos == 0 && outtake2Pos == 0) {
                    robot.leftOuttakeServo.setPosition(1);
                    robot.rightOuttakeServo.setPosition(1);
                    sleep(500);
                } else if (outtake1Pos == 1 && outtake2Pos == 1) {
                    robot.leftOuttakeServo.setPosition(0);
                    robot.rightOuttakeServo.setPosition(0);
                    sleep(500);
                } else if (outtake1Pos == 1 && outtake2Pos == 0 | outtake1Pos == 0 && outtake2Pos == 1){
                    telemetry.addLine("rip");
                    telemetry.update();
                }
            }
            // launch
            if (gamepad1.right_bumper == true) {
                double d = robot.launchServo.getPosition();
                if (d == 0) {
                    robot.launchServo.setPosition(1);
                    sleep(500);
                } else if (d == 1) {
                    robot.launchServo.setPosition(0);
                    sleep(500);
                }
            }
            // mosaic
            if (gamepad1.y == true) {
                double e = robot.mosaicServo.getPosition();
                if (e == 0) {
                    robot.mosaicServo.setPosition(1);
                    sleep(800);
                } else if (e == 1) {
                    robot.mosaicServo.setPosition(0);
                    sleep(800);
                }
            }
            // intake
            if (gamepad1.a == true) {
                robot.intakeMotor.setPower(1);
            }
            if (gamepad1.b == true) {
                robot.intakeMotor.setPower(0);
            }
            if (gamepad1.x == true) {
                robot.intakeMotor.setPower(-0.5);
            }
            // lift held
            if (gamepad2.dpad_up == true) {
                robot.slide1.setPower(1);
                robot.slide2.setPower(1);
            }
            else if (gamepad2.dpad_down == true) {
                robot.slide1.setPower(-1);
                robot.slide2.setPower(-1);
            }
            else {
                robot.slide1.setPower(0);
                robot.slide2.setPower(0);
            }

            // presets
            if (gamepad2.a == true) {
                robot.slide1.setPower(-1);
                robot.slide2.setPower(-1);
                robot.slide1.setTargetPosition(0);
                robot.slide2.setTargetPosition(0);
            }
            if (gamepad2.x == true){
                int value = robot.slide1.getCurrentPosition();
                int value2 = robot.slide2.getCurrentPosition();
                if (value < 400) {
                    robot.slide1.setPower(1);
                    robot.slide2.setPower(1);
                    robot.slide1.setTargetPosition(400);
                    robot.slide2.setTargetPosition(400);
                }
                if (value > 400);{
                    robot.slide1.setPower(-1);
                    robot.slide2.setPower(-1);
                    robot.slide1.setTargetPosition(400);
                    robot.slide2.setTargetPosition(400);
                }
            }
            if (gamepad2.b == true){
                int value = robot.slide1.getCurrentPosition();
                int value2 = robot.slide2.getCurrentPosition();
                if (value < 800) {
                    robot.slide1.setPower(1);
                    robot.slide2.setPower(1);
                    robot.slide1.setTargetPosition(800);
                    robot.slide2.setTargetPosition(800);
                }
                if (value > 800) {
                    robot.slide1.setPower(-1);
                    robot.slide2.setPower(-1);
                    robot.slide1.setTargetPosition(800);
                    robot.slide2.setTargetPosition(800);
                }
            }
            if (gamepad2.y == true){
                int value = robot.slide1.getCurrentPosition();
                int value2 = robot.slide2.getCurrentPosition();
                if (value < 1200) {
                    robot.slide1.setPower(1);
                    robot.slide2.setPower(1);
                    robot.slide1.setTargetPosition(1200);
                    robot.slide2.setTargetPosition(1200);
                }
                if (value > 1200) {
                    robot.slide1.setPower(-1);
                    robot.slide2.setPower(-1);
                    robot.slide1.setTargetPosition(1200);
                    robot.slide2.setTargetPosition(1200);
                }
            }
            if (gamepad2.dpad_left == true){
                int value = robot.slide1.getCurrentPosition();
                int value2 = robot.slide2.getCurrentPosition();
                if (value < 1600) {
                    robot.slide1.setPower(1);
                    robot.slide2.setPower(1);
                    robot.slide1.setTargetPosition(1600);
                    robot.slide2.setTargetPosition(1600);
                }
                if (value > 1600) {
                    robot.slide1.setPower(-1);
                    robot.slide2.setPower(-1);
                    robot.slide1.setTargetPosition(1600);
                    robot.slide2.setTargetPosition(1600);
                }
            }
            if (gamepad2.dpad_right == true){
                int value = robot.slide1.getCurrentPosition();
                int value2 = robot.slide2.getCurrentPosition();
                if (value < 2000) {
                    robot.slide1.setPower(1);
                    robot.slide2.setPower(1);
                    robot.slide1.setTargetPosition(2000);
                    robot.slide2.setTargetPosition(2000);
                }
                if (value > 2000) {
                    robot.slide1.setPower(-1);
                    robot.slide2.setPower(-1);
                    robot.slide1.setTargetPosition(2000);
                    robot.slide2.setTargetPosition(2000);
                }
            }
        }
    }
}