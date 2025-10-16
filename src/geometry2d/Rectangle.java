package geometry2d;

import Exceptions.InvalidParametersException;
import Exceptions.NegativeValueException;
import java.util.logging.*;
import java.io.IOException;

public class Rectangle implements Figure {
    private double width;
    private double height;
    private Logger logger;

    private void setupLogger() {
        try {
            logger = Logger.getLogger(Rectangle.class.getName());
            FileHandler fileHandler = new FileHandler("figures.log", true);
            fileHandler.setFormatter(new XMLFormatter());
            fileHandler.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Failed to create log file for Rectangle: " + e.getMessage());
        }
    }

    public Rectangle(double width, double height) {
        setupLogger();

        if (width <= 0 || height <= 0) {
            logger.log(Level.INFO, "Rectangle creation failed: negative dimensions = " + width + ", " + height);
            throw new NegativeValueException("The width or height of a rectangle cannot be negative or equal to 0. Width = " + width + "; height = " + height + ".");
        } else if (width > 1000 || height > 1000) {
            logger.log(Level.INFO, "Rectangle creation failed: oversized dimensions = " + width + ", " + height);
            throw new InvalidParametersException("The width or height of a rectangle cannot be > 1000. Width = " + width + "; height = " + height + ".");
        }

        this.width = width;
        this.height = height;
        logger.log(Level.INFO, "Rectangle created successfully: width = " + width + ", height = " + height);
    }

    @Override
    public double Area() {
        double area = width * height;
        logger.log(Level.INFO, "Rectangle area calculated: " + area);
        return area;
    }

    @Override
    public void Show() {
        logger.log(Level.INFO, "Displaying rectangle: width = " + width + ", height = " + height + ", area = " + Area());
        System.out.println("Rectangle: width = " + width + ", height = " + height + ", square = " + Area());
    }
}