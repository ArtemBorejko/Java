package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import java.util.Arrays;
import javafx.scene.chart.XYChart;
import static java.lang.Math.*;

public class Controller {

    private int size = 9;
    private double []X = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private double []Y = {8.00, 11.52, 14.26, 16.04, 16.88, 17.52, 18.84, 19.07, 16.65};

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CategoryAxis xAxisScatterChart = new CategoryAxis();

    @FXML
    private NumberAxis yAxisScatterChart = new NumberAxis(10, 20, 1.0);

    @FXML
    private CategoryAxis xAxisLineChart = new CategoryAxis();

    @FXML
    private NumberAxis yAxisLineChart = new NumberAxis(28, 46, 1);

    @FXML
    private LineChart<String, Number> lineChart = new LineChart<>(xAxisLineChart, yAxisLineChart);

    @FXML
    private ScatterChart<String, Number> scatterChart = new ScatterChart<>(xAxisScatterChart, yAxisScatterChart);

    @FXML
    private Button calcButton;

    @FXML
    void initialize() {

       yAxisLineChart.setAutoRanging(false);
       yAxisLineChart.setLowerBound(4.5);
       yAxisLineChart.setUpperBound(25);
       yAxisLineChart.setTickUnit(0.5);

       yAxisScatterChart.setAutoRanging(false);
       yAxisScatterChart.setLowerBound(5);
       yAxisScatterChart.setUpperBound(25);
       yAxisScatterChart.setTickUnit(0.5);

        calcButton.setOnAction(event -> {

            double []lineFunc = approximationLine();
            double []hyperbolicFunc = approximationHyperbola();

            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Исходные данные");
            XYChart.Series series2 = new XYChart.Series();
            series2.setName("Апроксимация прямой");
            XYChart.Series series3 = new XYChart.Series();
            series3.setName("Апроксимация гиперболой");

            for (int i = 0; i < size; i++) {
                series1.getData().add(new XYChart.Data<String, Number>(Double.toString(X[i]), Y[i]));
                series2.getData().add(new XYChart.Data<String, Number>(Double.toString(X[i]), lineFunc[i]));
                series3.getData().add(new XYChart.Data<String, Number>(Double.toString(X[i]), hyperbolicFunc[i]));
            }

            scatterChart.getData().addAll(series1);
            lineChart.getData().addAll(series2, series3);

            System.out.println("Переменная Х\tОпытные данные\tЛинейная функция\t\tГипербола");
            for (int i = 0; i < size; i++) {
                System.out.println(X[i] + "\t\t\t\t" + Y[i] + "\t\t\t" + lineFunc[i] + "\t\t\t" + hyperbolicFunc[i]);
            }

            System.out.println("Сумма квадратов отклонений для линейной функции: " + leastSquaresMethod(lineFunc));
            System.out.println("Сумма квадратов отклонений для гиперболы: " + leastSquaresMethod(hyperbolicFunc));
        });




    }

    public double []GaussianElimination(double [][]matrix, double []b, int matrixSize)
    {

        double []X = new double[size];
        double [][]A = matrix;
        double []b_ = b;

        for (int k = 0; k < matrixSize - 1; k++) {

            double max = abs(A[k][k]);
            int c = k;

            for (int i = k + 1; i < matrixSize; i++) {
                if (abs(A[i][k]) > max) {
                    max = A[i][k];
                    c = i;
                }
            }

            double tmp;
            for (int i = k; i < matrixSize; i++) {
                tmp = A[k][i];
                A[k][i] = A[c][i];
                A[c][i] = tmp;
            }

            tmp = b_[k];
            b_[k] = b_[c];
            b_[c] = tmp;

            for (int i = k + 1; i < matrixSize; i++) {
                double m = A[i][k] / A[k][k];
                for (int j = k; j < matrixSize; j++) {
                    A[i][j] = A[i][j] - A[k][j] * m;
                }
                b_[i] = b_[i] - b_[k] * m;
            }
        }


        for (int i = matrixSize - 1; i >= 0; i--) {
            double tmp = 0;
            for (int j = i + 1; j < matrixSize; j++) {
                tmp = tmp + (A[i][j] * X[j]);
            }
            X[i] = (b_[i] - tmp) / A[i][i];
        }

        return X;
    }

    public double []approximationLine() {
        int arrSize = 2;
        double [][]matrix = new double[arrSize][arrSize];
        double []b = new double[arrSize];

        matrix[0][0] = 0;
        for (int i = 0; i < size; i++) {
            matrix[0][0] += X[i] * X[i];
        }
        b[0] = 0;
        for (int i = 0; i < size; i++) {
            b[0] += Y[i] * X[i];
        }

        matrix[0][1] = matrix[1][0] = Arrays.stream(X).sum();
        matrix[1][1] = size;
        b[1] = Arrays.stream(Y).sum();

        double []res = GaussianElimination(matrix, b, arrSize);
        double []funcValues = new double[size];

        for (int i = 0; i < funcValues.length; i++) {
            funcValues[i] = res[0] * X[i] + res[1];
        }

        return funcValues;
    }

    public double []approximationHyperbola() {
        int arrSize = 2;
        double [][]matrix = new double[arrSize][arrSize];
        double []b = new double[arrSize];

        matrix[0][0] = 0;
        for (int i = 0; i < size; i++) {
            matrix[0][0] += 1 / (X[i] * X[i]);
        }

        b[0] = 0;
        for (int i = 0; i < size; i++) {
            b[0] += Y[i] / X[i];
        }

        for (int i = 0; i < size; i++) {
            matrix[0][1] += 1 / X[i];
        }

        matrix[1][0] = matrix[0][1];
        matrix[1][1] = size;
        b[1] = Arrays.stream(Y).sum();

        double []res = GaussianElimination(matrix, b, arrSize);
        double []funcValues = new double[size];

        for (int i = 0; i < funcValues.length; i++) {
            funcValues[i] = res[0] / X[i] + res[1];
        }

        return funcValues;
    }

    public double leastSquaresMethod(double []y) {
        double e = 0;
        for (int i = 0; i < y.length; i++) {
            e = (Y[i] - y[i]) * (Y[i] - y[i]);
        }
        return e;
    }
}
