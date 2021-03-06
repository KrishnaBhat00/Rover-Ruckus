package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.controls.GamepadWrapper;
import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;
import org.firstinspires.ftc.teamcode.subsystems.TwinstickMecanum;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.SubsystemManager;

@TeleOp
public class MasterTeleop extends OpMode {
    HardwareManager hardware;


    GamepadWrapper driveController; //gamepad 1;
    GamepadWrapper manipController;//gamepad 2;

    SubsystemManager subsystems;
    @Override
    public void init() {
        hardware = new HardwareManager(hardwareMap);
        driveController = new GamepadWrapper(gamepad1);
        manipController = new GamepadWrapper(gamepad2);

        Subsystem drivesystem = setUpDriveTrain();
        subsystems = new SubsystemManager(drivesystem);
    }

    @Override
    public void loop() {
        hardware.leftFrontDrive.setPower(1);
//        hardware.leftRearDrive.setPower(1);
//        hardware.rightFrontDrive.setPower(1);
//        hardware.rightRearDrive.setPower(1);

    }
    private Subsystem setUpDriveTrain()
    {
        return new TwinstickMecanum(driveController, hardware.leftFrontDrive, hardware.rightFrontDrive, hardware.leftRearDrive, hardware.rightRearDrive);
    }
}
