package kertészet;

public class Vásárló implements VásárlóInterface {

    private int pénz;
    private boolean törzsvásárló = false;

    public Vásárló() {
        this.pénz = 10000;
    }

    public Vásárló(int pénz) {
        this.pénz = pénz;
    }

    public boolean isTörzsvásárló() {
        return törzsvásárló;
    }

    public void fizetéstKap(int pénz) {
        this.pénz += pénz;
    }

    public void fizet(int pénz) {
        this.pénz -= pénz;
    }

    public void setTörzsvásárló(boolean törzsvásárló) {
        this.törzsvásárló = törzsvásárló;
    }

    public int getPénz() {
        return pénz;
    }

    public void vásárol(Kertészet kertészet, Növény növény, int darab) {
        kertészet.eladás(this, növény, darab);
    }

}
