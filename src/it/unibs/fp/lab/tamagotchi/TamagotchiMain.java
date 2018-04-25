
package it.unibs.fp.lab.tamagotchi;
import java.util.*;

import it.unibs.fp.mylib.*;
/**
 * @author Denis Festa, Sara Salducco.
 */

public class TamagotchiMain {
	
	private final static String INSERT = "\n>\t";
	private final static String BENVENUTO = "Lei e' il/la benvenuto/a nel mondo dei Tamagotchi!";
	private final static String PRONTO = "E' pronto/a per creare il suo primo Tamagotchi?";
	
    private final static String INSERISCI_NOME = "Inserisca il nome del suo tamagotchi: ";
    private final static String INSERISCI_SODDISFAZIONE = "Inserisca la soddisfazione iniziale del suo tamagotchi:\n > minimo: "+Tamagotchi.ZERO_SAZIETA+"\n > massimo: " +Tamagotchi.MASSIMA_SAZIETA;
    private final static String INSERISCI_SAZIETA = "Inserisca la sazieta' iniziale del suo tamagotchi:\n > minimo: "+Tamagotchi.ZERO_SAZIETA+"\n > massimo: " +Tamagotchi.MASSIMA_SAZIETA;
    
    private final static String DAI_CAREZZE = "Accarezzi il suo tamagotchi";
    private final static String DAI_BISCOTTI = "Dia i biscotti al suo tamagotchi";
    private final static String DAI_CAFFE = "Somministri un caffe' al suo tamagotchi";
    private final static String VEDI_STATO = "Veda lo stato del tuo tamagotchi";
    private final static String NUOVO_TAMAGOTCHI = "Crei un nuovo tamagotchi";
    
    private final static String QUALE_TAMAGOTCHI = "Quale tamagotchi?";
    
    private final static String FINE = "Ha abbandonato i suoi tamagotchi!";
    private final static String COMPLIMENTI = "Complimenti: tutti i suoi tamagotchi sono morti.\nLe suggeriamo di cambiare mestiere!";
    
    private final static String[] vociMenuTamagotchi = {DAI_CAREZZE,DAI_BISCOTTI,DAI_CAFFE,VEDI_STATO,NUOVO_TAMAGOTCHI};
    private static MyMenuCorretto menuTamagotchi = new MyMenuCorretto(vociMenuTamagotchi);
    
