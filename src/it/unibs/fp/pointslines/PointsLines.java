/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibs.fp.pointslines;
import it.unibs.fp.mylib.MyMenuCorretto;

/**
 *
 * @author Kyazai
 */
public class PointsLines {

    /**
     * @param args the command line arguments
     */
    /*Attributes*/
    public static final String EXPL = "Welcome!"
            + "\nThis program deals with points and lines in the cartesian 2D plane.";
    public static final String END = "End of the execution.";
    public static final String AGAIN = "Again";
    
    public static void main(String[] args) {
        

        // TODO code application logic here
        /*graphical mode*/
        
        
        /*command-line mode*/
        System.out.println("\n\n"+EXPL+"\n\n");
         String[] voci = {AGAIN};
        MyMenuCorretto menuConsole = new MyMenuCorretto(voci);
        boolean exit = false;
     
        do
                                     {
            
        System.out.println("\n"+Point.STP+"\n");
        Point StP = new Point(Point.consoleInputAbscissa(),Point.consoleInputOrdinate());
        System.out.println("\n\n"+StP.toString()+"\n\n");
        
        System.out.println("\n"+Point.NDP+"\n");
        Point NdP = new Point(Point.consoleInputAbscissa(),Point.consoleInputOrdinate());
        System.out.println("\n\n"+NdP.toString()+"\n\n");
        
        System.out.println("\n"+StP.stringDistance(NdP)+"\n\n");
        
        if(  !(StP.getAbscissa()==NdP.getAbscissa()&&StP.getOrdinate()==NdP.getOrdinate()) )
                {
        
        System.out.println(Line.LINE);
        Line StL = new Line(StP,NdP);
        System.out.println("\n\n"+StL.toString()+"\n\n");
       System.out.println("\n\n");
       
       System.out.println("\n"+Point.RDP+"\n");
       Point RdP = new Point(Point.consoleInputAbscissa(),Point.consoleInputOrdinate());
       System.out.println("\n\n"+RdP.toString()+"\n\n");
       
       System.out.println("\n\n"+StL.stringHasPoint(RdP)+"\n\n");
       
                }
        else
        {
            System.out.println("\n\n"+Line.COINCIDENT_POINTS+"\n\n");
        }
        
       System.out.println("\n\n");
       int scelta = menuConsole.scegliSenzaTitolo();
       if (scelta==0)
       {
           exit=true;
       }
       else exit=false;
        
                                       }
        while(exit==false);
        System.out.println("\n\n"+END+"\n\n");
    }
}
