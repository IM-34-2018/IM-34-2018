package geometry;

import geometry.Point;

import java.awt.*;

public class Circle extends Shape {

    private Point center;
    private int radius;
    private Color insideColor;

    public double area() {
        return radius*radius*Math.PI;
    }

    public double circumference() {
        return radius*2*Math.PI;
    }


    @Override
    public String toString() {
        return "Center: ( " +this.center.getX() + " and " +this.center.getY() + " ), radius = " + this.radius;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Circle) {
            Circle temp = (Circle) obj;
            if(this.center.equals(temp.center) && this.radius == temp.radius) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int x, int y) {
        return this.center.distance(new Point(x,y)) <= radius;
    }

    public boolean contains(Point p) {
        return contains(p.getX(), p.getY());
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Circle) {
            return (int)(area() - ((Circle)o).area());
        }
        return 0;
    }

    public Circle() {

    }

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(Point center, int radius, boolean selected) {
        this(center,radius);
        this.selected = selected;
    }

    public Circle(Point center, int radius, Color borderColor, Color insideColor) {
        this(center,radius);
        this.setColor(borderColor);
        this.setInsideColor(insideColor);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws Exception{
        if(radius > 0) {
            this.radius = radius;
        }else {
            System.out.println("Radius ne sme da bude negativan");
            throw new Exception("Radius ne sme da bude negativan");
        }
    }

    public Color getInsideColor() {
        return insideColor;
    }

    public void setInsideColor(Color insideColor) {
        this.insideColor = insideColor;
    }

    public void draw(Graphics g) {
        if(this.getInsideColor() != null) {
            g.setColor(this.getInsideColor());
            g.fillOval(this.getCenter().getX() - this.radius, this.getCenter().getY() - this.radius, 2 * this.radius,
                    2 * this.radius);
        }
        if(this.getColor() != null) {
            g.setColor(this.getColor());
        }
        g.drawOval(this.getCenter().getX() - this.radius, this.getCenter().getY() - this.radius, this.radius * 2, this.radius*2);
        if(this.isSelected()) {
            g.drawRect(this.getCenter().getX() - this.radius - 3, this.getCenter().getY() - 3, 6, 6);
            g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.radius - 3, 6, 6);
            g.drawRect(this.getCenter().getX() + this.radius - 3, this.getCenter().getY() - 3, 6, 6);
            g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.radius - 3, 6, 6);
        }
    }
}