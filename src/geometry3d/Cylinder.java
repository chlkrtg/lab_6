package geometry3d;

import Exceptions.InvalidParametersException;
import Exceptions.NegativeValueException;
import geometry2d.Figure;
import java.util.logging.*;
import java.io.IOException;

public class Cylinder {
    private Figure base;
    private double height;
    private Logger logger;

    private void setupLogger() {
        try {
            logger = Logger.getLogger(Cylinder.class.getName());
            FileHandler fileHandler = new FileHandler("cylinder.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.FINEST);
            logger.addHandler(fileHandler);
            logger.setLevel(Level.FINEST);
        } catch (IOException e) {
            System.err.println("Failed to create log file for Cylinder: " + e.getMessage());
        }
    }

    public Cylinder(Figure base, double height) {
        setupLogger();

        if (base == null) {
            logger.log(Level.FINEST, "Cylinder creation failed: base is null");
            throw new InvalidParametersException("The base of a cylinder cannot be equal to null. \n");
        }
        if (height <= 0) {
            logger.log(Level.FINEST, "Cylinder creation failed: negative height = " + height);
            throw new NegativeValueException("The height of a cylinder cannot be negative or equal to 0. Height = " + height + "\n");
        }
        if (height > 500) {
            logger.log(Level.FINEST, "Cylinder creation failed: oversized height = " + height);
            throw new InvalidParametersException("The height of a cylinder cannot be > 500. Height = " + height + "\n");
        }
        this.base = base;
        this.height = height;
        logger.log(Level.FINEST, "Cylinder created successfully: height = " + height);
    }

    public double Volume() {
        double volume = base.Area() * height;
        logger.log(Level.FINEST, "Cylinder volume calculated: " + volume);
        return volume;
    }

    public void Show() {
        logger.log(Level.FINEST, "Displaying cylinder information");
        System.out.print("Cylinder: ");
        base.Show();
        System.out.println("\t\theight = " + height + ", volume = " + Volume());
    }
}