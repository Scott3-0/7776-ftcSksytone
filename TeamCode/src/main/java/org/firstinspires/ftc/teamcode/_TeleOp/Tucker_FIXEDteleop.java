package org.firstinspires.ftc.teamcode._TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode._Libs.AutoLib;
import org.firstinspires.ftc.teamcode._Libs.hardware.SkystoneHardware;

@TeleOp(name="Tucker_FIXED_teleop")
public class Tucker_FIXEDteleop extends OpMode {
    SkystoneHardware robot = new SkystoneHardware();

    DcMotor motors[];

    @Override
    public void init(){
        motors = new DcMotor[4];
        robot.init(hardwareMap);

        // MOTORS ARE CORRECT - DO NOT CHANGE THIS SECTION //
        motors[0] = robot.fl;
        motors[1] = robot.fr;
        motors[2] = robot.bl;
        motors[3] = robot.br;

        //TODO: Teach people to not set things to null for garbage reasons
    }

    @Override
    public void start(){
        telemetry.addData("Daniel","makes poop teleop");
    }

    @Override
    public void loop(){
        float tx = gamepad1.left_stick_x;
        float ty = -gamepad1.left_stick_y;
        float left = (ty + tx/2);
        float right = (ty - tx/2);

        // clip the right/left values so that the values never exceed +/- 1
        left = Range.clip(left, -1, 1); //unnecessary but I'll let it slide
        right = Range.clip(right, -1, 1);
        left = left*left*left;
        right = right*right*right;

        float x = gamepad1.right_stick_x;
        float y = -gamepad1.right_stick_y;

        x = Range.clip(x, -1, 1);
        y = Range.clip(y, -1, 1);
        x = x*x*x;
        y = y*y*y;

        double theta = Math.atan2(-x, y);	// stick angle: zero = +y, positive CCW, range +-pi
        double heading = theta * 180.0/Math.PI;		// radians to degrees

        AutoLib.MotorPowers mp = AutoLib.GetSquirrelyWheelMotorPowers(heading);
        double front = mp.Front();
        double back = mp.Back();

        double power = Math.sqrt(x*x + y*y);
        front *= power;
        back *= power;

        double powFl = Range.clip(front+left, -1, 1);
        double powFr = Range.clip(front+right, -1, 1);
        double powBl = Range.clip(back+left, -1, 1);
        double powBr = Range.clip(back+right, -1, 1);

        motors[0].setPower(powFl);
        motors[1].setPower(powFr);
        motors[2].setPower(powBl);
        motors[3].setPower(powBr);

        telemetry.addData("Text", "*** v1.1 ***");
        telemetry.addData("front left/right power:", "%.2f %.2f", powFl, powFr);
        telemetry.addData("back left/right power:", "%.2f %.2f", powBl, powBr);
        telemetry.addData("heading:", "%.2f", heading);
        telemetry.addData("gamepad1:", gamepad1);
    }

    @Override
    public void stop() {

    }
}
