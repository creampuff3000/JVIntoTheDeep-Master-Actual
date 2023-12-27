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

        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() { // init the camera?
            @Override
            public void onOpened() {
                webcam.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT); // starting the camera at 1280 x 800
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
        int robotPos = 0;

        // hi
        // Autonomous code starts here
        String var = "";
        while (!isStarted()) {
            // uygiufougoijpiuhitfjfstuhhdstersuyrukuy;oyg

            if (gamepad1.right_bumper == true) {

                isFBlue = true;
                isBBlue = false;
                isFRed = false;
                isBRed = false;
                robotPos = 1;
                var = "FBlue";
            }
            if (gamepad1.left_bumper == true) {

                isFBlue = false;
                isBBlue = false;
                isFRed = true;
                isBRed = false;
                robotPos = 3;
                var = "FRed";
            }
            if (gamepad1.left_trigger != 0) {

                isFBlue = false;
                isBBlue = false;
                isFRed = false;
                isBRed = true;
                robotPos = 4;
                var = "BRed";
            }
            if (gamepad1.right_trigger != 0) {
                isFBlue = false;
                isBBlue = true;
                isFRed = false;
                isBRed = false;
                robotPos = 2;
                var = "BBlue";
            }


            telemetry.addData("Parking", var);
            telemetry.update();
            sleep(1000);

            if (robotPos == 1 || robotPos == 2) {
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
            if (robotPos == 3 || robotPos == 4) {
                webcam.setPipeline(RedPropDetectionPipeline); // setting the pipeline
                RedPropLocation elementLocation = RedPropDetectionPipeline.getPropLocation(); // getting the prop location into a variable elementLocation
                if (elementLocation == RedPropLocation.RIGHT) {
                    telemetry.addLine("right");
                    telemetry.update();
                    location = "Right";
                    sleep(500);


                } else if (elementLocation == RedPropLocation.LEFT) {
                    telemetry.addLine("left");
                    telemetry.update();
                    location = "Left";
                    sleep(500);

                } else if (elementLocation == RedPropLocation.MIDDLE) {
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

        if (robotPos == 1)
        { // BBlue
            fBlue(location);
        }
        else if (robotPos == 2)
        {
            bBlue(location);
        }
        else if (robotPos == 3)
        {
            fRed(location);
        }
        else if (robotPos == 4)
        {
            bRed(location);
        }
    }
    public void tile(double tileNum)
    {
        int fright = robot.frontRightDrive.getCurrentPosition();
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        robot.frontRightDrive.setPower(0.8);
        robot.frontLeftDrive.setPower(0.8);
        robot.backRightDrive.setPower(0.8);
        robot.backLeftDrive.setPower(0.8);
        robot.frontRightDrive.setTargetPosition((int)(fright + 1000 * tileNum));
        robot.frontLeftDrive.setTargetPosition((int)(fleft + 1000 * tileNum));
        robot.backRightDrive.setTargetPosition((int)(bright + 1000 * tileNum));
        robot.backLeftDrive.setTargetPosition((int)(bleft + 1000 * tileNum));
        sleep(Math.abs((long)(1000 * tileNum)));
    }
    public void right90()
    {
        sleep(100);
        robot.frontLeftDrive.setPower(0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backLeftDrive.setPower(0.7);
        robot.backRightDrive.setPower(0.7);
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.frontRightDrive.getCurrentPosition();
        robot.frontLeftDrive.setTargetPosition(fleft + 1285);
        robot.frontRightDrive.setTargetPosition(fright - 1285);
        robot.backLeftDrive.setTargetPosition(bleft + 1285);
        robot.backRightDrive.setTargetPosition(bright - 1285);
        sleep(1000);
    }
    public void left90()
    {
        sleep(100);
        robot.frontLeftDrive.setPower(0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backLeftDrive.setPower(0.7);
        robot.backRightDrive.setPower(0.7);
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.frontRightDrive.getCurrentPosition();
        robot.frontLeftDrive.setTargetPosition(fleft - 1285);
        robot.frontRightDrive.setTargetPosition(fright + 1285);
        robot.backLeftDrive.setTargetPosition(bleft - 1285);
        robot.backRightDrive.setTargetPosition(bright + 1285);
        sleep(1000);
    }
    public void pixelDown()
    {
        sleep(200);
        robot.intakeMotor.setPower(0.3);
        sleep(1000);
        robot.intakeMotor.setPower(0);
    }
    public void outtake()
    {
        sleep(200);
        int slidePos1 = robot.slide1.getCurrentPosition();
        int slidePos2 = robot.slide2.getCurrentPosition();
        robot.slide1.setPower(0.7);
        robot.slide2.setPower(0.7);
        robot.slide1.setTargetPosition(slidePos1 + 2100);
        robot.slide2.setTargetPosition(slidePos2 + 2100);
        sleep(3000);
        robot.outtakeServo.setPosition(1);
        sleep(500);
        robot.outtakeServo.setPosition(0);
        sleep(500);
        robot.outtakeServo.setPosition(1);
        sleep(500);
        robot.outtakeServo.setPosition(0);
        sleep(500);
        robot.outtakeServo.setPosition(1);
        sleep(500);
    }
    public void slideDown()
    {
        int slidePos1 = robot.slide1.getCurrentPosition();
        int slidePos2 = robot.slide2.getCurrentPosition();
        robot.slide1.setPower(0.7);
        robot.slide2.setPower(0.7);
        robot.slide2.setTargetPosition(slidePos2 - 2100);
        robot.slide1.setTargetPosition(slidePos1 - 2100);
        sleep(3000);
    }
    public void strafeLeft(double tileNum)
    {
        robot.frontLeftDrive.setPower(-0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backRightDrive.setPower(-0.7);
        robot.backLeftDrive.setPower(0.7);
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.frontRightDrive.getCurrentPosition();
        robot.frontLeftDrive.setTargetPosition((int) (fleft - 800 * tileNum));
        robot.frontRightDrive.setTargetPosition((int) (fright + 800 * tileNum));;
        robot.backLeftDrive.setTargetPosition((int) (bleft + 800 * tileNum));
        robot.backRightDrive.setTargetPosition((int)(bright - 800 * tileNum));
        sleep(1000);
    }
    public void strafeRight(double tileNum)
    {
        robot.frontLeftDrive.setPower(0.7);
        robot.frontRightDrive.setPower(-0.7);
        robot.backRightDrive.setPower(0.7);
        robot.backLeftDrive.setPower(-0.7);
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.frontRightDrive.getCurrentPosition();
        robot.frontLeftDrive.setTargetPosition((int) (fleft + 800 * tileNum));
        robot.frontRightDrive.setTargetPosition((int) (fright - 800 * tileNum));;
        robot.backLeftDrive.setTargetPosition((int) (bleft - 800 * tileNum));
        robot.backRightDrive.setTargetPosition((int)(bright + 800 * tileNum));
        sleep(1000);
    }
    public void bBlue(String location)
    {
        if (location == "Middle")
        {
            tile(2);
            sleep(100);
            tile(-0.35);
            pixelDown();
            sleep(100);
            tile(-0.5);
            sleep(100);
            left90();
            sleep(100);
            tile(-2.25);
            sleep(100);
            outtake();
            sleep(100);
            tile(0.5);
            sleep(100);
            robot.outtakeServo.setPosition(0);
            sleep(500);
            slideDown();
            sleep(100);
            strafeLeft(2.2);
            tile(-1.6);
        }
        if (location == "Right")
        {
            right90();
//            tile(1.5);
//            pixelDown();
//            right90();
//            tile(-1.2);
//            outtake();
//            tile(-0.2);
//            strafeLeft(1300);
//            tile(0.5);
        }
        if (location == "Left")
        {
            tile(1.5);
            sleep(100);
            pixelDown();
            sleep(100);
            right90();
            sleep(100);
            tile(-1.2);
            sleep(100);
//            outtake();
//            tile(-0.2);
//            strafeLeft(1300);
//            tile(0.5);
        }
    }
    public void fBlue(String location)
    {
        tile(1.2);
    }
    public void fRed(String location)
    {

    }
    public void bRed(String location)
    {

    }
}