    /**
     * @return un oggetto di tipo Tamagotchi dotato di nome, 
     * grado di soddisfazione iniziale e grado di sazieta' iniziale.
     * I dati sono ottenuti con l'aiuto di it.unibs.fp.mylib.InputDati ;
     * fornita dall'universita'.
     */
    private static Tamagotchi creaTamagotchiDaTerminale(){
        return new Tamagotchi(
    			InputDati.leggiStringaNonVuota(INSERISCI_NOME+INSERT),
        		InputDati.leggiIntero(INSERISCI_SODDISFAZIONE+INSERT,Tamagotchi.ZERO_SODDISFAZIONE,Tamagotchi.MASSIMA_SODDISFAZIONE),
        		InputDati.leggiIntero(INSERISCI_SAZIETA+INSERT,Tamagotchi.ZERO_SAZIETA,Tamagotchi.MASSIMA_SAZIETA)
        		);
    }
    /**
     * @param listaTamagotchi la lista dei Tamagotchi che verra' iterata per stampare il nome di ogni tamagotchi in essa.
     */
    public static void stampaListaTamagotchi(List<Tamagotchi> listaTamagotchi) {
		for(int i=0;i<listaTamagotchi.size();i++) {
			System.out.printf(ListaTamagotchi.TAMAGOTCHI_IN_LISTA+"%n",(i+1),listaTamagotchi.get(i).getNome().toUpperCase());
		}
	}
    public static void main(String[] args){
		System.out.println("\n\n");
    	System.out.println(BENVENUTO);
    	System.out.println("\n\n");
    	System.out.println(PRONTO);
    	System.out.println("\n\n");
    	
        ListaTamagotchi listaTamagotchi = new ListaTamagotchi();   
        
        try {listaTamagotchi.addTamagotchi(creaTamagotchiDaTerminale());}
        catch(TamagotchiGiaEsistenteException ex ){System.out.println(ex.toString());}
        
        boolean fine=false;
        
        if(listaTamagotchi.nessunoVivo()==false){
        	do{
        		System.out.println("\n\n");
        		int scelta = menuTamagotchi.scegliSenzaTitolo();
        		switch(scelta){
        		/**
        		 * L'utente accarezza uno dei tamagotchi.
        		 */
        		case 1:
        			System.out.println("\n\n");
        			System.out.println(QUALE_TAMAGOTCHI+"\n");
        			stampaListaTamagotchi(listaTamagotchi.getListaTamagotchi());
        			System.out.println(INSERT);
        			int scelta1 =InputDati.leggiIntero("",1 ,listaTamagotchi.getListaTamagotchi().size());
        			scelta1--;
        			listaTamagotchi.getListaTamagotchi().get(scelta1).ricevoCarezze(EstrazioniCasuali.estraiIntero(Tamagotchi.MIN_ASSEGNABILE,Tamagotchi.MAX_ASSEGNABILE));
        			for(Tamagotchi tamaSenzaCarezze:listaTamagotchi.getListaTamagotchi()) {
        				if(!tamaSenzaCarezze.equals(listaTamagotchi.getListaTamagotchi().get(scelta1)))
        					System.out.println(tamaSenzaCarezze.anchioVoglioCarezze());
        			}
        			System.out.println("\n\n");
        			break;	
        		/**
        		 * L'utente da' i biscotti a uno dei tamagotchi.
        		 */
        		case 2:
        			System.out.println("\n\n");
        			System.out.println(QUALE_TAMAGOTCHI+"\n");
        			stampaListaTamagotchi(listaTamagotchi.getListaTamagotchi());
        			System.out.println(INSERT);
        			int scelta2 =InputDati.leggiIntero("",1 ,listaTamagotchi.getListaTamagotchi().size());
        			scelta2--;
        			listaTamagotchi.getListaTamagotchi().get(scelta2).ricevoBiscotti(EstrazioniCasuali.estraiIntero(Tamagotchi.MIN_ASSEGNABILE,Tamagotchi.MAX_ASSEGNABILE));
        			for(Tamagotchi tamaSenzaBiscotti:listaTamagotchi.getListaTamagotchi()){
        				if(!tamaSenzaBiscotti.equals(listaTamagotchi.getListaTamagotchi().get(scelta2)))
        					System.out.println(tamaSenzaBiscotti.anchioVoglioBiscotti());
        			}
        			System.out.println("\n\n");
        			break;
        		/**
        		 * L'utente da' una sigaretta a uno dei tamagotchi.
        		 */
        		case 3:
        			System.out.println("\n\n");
        			System.out.println(QUALE_TAMAGOTCHI+"\n");
        			stampaListaTamagotchi(listaTamagotchi.getListaTamagotchi());
        			System.out.println(INSERT);
        			int scelta3 =InputDati.leggiIntero("",1 ,listaTamagotchi.getListaTamagotchi().size());
        			scelta3--;
        			System.out.println(listaTamagotchi.getListaTamagotchi().get(scelta3).ricevoCaffe());
        			System.out.println("\n\n");
        			break;
        		/**
        		 * L'utente vedw lo stato di uno dei tamagotchi.
        		 */
        		case 4:
        			System.out.println("\n\n");
        			System.out.println(QUALE_TAMAGOTCHI+"\n");
        			stampaListaTamagotchi(listaTamagotchi.getListaTamagotchi());
        			System.out.println(INSERT);
        			int scelta4 =InputDati.leggiIntero("",1 ,listaTamagotchi.getListaTamagotchi().size());
        			scelta4--;
        			System.out.println(listaTamagotchi.getListaTamagotchi().get(scelta4).toString());
        			System.out.println("\n\n");
        			break;
        		/**
        		 * L'utente crea un nuovo tamagotchi (deve avere un nome diverso dai presenti).
        		 */
        		case 5:
        			System.out.println("\n\n");
        			try{listaTamagotchi.addTamagotchi(creaTamagotchiDaTerminale());}
        			catch(TamagotchiGiaEsistenteException ex ){System.out.println(ex.toString());}
        			System.out.println("\n\n");
        			break;
        		/**
        		 * L'utente esce dal programma.
        		 */
        		case 0:
        			System.out.println("\n\n");
        			System.out.println(FINE);
        			System.out.println("\n\n");
        			fine=true;
        			break;
        		}
        		/**
        		 * se nessun tamagotchi e' vivo il programma termina.
        		 */
        		if(listaTamagotchi.nessunoVivo()){
        			System.out.println("\n\n");
        			System.out.println(COMPLIMENTI);
        			System.out.println("\n\n");
        			fine=true;
        		}else {
        		/**
        		 * dato che esiste almeno un tamagotchi vivo, viene iterata la lista
        		 * dei tamagotchi alla ricerca di un tamagotchi che sia morto.
        		 * Se viene trovato un tamagotchi morto, allora parte una seconda
        		 * ricerca di un tamagotchi che sia diverso da quello morto trovato 
        		 * durante la prima ricerca, se questo viene trovato, annuncera' 
        		 * la morte del tamagotchi morto (quello trovato durante la prima ricerca).
        		 */
        			for(Tamagotchi tamaMorto:listaTamagotchi.getListaTamagotchi()) {
        				if(tamaMorto.sonoMorto()) {
        					for(Tamagotchi tamaVivo:listaTamagotchi.getListaTamagotchi()) {
        						if(!tamaVivo.equals(tamaMorto))
        							System.out.println(tamaVivo.unAmicoEMorto(tamaMorto.getNome()));
        					}
        				}
        			}
        			listaTamagotchi.rimuoviMorti();
        		}
        	}while(fine==false);
        }
    }
    
}
