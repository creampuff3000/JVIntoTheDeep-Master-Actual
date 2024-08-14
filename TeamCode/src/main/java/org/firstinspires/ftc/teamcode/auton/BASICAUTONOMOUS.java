package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.exception.RobotCoreException;
import org.firstinspires.ftc.teamcode.Projects.HWMap;

@Autonomous(name = "BASICAUTONOMOUS")

public class BASICAUTONOMOUS extends LinearOpMode {
    enum Parking {
        FBlue,
        BBlue,
        BRed,
        FRed,
    }

    Gamepad currentGamepad1 = new Gamepad();
    Gamepad previousGamepad1 = new Gamepad();
    public HWMap robot = new HWMap();

    @Override
    public void runOpMode() throws InterruptedException {
        //initialize hardware map

        robot.init(hardwareMap);
        Parking Alliance = Parking.FBlue;


        int direction = 1;
        int otherDirection = -1;

        boolean isFBlue = false;
        boolean isBBlue = false;
        boolean isFRed = false;
        boolean isBRed = false;
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
            }
            if (currentGamepad1.left_bumper && !previousGamepad1.left_bumper) {

                isFBlue = false;
                isBBlue = false;
                isFRed = true;
                isBRed = false;
            }
            if (currentGamepad1.left_trigger != 0) {

                isFBlue = false;
                isBBlue = false;
                isFRed = false;
                isBRed = true;
            }
            if (currentGamepad1.right_trigger != 0) {

                isFBlue = false;
                isBBlue = true;
                isFRed = false;
                isBRed = false;
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
        }
        waitForStart(); //wait for play button to be pressed

        if (Alliance == BASICAUTONOMOUS.Parking.FBlue) {

        }
        if (Alliance == BASICAUTONOMOUS.Parking.FRed) {

        }

        if (Alliance == BASICAUTONOMOUS.Parking.BRed) {

        }

        if (Alliance == BASICAUTONOMOUS.Parking.BBlue) {

        }
    }
}

