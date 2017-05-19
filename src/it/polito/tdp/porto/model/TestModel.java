package it.polito.tdp.porto.model;

import org.jgrapht.graph.DefaultEdge;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		model.getAutori();
		
		model.getArticoli();
		
		model.createGraph();
		
        model.getSequenzaArticoli(model.listaAutori.get(33), model.listaAutori.get(3) );
	}

}
