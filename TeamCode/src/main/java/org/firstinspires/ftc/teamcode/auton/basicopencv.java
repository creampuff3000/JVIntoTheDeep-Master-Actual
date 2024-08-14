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

@Autonomous(name = "this")

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
        robot.lslide.setTargetPosition(0);
        robot.rslide.setTargetPosition(0);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.lslide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rslide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.lslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

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
            if (gamepad1.right_trigger != 0) {
                isFBlue = false;
                isBBlue = true;
                isFRed = false;
                isBRed = false;
                robotPos = 2;
                var = "BBlue";
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



            telemetry.addData("Parking", var);
            telemetry.update();
            sleep(500);

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
                    location = "Left";
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
                    location = "rip";
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

    public void slow(double tileNum)
    {
        int fright = robot.frontRightDrive.getCurrentPosition();
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        robot.frontRightDrive.setTargetPosition((int)(fright + 1350.846 * tileNum));
        robot.frontLeftDrive.setTargetPosition((int)(fleft + 1350.846 * tileNum));
        robot.backRightDrive.setTargetPosition((int)(bright + 1350.846 * tileNum));
        robot.backLeftDrive.setTargetPosition((int)(bleft + 1350.846 * tileNum));
        robot.frontRightDrive.setPower(0.1);
        robot.frontLeftDrive.setPower(0.1);
        robot.backRightDrive.setPower(0.1);
        robot.backLeftDrive.setPower(0.1);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.backLeftDrive.isBusy() && robot.backRightDrive.isBusy() && robot.frontLeftDrive.isBusy() && robot.frontRightDrive.isBusy()) {

        }
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void tile(double tileNum)
    {
        int fright = robot.frontRightDrive.getCurrentPosition();
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        robot.frontRightDrive.setTargetPosition((int)(fright + 1350.846 * tileNum));
        robot.frontLeftDrive.setTargetPosition((int)(fleft + 1350.846 * tileNum));
        robot.backRightDrive.setTargetPosition((int)(bright + 1350.846 * tileNum));
        robot.backLeftDrive.setTargetPosition((int)(bleft + 1350.846 * tileNum));
        robot.frontRightDrive.setPower(0.8);
        robot.frontLeftDrive.setPower(0.8);
        robot.backRightDrive.setPower(0.8);
        robot.backLeftDrive.setPower(0.8);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.backLeftDrive.isBusy() && robot.backRightDrive.isBusy() && robot.frontLeftDrive.isBusy() && robot.frontRightDrive.isBusy()) {

        }
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void right90()
    {
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.frontRightDrive.getCurrentPosition();
        robot.frontLeftDrive.setTargetPosition(fleft + 1050);
        robot.frontRightDrive.setTargetPosition(fright - 1050);
        robot.backLeftDrive.setTargetPosition(bleft + 1050);
        robot.backRightDrive.setTargetPosition(bright - 1050);
        robot.frontLeftDrive.setPower(0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backLeftDrive.setPower(0.7);
        robot.backRightDrive.setPower(0.7);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.backLeftDrive.isBusy() && robot.backRightDrive.isBusy() && robot.frontLeftDrive.isBusy() && robot.frontRightDrive.isBusy()) {

        }
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void turn(String direction, double degrees)
    {
        if (direction == "left")
        {
            robot.frontLeftDrive.setPower(0.7);
            robot.frontRightDrive.setPower(0.7);
            robot.backLeftDrive.setPower(0.7);
            robot.backRightDrive.setPower(0.7);
            int fleft = robot.frontLeftDrive.getCurrentPosition();
            int bleft = robot.backLeftDrive.getCurrentPosition();
            int bright = robot.backRightDrive.getCurrentPosition();
            int fright = robot.frontRightDrive.getCurrentPosition();
            robot.frontLeftDrive.setTargetPosition((int)(fleft - 11.0256384615 * degrees));
            robot.frontRightDrive.setTargetPosition((int)(fright + 11.0256384615 * degrees));
            robot.backLeftDrive.setTargetPosition((int)(bleft - 11.0256384615 * degrees));
            robot.backRightDrive.setTargetPosition((int)(bright + 11.0256384615 * degrees));
            sleep((long)(20 * degrees));
        }
        if (direction == "right")
        {
            robot.frontLeftDrive.setPower(0.7);
            robot.frontRightDrive.setPower(0.7);
            robot.backLeftDrive.setPower(0.7);
            robot.backRightDrive.setPower(0.7);
            int fleft = robot.frontLeftDrive.getCurrentPosition();
            int bleft = robot.backLeftDrive.getCurrentPosition();
            int bright = robot.backRightDrive.getCurrentPosition();
            int fright = robot.frontRightDrive.getCurrentPosition();
            robot.frontLeftDrive.setTargetPosition((int)(fleft + 11.0256384615 * degrees));
            robot.frontRightDrive.setTargetPosition((int)(fright - 11.0256384615 * degrees));
            robot.backLeftDrive.setTargetPosition((int)(bleft + 11.0256384615 * degrees));
            robot.backRightDrive.setTargetPosition((int)(bright - 11.0256384615 * degrees));
            sleep((long)(20 * degrees));
        }
    }
    public void left90()
    {
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.frontRightDrive.getCurrentPosition();
        robot.frontLeftDrive.setTargetPosition(fleft - 1000);
        robot.frontRightDrive.setTargetPosition(fright + 1000);
        robot.backLeftDrive.setTargetPosition(bleft - 1000);
        robot.backRightDrive.setTargetPosition(bright + 1000);
        robot.frontLeftDrive.setPower(0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backLeftDrive.setPower(0.7);
        robot.backRightDrive.setPower(0.7);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.backLeftDrive.isBusy() && robot.backRightDrive.isBusy() && robot.frontLeftDrive.isBusy() && robot.frontRightDrive.isBusy()) {

        }
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void pixelDown()
    {
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        sleep(100);
        robot.intakeMotor.setPower(0.5);
        sleep(1020);
        robot.intakeMotor.setPower(0);
    }
    public void outtake()
    {
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        int slidePos1 = robot.lslide.getCurrentPosition();
        int slidePos2 = robot.rslide.getCurrentPosition();
        robot.lslide.setTargetPosition(slidePos1 + 2600);  //if change this, change slideDown as well
        robot.rslide.setTargetPosition(slidePos2 + 2600);
        robot.lslide.setPower(1);
        robot.rslide.setPower(1);
        robot.lslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.lslide.isBusy() && robot.rslide.isBusy()) {

    }
        robot.lslide.setPower(0);
        robot.rslide.setPower(0);
        robot.lslide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rslide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        robot.leftOuttakeServo.setPosition(0);
        robot.rightOuttakeServo.setPosition(0);
        sleep(700);
        slidePos1 = robot.lslide.getCurrentPosition();
        slidePos2 = robot.lslide.getCurrentPosition();
        robot.lslide.setTargetPosition(slidePos1 + 300);  //if change this, change slideDown as well
        robot.rslide.setTargetPosition(slidePos2 + 300);
        robot.lslide.setPower(1);
        robot.rslide.setPower(1);
        robot.lslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.lslide.isBusy() && robot.rslide.isBusy()) {

        }
        robot.lslide.setPower(0);
        robot.rslide.setPower(0);
        robot.lslide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rslide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void slideDown()
    {
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        int slidePos1 = robot.lslide.getCurrentPosition();
        int slidePos2 = robot.rslide.getCurrentPosition();
        robot.rslide.setTargetPosition(slidePos2 - 2900);
        robot.lslide.setTargetPosition(slidePos1 - 2900);
        robot.lslide.setPower(0.7);
        robot.rslide.setPower(0.7);
        robot.lslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rslide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.lslide.isBusy() && robot.rslide.isBusy()) {

        }
        robot.lslide.setPower(0);
        robot.rslide.setPower(0);
        robot.lslide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rslide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void strafeLeft(double tileNum)
    {
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.frontRightDrive.getCurrentPosition();
        robot.frontLeftDrive.setTargetPosition((int) (fleft - 1307.692 * tileNum));
        robot.frontRightDrive.setTargetPosition((int) (fright + 1307.692 * tileNum));;
        robot.backLeftDrive.setTargetPosition((int) (bleft + 1307.692 * tileNum));
        robot.backRightDrive.setTargetPosition((int)(bright - 1307.692 * tileNum));
        robot.frontLeftDrive.setPower(-0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backRightDrive.setPower(-0.7);
        robot.backLeftDrive.setPower(0.7);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.backLeftDrive.isBusy() && robot.backRightDrive.isBusy() && robot.frontLeftDrive.isBusy() && robot.frontRightDrive.isBusy()) {

        }
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void strafeRight(double tileNum)
    {
        int fleft = robot.frontLeftDrive.getCurrentPosition();
        int bleft = robot.backLeftDrive.getCurrentPosition();
        int bright = robot.backRightDrive.getCurrentPosition();
        int fright = robot.frontRightDrive.getCurrentPosition();
        robot.frontLeftDrive.setTargetPosition((int) (fleft + 1307.692 * tileNum));
        robot.frontRightDrive.setTargetPosition((int) (fright - 1307.692 * tileNum));;
        robot.backLeftDrive.setTargetPosition((int) (bleft - 1307.692 * tileNum));
        robot.backRightDrive.setTargetPosition((int)(bright + 1307.692 * tileNum));
        robot.frontLeftDrive.setPower(-0.7);
        robot.frontRightDrive.setPower(0.7);
        robot.backRightDrive.setPower(-0.7);
        robot.backLeftDrive.setPower(0.7);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (robot.backLeftDrive.isBusy() && robot.backRightDrive.isBusy() && robot.frontLeftDrive.isBusy() && robot.frontRightDrive.isBusy()) {

        }
        robot.backRightDrive.setPower(0);
        robot.backLeftDrive.setPower(0);
        robot.frontRightDrive.setPower(0);
        robot.frontLeftDrive.setPower(0);
        robot.frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void bRed(String location)
    {
        if (location == "Middle")
        {
            tile(1.16);
            tile(-0.31);
            pixelDown();
            tile(-0.3);
            left90();
            tile(-1.8);
            outtake();
            sleep(1000);
            slow(0.2);
            robot.leftOuttakeServo.setPosition(1);
            robot.rightOuttakeServo.setPosition(1);
            slideDown();
            strafeLeft(1.34);
            tile(-0.7);
        }
        else if (location == "Right")
        {
            tile(1);
            left90();
            tile(-0.65);
            pixelDown();
            tile(-0.4);
            strafeLeft(0.31);
            tile(-0.6);
            outtake();
            slow(0.3);
            robot.leftOuttakeServo.setPosition(1);
            robot.rightOuttakeServo.setPosition(1);
            slideDown();
            tile(0.1);
            strafeLeft(1.7);
            tile(-1.2);
        }
        else if (location == "Left" | location == "rip")
        {
            tile(1);
            left90();
            pixelDown();
            strafeRight(0.08);
            tile(-1.4);
            outtake();
            slow(0.3);
            robot.leftOuttakeServo.setPosition(1);
            robot.rightOuttakeServo.setPosition(1);
            slideDown();
            strafeLeft(2.1);
            tile(-1);
        }
    }
    public void fRed(String location) {

        if (location == "Left") {
            tile(1);
            right90();
            tile(-0.77);
            pixelDown();
            tile(-0.2);
 }
        if (location == "Middle") {
                tile(1.16);
                tile(-0.31);
                pixelDown();
        }
        if (location == "Right" | location == "rip") {
                    tile(1);
                    right90();
                    tile(0.14);
                    pixelDown();
        }

    }
    public void fBlue (String location) {
        if (location == "Middle") {
            tile(1.16);
            tile(-0.31);
            pixelDown();
            tile(-0.33);
        }
        if (location == "Left") {
            tile(1);
            left90();
            pixelDown();
        }
        if (location == "Right" | location == "rip") {
            tile(1);
            left90();
            tile(-0.7);
            pixelDown();
            tile(-0.1);
        }

    }
                public void bBlue (String location)
                {
                    if (location == "Middle") {
                        tile(1.16);
                        tile(-0.33);
                        pixelDown();
                        tile(-0.1);
                        right90();
                        tile(-1.4);
                        outtake();
                        sleep(1000);
                        slow(0.2);
                        robot.leftOuttakeServo.setPosition(1);
                        robot.rightOuttakeServo.setPosition(1);
                        slideDown();
                        strafeRight(1.34);
                        tile(-0.7);
                    }
                    if (location == "Left" | location == "rip") {
                        tile(1);
                        right90();
                        tile(-0.6);
                        pixelDown();
                        tile(-0.5);
                        strafeRight(0.5);
                        tile(-0.5);
                        outtake();
                        slow(0.3);
                        robot.leftOuttakeServo.setPosition(1);
                        robot.rightOuttakeServo.setPosition(1);
                        slideDown();
                        tile(0.1);
                        strafeRight(1.7);
                        tile(-1.2);
                    }
                    if (location == "Right") {
                        tile(1);
                        right90();
                        tile(0.14);
                        pixelDown();
                        strafeLeft(0.08);
                        tile(-1.4);
                        outtake();
                        slow(0.3);
                        robot.leftOuttakeServo.setPosition(1);
                        robot.rightOuttakeServo.setPosition(1);
                        slideDown();
                        strafeRight(2.1);
                        tile(-1);
                    }
                }
            }

