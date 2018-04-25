package it.unibs.fp.lab.tamagotchi;
import java.util.*;

public class ListaTamagotchi 
{
	private List<Tamagotchi> listaTamagotchi;
	public final static String TAMAGOTCHI_IN_LISTA = "#%3d\t%s";
	/**
	 * @return l'oggetto listaTamagotchi di tipo List con la protezione
	 * fornita dal metodo unmodifiableList della classe Collections
	 * che impedisce l'uso di metodi che modifichino la lista stessa, 
	 * come i metodi add, remove, clear...
	 */
	public List<Tamagotchi> getListaTamagotchi(){
		return Collections.unmodifiableList (listaTamagotchi);
	}
	public ListaTamagotchi(){
		this.listaTamagotchi = new Vector<Tamagotchi>();
		}
	/**
	 * @param tamagotchiDaAggiungere il tamagotchi da aggiungere;
	 * @throws TamagotchiGiaEsistenteException se il tamagotchi da aggiungere ha 
	 * un nome che un'altro tamagotchi gia' presente nella lista ha, viene lanciata un'eccezione.
	 */
	public void addTamagotchi(Tamagotchi tamagotchiDaAggiungere) throws TamagotchiGiaEsistenteException{
		for(Tamagotchi tamagotchi : listaTamagotchi){
			if(tamagotchi.getNome().equalsIgnoreCase(tamagotchiDaAggiungere.getNome())) 
				throw new TamagotchiGiaEsistenteException(tamagotchiDaAggiungere.getNome().toUpperCase());
		}
		listaTamagotchi.add(tamagotchiDaAggiungere);
	}
	/**
	 * @param tamagotchiDaRimuovere il tamagotchi da rimuovere.
	 */
	public void removeTamagotchi(Tamagotchi tamagotchiDaRimuovere) {
		listaTamagotchi.remove(tamagotchiDaRimuovere);
	}
	/**
	 * il metodo rimuove dalla lista tutti i tamagotchi che verificano
	 * la condizione sonoMorto().
	 */
	public void rimuoviMorti() {
		for(Tamagotchi tamaMorto:listaTamagotchi) {
			if(tamaMorto.sonoMorto())
				listaTamagotchi.remove(tamaMorto);
		}
	}
	/**
	 * @return una nuova lista costituita dai soli tamagotchi vivi, 
	 * per ora il metodo e' inutilizzato.
	 */
	public List<Tamagotchi> listaDeiVivi(){
		List<Tamagotchi> listaDeiVivi=new Vector<Tamagotchi>();
		for(Tamagotchi tama:listaTamagotchi){
			if(!tama.sonoMorto())
				listaDeiVivi.add(tama);
		}
		return listaDeiVivi;
	}
	/**
	 * @return false se almeno un tamagotchi presente nella lista e' vivo,
	 * true se nessun tamagotchi e' rimasto vivo.
	 */
	public boolean nessunoVivo(){
		for(Tamagotchi tamagotchi:listaTamagotchi){
			if(!tamagotchi.sonoMorto()) return false;
			}
		return true;
	}


	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
