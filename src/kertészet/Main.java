package kertészet;

import java.util.ArrayList;

public class Main {

    /**Feladat:
     * Egy kertészet növényeket értékesít.
     * A vásárlók, ha van elég pénzük, meg tudják venni a növényeket.
     * Ha a vásárlónak van kedvezményre jogosító kártyája, akkor 25% kedvezménnyel vásárolhat.
     * A vásárlók kaphatnak fizetést, akkor ennyivel több pénze lesz vásárlásra.
     * Ha nem adtuk meg a kezdő összeget egy vásárlónál, akkor az 10 000 Ft összeggel rendelkezik.
     * Egyébként megadhatjuk, hogy mennyi a kezdő tőke.
     * A kertészet meg tudja adni a növényeinek listáját érték szerint rendezve.
     * A kertészet jelenleg nem termel új növényeket, de az aktuális állapotát ki tudja írni egy bináris állományba.
     * Amikor „létrejön” egy kertészet, akkor aktualizálja magát, ha van létező bináris állomány.
     * @param args
     */
    public static void main(String[] args) {
        Kertészet kertészet = new Kertészet("Budai kertészet");
        kertészet.addNövény(new Növény("Paradicsom", 20, 100));
        
        Vásárló vásárló1 = new Vásárló();
        Vásárló vásárló2 = new Vásárló(20000);
        vásárló1.vásárol(kertészet, kertészet.getNövényekByÁr().get(0), 2);
        
        ArrayList<Növény> növények = kertészet.getNövényekByÁr();
        
        for (int i = 0; i < növények.size(); i++) {
            System.out.println(növények.get(i).toString());
        }
        
        vásárló1.setTörzsvásárló(true);
        vásárló1.vásárol(kertészet, kertészet.getNövényekByÁr().get(0), 2);
        
        System.out.println(vásárló1.getPénz());
        
    }
    
}
