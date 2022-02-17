/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_project;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLkataloqController implements Initializable {

    @FXML
    private TextField istAdi, istSoyadi, istEmail, istTelefon, istUnvan, istPoctKodu, istSheher;
    @FXML
    private DatePicker istDTarixi;
    @FXML
    private TableView<Shexs> tableShexsler;
    @FXML
    private TableColumn<Shexs, String> sutunAd;
    @FXML
    private TableColumn<Shexs, String> sutunSoyad;

    private ObservableList<Shexs> shexsler = FXCollections.observableArrayList();

    @FXML
    private TabPane tabPaneRehber;
    @FXML
    private Tab tabShexs;
    @FXML
    private Tab tabQrafik;
    @FXML
    private BarChart<String, Integer> barQrafik;
    @FXML
    private CategoryAxis eksAylar;
    private ObservableList<String> ayAdlari = FXCollections.observableArrayList();

    public void dogumQrafikAyarla(List<Shexs> butunShexsler) {
        barQrafik.getData().clear();
        int[] aySaygac = new int[12];
        for (Shexs s : butunShexsler) {
            int ay = s.getTarix().getMonthValue() - 1;
            aySaygac[ay]++;
        }
        XYChart.Series<String, Integer> seriler = new XYChart.Series<>();
        for (int i = 0; i < aySaygac.length; i++) {
            seriler.getData().add(new XYChart.Data<>(ayAdlari.get(i), aySaygac[i]));
        }
        barQrafik.getData().add(seriler);
    }

    public void TableShexslerDoldur() {
        sutunAd.setCellValueFactory(new PropertyValueFactory<Shexs, String>("ad"));
        sutunSoyad.setCellValueFactory(new PropertyValueFactory<Shexs, String>("soyad"));
        tableShexsler.setItems(shexsler);
        tableShexsler.refresh();
    }

    public void ShexsGoster(Shexs shexs) {
        if (shexs != null) {
            istAdi.setText(shexs.getAd());
            istSoyadi.setText(shexs.getSoyad());
            istDTarixi.setValue(shexs.getTarix());
            istEmail.setText(shexs.getEmail());
            istTelefon.setText(shexs.getTelefon());
            istUnvan.setText(shexs.getUnvan());
            istPoctKodu.setText("" + shexs.getPoctkodu());
            istSheher.setText(shexs.getSheher());
        } else {
            istAdi.setText("");
            istSoyadi.setText("");
            istDTarixi.setValue(LocalDate.of(2000, 02, 02));
            istEmail.setText("");
            istTelefon.setText("");
            istUnvan.setText("");
            istPoctKodu.setText("");
            istSheher.setText("");

        }

    }

    public void buttonYeniAct() {
        istAdi.setText("");
        istSoyadi.setText("");
        istDTarixi.setValue(LocalDate.of(2000, 02, 02));
        istEmail.setText("");
        istTelefon.setText("");
        istUnvan.setText("");
        istPoctKodu.setText("");
        istSheher.setText("");

    }

    public void buttonElaveAct() {
        try {
            shexsler.add(new Shexs(istAdi.getText(), istSoyadi.getText(), istDTarixi.getValue(), istEmail.getText(), istTelefon.getText(), istUnvan.getText(), Integer.parseInt(istPoctKodu.getText()), istSheher.getText()));
            TableShexslerDoldur();
        } catch (NumberFormatException e) {
            Alert xeta = new Alert(AlertType.WARNING);
            xeta.setTitle("Xəta");
            xeta.setHeaderText("Poçt Kodu Ədəd Olmalıdır!!!");
            xeta.showAndWait();
        }
    }

    public void buttonGuncelleAct() {
        int secilen = tableShexsler.getSelectionModel().getSelectedIndex();
        if (secilen != -1) {
            shexsler.get(secilen).setAd(istAdi.getText());
            shexsler.get(secilen).setSoyad(istSoyadi.getText());
            shexsler.get(secilen).setTarix(istDTarixi.getValue());
            shexsler.get(secilen).setEmail(istEmail.getText());
            shexsler.get(secilen).setTelefon(istTelefon.getText());
            shexsler.get(secilen).setUnvan(istUnvan.getText());
            shexsler.get(secilen).setPoctkodu(Integer.parseInt(istPoctKodu.getText()));
            shexsler.get(secilen).setSheher(istSheher.getText());
            TableShexslerDoldur();

        } else {
            Alert xeta = new Alert(AlertType.WARNING);
            xeta.setTitle("Xəta");
            xeta.setHeaderText("Seçim Edilmədi!!!");
            xeta.showAndWait();

        }
    }

    public void buttonSilAct() {
        int secilen = tableShexsler.getSelectionModel().getSelectedIndex();
        if (secilen != -1) {
            shexsler.remove(secilen);
            TableShexslerDoldur();

        } else {
            Alert xeta = new Alert(AlertType.WARNING);
            xeta.setTitle("Xəta");
            xeta.setHeaderText("Seçim Edilmədi!!!");
            xeta.showAndWait();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shexsler.add(new Shexs("Elnur", "Ahmadov", LocalDate.of(1998, 05, 22), "ahmadovelnurjr@gmail.com", "0771231221", "Resulzade kuch", 1223, "Baki"));
        shexsler.add(new Shexs("Elvin", "Ahmadov", LocalDate.of(1995, 11, 22), "ahmadovelnurjr@gmail.com", "0771231221", "Resulzade kuch", 1090, "Gence"));
        shexsler.add(new Shexs("Vuqar", "Ceferov", LocalDate.of(1978, 02, 22), "ahmadovelnurjr@gmail.com", "0771234532", "Resulzade kuch", 1990, "Sheki"));
        shexsler.add(new Shexs("Hesen", "Mammadov", LocalDate.of(1998, 04, 12), "ahmad@gmail.com", "0771233451", "Resulzade kuch", 1223, "Baki"));
        shexsler.add(new Shexs("Ulvi", "Hesenli", LocalDate.of(1998, 01, 25), "aelnurjr@gmail.com", "0771231221", "Resulzade kuch", 1267, "Shusha"));
        shexsler.add(new Shexs("Huseyn", "Veliyev", LocalDate.of(1998, 05, 22), "ahmadovjr@gmail.com", "0771231221", "Resulzade kuch", 1145, "Quba"));
        TableShexslerDoldur();
        tableShexsler.getSelectionModel().selectedItemProperty().addListener((observable, oldValues, newValue) -> ShexsGoster(newValue));

        String[] aylar = {"YANVAR", "FEVRAL", "MART", "APREL", "MAY", "IYUN", "IYUL", "AVQUST", "SENTYABR", "OKTYABR", "NOYABR", "DEKABR"};
        ayAdlari.addAll(Arrays.asList(aylar));
        eksAylar.setCategories(ayAdlari);
        tabPaneRehber.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                if (newValue.equals(tabQrafik)) {
                    dogumQrafikAyarla(shexsler);
                }
            }

        });
    }

}
