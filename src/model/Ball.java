package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javafx.scene.shape.Circle;

public class Ball {//Modelo

    private static final int DIAMETER = 30;
    private double x;
    private double y;
    double xa;
    double ya;
    boolean juego;
    boolean colision;
    Contador contador;

    public Ball() {
        this.x = 0;
        this.y = 0;
        this.xa = 1;
        this.ya = 1;
    }

    public Ball(Raqueta raq, Contador cont, Circulo cir) {
        this.juego = true;
    }

    public void move(int cY, int cX, int rX, int rY) {
        if (getX() + xa < 44) {//Borde Izquierdo
            xa = 1;
        }
        if (getX() + xa > cY + 7.7 * getDIAMETER()) {//Borde Derecho
            xa = -1;
        }
        if (getY() + ya < cX - getDIAMETER() + 50) {//Arriba
            ya = 1;
        }
        if (getY() + ya < 0) {//Abajo
            juego = false;
        }
        if (colision) {
            ya = -1;
            y = rX - getDIAMETER();
            y = rY - getDIAMETER();

        }
        x = getX() + xa;
        y = getY() + ya;
    }

    public void collision(Rectangle rac) {//colisión con raqueta
//        contador.setPuntaje(1);
        colision = rac.intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getDIAMETER(), getDIAMETER());
    }

    public Circle getBoundsc() {
        return new Circle(getX(), getY(), getDIAMETER());
    }

    public boolean getJuego() {
        return juego;
    }

    public int getDIAMETER() {
        return DIAMETER;
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public boolean isColision() {
        return colision;
    }

}
