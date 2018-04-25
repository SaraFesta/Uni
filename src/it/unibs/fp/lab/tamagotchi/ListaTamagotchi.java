package it.unibs.fp.lab.tamagotchi;
import java.util.*;

public class ListaTamagotchi 
{
	private List<Tamagotchi> listaTamagotchi;
	public final static String TAMAGOTCHI_IN_LISTA = "#%3d\t%s";
	
	public List<Tamagotchi> getListaTamagotchi(){
		return Collections.unmodifiableList (listaTamagotchi);
	}
	public ListaTamagotchi(){
		this.listaTamagotchi = new Vector<Tamagotchi>();
		}
	public void addTamagotchi(Tamagotchi tamagotchiDaAggiungere) throws TamagotchiGiaEsistenteException{
		for(Tamagotchi tamagotchi : listaTamagotchi){
			if(tamagotchi.getNome().equalsIgnoreCase(tamagotchiDaAggiungere.getNome())) 
				throw new TamagotchiGiaEsistenteException(tamagotchiDaAggiungere.getNome().toUpperCase());
		}
		listaTamagotchi.add(tamagotchiDaAggiungere);
	}
	public void removeTamagotchi(Tamagotchi tamagotchiDaRimuovere) {
		listaTamagotchi.remove(tamagotchiDaRimuovere);
	}
	public void rimuoviMorti() {
		for(Tamagotchi tamaMorto:listaTamagotchi) {
			if(tamaMorto.sonoMorto())
				listaTamagotchi.remove(tamaMorto);
		}
	}
	public List<Tamagotchi> listaDeiVivi(){
		List<Tamagotchi> listaDeiVivi=new Vector<Tamagotchi>();
		for(Tamagotchi tama:listaTamagotchi){
			if(!tama.sonoMorto())
				listaDeiVivi.add(tama);
		}
		return listaDeiVivi;
	}
	public boolean nessunoVivo(){
		for(Tamagotchi tamagotchi:listaTamagotchi){
			if(!tamagotchi.sonoMorto()) return false;
			}
		return true;
	}


	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
