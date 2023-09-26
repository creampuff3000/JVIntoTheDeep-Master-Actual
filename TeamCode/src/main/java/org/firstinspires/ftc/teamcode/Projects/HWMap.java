package org.firstinspires.ftc.teamcode.Projects;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HWMap extends Project{

    public DcMotor  frontLeftDrive   = null;
    public DcMotor  frontRightDrive  = null;
    public DcMotor  backLeftDrive = null;
    public DcMotor  backRightDrive     = null;
    public Servo    intakeServo    = null;
    public Servo    outtakeServo   = null;
    public Servo    tiltServo = null;
    public Servo rotateServo = null;

    public DcMotor  leftClimb = null;

    public DcMotor  rightClimb = null;

    @Override
    public void init(HardwareMap hwMap) {
        // Define and Initialize Motors
        frontLeftDrive  = hwMap.get(DcMotor.class, "left_drive");
        frontRightDrive = hwMap.get(DcMotor.class, "right_drive");
        backLeftDrive = hwMap.get(DcMotor.class, "back_left");
        backRightDrive = hwMap.get(DcMotor.class, "back_right");
        leftClimb  = hwMap.get(DcMotor.class, "left_climb");
        rightClimb = hwMap.get(DcMotor.class, "right_climb");
        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        // leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Define and initialize ALL installed servos.

        intakeServo  = hwMap.get(Servo.class, "intakeServo");
        outtakeServo = hwMap.get(Servo.class, "outtakeServo");
        tiltServo = hwMap.get(Servo.class, "tiltServo");
        rotateServo = hwMap.get(Servo.class, "rotateServo");

        Stop();
    }
    public void Stop(){
        frontRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        intakeServo.setPosition(0);
        outtakeServo.setPosition(0);
        tiltServo.setPosition(0);
        rotateServo.setPosition(0);
    }
}