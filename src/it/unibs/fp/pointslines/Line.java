/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibs.fp.pointslines;

/**
 *
 * @author Kyazai
 */
public class Line 
{
    
    /*attributes*/
    
    /*private*/
    /*non-static*/
    private Point A;
    private Point B;
    private double angle;
    /*static*/
    public static final String EQN = "Equation of the line:";
    public static final String ANGLE = "The angular coefficient of the line is:";
    public static final String HAS_POINT = "The point belongs to the line.";
    public static final String HASNT_POINT = "The point doesn't belong to the line.";
    public static final String COINCIDENT_POINTS = "The two points concide, so they do not individuate a single line but an infinite number of lines";
    public static final String LINE = "Creating the line for the two points:";

    /*methods*/
    /*constructors*/
    public Line(Point A,Point B)
    {
        if(! (A.getAbscissa()==B.getAbscissa() && A.getOrdinate()==B.getOrdinate())  )
        {
             this.A = A;
             this.B = B;
        }
        else
        {
            System.out.println("\n"+COINCIDENT_POINTS+"\n");
        }
    }
           
    /*getters*/
    public Point getA()
    {
        return A;
    }
    public Point getB()
    {
        return B;
    }
    public double getAngle()
    {
        return angle;
    }
    /*angular coefficient*/
    public double angle()
    {
        if(A.getAbscissa()==B.getAbscissa())
        {
            return Double.POSITIVE_INFINITY;
        }
        else if(A.getOrdinate()==B.getOrdinate())
        {
            return 0;
        }
        else
        {
            return (A.getOrdinate()-B.getOrdinate())/(A.getAbscissa()-B.getAbscissa());
        }
    }
    
    public static double angle(Point A, Point B)
    {
        if(A.getAbscissa()==B.getAbscissa())
        {
            return Double.POSITIVE_INFINITY;
        }
        else if(A.getOrdinate()==B.getOrdinate())
        {
            return 0;
        }
        else
        {
            return (A.getOrdinate()-B.getOrdinate())/(A.getAbscissa()-B.getAbscissa());
        }
        
    }
    public boolean hasPoint(Point C)
    {
        if(angle()==C.angle(A)||angle==C.angle(B)||C.angle(A)==C.angle(B))
        {
            return true;
        }
        else
        {
            return false;
        }
     }
    /*string*/
    public String toString()
    {
        if(angle()==Double.POSITIVE_INFINITY)
        {
            return EQN+"\n"+"X = "+A.getAbscissa();
        }
        else if(angle()==0)
        {
            return EQN+"\n"+"Y = "+A.getOrdinate();
        }
        else
        {
            return EQN+"\n"+"Y - "+A.getOrdinate()+" = "+angle()+" ( "+ "X - "+A.getAbscissa() + " ) ";
        }
    }
    public String stringHasPoint(Point C)
    {
        if(hasPoint(C))
        {
            return HAS_POINT;
        }
        else
            return HASNT_POINT;
    }
}
