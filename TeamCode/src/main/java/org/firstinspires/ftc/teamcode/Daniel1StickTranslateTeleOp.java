/**
 * Teleop Mode where Left Stick Controls Robot Translation and Right Stick Controls Rotation
 * Made by Daniel on 10/11/19
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode._Libs.hardware.SkystoneHardware;

import java.lang.Math;

@TeleOp(name="1StickTranslate-Daniel")
public class Daniel1StickTranslateTeleOp extends OpMode {
    SkystoneHardware robot = new SkystoneHardware(); //get the hardware
    DcMotor motors[];

    float power=0;
    float theta=0;

    @Override
    public void init(){
        telemetry.addData(">","Initializing 1StickTranslate");
        robot.init(hardwareMap); //idk what this does -daniel

        motors = new DcMotor[4];
        motors[0]=robot.fr;
        motors[1]=robot.fl;
        motors[2] = robot.bl;
        motors[3] = robot.br;
    }

    @Override
    public void start(){
        telemetry.addData(">","Starting 1StickTranslate");
    }

    @Override
    public void loop(){
        //telemetry.addData(">","Loop");
        power = (float) Math.sqrt((gamepad1.left_stick_x*gamepad1.left_stick_x)+(gamepad1.left_stick_y*gamepad1.left_stick_y)); //sqrt(x^2+y^2)= distance of joystick to origin use as power for motors !!!check output values before sending to robot!!!
        theta = (float) Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x); //atan(y/x)= angle (in rad) of joystick from origin use to determine direction of robot movement !!!also check!!!

    }
}