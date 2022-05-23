package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Kertészet implements KertészetInterface {

    private String név;
    private ArrayList<Növény> növények = new ArrayList<>();

    public Kertészet(String név) {
        this.név = név;
        betöltésFájlból();
    }

    public String getNév() {
        return név;
    }

    public ArrayList<Növény> getNövényekByÁr() {
        Collections.sort(növények,
                (Növény első, Növény második) -> első.getÁr() < második.getÁr() ? -1 : (első.getÁr() > második.getÁr()) ? 1 : 0);
        return növények;
    }

    public void addNövény(Növény növény) {
        növények.add(növény);
        mentésFájlba();
    }

    public void eladás(Vásárló vásárló, Növény növény, int darab) {
        Növény valósNövény = null;
        for (int i = 0; i < növények.size(); i++) {
            if (növények.get(i).equals(növény)) {
                valósNövény = növények.get(i);
                break;
            }
        }

        if (valósNövény != null) {
            if (valósNövény.getMennyiség() >= darab) {
                int price = valósNövény.getÁr();
                int teljesÁr = price * darab;

                if (vásárló.isTörzsvásárló()) {
                    teljesÁr = (int) (teljesÁr * 0.75);
                }

                if (teljesÁr <= vásárló.getPénz()) {
                    vásárló.fizet(teljesÁr);
                    valósNövény.elad(darab);
                    System.out.println("Sikeres vásárlás: " + darab + " db, " + valósNövény.getNév() + ", " + teljesÁr + " Ft");
                    mentésFájlba();
                } else {
                    System.out.println("Nincs elég pénze");
                }
            } else {
                System.out.println("Nincs ennyi termék");
            }
        }
    }

    public void mentésFájlba() {

        String fájlnév = név + ".bin";

        try {
            FileOutputStream fos = new FileOutputStream(fájlnév);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(növények);
            oos.close();
            fos.close();

            System.out.println("Sikeres mentés -> " + fájlnév);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

    }

    public void betöltésFájlból() {

        String fájlnév = név + ".bin";

        try {
            FileInputStream fis = new FileInputStream(fájlnév);

            ObjectInputStream ois = new ObjectInputStream(fis);

            növények = (ArrayList<Növény>) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("Sikeres betöltés -> " + fájlnév);
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
        }
    }

}
