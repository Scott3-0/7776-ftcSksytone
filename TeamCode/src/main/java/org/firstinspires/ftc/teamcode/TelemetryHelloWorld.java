/**
 *Scott told me to make a TeleOp mode that just outputs telemetry
 * so heres a crappy attempt at that.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Telemetry Hello World Thing")
public class TelemetryHelloWorld extends OpMode {
    @Override
    public void init(){
        telemetry.addData(">","Press Player to Show Telemetry");
    }

    @Override
    public void start(){
        telemetry.addData(">","Starting Telemetry Hello World Thing");
    }

    @Override
    public void loop(){
        telemetry.addData(">","xXbobitoXx");
    }
}
