package geometry2d;

import Exceptions.InvalidParametersException;
import Exceptions.NegativeValueException;
import java.util.logging.*;
import java.io.IOException;

public class Circle implements Figure {
    private double radius;
    private Logger logger;

    private void setupLogger() {
        try {
            logger = Logger.getLogger(Circle.class.getName());
            FileHandler fileHandler = new FileHandler("figures.log", true);
            fileHandler.setFormatter(new XMLFormatter());
            fileHandler.setLevel(Level.SEVERE);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Failed to create log file for Circle: " + e.getMessage());
        }
    }

    public Circle(double radius) {
        setupLogger();

        if (radius <= 0) {
            logger.log(Level.SEVERE, "Circle creation failed: negative radius = " + radius);
            throw new NegativeValueException("The radius of a circle cannot be negative or equal to 0. Radius = " + radius);
        } else if (radius > 1000) {
            logger.log(Level.SEVERE, "Circle creation failed: oversized radius = " + radius);
            throw new InvalidParametersException("The radius of a circle cannot be > 1000. Radius = " + radius);
        }
        this.radius = radius;
        logger.log(Level.SEVERE, "Circle created successfully with radius = " + radius);
    }

    @Override
    public double Area() {
        double area = Math.PI * radius * radius;
        logger.log(Level.SEVERE, "Circle area calculated: " + area);
        return area;
    }

    @Override
    public void Show() {
        String message = "Displaying circle: radius = " + radius + ", area = " + Area();
        logger.log(Level.SEVERE, message);
        System.out.println("Circle: radius = " + radius + ", square = " + Area());
    }
}