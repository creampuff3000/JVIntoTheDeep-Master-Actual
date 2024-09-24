package org.firstinspires.ftc.teamcode.teleop;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Projects.HWMap;

@TeleOp(name = "driverhubnotcharging")
public class TestTeleop extends LinearOpMode {
    public HWMap robot = new HWMap();

    //rthrhyrjytjutyjjdfajflajldfsjf;lkadsjg;klsajl;jakfsdfjdsalkfjdsalkjfiuhiuhiuhuhuhuhuhuhuhuhuhuhuhuhuhu
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        boolean isSpinning = false;
        double speed = 1;
        boolean slowMode = false;
        boolean slowModeToggle = false;
        robot.lslide.setTargetPosition(0);
        robot.rslide.setTargetPosition(0);
        robot.lslide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rslide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.lslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (opModeIsActive()) {
            telemetry.addLine("lslide pos = " + robot.lslide.getCurrentPosition());
            telemetry.addLine("rslide pos = " + robot.rslide.getCurrentPosition());
            telemetry.update();

            boolean aButtonHeld = false;
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing (suspicious)
            double rx = -gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1jh
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

            //start coding here
            if (robot.clawServo.getPosition() == 1 && gamepad1.right_bumper == true) {
                robot.clawServo.setPosition(0);
            } else if (robot.clawServo.getPosition() == 0 && gamepad1.right_bumper == true) {
                robot.clawServo.setPosition(1);
            }
        }
    }
}