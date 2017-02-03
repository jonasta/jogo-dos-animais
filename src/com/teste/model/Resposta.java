package com.teste.model;

public class Resposta {
	private Pergunta pergunta;
	private Animal animal;
	private boolean resposta;
	private Resposta respostaAnterior;

	public Resposta(){
	}
	
	public Resposta(Pergunta pergunta, Animal animal, boolean resposta, Resposta respostaAnterior) {
		this.pergunta = pergunta;
		this.animal = animal;
		this.resposta = resposta;
		this.respostaAnterior = respostaAnterior;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public boolean isResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	public Resposta getRespostaAnterior() {
		return respostaAnterior;
	}

	public void setRespostaAnterior(Resposta respostaAnterior) {
		this.respostaAnterior = respostaAnterior;
	}
	
}
