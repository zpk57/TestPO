package Logarithm;

import Sources.*;

public class MainLogarithm implements CalculationIface
{
    private NaturalLogarithm NaturalLogarithmInst;
    private int base;
/*    private FileWriter writer;*/
    boolean fake;
    public MainLogarithm(/*FileWriter writer, */int base)
    {
        NaturalLogarithmInst = new NaturalLogarithm();
        this.base = base;
        fake = FakeSettings.fakeCosecant;
    }
    public double Calc(double arg)
    {
        double result;
        if((base == 2) || (base == 3) || (base == 5) || (base == 10))
        {
            result = NaturalLogarithmInst.Calc(arg) / NaturalLogarithmInst.Calc(base);
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
