/**
 * @author Denis Festa
 */
package it.unibs.fp.lab.medagliereolimpico;

import java.util.*;

public class ListaGare {
	/**
	 * Attributi:
	 * la LinkedList di oggetti di tipo gara;
	 */
	private List <Gara> listaGare;
	private final static String GARA_IN_LISTA = "#%4d\t%s";
	private final static String NUMERO_SCORRETTO = "Il numero inserito non fa riferimento a nessuna disciplina!";
	/**
	 * Metodi:
	 */
	
	/**
	 * 
	 * @param gara si veda il commento alla classe ListaNazioni
	 * @throws EccGaraPreEsistente
	 */
	public ListaGare()
	{
		this.listaGare = new ArrayList<Gara>();
	}
	
	public void addGara(Gara gara) throws EccGaraPreEsistente
	{
		for(int i=0;i<listaGare.size();i++)
		{
			if(listaGare.get(i).getNomeGara().equalsIgnoreCase(gara.getNomeGara()))
			{
				throw new EccGaraPreEsistente();
			}
		}
		listaGare.add(gara);
	}
	
	public String rimuoviGara(int index)
	{
		if(index<listaGare.size()&&index>=0)
		{
			listaGare.remove((index-1));
			return "\n\n";
		}
		else return "\n\n"+NUMERO_SCORRETTO;
	}
	public String nomeGaraAllIndiceN(int index)
	{
		StringBuffer result = new StringBuffer();
		result.append(String.format(GARA_IN_LISTA,(index+1),listaGare.get(index).getNomeGara()));
		return result.toString();
	}
	public int lunghezzaDellaLista()
	{
		return listaGare.size();
	}
	
}
