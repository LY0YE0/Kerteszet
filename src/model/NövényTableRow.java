package model;

import javafx.beans.property.SimpleStringProperty;

public class NövényTableRow {

    private final SimpleStringProperty név;
    private final SimpleStringProperty ár;
    private final SimpleStringProperty mennyiség;

    public NövényTableRow(String név, String ár, String mennyiség) {
        this.név = new SimpleStringProperty(név);
        this.ár = new SimpleStringProperty(ár);
        this.mennyiség = new SimpleStringProperty(mennyiség);
    }

    public String getNév() {
        return név.get();
    }

    public void setNév(String név) {
        this.név.set(név);
    }

    public String getÁr() {
        return ár.get() + " Ft";
    }

    public void setÁr(String ár) {
        this.ár.set(ár);
    }

    public String getMennyiség() {
        return mennyiség.get();
    }

    public void setMennyiség(String mennyiség) {
        this.mennyiség.set(mennyiség);
    }

    @Override
    public String toString() {
        return "N\u00f6v\u00e9nyTable{" + "n\u00e9v=" + név + ", \u00e1r=" + ár + ", mennyis\u00e9g=" + mennyiség + '}';
    }

}
