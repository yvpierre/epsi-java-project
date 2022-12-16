package main.java.model;

public class Card {

    private Face face;
    private Color color;
    private int value;


    public Card(Face face, Color color){
        super();
        this.face = face;
        this.color = color;
        this.value = face.value;
    }


    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return face + " " + color;
    }
}
