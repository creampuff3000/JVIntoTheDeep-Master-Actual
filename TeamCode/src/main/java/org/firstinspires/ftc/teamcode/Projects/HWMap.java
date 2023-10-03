package org.firstinspires.ftc.teamcode.Projects;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HWMap extends Project{

    public DcMotor  frontLeftDrive   = null;
    public DcMotor  frontRightDrive  = null;
    public DcMotor  backLeftDrive = null;
    public DcMotor  backRightDrive     = null;
    public DcMotor    intakeMotor    = null;
    public DcMotor    outtakeMotor   = null;
    public Servo    tiltServo = null;
    public Servo rotateServo = null;

    public Servo  leftClimb = null;

    public Servo  rightClimb = null;

    @Override
    public void init(HardwareMap hwMap) {
        // Define and Initialize Motors
        frontLeftDrive  = hwMap.get(DcMotor.class, "frontLeftDrive");
        frontRightDrive = hwMap.get(DcMotor.class, "frontRightDrive");
        backLeftDrive = hwMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hwMap.get(DcMotor.class, "backRightDrive");
        intakeMotor = hwMap.get(DcMotor.class, "intakeMotor");
        outtakeMotor = hwMap.get(DcMotor.class, "outtakeMotor");
       // leftClimb  = hwMap.get(DcMotor.class, "left_Climb");
        //rightClimb = hwMap.get(DcMotor.class, "right_Climb");
       // intake = hwMap.get(DcMotor.class, "intake");
        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
      //  intake.setDirection(DcMotor.Direction.FORWARD);
        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        // leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Define and initialize ALL installed servos.
       // outtakeServo = hwMap.get(Servo.class, "outtakeServo");
        tiltServo = hwMap.get(Servo.class, "tiltServo");
        rotateServo = hwMap.get(Servo.class, "rotateServo");
        rightClimb = hwMap.get(Servo.class, "rotateServo");
        leftClimb = hwMap.get(Servo.class, "rotateServo");
        Stop();
    }
    public void Stop(){
        frontRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        intakeMotor.setPower(0);
        tiltServo.setPosition(0);
        rotateServo.setPosition(1);
    }
}
