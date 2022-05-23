package kertészet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Feladat: Egy kertészet növényeket értékesít. A vásárlók, ha van elég
     * pénzük, meg tudják venni a növényeket. Ha a vásárlónak van kedvezményre
     * jogosító kártyája, akkor 25% kedvezménnyel vásárolhat. A vásárlók
     * kaphatnak fizetést, akkor ennyivel több pénze lesz vásárlásra. Ha nem
     * adtuk meg a kezdő összeget egy vásárlónál, akkor az 10 000 Ft összeggel
     * rendelkezik. Egyébként megadhatjuk, hogy mennyi a kezdő tőke. A kertészet
     * meg tudja adni a növényeinek listáját érték szerint rendezve. A kertészet
     * jelenleg nem termel új növényeket, de az aktuális állapotát ki tudja írni
     * egy bináris állományba. Amikor „létrejön” egy kertészet, akkor
     * aktualizálja magát, ha van létező bináris állomány.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Kertészet");
        stage.setScene(scene);
        stage.show();
    }

}
