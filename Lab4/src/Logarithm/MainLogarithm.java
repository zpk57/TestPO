package Logarithm;

import Fake.FakeSettings;

public class MainLogarithm
{
    private NaturalLogarithm NaturalLogarithmInst;
    private int base;
/*    private FileWriter writer;*/
    boolean fake;
    MainLogarithm(/*FileWriter writer, */int base)
    {
        NaturalLogarithmInst = new NaturalLogarithm();
        this.base = base;
        fake = FakeSettings.fakeCosecant;
    }
    public double LogBase(double arg)
    {
        double result;
        if((base == 2) || (base == 3) || (base == 5) || (base == 10))
        {
            result = NaturalLogarithmInst.ln(arg) / NaturalLogarithmInst.ln(base);
        }
        else
        {
            result = Double.NaN;
        }
/*        try
        {
            writer.write("Log_" + base + "(" +arg+ ") = " + result + "\n");
        }
        catch (Exception e) {}*/
        return result;
    }
}
