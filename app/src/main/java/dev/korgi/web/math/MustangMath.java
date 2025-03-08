package dev.korgi.web.math;

@SuppressWarnings("unused")
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

    /**
     * @precondition: softLimits is an array of two floats, where the first element is the lower limit and the second element is the upper limit.
     */
    public static boolean checkSoftLimits(float[] softLimits, double position){
        return position > softLimits[0] && position < softLimits[1];
    }
    
}
