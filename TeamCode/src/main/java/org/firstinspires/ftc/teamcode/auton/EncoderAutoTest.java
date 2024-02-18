package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Projects.HWMap;
@Autonomous(name="EncoderAutoTest", group="test")
public class EncoderAutoTest extends LinearOpMode {
    public static final double TICKS_PER_REV = 1120;
    public static double WHEEL_RADIUS = (75 / 25.4) / 2.0;
    public static double GEAR_RATIO = 0.065;

    public HWMap robot = new HWMap();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        setDrivetrainMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (!isStarted()) {
            telemetry.addLine("auto in init");
            telemetry.update();
        }
        waitForStart();
        if (opModeIsActive()) {
            driveForward(0.5, 10);
            /*driveBackwards(0.5, 10);
            driveForward(0.5, 5);
            turnLeft(0.5);
            turnRight(0.5);*/
        }
        while (opModeIsActive()) {
            telemetry.update();
        }
    }

    public void logTicks() {

    }
    public void driveForward(double speed, double inches) {
        encoderDrive(speed, inches, inches, inches, inches);
    }
    public void driveBackwards(double speed, double inches) {
        encoderDrive(speed, -inches, -inches, -inches, -inches);
    }
    public void strafeRight(double speed, double inches) {
        encoderDrive(speed, inches, -inches, -inches, inches);
    }

    public void strafeLeft(double speed, double inches) {
        encoderDrive(speed, -inches, inches, inches, -inches);
    }

    // Turn 90 degrees right
    public void turnRight(double speed) {
        // TODO: NEED TO TUNE TURN VALUES
        encoderDrive(speed, 10, -10, 10, -10);
    }

    // Turn 90 degrees left
    public void turnLeft(double speed) {
        // TODO: NEED TO TUNE TURN VALUES, they should all be the same value except left should be negative and right should be positive
        // TODO: Keep adjusting values until you get a turn that looks somewhat close to 90 degrees.
        encoderDrive(speed, -10, 10, -10, 10);
    }

    public void setDrivetrainTarget(int backLeftTarget, int backRightTarget, int frontLeftTarget, int frontRightTarget) {
        robot.backLeftDrive.setTargetPosition(backLeftTarget);
        robot.backRightDrive.setTargetPosition(backRightTarget);
        robot.frontLeftDrive.setTargetPosition(frontLeftTarget);
        robot.frontRightDrive.setTargetPosition(frontRightTarget);
    }
    public void setDrivetrainMode(DcMotor.RunMode mode) {
        robot.backLeftDrive.setMode(mode);
        robot.backRightDrive.setMode(mode);
        robot.frontLeftDrive.setMode(mode);
        robot.frontRightDrive.setMode(mode);
    }

    public boolean isBusy() {
        return robot.backLeftDrive.isBusy() && robot.backRightDrive.isBusy() && robot.frontLeftDrive.isBusy() && robot.frontRightDrive.isBusy();
    }

    public void encoderDrive(double speed,
                             double leftFrontInches, double rightFrontInches, double leftBackInches, double rightBackInches) {
        int newLFTarget;
        int newRFTarget;
        int newLBTarget;
        int newRBTarget;

        // Ensure that the opmode is still active

        // Determine new target position, and pass to motor controller
        newLFTarget = robot.frontLeftDrive.getCurrentPosition() + (int) (inchesToEncoderTicks(leftFrontInches));
        newRFTarget = robot.frontRightDrive.getCurrentPosition() + (int) (inchesToEncoderTicks(rightFrontInches));
        newLBTarget = robot.backLeftDrive.getCurrentPosition() + (int) (inchesToEncoderTicks(leftBackInches));
        newRBTarget = robot.backRightDrive.getCurrentPosition() + (int) (inchesToEncoderTicks(rightBackInches));
        telemetry.addData("frontLeftPosition: ", newLFTarget);
        telemetry.addData("frontRightPosition: ", newRFTarget);
        telemetry.addData("backLeftPosition: ", newLBTarget);
        telemetry.addData("backRightPosition: ", newRBTarget);
        telemetry.update();

        setDrivetrainTarget(newLBTarget, newRBTarget, newLFTarget, newRFTarget);

        // Turn On RUN_TO_POSITION
        setDrivetrainMode(DcMotor.RunMode.RUN_TO_POSITION);

        // reset the timeout time and start motion.
        setDrivePowers(Math.abs(speed), Math.abs(speed), Math.abs(speed), Math.abs(speed));

        // keep looping while we are still active, and there is time left, and both motors are running.
        // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
        // its target position, the motion will stop.  This is "safer" in the event that the robot will
        // always end the motion as soon as possible.
        // However, if you require that BOTH motors have finished their moves before the robot continues
        // onto the next step, use (isBusy() || isBusy()) in the loop test.
        while (isBusy()) {
        }

        // Stop all motion;
        stopDrive();

        // Turn off RUN_TO_POSITION
        setDrivetrainMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    public void setDrivePowers(double backLeft, double backRight, double frontLeft, double frontRight) {
        robot.backLeftDrive.setPower(backLeft);
        robot.backRightDrive.setPower(backRight);
        robot.frontLeftDrive.setPower(frontLeft);
        robot.frontRightDrive.setPower(frontRight);
    }

    public void stopDrive() {
        setDrivePowers(0, 0, 0, 0);
    }
    public static double inchesToEncoderTicks(double inches) {
        return (inches * TICKS_PER_REV) / (2 * WHEEL_RADIUS * Math.PI * GEAR_RATIO);
    }
}
