/**
 * @author Denis Festa
 */
package it.unibs.fp.lab.medagliereolimpico;


public class EccNazionePreEsistente extends Exception 
{
	/**
	 * Attributi:
	 */
	private final static String NOME_PREESISTENTE = "Esiste gia' una nazione con questo nome";
	
	public String toString()
	{
		return NOME_PREESISTENTE;
	}
}
