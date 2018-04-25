/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibs.fp.lab.tamabase;
import it.unibs.fp.mylib.*;
/**
 *
 * @author kyazai
 */

public class TamagotchiMain {
    public static void main(String[] args)
    {
       
        
  //---------------------------------GUI--------------------------------------------------

      
        
           
//---------------------------------CONSOLE--------------------------------------------------
        System.out.println(BENVENUTO);
        Tamagotchi myTamagotchi = creaTamagotchi();
        boolean fine=false;
        String[] vociMenuTamagotchi = {DAI_CAREZZE,DAI_BISCOTTI,VEDI_STATO};
        MyMenuCorretto menuTamagotchi = new MyMenuCorretto(vociMenuTamagotchi);
        do
        {
           System.out.println("\n\n\n");
            int scelta = menuTamagotchi.scegliSenzaTitolo();
            if(scelta==1)
            {
                int numeroCarezze = InputDati.leggiIntero(QUANTE_CAREZZE, 0, Tamagotchi.MAX_CAREZZE_ASSEGNABILI);
                myTamagotchi.daiNCarezze(numeroCarezze);
            }
            else if(scelta==2)
            {
                int numeroBiscotti = InputDati.leggiIntero(QUANTI_BISCOTTI, 0, Tamagotchi.MAX_BISCOTTI_ASSEGNABILI);
                myTamagotchi.daiNBiscotti(numeroBiscotti);
            }
            else if(scelta==3)
            {
                System.out.println(myTamagotchi.getStato());
             
                if(myTamagotchi.sazio())
            {
                System.out.println(Tamagotchi.SAZIO);
            }
            if (myTamagotchi.soddisfatto())
            {
                System.out.println(Tamagotchi.SODDISFATTO);
            }
            if(myTamagotchi.affamato())
            {
                System.out.println(Tamagotchi.FAME);
            }
            if(myTamagotchi.insoddisfatto())
            {
                System.out.println(Tamagotchi.TRISTE);
            }
               if(myTamagotchi.felice())
                {
                    System.out.println(Tamagotchi.FELICE);
                }
                if(myTamagotchi.infelice())
                {
                    System.out.println(Tamagotchi.INFELICE);
                }
            
          
            }
            else if(scelta==0)
            {
                fine=true;
            }
        }
        while(fine==false);
        
    }
    
    private static Tamagotchi creaTamagotchi()
    {
        String nomeTamagotchi=InputDati.leggiStringaNonVuota(INSERISCI_NOME);
        int soddisfazioneIniziale=InputDati.leggiIntero(INSERISCI_SODDISFAZIONE,0,Tamagotchi.MASSIMA_SODDISFAZIONE);
        int sazietaIniziale = InputDati.leggiIntero(INSERISCI_SAZIETA,0,Tamagotchi.MASSIMA_SAZIETA);
        Tamagotchi myTamagotchi = new Tamagotchi(nomeTamagotchi,soddisfazioneIniziale,sazietaIniziale);
        return myTamagotchi;
    }
    
    private final static String BENVENUTO = "TAMAGOTCHI!\n\n";
    private final static String INSERISCI_NOME = "Inserisci il nome del tuo tamagotchi:\n>  ";
    private final static String INSERISCI_SODDISFAZIONE = "Inserisci la soddisfazione iniziale "
            + "del tuo tamagotchi:\n -> minimo: "+Tamagotchi.ZERO_SAZIETA+"\n -> massimo: " +Tamagotchi.MASSIMA_SAZIETA  + " \n>  ";
    private final static String INSERISCI_SAZIETA = "Inserisci la sazietà iniziale del "
            + "tuo tamagotchi:\n -> minimo: "+Tamagotchi.ZERO_SAZIETA+"\n -> massimo: " +Tamagotchi.MASSIMA_SAZIETA  + "\n>  ";
    private final static String DAI_CAREZZE = "Accarezza il tuo tamagotchi";
    private final static String DAI_BISCOTTI = "Dai i biscotti al tuo tamagotchi";
    private final static String VEDI_STATO = "Vedi lo stato del tuo tamagotchi";
    private final static String QUANTE_CAREZZE = "Quante carezze vuoi dare?\n>  ";
    private final static String QUANTI_BISCOTTI = "Quanti biscotti vuoi dare?\n>  ";
    
}
