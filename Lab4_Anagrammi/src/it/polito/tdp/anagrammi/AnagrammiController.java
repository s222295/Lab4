package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Dictionary;
import it.polito.tdp.anagrammi.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {
	private Dictionary d;
	HashSet<String> listaDaCorreggere= new LinkedHashSet<String>();
	List<Text> listaDiText = new LinkedList<Text>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextFlow txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagramma(ActionEvent event) {

    	String s=txtParola.getText();
    	listaDaCorreggere = (HashSet<String>) d.CalcolaPermutazioni(s);
    	List<RichWord> lista = d.spellCheckTextConQuery(listaDaCorreggere);
    	
    	Text txt = new Text("");
    	
    	for(RichWord r: lista){
    		if(r.isCorretta())
    			txt=new Text(r.getParola()+"\n");
    		else{
    			txt = new Text(r.getParola()+"\n");
    			txt.setFill(Color.RED);
    		}
    		listaDiText.add(txt);
    		txtRisultato.getChildren().add(txt);
    	
    	}
    	lista.clear();
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtParola.clear();	
    	for(Text t:listaDiText){
    		txtRisultato.getChildren().removeAll(t);
    	}
    	listaDiText.clear();
    	listaDaCorreggere.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

        txtRisultato.setDisable(true);
    }

	public void setModel() {
		// TODO Auto-generated method stub
		d = new Dictionary();
		//d.loadDictionary();
	}
}

