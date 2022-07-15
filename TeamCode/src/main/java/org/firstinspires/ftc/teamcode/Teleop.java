package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Teleop", group = "teleop")
public class Teleop extends OpMode {
    Hardware hardware;

    @Override
    public void init() {
        hardware = new Hardware(hardwareMap);
    }

    @Override
    public void loop() {
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
        double rot = gamepad1.right_stick_x;

        // r is the hypotenuse of (x,y) coordinate of left stick, robotAngle = angleTheta of (x,y) coordinate of left stick. rightX = turning speed
        double r = Math.hypot(x, y);
        double robotAngle = Math.atan2(y, x) - Math.PI / 4;
        double rightX = rot;

        // Equations below is motor speed for each wheel
        double v1 = r * Math.cos(robotAngle) + rightX; // v1: Front Right
        double v2 = r * Math.sin(robotAngle) - rightX; // v2: Back Right
        double v3 = r * Math.sin(robotAngle) + rightX; // v3: Front Left
        double v4 = r * Math.cos(robotAngle) - rightX; // v4: Back Left

        // If not turning give each wheel full power
        if (rot == 0) {
            v1 += v1 / 3;
            v2 += v2 / 3;
            v3 += v3 / 3;
            v4 += v4 / 3;
        }

        this.hardware.rightFront.setPower(v1);
        this.hardware.rightBack.setPower(v2);
        this.hardware.leftFront.setPower(v3);
        this.hardware.leftBack.setPower(v4);
    }
}
