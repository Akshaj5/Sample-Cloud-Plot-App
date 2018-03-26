import java.util.*;

import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Main extends Application {

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) throws Exception {
      stage.setTitle("JavaFX Chart Demo");
      StackPane pane = new StackPane();
      pane.getChildren().add(createBubbleChart());
      stage.setScene(new Scene(pane, 1200, 800));
      stage.show();
   }

   public ObservableList<XYChart.Series<Integer, Double>>
   getDummyChartData2() {
      ObservableList<XYChart.Series<Integer, Double>> data =
         FXCollections.observableArrayList();

      Series<Integer, Double> as = new Series<>();
      Series<Integer, Double> bs = new Series<>();
      Series<Integer, Double> cs = new Series<>();
      Series<Integer, Double> ds = new Series<>();
      Series<Integer, Double> es = new Series<>();
      Series<Integer, Double> fs = new Series<>();
      as.setName("A-Series");
      bs.setName("B-Series");
      cs.setName("C-Series");
      ds.setName("D-Series");
      es.setName("E-Series");
      fs.setName("F-Series");

      Random r = new Random();

      for (int i = 1900; i < 2017; i += 10) {
         double d = r.nextDouble();

         as.getData().add(new XYChart.Data<>
         (i, r.nextInt(32)+r.nextDouble(), 2 * d));
         bs.getData().add(new XYChart.Data<>
         (i,r.nextInt(32)+r.nextDouble(), 4 * d));
         cs.getData().add(new XYChart.Data<>
         (i,r.nextInt(32)+r.nextDouble(), 3 * d));
         ds.getData().add(new XYChart.Data<>
         (i,r.nextInt(32)+r.nextDouble(), 5 * d));
         es.getData().add(new XYChart.Data<>
         (i,r.nextInt(32)+r.nextDouble(), 1.5 * d));
         fs.getData().add(new XYChart.Data<>
         (i,r.nextInt(32)+r.nextDouble(), 1.7 * d));

      }

      data.addAll(as, bs, cs, ds, es, fs);
      return data;
   }

   public BubbleChart<Number, Number> createBubbleChart() {
      NumberAxis xAxis = new NumberAxis();
      NumberAxis yAxis = new NumberAxis();
      yAxis.setAutoRanging(false);
      yAxis.setLowerBound(0);
      yAxis.setUpperBound(30);

      xAxis.setAutoRanging(false);
      xAxis.setLowerBound(1900);
      xAxis.setUpperBound(2017);
      xAxis.setTickUnit(10);
      xAxis.setTickLabelFormatter(new StringConverter<Number>() {

         @Override
         public String toString(Number object) {
            return String.valueOf(object.intValue() / 10);
         }

         @Override
         public Number fromString(String string) {
            return Integer.valueOf(string) * 10;
         }
      });

      BubbleChart blc = new BubbleChart<>(xAxis, yAxis);
      blc.setData(getDummyChartData2());
      blc.setTitle("Bubble chart on random data");
      return blc;
   }
}