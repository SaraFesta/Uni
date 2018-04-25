/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibs.fp.pointslines;
import it.unibs.fp.mylib.*;

/**
 *
 * @author Kyazai
 */
public class Point {
    
    /*attributes*/
    
    /*private*/
    /*non-static*/
    private double abscissa;
    private double ordinate;
    /*public*/
    /*static*/
    public static final String SET_ABSCISSA = "Insert real value for the abscissa\n> ";
    public static final String SET_ORDINATE = "Insert the real value for the ordinate\n> ";
    public static final String ABSCISSA = "Abscissa:";
    public static final String ORDINATE = "Ordinate:";
    public static final String DISTANCE = "Distance between the two points:";
    public static final String STP = "Creating the first point:";
    public static final String NDP = "Creating the second point:";
    public static final String RDP = "Creating the third point:";
    /*methods*/
    
    /*constructors*/
    public Point(double abscissa,double ordinate)
    {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }
    
    /*getters*/
    public double getAbscissa()
    {
        return abscissa;
    }
    public double getOrdinate()
    {
        return ordinate;
    }
    
    /*setters*/
    public void setAbscissa(double abscissa)
    {
        this.abscissa = abscissa;
    }
    public void setOrdinate(double ordinate)
    {
        this.ordinate = ordinate;
    }
    
    /*distance between two points*/
    public double distance(Point A)
    {
       return Math.sqrt(Math.pow((this.abscissa-A.abscissa),2)  +Math.pow ((this.ordinate-A.ordinate),2) );
    }
    /*angular coefficient of two points*/
    public double angle(Point B)
    {
        if(abscissa == B.abscissa)
        {
            return Double.POSITIVE_INFINITY;
        }
        else if(ordinate == B.ordinate)
        {
            return 0;
        }
        else
        {
            return (ordinate-B.ordinate)/(abscissa-B.abscissa);
        }
    }
    
    /*strings*/
    public String stringDistance(Point A)
    {
        return DISTANCE+distance(A);
    }

    public String toString()
    {
        return ABSCISSA+abscissa+"\n"+ORDINATE+ordinate;
    }
    /*console mode*/
    public static double consoleInputAbscissa()
    {
        return InputDati.leggiDouble(SET_ABSCISSA);
    }
    public static double consoleInputOrdinate()
    {
        return InputDati.leggiDouble(SET_ORDINATE);
    }
   
}
