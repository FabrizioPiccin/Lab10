package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {
	
    UndirectedGraph<Author, DefaultEdge> grafo = new SimpleGraph<Author, DefaultEdge>(DefaultEdge.class);
	
	private Map<Integer, Author> autori = new HashMap<Integer, Author>();
	 List<Author> listaAutori ;

	private Map<Integer, Paper> articoli = new HashMap<Integer, Paper>();
	List<Paper> listaArticoli ;
	List<DefaultEdge> archiMinimi;

	public List<Author> getAutori() {
		
		PortoDAO dao = new PortoDAO();
		
		autori = dao.getAutori();
		
		listaAutori = new ArrayList<Author> (autori.values());
		
		for (Author a : listaAutori){
			grafo.addVertex(a);
		}
		
		return listaAutori; 
	}

	public void createGraph() {

        PortoDAO dao = new PortoDAO();
        
        dao.relazioni(autori, articoli);
    
        for (Author a : listaAutori){
        			
            for (Paper p : a.getArticoliProdotti()){
            	
            	for (Author coautore : p.getAutoriArticolo()){
            		if (!a.equals(coautore)){
            		   a.addCoautore(coautore);
            		   grafo.addEdge(a, coautore);
            		}
            	}
            }
        }
        	

	}

	public void getArticoli() {
		
        PortoDAO dao = new PortoDAO();
		
		articoli = dao.getArticoli();
		
		listaArticoli = new ArrayList<Paper> (articoli.values());
		

	}

	public List<Paper> getSequenzaArticoli(Author autore1, Author autore2) {
		
		
	
		return null;
	}

	
}
