package org.firstinspires.ftc.teamcode.Projects;
import com.qualcomm.hardware.motors.RevRoboticsUltraPlanetaryHdHexMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

public class HWMap extends Project{
    public DcMotor  frontLeftDrive   = null;
    public DcMotor  frontRightDrive  = null;
    public DcMotor  backLeftDrive = null;
    public DcMotor  backRightDrive     = null;
    public DcMotor    intakeMotor   = null;
    public DcMotor slide2 = null;
    public Servo launchServo = null;
    public Servo leftOuttakeServo = null;
    public Servo mosaicServo = null;
    public Servo rightOuttakeServo;
    public DcMotor slide1 = null;

    public WebcamName camera = null;
    @Override
    public void init(HardwareMap hwMap) {
        // Define and Initialize Motors
        frontLeftDrive  = hwMap.get(DcMotor.class, "frontLeftDrive");
        frontRightDrive = hwMap.get(DcMotor.class, "frontRightDrive");
        backLeftDrive = hwMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hwMap.get(DcMotor.class, "backRightDrive");
        intakeMotor = hwMap.get(DcMotor.class, "intakeMotor");
        slide1 = hwMap.get(DcMotor.class, "lslide");
        slide2 = hwMap.get(DcMotor.class, "rslide");
        launchServo = hwMap.get(Servo.class, "launchServo");
        leftOuttakeServo = hwMap.get(Servo.class, "leftOuttakeServo");
        mosaicServo = hwMap.get(Servo.class, "mosaicServo");
        rightOuttakeServo = hwMap.get(Servo.class, "rightOuttake");
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        slide1.setDirection(DcMotor.Direction.REVERSE);
        slide2.setDirection(DcMotor.Direction.FORWARD);
        rightOuttakeServo.setDirection(Servo.Direction.REVERSE);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slide2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        camera = hwMap.get(WebcamName.class, "webcam");
        Stop();
    }
    public void Stop(){
        frontRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        intakeMotor.setPower(0);
        slide1.setPower(0);
        slide2.setPower(0);
        launchServo.setPosition(0);
        leftOuttakeServo.setPosition(0);
        rightOuttakeServo.setPosition(0);
        mosaicServo.setPosition(1); // 1 is the right position for mosaicServo
    }
}
