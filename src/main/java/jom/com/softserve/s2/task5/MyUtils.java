package jom.com.softserve.s2.task5;

import java.util.List;

public class MyUtils {

    public double sumPerimeter(List<? extends Figure> figures) {
        for (Figure figure : figures) {
            if (figure == null) return 0;
        }


        double totalPerimeter = 0;
        for (Figure figure : figures) {
            totalPerimeter += figure.getPerimeter();
        }
        return totalPerimeter;

    }
}

abstract class Figure {

    public abstract double getPerimeter();
}

class Square extends Rectang {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    public Square(double width, double height, double width1) {
        super(width, height);
        this.width = width1;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getPerimeter() {
        return 4 * width;
    }

}

class Rectang extends Figure {
    private double width;
    private double height;

    public Rectang() {
    }

    public Rectang(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

}
