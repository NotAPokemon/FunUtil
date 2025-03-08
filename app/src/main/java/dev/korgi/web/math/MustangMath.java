package dev.korgi.web.math;

public class MustangMath {
    private Function function;
    private RationalFunction rFunction;
    private ImaginaryNumber i;

    public static double RotationsToDegrees(double rotations, double gearRatio){
        return (rotations * gearRatio) / 360.0;
    }

    public static double DegreesToRotations(double theta, double gearRatio){
        return (theta / gearRatio) * 360.0;
    }
    
}
