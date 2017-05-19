package it.polito.tdp.porto;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.Model;
import it.polito.tdp.porto.model.Paper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PortoController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Author> boxPrimo;

    @FXML
    private ComboBox<Author> boxSecondo;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleCoautori(ActionEvent event) {
    	
    	Author autore = boxPrimo.getValue();

    	if (autore==null){
    		txtResult.setText("Errore, inserire un autore.");
    		return;
    	}
    	
  	   txtResult.setText("");

    	
 	   txtResult.appendText("I coautori sono:\n");

    	for (Author a : autore.getCoautori() ){
    	   txtResult.appendText(a.toString()+"\n");
    	}
    	

    }

    @FXML
    void handleSequenza(ActionEvent event) {
    	
    	Author autore1 = boxPrimo.getValue();
    	Author autore2 = boxSecondo.getValue();
    	
    	if (autore1==null || autore2==null){
    		txtResult.setText("Errore, inserire entrambi gli autori.");
    		return;
    	}
    	if (autore1.getCoautori().contains(autore2) || autore1.equals(autore2) ){
    		txtResult.setText("Errore, scegliere due autore differenti che non siano coautori di un articolo.");
    	}

    	List<Paper> sequenzaArticoli = model.getSequenzaArticoli(autore1, autore2);

    }

    @FXML
    void initialize() {
        assert boxPrimo != null : "fx:id=\"boxPrimo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert boxSecondo != null : "fx:id=\"boxSecondo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Porto.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
		boxPrimo.getItems().addAll(model.getAutori());
    	boxSecondo.getItems().addAll(boxPrimo.getItems());

		model.getArticoli();
    	model.createGraph();
	}
}
