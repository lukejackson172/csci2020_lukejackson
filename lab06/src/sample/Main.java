package sample;

import java.io.*;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.chart.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Main extends Application {
    final static String one = "1";
    final static String two = "2";
    final static String three = "3";
    final static String four = "4";
    final static String five = "5";
    final static String sixx= "6";
    final static String six = "7";
    final static String seven= "8";
    private static double[] avgHousingPricesByYear = { 247381.0,264171.4,287715.3,294736.1, 308431.4,322635.9,340253.0,363153.7};
    private static double[] avgCommercialPricesByYear = { 1121585.3,1219479.5,1246354.2,1295364.8, 1335932.6,1472362.0,1583521.9,1613246.3};
    private static String[] ageGroups = { "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = { 648, 1021, 2453, 3173, 1868, 2247};

    @Override public void start(Stage stage) {
        stage.setTitle("Lab 06");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Bar Chart");
        xAxis.setLabel("Year");
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Avg Housing Price by Year");


        series1.getData().add(new XYChart.Data(one, avgHousingPricesByYear[0]));
        series1.getData().add(new XYChart.Data(two, avgHousingPricesByYear[1]));
        series1.getData().add(new XYChart.Data(three, avgHousingPricesByYear[2]));
        series1.getData().add(new XYChart.Data(four, avgHousingPricesByYear[3]));
        series1.getData().add(new XYChart.Data(five, avgHousingPricesByYear[4]));
        series1.getData().add(new XYChart.Data(sixx, avgHousingPricesByYear[5]));
        series1.getData().add(new XYChart.Data(six, avgHousingPricesByYear[6]));
        series1.getData().add(new XYChart.Data(seven, avgHousingPricesByYear[7]));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Avg Commerical Prices by year");
        series2.getData().add(new XYChart.Data(one, avgCommercialPricesByYear[0]));
        series2.getData().add(new XYChart.Data(two, avgCommercialPricesByYear[1]));
        series2.getData().add(new XYChart.Data(three, avgCommercialPricesByYear[2]));
        series2.getData().add(new XYChart.Data(four, avgCommercialPricesByYear[3]));
        series2.getData().add(new XYChart.Data(five, avgCommercialPricesByYear[4]));
        series2.getData().add(new XYChart.Data(sixx, avgCommercialPricesByYear[5]));
        series2.getData().add(new XYChart.Data(six, avgCommercialPricesByYear[6]));
        series2.getData().add(new XYChart.Data(seven, avgCommercialPricesByYear[7]));

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data(ageGroups[0], purchasesByAgeGroup[0]),
                        new PieChart.Data(ageGroups[1], purchasesByAgeGroup[1]),
                        new PieChart.Data(ageGroups[2], purchasesByAgeGroup[2]),
                        new PieChart.Data(ageGroups[3], purchasesByAgeGroup[3]),
                        new PieChart.Data(ageGroups[4], purchasesByAgeGroup[4]));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Purchases by Age Groups");



        Scene scene = new Scene(new Group());
        bc.getData().addAll(series1, series2);
        ((Group) scene.getRoot()).getChildren().add(chart);
        ((Group) scene.getRoot()).getChildren().add(bc);
        chart.setLayoutX(500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
