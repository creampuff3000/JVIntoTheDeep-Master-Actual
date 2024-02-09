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
    public DcMotor rslide = null;
    public Servo launchServo = null;
    public Servo leftOuttakeServo = null;
    public Servo mosaicServo = null;
    public Servo rightOuttakeServo = null;
    public DcMotor lslide = null;

    public WebcamName camera = null;
    @Override
    public void init(HardwareMap hwMap) {
        // Define and Initialize Motors
        frontLeftDrive  = hwMap.get(DcMotor.class, "frontLeftDrive");
        frontRightDrive = hwMap.get(DcMotor.class, "frontRightDrive");
        backLeftDrive = hwMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hwMap.get(DcMotor.class, "backRightDrive");
        intakeMotor = hwMap.get(DcMotor.class, "intakeMotor");
        lslide = hwMap.get(DcMotor.class, "lslide");
        rslide = hwMap.get(DcMotor.class, "rslide");
        launchServo = hwMap.get(Servo.class, "launchServo");
        leftOuttakeServo = hwMap.get(Servo.class, "leftOuttakeServo");
        mosaicServo = hwMap.get(Servo.class, "mosaicServo");
        rightOuttakeServo = hwMap.get(Servo.class, "rightOuttakeServo");
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        lslide .setDirection(DcMotor.Direction.REVERSE);
        rslide.setDirection(DcMotor.Direction.FORWARD);
        rightOuttakeServo.setDirection(Servo.Direction.REVERSE);
        intakeMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lslide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rslide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        camera = hwMap.get(WebcamName.class, "webcam");
        Stop();
    }
    public void Stop(){
        frontRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        intakeMotor.setPower(0);
        lslide.setPower(0);
        rslide.setPower(0);
        launchServo.setPosition(1);
        leftOuttakeServo.setPosition(1);
        rightOuttakeServo.setPosition(1);
        mosaicServo.setPosition(1); // 1 is the right position for mosaicServo
    }
}
