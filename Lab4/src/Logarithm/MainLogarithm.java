package Logarithm;

public class MainLogarithm
{
    private NaturalLogarithm NaturalLogarithmInst;
    private int base;
/*    private FileWriter writer;*/
    MainLogarithm(/*FileWriter writer, */int base)
    {
        NaturalLogarithmInst = new NaturalLogarithm();
        this.base = base;
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
