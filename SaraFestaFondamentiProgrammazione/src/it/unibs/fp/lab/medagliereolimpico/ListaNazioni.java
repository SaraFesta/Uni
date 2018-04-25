/**
 * @author Denis Festa
 */
package it.unibs.fp.lab.medagliereolimpico;

import java.util.*;
public class ListaNazioni   
{
	/**
	 * Attributi:
	 * la LinkedList di oggetti di tipo nazione;
	 */
	private List <Nazione> listaNazioni;
	private final static String NAZIONE_IN_LISTA = "#%4d\t%s";
	private final static String NUMERO_SCORRETTO = "Il numero inserito non fa riferimento a nessuna nazione!";

	/**
	 * Metodi:
	 */
	
	/**
	 * 
	 * @param nazione e' l'oggetto di tipo nazione aggiunto alla LinkedList di nazioni, su cui viene effettuato un controllo: il nome della nazione non deve gia' essere presente;
	 * @throws EccNazionePreEsistente 
	 */
	public ListaNazioni ()
	{
		this.listaNazioni = new ArrayList<Nazione>();
	}

	public void addNazione(Nazione nazione) throws EccNazionePreEsistente
	{
		for (int i=0;i<this.listaNazioni.size();i++) 
		{
			if(listaNazioni.get(i).getNomeNazione().equalsIgnoreCase(nazione.getNomeNazione())) 
			{
				throw new EccNazionePreEsistente();
			}
		}
		listaNazioni.add(nazione);
	}
	public String rimuoviNazione(int index)
	{
		if(index<listaNazioni.size()&&index>=0)
		{
			listaNazioni.remove((index));
			return "\n\n";
		}
		else return "\n\n"+NUMERO_SCORRETTO;
	}
	public String nomeNazioneAllIndiceN(int index)
	{
		StringBuffer result = new StringBuffer();
		result.append(String.format(NAZIONE_IN_LISTA,(index+1),listaNazioni.get(index).getNomeNazione()));
		return result.toString();
	}
	public int lunghezzaDellaLista()
	{
		return listaNazioni.size();
	}
}
