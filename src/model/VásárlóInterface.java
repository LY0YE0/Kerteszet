package model;

public interface VásárlóInterface {
    public boolean isTörzsvásárló();
    public void fizetéstKap(int pénz);
    public void fizet(int pénz);
    public void setTörzsvásárló(boolean törzsvásárló);
    public int getPénz();
    public void vásárol(Kertészet kertészet, Növény növény, int darab);
}
