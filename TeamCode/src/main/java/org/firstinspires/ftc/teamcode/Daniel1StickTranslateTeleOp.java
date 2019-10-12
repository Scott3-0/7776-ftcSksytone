/**
 * Teleop Mode where Left Stick Controls Robot Translation and Right Stick Controls Rotation
 * Made by Daniel on 10/11/19
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="1StickTranslate-Daniel")
public class Daniel1StickTranslateTeleOp extends OpMode {
    @Override
    public void init(){
        telemetry.addData(">","Initializing 1StickTranslate");
        SkystoneHardware robot = new SkystoneHardware();
    }

    @Override
    public void start(){
        telemetry.addData(">","Starting 1StickTranslate");
    }

    @Override
    public void loop(){
        telemetry.addData(">","Loop");
    }
}