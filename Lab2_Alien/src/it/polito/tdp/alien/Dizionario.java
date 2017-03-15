package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class Dizionario {
	
	List<Parola> elementi = new LinkedList<Parola>();
	
	public void aggiungiParola (Parola p){
		elementi.add(p);
	}
	
    public String traduciParola (String alienWord){
    	
    	for( Parola p : elementi){
    		if (p.getParolaAliena().matches(alienWord)){
    			return p.getTraduzione();
    		}
    	}
    	
    	return "Traduzione sconosciuta, accettiamo suggerimenti.";
		
	}

	public void resetta() {	
		elementi.clear();	
	}


}
