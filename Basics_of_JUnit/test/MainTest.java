import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MainTest {
    Main main;

    @Before
    public void setUp() throws Exception {
        main = new Main();
    }

    @Test
    public void testCalcY1() {
        double expected = 8.698;
        double result = main.CalcY(1.35, 2.8, -0.3, 4);
        assertEquals(expected, result, 0.001, "В первом уравнении: CalcY(1.35, 2.8, -0.3, 4)");
    }

    @Test
    public void testCalcY2() {
        double expected = 9.067;
        double result = main.CalcY(1.4, 2.8, -0.3, 4);
        assertEquals(expected, result, 0.001, "Во втором уравнении: CalcY(1.4, 2.8, -0.3, 4)");
    }

    @Test
    public void testCalcY3() {
        double expected = 1.342;
        double result = main.CalcY(1.45, 2.8, -0.3, 4);
        assertEquals(expected, result, 0.001, "В третьем уравнении: CalcY(1.45, 2.8, -0.3, 4)");
    }
    @Test
    public void testGetSteps(){
        double expected = 10;
        double result = main.stepPoint(1 , 10, 1);
        assertEquals(expected, result, 0.001,"неправильно!");
    }
    @Test
    public void testGetAllx(){
        double[] expected = {1, 2, 3, 4, 5};
        double[] result = main.getAllx(1, 5, 1);
        assertArrayEquals(expected, result, 0.001, "");
    }
    @Test
    public void testGetAlly(){
        double a = 2.8;
        double b = -0.3;
        double c = 4;
        double[] x = {1, 2};
        double[] expected = {main.CalcY(x[0],a, b, c), main.CalcY(x[1], a, b, c)};
        double[] result = main.getAlly(x, a, b, c);
        assertArrayEquals(expected, result, 0.001, "getAlly({1,2},2,3)");
    }
    @Test
    public void testGetAlly0(){
        double a = 2.8, start = 0, end = 2, step = 0.002;
        double b = -0.3;
        double c = 4;
        double[] x = main.getAllx(start, end, step);
        double[] y = main.getAlly(x, a, b, c);

        double expected = 4;
        double result = y[0];
        assertEquals(expected, result, 0.001, "y[0]");
    }
    @Test
    public void testGetAlly700(){
        double a = 2.8, start = 0, end = 2, step = 0.002;
        double b = -0.3;
        double c = 4;
        double[] x = main.getAllx(start, end, step);
        double[] y = main.getAlly(x, a, b, c);

        double expected = 9.068;
        double result = y[700];
        assertEquals(expected, result, 0.001, "y[700]");
    }
    @Test
    public void testGetAlly1000(){
        double a = 2.8, start = 0, end = 2, step = 0.002;
        double b = -0.3;
        double c = 4;
        double[] x = main.getAllx(start, end, step);
        double[] y = main.getAlly(x, a, b, c);

        double expected = 0.983;
        double result = y[1000];
        assertEquals(expected, result, 0.001, "y[1000]");
    }
}