package sample;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.w3c.dom.*;
import javafx.scene.paint.Color;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

public class Controller {
    @FXML
    private GraphicsContext gc;
    @FXML
    private Canvas graph;
    public List<List<String>> close = new ArrayList<>();
    public ArrayList<Float> GOOG = new ArrayList<>();
    public ArrayList<Float> AAPL = new ArrayList<>();

    public void initialize() throws IOException, ParserConfigurationException, SAXException {
        gc = graph.getGraphicsContext2D();
        downloadStockPrices("GOOG", GOOG);
        downloadStockPrices("AAPL", AAPL);
        drawLinePlot(GOOG, AAPL);
    }

    public void downloadStockPrices(String currentStock, ArrayList<Float> items) throws IOException, ParserConfigurationException, SAXException {
        close.clear();
        String sURL="https://query1.finance.yahoo.com/v7/finance/download/";
        sURL+=currentStock;
        sURL+="?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true";

        InputStream file = new URL(sURL).openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));

        String current;
        while ((current = reader.readLine()) != null) {
            String[] info = current.split(",");
            close.add(Arrays.asList(info));
        };
        for (int i = 1; i < close.size(); i++) {
            items.add((Float.parseFloat(close.get(i).get(4))));
        }

    }

    public void plotLine(ArrayList<Float> current){
        int posX = 50;
        float posY = 700 - current.get(0);
        float posY2;

        for(float info: current){
            posY2 = 700 - info;
            gc.strokeLine(posX, posY, posX+10, posY2);
            posX += 10;
            posY = 700 - info;
        }

    }

    public void drawLinePlot(ArrayList<Float> google, ArrayList<Float> apple){
        gc.setStroke(Color.BLACK);
        gc.strokeLine(50,700,800,700);
        gc.strokeLine(50,0,50,800);

        gc.setStroke(Color.GREEN);
        plotLine(google);

        gc.setStroke(Color.BLUE);
        plotLine(apple);

    }
}
