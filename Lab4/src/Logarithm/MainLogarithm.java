package Logarithm;

import Sources.*;

public class MainLogarithm implements CalculationIface
{
    private static final double LN2 = 0.6931471806;
    private static final double LN3 = 1.098612289;
    private static final double LN5 = 1.609437912;
    private static final double LN10 =2.302585093;

    private NaturalLogarithm NaturalLogarithmInst;
    private int base;
/*    private FileWriter writer;*/
    boolean fake;
    public MainLogarithm(int base)
    {
        NaturalLogarithmInst = new NaturalLogarithm();
        this.base = base;
        fake = FakeSettings.fakeCosecant;
    }
    public double Calc(double arg)
    {
        double result;
        if(this.fake)
        {
            result = calcFake(arg, base);
        }
        else
        {
            result = Log(arg, base);
        }
        return result;
    }

    public double Log(double arg, int base)
    {
        double result;
        switch (base) {
            case 2:
                result = NaturalLogarithmInst.Calc(arg) / LN2;
                break;
            case 3:
                result = NaturalLogarithmInst.Calc(arg) / LN3;
                break;
            case 5:
                result = NaturalLogarithmInst.Calc(arg) / LN5;
                break;
            case 10:
                result = NaturalLogarithmInst.Calc(arg) / LN10;
                break;
            default:
                result = Double.NaN;
        }
        return result;
    }

    private double calcFake(double arg, int base)
    {
        double result;

        switch (base)
        {
            case 2:
                result = calcFake2(arg);
                break;
            case 3:
                result = calcFake3(arg);
                break;
            case 5:
                result = calcFake5(arg);
                break;
            case 10:
                result = calcFake10(arg);
                break;
            default:
                result = Double.NaN;
        }

        return result;
    }

    private double calcFake2(double arg)
    {
        double result;
        if((arg == 2.0) || (arg == 3.0))
        {
            if (arg == 2.0)
            {
                result = 1;
            }
            else
            {
                result = 1.584962501;
            }
        }
        else
        {
            if((arg == 2.01) || (arg == 2.98))
            {
                result = Double.NaN;
            }
            else
            {
                if((arg == 2.2) || (arg == 2.5) || (arg == 2.8))
                {
                    if(arg == 2.2) result = 1.137503524;
                    else
                    {
                        if (arg == 2.5) result = 1.321928095;
                        else result = 1.485426827;
                    }

                }
                else
                {
                    result = Double.NaN;
                }
            }
        }
        return result;
    }

    private double calcFake3(double arg)
    {
        double result;
        if((arg == 2.0) || (arg == 3.0))
        {
            if (arg == 2.0)
            {
                result = 0.6309297536;
            }
            else
            {
                result = 1;
            }
        }
        else
        {
            if((arg == 2.01) || (arg == 2.98))
            {
                result = Double.NaN;
            }
            else
            {
                if((arg == 2.2) || (arg == 2.5) || (arg == 2.8))
                {
                    if(arg == 2.2) result = 0.7176848179;
                    else
                    {
                        if (arg == 2.5) result = 0.8340437671;
                        else result = 0.937199982;
                    }

                }
                else
                {
                    result = Double.NaN;
                }
            }
        }
        return result;
    }

    private double calcFake5(double arg)
    {
        double result;
        if((arg == 2.0) || (arg == 3.0))
        {
            if (arg == 2.0)
            {
                result = 0.4306765581;
            }
            else
            {
                result = 0.6826061945;
            }
        }
        else
        {
            if((arg == 2.01) || (arg == 2.98))
            {
                result = Double.NaN;
            }
            else
            {
                if((arg == 2.2) || (arg == 2.5) || (arg == 2.8))
                {
                    if(arg == 2.2) result = 0.4898961024;
                    else
                    {
                        if (arg == 2.5) result = 0.5693234419;
                        else result = 0.6397385132;
                    }

                }
                else
                {
                    result = Double.NaN;
                }
            }
        }
        return result;
    }

    private double calcFake10(double arg)
    {
        double result;
        if((arg == 2.0) || (arg == 3.0))
        {
            if (arg == 2.0)
            {
                result = 0.3010299957;
            }
            else
            {
                result = 0.4771212547;
            }
        }
        else
        {
            if((arg == 2.01) || (arg == 2.98))
            {
                result = Double.NaN;
            }
            else
            {
                if((arg == 2.2) || (arg == 2.5) || (arg == 2.8))
                {
                    if(arg == 2.2) result = 0.3424226808;
                    else
                    {
                        if (arg == 2.5) result = 0.3979400087;
                        else result = 0.4471580313;
                    }

                }
                else
                {
                    result = Double.NaN;
                }
            }
        }
        return result;
    }
}
