import Fake.FakeSettings;
import Trigonometry.Cosine;
import org.junit.Test;

import java.io.PrintWriter;

public class Main
{
    private static void runIntegration()
    {
        Function func;
        {
            FakeSettings.fakeBaseTrigonometry = true;
            FakeSettings.fakeCosecant = true;
            FakeSettings.fakeCotangent = true;
            FakeSettings.fakeFunction = true;
            FakeSettings.fakeLogFunction = true;
            FakeSettings.fakeMainLogarithm = true;
            FakeSettings.fakeNaturalLogarithm = true;
            FakeSettings.fakeSecant = true;
            FakeSettings.fakeSine = true;
            FakeSettings.fakeTangent = true;
            FakeSettings.fakeTrigFunction = true;
            func = new Function();
            SystemTest.testSystem(func, "All fakes: ");
        }
        {
            FakeSettings.fakeFunction = false;
            func = new Function();
            SystemTest.testSystem(func, "With real function: ");
        }
        {
            FakeSettings.fakeLogFunction = false;
            func = new Function();
            SystemTest.testSystem(func, "With real log function: ");
        }
        {
            FakeSettings.fakeLogFunction = true;
            FakeSettings.fakeTrigFunction = false;
            func = new Function();
            SystemTest.testSystem(func, "With real trig function: ");
        }
        {
            FakeSettings.fakeLogFunction = false;
            FakeSettings.fakeTrigFunction = false;
            func = new Function();
            SystemTest.testSystem(func, "With real trig and log function: ");
        }
    }

    private static void runCSVWriter(PrintWriter writer, String header, Cosine cos, double step, double start, double end)
    {
        writer.println("---"+header+"---");
        for(double x = start; x<=end; x+=step)
        {
            writer.println(x + ", " + cos.Calc(x));
        }
    }

    private static void runAnalyze(double step)
    {
        PrintWriter writer;
        try {
            writer = new PrintWriter("analyze_results", "UTF-8");
        } catch (Exception e){
            System.out.println("Error: can`t open file");
            return;
        }
        runCSVWriter(writer, "Cosine", new Cosine(), step, 0, 1.5707);
    }

    public static void main(String[] args)
    {
        if(args.length >= 2)
        {
            if(args[0].equalsIgnoreCase("-s"))
            {
                double step;
                try {
                    step = Double.parseDouble(args[1]);
                } catch (Exception e) {
                    System.out.println("Error: unknown step");
                    return;
                }
                runAnalyze(step);
            }
        }
        else
        {
            runIntegration();
        }
    }
}