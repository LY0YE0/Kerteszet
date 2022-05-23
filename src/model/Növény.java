package model;

import java.io.Serializable;

public class Növény implements Serializable, NövényInterface{

    private String név;
    private int ár;
    private float mennyiség;

    public Növény(String név, int ár, int mennyiség) {
        super();
        this.név = név;
        this.ár = ár;
        this.mennyiség = mennyiség;
    }

    public String getNév() {
        return név;
    }

    public int getÁr() {
        return ár;
    }

    public float getMennyiség() {
        return mennyiség;
    }

    public void elad(int darab) {
        mennyiség -= darab;
    }

    @Override
    public String toString() {
        return "Növény [név=" + név + ", ár=" + ár + ", mennyiség=" + mennyiség + "]";
    }

}
