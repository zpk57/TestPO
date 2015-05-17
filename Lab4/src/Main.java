import Logarithm.*;
import Sources.*;
import Trigonometry.*;

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
        {
            FakeSettings.fakeMainLogarithm = false;
            func = new Function();
            SystemTest.testSystem(func, "With real main logarithm: ");
        }
        {
            FakeSettings.fakeNaturalLogarithm = false;
            func = new Function();
            SystemTest.testSystem(func, "With real natural logarithm: ");
        }
        {
            FakeSettings.fakeCosecant = false;
            func = new Function();
            SystemTest.testSystem(func, "With real Cosecant: ");
        }
        {
            FakeSettings.fakeCosecant = true;
            FakeSettings.fakeCotangent = false;
            func = new Function();
            SystemTest.testSystem(func, "With real Cotangent: ");
        }
        {
            FakeSettings.fakeCotangent = true;
            FakeSettings.fakeSecant = false;
            func = new Function();
            SystemTest.testSystem(func, "With real Secant: ");
        }
        {
            FakeSettings.fakeSecant = true;
            FakeSettings.fakeSine = false;
            func = new Function();
            SystemTest.testSystem(func, "With real Sine: ");
        }
        {
            FakeSettings.fakeSine = true;
            FakeSettings.fakeTangent = false;
            func = new Function();
            SystemTest.testSystem(func, "With real Tangent: ");
        }
        {
            FakeSettings.fakeCosecant = false;
            FakeSettings.fakeCotangent = false;
            FakeSettings.fakeSecant = false;
            FakeSettings.fakeSine = false;
            FakeSettings.fakeTangent = false;
            func = new Function();
            SystemTest.testSystem(func, "With all not-base trigonometry: ");
        }
        {
            FakeSettings.fakeBaseTrigonometry = false;
            func = new Function();
            SystemTest.testSystem(func, "All real: ");
        }
    }

    private static void runCSVWriter(PrintWriter writer, String header, CalculationIface cos, double step, double start, double end)
    {
        writer.println("---" + header + "---");
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
        runCSVWriter(writer, "Cosecant", new Cosecant(), step, 0, 1.5707);
        runCSVWriter(writer, "Cosine", new Cosine(), step, 0, 1.5707);
        runCSVWriter(writer, "Cotangent", new Cotangent(), step, 0, 1.5707);
        runCSVWriter(writer, "Secant", new Secant(), step, 0, 1.5707);
        runCSVWriter(writer, "Sine", new Sine(), step, 0, 1.5707);
        runCSVWriter(writer, "Tangent", new Tangent(), step, 0, 1.5707);
        runCSVWriter(writer, "TrigFunction", new TrigFunction(), step, 0, 1.5707);

        runCSVWriter(writer, "NaturalLogarithm_2", new NaturalLogarithm(), step, 2, 3);
        runCSVWriter(writer, "MainLogarithm", new MainLogarithm(2), step, 2, 3);
        runCSVWriter(writer, "LogFunction", new LogFunction(), step, 2, 3);

        runCSVWriter(writer, "MainFunction", new Function(), step, 0, 3);

        writer.close();
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