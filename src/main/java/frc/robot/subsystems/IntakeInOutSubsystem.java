package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.defaultcommands.DefaultIntakeInOutCommand;
import frc.robot.constants.RobotMap;

public class IntakeInOutSubsystem extends Subsystem {

    private TalonSRX intake = new TalonSRX(RobotMap.INTAKE_MOTOR_ROLLERS_ADDRESS);
    private boolean activated = false;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeInOutCommand());
    }

    /**
     * Will turn intake motors
     */
    public void activate(boolean activate) { //TODO don't think this will work
        this.activated = activate;
        while(activated) {
            this.setEncoderPosition(this.getEncoderPosition() + 1);
        }
    }

    /**
     * Will return state of motors
     * If motors are on, returns true
     */
    public boolean getActivated() {
        return this.activated;
    }

    /**
     * @return
     * Encoder Position
     */
    public int getEncoderPosition() {
        return intake.getSelectedSensorPosition(0);
    }

    /**
     * 
     * @param position
     * 
     */
    public void setEncoderPosition(int position) {
        intake.setSelectedSensorPosition(position);
    }
}