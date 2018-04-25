/**
 * @author Denis Festa
 */
package it.unibs.fp.lab.medagliereolimpico;
import java.util.*;
import it.unibs.fp.mylib.*;
public class ClasseMain 
{
	/**
	 * Attributi: 
	 */
	
	/**
	 * Voci del menu:
	 */
	private final static String INTRODUCI_NAZIONE = "Introduci una nazione";
	private final static String INTRODUCI_GARA = "Introduci una disciplina";
	private final static String INTRODUCI_RISULTATO = "Introduci i risultati delle gare";
	private final static String VISUALIZZA_MEDAGLIERE = "Visualizza il medagliere";
	private final static String RIMUOVI_NAZIONE = "Rimuovi una nazione dalla lista";
	private final static String RIMUOVI_GARA = "Rimuovi una disciplina dalla lista";
	private final static String[] vociMenu = {INTRODUCI_NAZIONE,RIMUOVI_NAZIONE,INTRODUCI_GARA,RIMUOVI_GARA,INTRODUCI_RISULTATO, VISUALIZZA_MEDAGLIERE};
	/**
	 * Esecuzione del programma;
	 * l'intero scelta e' inizializzato a zero solo per sicurezza, il valore zero coincide con la scelta di uscire dal programma;
	 */
	private static int scelta = 0;
	private static boolean end = false;
	private final static String INSERIRE_INTERO = "Scegli la voce desiderata:\n>\t";
	private final static String INVALID = "La scelta non e' valida!";
	private final static String BYE = "Arrivederci!\n\n";
	private final static String INSERISCI_NOME_NAZIONE = "Inserisci il nome della nazione:\n>\t";
	private final static String INSERISCI_NOME_GARA = "Inserisci il nome della disciplina:\n>\t";
	private final static String NUMERO_NAZIONE_DA_ELIMINARE = "Inserisci il numero della nazione da eliminare:\n>\t";
	private final static String NUMERO_GARA_DA_ELIMINARE = "Inserisci il numero della disciplina da eliminare:\n>\t";

	/**
	 * Metodo main;
	 * @param args;
	 * 
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ListaGare listaGare = new ListaGare();
		ListaNazioni listaNazioni = new ListaNazioni();
		MyMenuCorretto menu = new MyMenuCorretto(vociMenu);
		do
		{
			System.out.println("\n\n");
			menu.stampaMenuSenzaTitolo();
			scelta = InputDati.leggiIntero(INSERIRE_INTERO);
			switch(scelta)
			{
			case 1: 
				System.out.println("\n\n");
				aggiungiNazione(listaNazioni);
				System.out.println("\n\n");
				break;
			case 2:
				System.out.println("\n\n");
				stampaNazioni(listaNazioni);
				System.out.println();
				cancellaNazione(listaNazioni);
				System.out.println("\n\n");
				break;
			case 3:
				System.out.println("\n\n");
				aggiungiGara(listaGare);
				System.out.println("\n\n");
				break;
			case 4:
				System.out.println("\n\n");
				stampaGare(listaGare);
				System.out.println();
				cancellaGara(listaGare);
				System.out.println("\n\n");
				break;
			case 5:
				break;
			case 6:
				stampaNazioni(listaNazioni);
				break;
			case 0:
				System.out.println("\n\n");
				System.out.println(BYE);
				end=true;
				break;
			default:
				System.out.println("\n\n");
				System.out.println(INVALID);
				break;
			}
			
		}
		while(!end);
	}

	/**
	 * @param listaGare
	 */
	private static void cancellaGara(ListaGare listaGare) {
		System.out.println(listaGare.rimuoviGara((InputDati.leggiIntero(NUMERO_GARA_DA_ELIMINARE)-1)));
	}

	/**
	 * @param listaGare
	 */
	private static void stampaGare(ListaGare listaGare) {
		for(int i=0;i<listaGare.lunghezzaDellaLista();i++)
		{
			System.out.println(listaGare.nomeGaraAllIndiceN(i));
		}
	}

	/**
	 * @param listaNazioni
	 */
	private static void cancellaNazione(ListaNazioni listaNazioni) {
		System.out.println(listaNazioni.rimuoviNazione((InputDati.leggiIntero(NUMERO_NAZIONE_DA_ELIMINARE))-1));
	}

	/**
	 * @param listaNazioni
	 */
	private static void stampaNazioni(ListaNazioni listaNazioni) {
		for(int i=0;i<listaNazioni.lunghezzaDellaLista();i++)
		{
			System.out.println(listaNazioni.nomeNazioneAllIndiceN(i));
		}
	}

	/**
	 * @param listaNazioni
	 */
	private static void aggiungiNazione(ListaNazioni listaNazioni) 
	{
		String nomeNazione = InputDati.leggiStringaNonVuota(INSERISCI_NOME_NAZIONE);
		try
		{
			listaNazioni.addNazione(new Nazione(nomeNazione));
		}
		catch(EccNazionePreEsistente ex)
		{
			System.out.println("\n\n"+ex.toString()+"\n\n");
		}
	}

	/**
	 * @param listaGare
	 */
	private static void aggiungiGara(ListaGare listaGare)
	{
		String nomeGara = InputDati.leggiStringaNonVuota(INSERISCI_NOME_GARA);
		try
		{
			listaGare.addGara(new Gara(nomeGara));
		}
		catch(EccGaraPreEsistente ex)
		{
			System.out.println("\n\n"+ex.toString()+"\n\n");
		}
	}

	/**
	 * 
	 * @return un oggetto Nazione il cui nome viene scelto con un metodo della classe InputDati del pacchetto it.unibs.fp.mylib;
	 */
	private static Nazione creaNazione()
	{
		String nomeNazione = InputDati.leggiStringaNonVuota(INSERISCI_NOME_NAZIONE);
		return new Nazione(nomeNazione);
	}
	private static Gara creaGara()
	{
		String nomeGara = InputDati.leggiStringaNonVuota(INSERISCI_NOME_GARA);
		return new Gara(nomeGara);
	}
}
