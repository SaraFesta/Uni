/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unibs.fp.lab.tamabase;

/**
 *
 * @author kyazai
 */
public class Tamagotchi {
    private String name;
    private int carezze;
    private int biscotti;
    public static final int MAX_CAREZZE_ASSEGNABILI = 20;
    public static final int MAX_BISCOTTI_ASSEGNABILI = 20;
    public static final int ALTA_SAZIETA=80;
    public static final int ALTA_SODDISFAZIONE = 80;
    public static final int BASSA_SODDISFAZIONE = 30;
    public static final int BASSA_SAZIETA = 30;
    public static final int MASSIMA_SODDISFAZIONE = 100;
    public static final int MASSIMA_SAZIETA = 100;
    public static final int ZERO_SODDISFAZIONE = 0;
    public static final int ZERO_SAZIETA = 0;
    public static final int DIMINUZIONE=5;
    public final static String FAME = "Sono affamato!";
    public final static String TRISTE = "Sono triste!";
    public final static String SAZIO = "Sono sazio!";
    public final static String SODDISFATTO = "Sono soddisfatto!";
    public static final String FELICE = "Sono felice!";
    public static final String INFELICE = "Sono infelice!";
    
    public Tamagotchi(String nome,int carezze,int biscotti)
    {
        this.name = nome;
        this.carezze=carezze;
        this.biscotti = biscotti;
    }
 
    public boolean felice()
    {
        if(carezze>=ALTA_SODDISFAZIONE && biscotti >=ALTA_SAZIETA)
        {
            return true;
        }
        return false;
    }
    
    public boolean infelice()
    {
        if(carezze<BASSA_SODDISFAZIONE||biscotti<BASSA_SAZIETA)
        {
            return true;
        }
        else return false;
    }
    
    public boolean sazio()
    {
        if(biscotti>=ALTA_SAZIETA)
        {
            return true;
        }
       else return false;
    }
    
    public boolean soddisfatto()
    {
        if(carezze>=ALTA_SODDISFAZIONE)
        {
            return true;
        }
        else return false;
    }
    
    public boolean affamato()
    {
        if(biscotti<BASSA_SAZIETA)
        {
            return true;
        }
        return false;
    }
    
    public boolean insoddisfatto()
    {
        if(carezze<BASSA_SODDISFAZIONE)
        {
            return true;
        }
        else return false;
    }
          
    public void daiNCarezze(int carezze)
    {
        {
            this.carezze=Math.min(MASSIMA_SODDISFAZIONE, this.carezze+carezze);
            this.biscotti = Math.max(this.biscotti-=DIMINUZIONE, ZERO_SAZIETA);
        }
        
    }
    public void daiNBiscotti(int biscotti)
    {
        {
        this.biscotti = Math.min(MASSIMA_SAZIETA, this.biscotti+ biscotti);
           carezze = Math.max(carezze-=DIMINUZIONE, ZERO_SODDISFAZIONE);
        }

    }

    public String getStato()
    {
        return "\n>  Nome del tamagotchi:   "+name+"\n> Soddisfazione:   "+carezze+"\n> Sazietà:   "+biscotti+"\n";
    }
}
