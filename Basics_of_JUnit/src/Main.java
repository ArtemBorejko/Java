import static java.lang.Math.*;

public class Main {

    public double CalcY(double x, double a, double b, double c, double eps) {
        if (x - 1.4 < eps) {
            return a * (x * x) + b * x + c;
        } else if (x == 1.4) {
            return a / x + sqrt((x * x) + 1);
        } else {
            return (a + b * x) / sqrt((x * x) + 1);
        }
    }
    public double CalcY(double x, double a, double b, double c){
        return CalcY(x, a, b, c, 0.001);
    }

    public int stepPoint(double start, double end, double step){
        return (int) ((end - start) / step + 1);
    }

    public double[] getAllx(double start, double end, double step){
        int steps = stepPoint(start, end, step);
        double[] x = new double [steps];
        for(int i = 0; i < x.length; i++)
            x[i] = start + i * step;
        return x;
    }

    public double[] getAlly(double[] x, double a,double b,double c){
        double [] y = new double [x.length];
        for(int i = 0; i <y.length; i++){
            y[i] =  CalcY(x[i], a, b, c);}
        return y;
    }
}

