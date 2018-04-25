/**
 * @author Denis Festa
 */
package it.unibs.fp.lab.medagliereolimpico;

public class Gara {
	/**
	 * Attributi:
	 */
	private String nomeGara;
	/**
	 * Metodi:
	 */
	public Gara(String nomeGara)
	{
		this.nomeGara = nomeGara;
	}
	/**
	 * @return the nomeGara
	 */
	public String getNomeGara() 
	{
		return nomeGara;
	}
	/**
	 * @param nomeGara the nomeGara to set
	 */
	public void setNomeGara(String nomeGara) 
	{
		this.nomeGara = nomeGara;
	}
}
