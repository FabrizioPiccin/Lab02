package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	Parola p;
	Dizionario d = new Dizionario();
	String parolaAliena= "";
	String traduzione= "";
	int numero = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {   	
    	d.resetta();
    	txtResult.setText("");
    	txtWord.setText("");
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	   
    	   if (txtWord.getText().matches("")){
    		   txtResult.setText("ATTENZIONE: "+txtResult.getPromptText());
    		   return;
    	   }
    	
            char[] stringa = txtWord.getText().toCharArray();
            
            for(int i=0; i<txtWord.getText().length(); i++){
            	char c = stringa[i];
            	if(Character.isLetter(c)==false && c!=' ' ){
            		txtResult.setText("NON INSERIRE NUMERI!");
            		return;
            	}
            }
        	
        	StringTokenizer st = new StringTokenizer( txtWord.getText(), " ");
        	parolaAliena = st.nextToken().toLowerCase();
      
        	if (st.hasMoreTokens()){
        		traduzione = st.nextToken().toLowerCase();
        		p = new Parola(parolaAliena, traduzione);
        		d.aggiungiParola(p);
        		txtResult.setText("La traduzione suggerita è stata inserita nel sistema, grazie.");
        	}
        	else{
        		txtResult.setText(d.traduciParola(parolaAliena));
        	}
        	
        	parolaAliena="";
        	traduzione="";     

    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
