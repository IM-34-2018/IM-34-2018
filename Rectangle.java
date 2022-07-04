package geometry;

import java.awt.*;

public class Rectangle extends Shape {

    private Point upperLeft;
    private int width;
    private int height;
    private Color insideColor;

    public int area() {
        return width * height;
    }

    public int circumference() {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return "Upper left point : (" + this.upperLeft.getX() + ", " + this.upperLeft.getY()
                + "), width = " + getWidth() + " height = " + this.height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle temp = (Rectangle) obj;
            if (this.upperLeft.equals(temp.upperLeft) && this.width == temp.width && this.height == temp.height) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int x, int y) {
        return this.upperLeft.getX() <= x && this.upperLeft.getX() + width >= x
                && this.upperLeft.getY() <= y && this.upperLeft.getY() + height >= y;
    }

    public boolean contains(Point p) {
        return contains(p.getX(), p.getY());
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Rectangle) {
            return area() - ((Rectangle) o).area();
        }
        return 0;
    }

    //Konstruktori
    public Rectangle() {

    }

    public Rectangle(Point upperLeft, int width, int height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point upperLeft, int width, int height, boolean selected) {
        this(upperLeft, width, height);
        this.selected = selected;
    }

    public Rectangle(Point upperLeft, int width, int height, Color borderColor, Color insideColor) {
        this(upperLeft, width, height);
        this.setColor(borderColor);
        this.setInsideColor(insideColor);
    }


    public Point getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getInsideColor() {
        return insideColor;
    }

    public void setInsideColor(Color insideColor) {
        this.insideColor = insideColor;
    }

    @Override
    public void draw(Graphics g) {
        if(this.getInsideColor() != null) {
            g.setColor(this.getInsideColor());
            g.fillRect(upperLeft.getX(), upperLeft.getY(), width, height);
        }
        if(this.getColor() == null) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(this.getColor());
        }
        g.drawRect(this.upperLeft.getX(), this.upperLeft.getY(), this.width, this.height);
        if (this.isSelected()) {
            g.drawRect(this.upperLeft.getX() - 3, this.upperLeft.getY() - 3, 6, 6);
            g.drawRect(this.upperLeft.getX() + this.width - 3, this.upperLeft.getY() - 3, 6, 6);
            g.drawRect(this.upperLeft.getX() - 3, this.upperLeft.getY() + this.height - 3, 6, 6);
            g.drawRect(this.upperLeft.getX() + this.width - 3, this.upperLeft.getY() + this.height - 3, 6, 6);
        }
    }

}
