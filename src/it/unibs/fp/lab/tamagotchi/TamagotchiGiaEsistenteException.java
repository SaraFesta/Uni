package it.unibs.fp.lab.tamagotchi;

public class TamagotchiGiaEsistenteException extends Exception
{

	private static final String MESSAGGIO_ERRORE = "Esiste gia' un tamagotchi con questo nome!:\t%s";
	private String nomeTamagotchiGiaEsistente;
	
	public TamagotchiGiaEsistenteException(String nomeTamagotchiGiaEsistente){
		this.nomeTamagotchiGiaEsistente=nomeTamagotchiGiaEsistente;
	}
	public String toString(){
		return String.format(MESSAGGIO_ERRORE,nomeTamagotchiGiaEsistente);
	}
}
