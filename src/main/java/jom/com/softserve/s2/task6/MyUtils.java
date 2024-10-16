package jom.com.softserve.s2.task6;

import java.util.ArrayList;
import java.util.List;

public class MyUtils {

    public  List<Shape> maxAreas(List<Shape> shapes) {
        if (shapes.isEmpty()) return new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape == null) return new ArrayList<>();
        }


        List<Shape> result = new ArrayList<>();

        double maxCircleArea = 0.0;
        double maxRectangleArea = 0.0;

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                double area = shape.getArea();
                if (area > maxCircleArea) {
                    maxCircleArea = area;
                }
            } else if (shape instanceof Rectangle) {
                double area = shape.getArea();
                if (area > maxRectangleArea) {
                    maxRectangleArea = area;
                }
            }

        }

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                if (shape.getArea() == maxCircleArea) {
                    result.add(shape);
                }
            } else if (shape instanceof Rectangle) {
                if (shape.getArea() == maxRectangleArea) {
                    result.add(shape);
                }
            }
        }
        return result;
    }
}