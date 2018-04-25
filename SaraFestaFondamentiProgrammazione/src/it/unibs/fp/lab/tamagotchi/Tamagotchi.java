package it.unibs.fp.lab.tamagotchi;
/**
 * @author Denis Festa, Sara Salducco.
 * Il tamagotchi e' un cucciolo di cui il giocatore si deve prendere cura
 * ed e' dotato di un grado di sazieta', un grado affettivo e un contatore
 * di caffe' di fila somministrati che variano
 * in funzione della scelta del giocatore.
 */
public class Tamagotchi {
    private String nome;
    private double gradoAffettivo;
    private double gradoSazieta;
    private int caffeDiFila;
    private String descrizione = "\n\t>\tNome:\t\t\t\t\t%s\n\t>\tGrado di soddisfazione affettiva:\t%.2f\n\t>\tGrado di sazieta':\t\t\t%.2f\n";
    private static final int MAX_CAFFE_DI_FILA = 3;
    public static final int MIN_ASSEGNABILE = 1;
    public static final int MAX_ASSEGNABILE = 20;
    private static final int ALTA_SAZIETA=90;
    private static final int BASSA_SODDISFAZIONE = 30;
    private static final int BASSA_SAZIETA = 30;
    public static final int MASSIMA_SODDISFAZIONE = 100;
    public static final int MASSIMA_SAZIETA = 100;
    public static final int ZERO_SODDISFAZIONE = 0;
    public static final int ZERO_SAZIETA = 0;
    private static final double DIMINUZIONE_UN_QUARTO = 0.25;
    private static final double DIMINUZIONE_UN_MEZZO = 0.5;
    private static final double AUMENTO_UN_DECIMO = 0.1;
    public static final String INFELICE = "%s: Sono infelice!";
    public static final String BASTA_CAFFE = "%s: Ancora un caffe' e mi verra' la gastrite!";
    public static final String E_MORTO = "%s: Il nostro amico %s e' morto!";
    public static final String ANCHIO_VOGLIO_CAREZZE = "%s: Anch'io voglio le carezze!";
    public static final String ANCHIO_VOGLIO_BISCOTTI = "%s: Anch'io voglio i biscotti!";
    /**
     * @param nome indica il nome del tamagotchi, e' a scelta del giocatore;
     * @param gradoAffettivo indica il grado affettivo iniziale del tamagotchi, a scelta del giocatore, se inizializzato a 0 il tamagotchi muore in partenza;
     * @param gradoSazieta indica il grado di sazieta' iniziale del tamagotchi, a scelta del giocatore, se inizializzato a 0 il tamagotchi muore in partenza.
     */
    public Tamagotchi(String nome,int gradoAffettivo,int gradoSazieta)
    {
        this.nome = nome;
        this.gradoAffettivo=gradoAffettivo;
        this.gradoSazieta = gradoSazieta;
    }
    /**
     * @return il nome del tamagotchi.
     */
    public String getNome()
    {
    	return nome;
    }
    public void setNome(String nome) {
    	this.nome=nome;
    }
    /**
     * @return true, cioe' il tamagotchi e' infelice, 
     * se il grado affettivo oppure il grado di sazieta' 
     * dello stesso sono troppo bassi
     *  oppure il grado di sazieta' e' troppo alto.
     */
    public boolean sonoInfelice(){
    	return(gradoAffettivo<BASSA_SODDISFAZIONE||gradoSazieta<BASSA_SAZIETA||gradoSazieta>ALTA_SAZIETA)?true:false;
    }
    /**
     * @param carezze il numero di carezze date, 
     * (attualmente il valore passato a questo metodo dal main e' casuale),
     * tale numero fara' variare il valore del grado affettivo aumentandolo di un'unita' per ogni carezza,
     * fara' anche diminuire il grado di sazieta' di meta' del numero di biscotti dati.
     * Ciascuna delle due variazioni e' vincolata, deve rimanere all'interno dei valori 0 e 100, questo
     * spiega l'utilizzo dei metodi max e min.
     * Il contatore caffeDiFila viene azzerato perche' il dono di un biscotto rompe la catena dei caffe' di fila assegnati.
     */
    public void ricevoCarezze(int carezze) {
    	caffeDiFila=0;
    	this.gradoAffettivo=Math.min(MASSIMA_SODDISFAZIONE, this.gradoAffettivo+carezze);
    	this.gradoSazieta = Math.max(this.gradoSazieta-=(DIMINUZIONE_UN_MEZZO*carezze), ZERO_SAZIETA);
    }
    /**
     * 
     * @param biscotti e' il numero di biscotti dati. Per ogni biscotto assegnato, il valore del grado di sazieta' aumenta
     * di un quarto del valore attuale. L'incremento non segue la legge simile a quella della diminuzione del grado di sazieta'
     * del metodo precedente, ma avviene in maniera sequenziale. Il primo biscotto assegnato incrementa il grado di sazieta' di
     * un quarto del valore attuale, e il secondo biscotto aumenta di un quarto il grado di sazieta' raggiunto dopo aver gia' 
     * assegnato il primo biscotto.
     * Il contatore caffeDiFila viene azzerato perche' il dono di un biscotto rompe la catena dei caffe' di fila assegnati.
     */
    public void ricevoBiscotti(int biscotti){
    	caffeDiFila=0;
        for(int i=0;i<biscotti;i++){
       		this.gradoSazieta = this.gradoSazieta + AUMENTO_UN_DECIMO*this.gradoSazieta;
       	}	
       	this.gradoSazieta = Math.min(MASSIMA_SAZIETA, this.gradoSazieta);
       	gradoAffettivo = Math.max(gradoAffettivo-= (biscotti*DIMINUZIONE_UN_QUARTO) , ZERO_SODDISFAZIONE);
    }
    /**
     * @return un eventuale messaggio che avverte che un ulteriore caffe' provochera' la gastrire al tamagotchi.
     * Il messaggio d'allarme viene visualizzato sono nel caso in cui il caffe' assegnato e' il penultimo caffe' 
     * di fila che puo' essere preso.
     */
    public String ricevoCaffe(){
    	caffeDiFila++;
    	return((caffeDiFila)==MAX_CAFFE_DI_FILA-1)?avvisoTroppiCaffe():"";
    }
    /**
     * @return un semplice messaggio d'allarme.
     */
    public String avvisoTroppiCaffe(){
    	return String.format(BASTA_CAFFE, getNome().toUpperCase());
    }
    /**
     * @return true, cioe' il tamagotchi muore, se ha raggiunto lo zero in almeno uno dei due gradi, oppure ha ricevuto il numero massimo di caffe' di fila
     * oppure il grado di sazieta' e' troppo alto.
     */
    public boolean sonoMorto(){
    	return(gradoAffettivo==ZERO_SODDISFAZIONE||gradoSazieta==ZERO_SAZIETA||gradoSazieta==MASSIMA_SAZIETA||caffeDiFila==MAX_CAFFE_DI_FILA)?true:false;
    }
    /**
     * @param nomeDellAmicoMorto il nome del tamagotchi che muore, che ovviamente non puo' anunciare la sua morte
     * ma la stessa sara' annunciata in coro disperato dagli altri tamagotchi.
     * All'interno della stringa E_MORTO il primo %s non si riferisce al nome del morto ma al nome di ciascun altro tamagotchi ancora
     * vivo che annuncera' la triste perdita.
     * @return l'avviso della morte da parte di un amico.
     */
    public String unAmicoEMorto(String nomeDellAmicoMorto){
    	return String.format(E_MORTO,getNome().toUpperCase(),nomeDellAmicoMorto);
    }
    /**
     * @return la descrizione del tamagotchi comprendente:
     * nome, grado affettivo, grado di sazieta', e un eventuale
     * messaggio di infelicita' solo se la condizione sonoInfelice e' verificata.
     */
    public String toString(){
    	StringBuffer stato = new StringBuffer();
    	stato.append(String.format(descrizione,nome,gradoAffettivo,gradoSazieta));
    	if(sonoInfelice()) 
    		stato.append("\n"+String.format(INFELICE, getNome().toUpperCase()));
    	return stato.toString() ;
    }
    /**
     * @return il lamento del tamagotchi che vuole i biscotti.
     */
    public String anchioVoglioBiscotti(){
    	return String.format(ANCHIO_VOGLIO_BISCOTTI,getNome().toUpperCase());
    }
    /**
     * @return il lamento del tamagotchi che vuole le carezze.
     */
    public String anchioVoglioCarezze(){
    	return String.format(ANCHIO_VOGLIO_CAREZZE,getNome().toUpperCase());
    }

}
