package geometry;

import java.awt.*;

public abstract class Shape implements Comparable<Object> {

    protected boolean selected;
    private String colorString;
    private Color color;

    public abstract boolean contains(int x, int y);
    public abstract void draw(Graphics g);

    public Shape() {

    }

    public Shape(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getColorString() {
        return colorString;
    }

    public void setColorString(String colorString) {
        this.colorString = colorString;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
