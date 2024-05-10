
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 31luc
 */
public class SlotGame {

    private final int min = 0;                      //valore estratto minimo
    private final int max = 5;                      //valore estratto massimo
    private final int jackpotValue = 0;             //valore vincente jackpot
    private final int nRuote = 3;                   //Inizializzo il numero di ruote
    private int jackpot, somma;                     //Variabili di jackpot e somma
    private final ArrayList<Integer> estrazione;    //Array contenente le estrazioni

    /**
     * Costruttore della slot
     * Inizializza la somma e il jackpot
     */
    public SlotGame() {
        jackpot = 100;
        somma = 0;
        estrazione = new ArrayList<>();
    }

    /**
     * Metodo che estrae un valore casuale tra un min e un max
     * @return int numero casuale tra min e max
     */
    public int estraiValore() {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /**
     * Metodo che estrae 3 valori e aumenta somma e jackpot in base alla scelta della puntata
     * @param selected 
     */
    public void estrai(int selected) {
        estrazione.removeAll(estrazione);
        for (int i = 0; i < nRuote; i++) {
            estrazione.add(estraiValore());
        }
        switch (selected) {
            case 0 -> {
                jackpot++;
                somma--;
            }
            case 1 -> {
                jackpot += 5;
                somma -= 5;
            }
            case 2 -> {
                jackpot += 10;
                somma -= 10;
            }
        }
    }

    /**
     * Metodo di supporto che permette di estrarre nRuote valori, usato nell'interfaccia grafica per la prima generazione
     */
    public void estrai_inizio() {
        estrazione.removeAll(estrazione);
        for (int i = 0; i < nRuote; i++) {
            estrazione.add(estraiValore());
        }
    }

    /**
     * Metodo che verifica se è stata estratta una combinazione corretta
     * @return true combinazione corretta, false altrimenti
     */
    public boolean vintoComb() {
        for (int i = 1; i < estrazione.size(); i++) {
            if (!Objects.equals(estrazione.get(i), estrazione.get(0))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo che verifica la vincita del jackpot
     * @return true se è stato vinto il jackpot, false altrimenti
     */
    public boolean vintoJackpot() {
        return vintoComb() && estrazione.get(0) == jackpotValue;
    }

    /**
     * Metodo che ritorna il valore enstratto data la ruota richiesta
     * @param n
     * @return int valore estratto nella ruota n
     */
    public int getComb(int n) {
        return estrazione.get(n);
    }

    /**
     * Metodo di get che ritorna il valore di jackpot
     * @return jackpot
     */
    public int getJackpot() {
        return jackpot;
    }

    /**
     * Metodo di get che ritorna il valore di somma
     * @return somma
     */
    public int getSomma() {
        return somma;
    }

    /**
     * Metodo di set per cambiare il valore di jackpot
     * @param jackpot 
     */
    public void setJackpot(int jackpot) {
        this.jackpot = jackpot;
    }
    
    /**
     * Metodo di set per cambiare il valore di somma
     * @param somma 
     */
    public void setSomma(int somma) {
        this.somma = somma;
    }
}
