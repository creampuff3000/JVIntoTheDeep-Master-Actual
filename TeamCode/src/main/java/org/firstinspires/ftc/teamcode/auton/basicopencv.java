package org.firstinspires.ftc.teamcode.auton;


import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;
import org.firstinspires.ftc.teamcode.Projects.HWMap;
import org.firstinspires.ftc.teamcode.auton.BluePropDetectionPipeline.BluePropLocation;
import org.firstinspires.ftc.teamcode.auton.RedPropDetectionPipeline.RedPropLocation;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

@Autonomous(name = "hopefullythisworks")

public class basicopencv extends LinearOpMode {
    enum Parking {
        FBlue,
        BBlue,
        BRed,
        FRed,
    }
    OpenCvCamera webcam;
    Gamepad currentGamepad1 = new Gamepad();
    Gamepad previousGamepad1 = new Gamepad();
    public HWMap robot = new HWMap();
    public String location = "Left";
    RedPropDetectionPipeline RedPropDetectionPipeline = new RedPropDetectionPipeline(telemetry);
    BluePropDetectionPipeline BluePropDetectionPipeline = new BluePropDetectionPipeline(telemetry);
    @Override
    public void runOpMode() throws InterruptedException {


        //initialize hardware map
        robot.init(hardwareMap);
        Parking Alliance = Parking.FBlue;
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName()); // init the camera?
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "webcam"), cameraMonitorViewId); // init the camera?

        robot.frontRightDrive.setTargetPosition(0);
        robot.frontLeftDrive.setTargetPosition(0);
        robot.backRightDrive.setTargetPosition(0);
        robot.backLeftDrive.setTargetPosition(0);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() { // init the camera?
            @Override
            public void onOpened() {
                webcam.startStreaming(1280, 960, OpenCvCameraRotation.UPRIGHT); // starting the camera at 1280 x 800
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        telemetry.setMsTransmissionInterval(50); // setting the amount of time between new shots transmitted

        int direction = 1;
        int otherDirection = -1;

        boolean isFBlue = false;
        boolean isBBlue = false;
        boolean isFRed = false;
        boolean isBRed = false;
        int numberthing = 0;

        // hi
        // Autonomous code starts here
        while (!isStarted()) {
            // uygiufougoijpiuhitfjfstuhhdstersuyrukuy;oyg
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);
            if (currentGamepad1.right_bumper && !previousGamepad1.right_bumper) {

                isFBlue = true;
                isBBlue = false;
                isFRed = false;
                isBRed = false;
                numberthing = 1;
            }
            if (currentGamepad1.left_bumper && !previousGamepad1.left_bumper) {

                isFBlue = false;
                isBBlue = false;
                isFRed = true;
                isBRed = false;
                numberthing = 3;
            }
            if (currentGamepad1.left_trigger != 0) {

                isFBlue = false;
                isBBlue = false;
                isFRed = false;
                isBRed = true;
                numberthing = 4;
            }
            if (currentGamepad1.right_trigger != 0) {
                isFBlue = false;
                isBBlue = true;
                isFRed = false;
                isBRed = false;
                numberthing = 2;
            }

            if (isFBlue) {

                Alliance = Parking.BBlue;
            }
            if (isBBlue) {

                Alliance = Parking.FRed;
            }
            if (isFRed) {

                Alliance = Parking.BRed;
            }
            if (isBRed) {

                Alliance = Parking.FBlue;
            }
            telemetry.addData("Parking", Alliance);
            telemetry.update();

            if (numberthing == 1 || numberthing == 2) {
                webcam.setPipeline(BluePropDetectionPipeline); // setting the pipeline
                BluePropLocation elementLocation = BluePropDetectionPipeline.getPropLocation(); // getting the prop location into a variable elementLocation
                if (elementLocation == BluePropLocation.RIGHT) {
                    telemetry.addLine("right");
                    telemetry.update();
                    location = "Right";
                    sleep(500);


                } else if (elementLocation == BluePropLocation.LEFT) {
                    telemetry.addLine("left");
                    telemetry.update();
                    location = "Left";
                    sleep(500);

                } else if (elementLocation == BluePropLocation.MIDDLE) {
                    telemetry.addLine("middle");
                    telemetry.update();
                    location = "Middle";
                    sleep(500);


                } else {
                    telemetry.addLine("rip");
                    telemetry.update();
                    location = "Middle";
                    sleep(500);
                }
            }
            if (numberthing == 3 || numberthing == 4) {
                webcam.setPipeline(BluePropDetectionPipeline); // setting the pipeline
                BluePropLocation elementLocation = BluePropDetectionPipeline.getPropLocation(); // getting the prop location into a variable elementLocation
                if (elementLocation == BluePropLocation.RIGHT) {
                    telemetry.addLine("right");
                    telemetry.update();
                    location = "Right";
                    sleep(500);


                } else if (elementLocation == BluePropLocation.LEFT) {
                    telemetry.addLine("left");
                    telemetry.update();
                    location = "Left";
                    sleep(500);

                } else if (elementLocation == BluePropLocation.MIDDLE) {
                    telemetry.addLine("middle");
                    telemetry.update();
                    location = "Middle";
                    sleep(500);


                } else {
                    telemetry.addLine("rip");
                    telemetry.update();
                    location = "Middle";
                    sleep(500);
                }
            }
        }

        waitForStart(); //wait for play button to be pressed

        if (numberthing == 1 || numberthing == 2)
        { // BBlue
            blueSide(location);
        }
        else if (numberthing == 3 || numberthing == 4)
        {
            //something happens
        }
    }
    public void tile(double tileNum)
    {
        int fleft = robot.frontRightDrive.getCurrentPosition();
        int bleft = robot.frontLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.backLeftDrive.getCurrentPosition();
        robot.frontRightDrive.setPower(0.8);
        robot.frontLeftDrive.setPower(0.8);
        robot.backRightDrive.setPower(0.8);
        robot.backLeftDrive.setPower(0.8);
        robot.frontRightDrive.setTargetPosition((int)(fright + 1000 * tileNum));
        robot.frontLeftDrive.setTargetPosition((int)(fleft + 1000 * tileNum));
        robot.backRightDrive.setTargetPosition((int)(bright + 1000 * tileNum));
        robot.backLeftDrive.setTargetPosition((int)(bleft + 1000 * tileNum));
        sleep(2000);
    }
    public void right90()
    {
        sleep(100);
        int fleft = robot.frontRightDrive.getCurrentPosition();
        int bleft = robot.frontLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.backLeftDrive.getCurrentPosition();
        robot.frontLeftDrive.setPower(0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backLeftDrive.setPower(0.7);
        robot.backRightDrive.setPower(0.7);
        robot.frontLeftDrive.setTargetPosition(fleft + 500);
        robot.frontRightDrive.setTargetPosition(fright - 250);
        robot.backLeftDrive.setTargetPosition(bleft + 500);
        robot.backRightDrive.setTargetPosition(bright - 250);
        sleep(100);
    }
    public void pixelDown()
    {
        sleep(200);
        robot.intakeMotor.setPower(-0.1);
        sleep(300);
        robot.intakeMotor.setPower(0);
    }
    public void outtake()
    {
        sleep(500);
        int slidePos1 = robot.slide1.getCurrentPosition();
        int slidePos2 = robot.slide1.getCurrentPosition();
        robot.slide1.setPower(0.7);
        robot.slide2.setPower(0.7);
        robot.slide1.setTargetPosition(slidePos1 + 2000);
        robot.slide2.setTargetPosition(slidePos2 + 2000);
        sleep(100);
        robot.outtakeServo.setPosition(1);
        sleep(500);
        robot.outtakeServo.setPosition(0);
        slidePos1 = robot.slide1.getCurrentPosition();
        slidePos2 = robot.slide2.getCurrentPosition();
        robot.slide1.setPower(0.7);
        robot.slide2.setPower(0.7);
        robot.slide2.setTargetPosition(slidePos2 - 2000);
        robot.slide1.setTargetPosition(slidePos1 - 2000);
        sleep(100);
    }
    public void strafeLeft(int time)
    {
        sleep(100);
        robot.frontLeftDrive.setPower(-0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backRightDrive.setPower(-0.7);
        robot.backLeftDrive.setPower(0.7);
        sleep(time);
        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        sleep(100);
    }
    public void blueSide(String location)
    {
        if (location == "Middle")
        {
            tile(1.5);
            pixelDown();
            right90();
            tile(-1.2);
            outtake();
            tile(-0.2);
            strafeLeft(1300);
            tile(0.5);
        }
    }
}

