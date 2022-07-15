package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.TimestampedData;
import org.firstinspires.ftc.robotcore.internal.tfod.Timer;

import java.util.concurrent.TimeUnit;

@TeleOp(name = "Drivetrain Tester")
public class DrivetrainTester extends OpMode {
    Hardware hardware;

    double frontLeftLastPosition;
    double frontRightLastPosition;
    double backLeftLastPosition;
    double backRightLastPosition;
    ElapsedTime timer;

    @Override
    public void init() {
        hardware = new Hardware(hardwareMap);
        timer = new ElapsedTime();

        hardware.configureEncoders();

        timer.startTime();
    }

    @Override
    public void loop() {
        hardware.rightFront.setPower(1);
        hardware.rightBack.setPower(1);
        hardware.leftBack.setPower(1);
        hardware.leftFront.setPower(1);

        double rightFrontPos = hardware.rightFront.getCurrentPosition();
        double rightBackPos = hardware.rightBack.getCurrentPosition();
        double leftFrontPos = hardware.leftFront.getCurrentPosition();
        double leftBackPos = hardware.leftBack.getCurrentPosition();

        double leftFrontDiff = Math.abs(leftFrontPos - frontLeftLastPosition);
        double leftBackDiff = Math.abs(leftBackPos - backLeftLastPosition);
        double rightFrontDiff = Math.abs(rightFrontPos - frontRightLastPosition);
        double rightBackDiff = Math.abs(rightBackPos - backRightLastPosition);

        double elapsedTime = timer.now(TimeUnit.SECONDS);

        telemetry.addData("Front Left Ticks per/s", leftFrontDiff / elapsedTime);
        telemetry.addData("Front Right Ticks per/s", rightFrontDiff / elapsedTime);
        telemetry.addData("Back Left Ticks per/s", leftBackDiff / elapsedTime);
        telemetry.addData("Back Right Ticks per/s", rightBackDiff / elapsedTime);

        frontRightLastPosition = rightFrontPos;
        frontLeftLastPosition = leftFrontPos;
        backLeftLastPosition = leftBackPos;
        backRightLastPosition = rightBackPos;
    }
}
