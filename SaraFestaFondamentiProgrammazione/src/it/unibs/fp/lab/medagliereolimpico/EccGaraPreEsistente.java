/**
 * @author Denis Festa
 */
package it.unibs.fp.lab.medagliereolimpico;

public class EccGaraPreEsistente extends Exception 
{
private final static String NOME_PREESISTENTE = "Esiste gia' una disciplina con questo nome";
	/**
	 * 
	 * @param NOME_PREESISTENTE e' un messaggio di errore;
	 * @return il messaggio di errore stesso;
	 */
	public String toString()
	{
		return NOME_PREESISTENTE;
	}
}
