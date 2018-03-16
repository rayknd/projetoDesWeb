package Model;

import java.awt.List;
import java.util.ArrayList;

public class Olimpiada {
	private String tipo;
	private int ano, id;
	
	
	ArrayList <Modalidade> modalidades = new ArrayList<Modalidade>();
	
	public Olimpiada(String tipo, int ano, int id) {
		setTipo(tipo);
		setAno(ano);
		setId(id);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
