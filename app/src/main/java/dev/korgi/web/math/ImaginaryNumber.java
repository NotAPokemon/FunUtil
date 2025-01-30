package dev.korgi.web.math;

import static dev.korgi.web.math.MustangMath.π;

public class ImaginaryNumber {
    private double real;
    private double imaginary;
  
    public ImaginaryNumber(double real, double imaginary) {
      this.real = real;
      this.imaginary = imaginary;
    }
  
    public double getReal() {
      return real;
    }
  
    public double getImaginary() {
      return imaginary;
    }
  
    public ImaginaryNumber add(ImaginaryNumber other) {
      return new ImaginaryNumber(real + other.getReal(), imaginary + other.getImaginary());
    }
  
    public ImaginaryNumber subtract(ImaginaryNumber other) {
      return new ImaginaryNumber(real - other.getReal(), imaginary - other.getImaginary());
    }
  
    public ImaginaryNumber multiply(ImaginaryNumber other) {
      return new ImaginaryNumber(
          real * other.getReal() - imaginary * other.getImaginary(),
          real * other.getImaginary() + imaginary * other.getReal());
    }
  
    public ImaginaryNumber divide(ImaginaryNumber other) {
      double denominator = Math.pow(other.getReal(), 2) + Math.pow(other.getImaginary(), 2);
      return new ImaginaryNumber(
          (real * other.getReal() + imaginary * other.getImaginary()) / denominator,
          (imaginary * other.getReal() - real * other.getImaginary()) / denominator);
    }
  
    public double getMagnitude() {
      return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }
  
    public double getAngle() {
      return Math.atan2(imaginary, real);
    }
  
    public ImaginaryNumber getConjugate() {
      return new ImaginaryNumber(real, -imaginary);
    }
  
    public ImaginaryNumber getInverse() {
      double denominator = Math.pow(real, 2) + Math.pow(imaginary, 2);
      if (denominator == 0) {
        return this;
      }
      return new ImaginaryNumber(real / denominator, -imaginary / denominator);
    }
  
    public ImaginaryNumber getExponential() {
      double magnitude = getMagnitude();
      double angle = getAngle();
      return new ImaginaryNumber(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
    }
  
    public ImaginaryNumber getLogarithm() {
      return new ImaginaryNumber(Math.log(getMagnitude()), getAngle());
    }
  
    public ImaginaryNumber getSquareRoot() {
      double magnitude = getMagnitude();
      double angle = getAngle();
      return new ImaginaryNumber(
          Math.sqrt(magnitude) * Math.cos(angle / 2), Math.sqrt(magnitude) * Math.sin(angle / 2));
    }
  
    public ImaginaryNumber getPower(double power) {
      return getLogarithm().multiply(new ImaginaryNumber(power, 0)).getExponential();
    }
  
    public double eTothePiI() {
      return Math.cos(π) + Math.sin(π) * imaginary;
    }
  }
