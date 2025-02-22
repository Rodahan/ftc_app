package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class HardwarePushbot10720
{
    /* Public OpMode members. */
    public DcMotor leftMotor   = null;
    public DcMotor  rightMotor  = null;

    //lift motors

    public DcMotor lift_motor_r = null;
    public DcMotor lift_motor_l1 =null;

    //catapult motors

    public DcMotor  catMotor    = null;

    //public ColorSensor Sensor_blue  = null;
    //public ColorSensor  Sensor_red    = null;
    //public GyroSensor Gyro   = null;
    //public ColorSensor  Sensor_white_front   = null;
    //public ColorSensor  Sensor_white_back = null;
    //public ColorSensor  getSensor_red_front = null;
   /* public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;*/

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwarePushbot10720(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftMotor   = hwMap.dcMotor.get("left_drive");
        rightMotor  = hwMap.dcMotor.get("right_drive");

      //  lift_motor_r = hwMap.dcMotor.get("lift_motor_r");
      //  lift_motor_l1 = hwMap.dcMotor.get("lift_motor_l1");

      //  catMotor    = hwMap.dcMotor.get("cat_motor");


        //Sensor_blue    = hwMap.colorSensor.get("Sensor_right");
        //Sensor_red  = hwMap.colorSensor.get("Sensor_left")
        //Gyro  = hwMap.gyroSensor.get("Gyro_sensor)")=

        // Set all motors to zero power
        //h
        leftMotor.setPower(1.0);
        rightMotor.setPower(1.0);

        lift_motor_r.setPower(0);
        lift_motor_l1.setPower(0);

        catMotor.setPower(0);

        //  armMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

     //   lift_motor_r.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
     //   lift_motor_l1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        catMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //   armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.
     /*   leftClaw = hwMap.servo.get("left_hand");
        rightClaw = hwMap.servo.get("right_hand");
        leftClaw.setPosition(MID_SERVO);
        rightClaw.setPosition(MID_SERVO);*/
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}



