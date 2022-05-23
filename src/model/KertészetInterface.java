package model;

import java.util.ArrayList;

public interface KertészetInterface {
    public String getNév();
    public ArrayList<Növény> getNövényekByÁr();
    public void addNövény(Növény növény);
    public void eladás(Vásárló vásárló, Növény növény, int darab);
    public void mentésFájlba();
    public void betöltésFájlból();
}
