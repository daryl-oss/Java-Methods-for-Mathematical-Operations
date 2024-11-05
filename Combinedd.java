/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package combinedd;

import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Combinedd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Object[] shapeOptions = {"2D Shape", "3D Shape", "Law of Cosines"};
        int shapeChoice = JOptionPane.showOptionDialog(null,
                "Select Functions you want to Solve! :)",
                "Shape Selection", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, shapeOptions, shapeOptions[0]);

        switch (shapeChoice) {
            case 0:
                Object[] twoDChoices = {"Area of Circle", "Area of Rectangle", "Area of Triangle", "Area of Circle Segment"};
                int twoDChoice = JOptionPane.showOptionDialog(null,
                        "Select the 2D Shape you want to Solve! :)",
                        "2D Shape Selection", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, twoDChoices, twoDChoices[0]);

                switch (twoDChoice) {
                    case 0:
                        double radius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius of the circle:"));
                        double circleArea = areaOfCircle(radius);
                        JOptionPane.showMessageDialog(null, "Area of Circle: " + circleArea);
                        break;
                    case 1:
                        double length = Double.parseDouble(JOptionPane.showInputDialog("Enter the length of the rectangle:"));
                        double width = Double.parseDouble(JOptionPane.showInputDialog("Enter the width of the rectangle:"));
                        double rectangleArea = areaOfRectangle(length, width);
                        JOptionPane.showMessageDialog(null, "Area of Rectangle: " + rectangleArea);
                        break;
                    case 2:
                        double base = Double.parseDouble(JOptionPane.showInputDialog("Enter the base of the triangle:"));
                        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter the height of the triangle:"));
                        double triangleArea = areaOfTriangle(base, height);
                        JOptionPane.showMessageDialog(null, "Area of Triangle: " + triangleArea);
                        break;
                    case 3:
                        double segmentRadius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius of the circle:"));
                        double angleTheta = Double.parseDouble(JOptionPane.showInputDialog("Enter the central angle θ (in degrees):"));
                        double segmentArea = calculateCircleSegmentArea(segmentRadius, angleTheta);
                        JOptionPane.showMessageDialog(null, "The area of the circle segment is: " + segmentArea);
                        break;
                }
                break;

            case 1:
                Object[] threeDChoices = {"Volume of Sphere", "Surface Area of Sphere", "Volume of Cylinder"};
                int threeDChoice = JOptionPane.showOptionDialog(null,
                        "Select the 3D Shape you want to Solve! :)",
                        "3D Shape Selection", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, threeDChoices, threeDChoices[0]);

                switch (threeDChoice) {
                    case 0:
                        double sphereRadius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius of the sphere:"));
                        double sphereVolume = calculateSphereVolume(sphereRadius);
                        JOptionPane.showMessageDialog(null, "Volume of Sphere: " + sphereVolume);
                        break;
                    case 1:
                        double radis = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius of the sphere:"));
                        double surfaceArea = calculateSphereSurfaceArea(radis);
                        JOptionPane.showMessageDialog(null, "Surface Area of the Sphere: " + surfaceArea);
                        break;
                    case 2:
                        double cylinderRadius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius of the cylinder:"));
                        double cylinderHeight = Double.parseDouble(JOptionPane.showInputDialog("Enter the height of the cylinder:"));
                        double cylinderVolume = volumeOfCylinder(cylinderRadius, cylinderHeight);
                        JOptionPane.showMessageDialog(null, "Volume of Cylinder: " + cylinderVolume);
                        break;
                }
                break;
            case 2:
                double sideA = Double.parseDouble(JOptionPane.showInputDialog("Enter side a:"));
                double sideB = Double.parseDouble(JOptionPane.showInputDialog("Enter side b:"));
                double angleC = Double.parseDouble(JOptionPane.showInputDialog("Enter angle C (in degrees):"));

                double sideC = calculateTriangleSide(sideA, sideB, angleC);

                JOptionPane.showMessageDialog(null, "The length of side c is: " + sideC);
                break;

            default:
                JOptionPane.showMessageDialog(null, "No option selected.");
        }
    }

    public static double areaOfCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double areaOfRectangle(double length, double width) {
        return length * width;
    }

    public static double areaOfTriangle(double base, double height) {
        return 0.5 * base * height;
    }

    public static double calculateCircleSegmentArea(double r, double theta) {
        double thetaRadians = Math.toRadians(theta);
        double sectorArea = 0.5 * r * r * thetaRadians;
        double triangleArea = 0.5 * r * r * Math.sin(thetaRadians);
        return sectorArea - triangleArea;
    }

    public static double calculateSphereVolume(double r) {
        return (4.0 / 3) * Math.PI * Math.pow(r, 3);
    }

    public static double calculateSphereSurfaceArea(double r) {
        return 4 * Math.PI * Math.pow(r, 2);
    }

    public static double volumeOfCylinder(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    public static double calculateTriangleSide(double a, double b, double angleC) {

        double angleCRadians = Math.toRadians(angleC);

        double c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(angleCRadians));

        return c;
    }
}
