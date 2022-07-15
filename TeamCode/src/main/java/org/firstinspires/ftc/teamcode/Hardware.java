package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    public Hardware(HardwareMap hardwareMap) {
        this.leftFront = hardwareMap.dcMotor.get("lf");
        this.leftBack = hardwareMap.dcMotor.get("lb");
        this.rightFront = hardwareMap.dcMotor.get("rf");
        this.rightBack = hardwareMap.dcMotor.get("rb");

        this.rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        this.rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        this.leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        this.leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void configureEncoders() {
        this.rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
