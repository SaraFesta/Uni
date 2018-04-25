/**
 * @author Denis Festa
 */
package it.unibs.fp.lab.medagliereolimpico;

public final class Nazione {
	/*usare hashmap*/
	/**
	 * Attributi:
	 * la String identifica il nome della nazione;
	 * gli int contano le medaglie accumulate;
	 */
	private String nomeNazione;
	private int medaglieOro;
	private int medaglieArgento;
	private int medaglieBronzo;
	/**
	 * Metodi:
	 */
	
	/**
	 * 
	 * @param nomeNazione e' la stringa che identifichera' il nome della nazione;
	 */
	public Nazione(String nomeNazione)
	{
		this.nomeNazione = nomeNazione;
	}
	/**
	 * @return the nomeNazione
	 */
	public String getNomeNazione() 
	{
		return nomeNazione;
	}

	
	
	
}
