package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Controller {

    @FXML
    private Canvas graph;
    @FXML
    private GraphicsContext gc;

    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };


    public int numbers[] = new int[4];
    public String names[] = new String[4];

    @FXML
    public void initialize(){
        gc = graph.getGraphicsContext2D();

        File dataDir = new File("weatherwarnings-2015.csv");

        WordCounter wordCounter = new WordCounter();

        try{
            wordCounter.parseFile(dataDir);
        }catch(FileNotFoundException e){
            System.err.println("Invalid input dir: " + dataDir.getAbsolutePath());
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        Map<String, Integer> total = wordCounter.getWordCounts();

        names=total.keySet().toArray(new String[0]);
        numbers[0] = total.get("FLASHFLOOD");
        numbers[1] = total.get("SEVERETHUNDERSTORM");
        numbers[2] = total.get("SPECIALMARINE");
        numbers[3] = total.get("TORNADO");
        drawPieChart(gc);

    }


    public void drawPieChart(GraphicsContext gc) {
        int numOfStudents=0;
        for (int numStudentsOfDegree: numbers)
            numOfStudents += numStudentsOfDegree;

        int spotY=50;
        double startAngle=0.0;
        for (int i=0; i<4; i++) {
            Rectangle rectangle = new Rectangle();
            double studentPercentage=(double) numbers[i] / (double) numOfStudents;
            double sweepAngle = studentPercentage*360.0;
            gc.setFill(pieColours[i]);
            gc.fillRect(50,spotY,30,20);
            gc.fillText(names[i], 50, spotY);

            spotY=spotY+50;

            gc.fillArc(500,150, 300, 300, startAngle, sweepAngle, ArcType.ROUND);


            startAngle+=sweepAngle;
        }
    }

}
