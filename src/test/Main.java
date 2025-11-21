package test;

import geometry2d.Circle;
import geometry2d.Rectangle;
import geometry3d.Cylinder;
import Exceptions.NegativeValueException;
import Exceptions.InvalidParametersException;
import java.util.logging.*;

public class Main {
    private static Logger logger;

    public static void main(String[] args) {
        logger = Logger.getLogger(Main.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter formatter = new SimpleFormatter();
        consoleHandler.setFormatter(formatter);
        consoleHandler.setLevel(Level.FINE);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);

        logger.log(Level.FINE, "Starting geometric figures testing");

        System.out.println("Testing geometric figures with exceptions\n");

        System.out.println("1. Correct figures:");
        try {
            logger.log(Level.FINE, "Creating circle with radius 5.0");
            Circle circle = new Circle(5.0);

            logger.log(Level.FINE, "Creating rectangle with dimensions 4.0x6.0");
            Rectangle rectangle = new Rectangle(4.0, 6.0);

            logger.log(Level.FINE, "Creating cylinder with circle base and height 10.0");
            Cylinder cylinder = new Cylinder(circle, 10.0);

            logger.log(Level.FINE, "Displaying circle information");
            circle.Show();

            logger.log(Level.FINE, "Displaying rectangle information");
            rectangle.Show();

            logger.log(Level.FINE, "Displaying cylinder information");
            cylinder.Show();

        } catch (Exception e) {
            logger.log(Level.WARNING, "Error in main test: " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        }

        logger.log(Level.FINE, "=== Starting exception testing ===");
        System.out.println("\n2. Exception testing:");

        logger.log(Level.FINE, "Testing negative radius scenario");
        System.out.println("\nTest: Negative radius");
        try {
            logger.log(Level.FINE, "Attempting to create circle with negative radius -5.0");
            Circle invalidCircle = new Circle(-5.0);
        } catch (NegativeValueException e) {
            logger.log(Level.FINE, "Caught NegativeValueException: " + e.getMessage());
            System.out.println("Caught NegativeValueException: " + e.getMessage());
        }

        logger.log(Level.FINE, "Testing negative rectangle sides scenario");
        System.out.println("\nTest: Negative rectangle sides");
        try {
            logger.log(Level.FINE, "Attempting to create rectangle with negative width -4.0");
            Rectangle invalidRect = new Rectangle(-4.0, 6.0);
        } catch (NegativeValueException e) {
            logger.log(Level.FINE, "Caught NegativeValueException: " + e.getMessage());
            System.out.println("Caught NegativeValueException: " + e.getMessage());
        }

        logger.log(Level.FINE, "Testing oversized rectangle scenario");
        System.out.println("\nTest: Oversized rectangle");
        try {
            logger.log(Level.FINE, "Attempting to create oversized rectangle 1500.0x2000.0");
            Rectangle hugeRect = new Rectangle(1500.0, 2000.0);
        } catch (InvalidParametersException e) {
            logger.log(Level.FINE, "Caught InvalidParametersException: " + e.getMessage());
            System.out.println("Caught InvalidParametersException: " + e.getMessage());
        }

        logger.log(Level.FINE, "Testing negative cylinder height scenario");
        System.out.println("\nTest: Negative cylinder height");
        try {
            logger.log(Level.FINE, "Creating valid circle for cylinder test");
            Circle circle = new Circle(5.0);
            logger.log(Level.FINE, "Attempting to create cylinder with negative height -10.0");
            Cylinder invalidCylinder = new Cylinder(circle, -10.0);
        } catch (NegativeValueException e) {
            logger.log(Level.FINE, "Caught NegativeValueException: " + e.getMessage());
            System.out.println("Caught NegativeValueException: " + e.getMessage());
        }

        logger.log(Level.FINE, "Testing null cylinder base scenario");
        System.out.println("\nTest: Null cylinder base");
        try {
            logger.log(Level.FINE, "Attempting to create cylinder with null base");
            Cylinder invalidCylinder = new Cylinder(null, 10.0);
        } catch (InvalidParametersException e) {
            logger.log(Level.FINE, "Caught InvalidParametersException: " + e.getMessage());
            System.out.println("Caught InvalidParametersException: " + e.getMessage());
        }

        logger.log(Level.FINE, "Testing completed");
    }
}