package com.teste.model;

public class Pergunta {
	private String descricao;
	private Animal animalSim;
	private Animal animalNao;
	private Pergunta proximaPerguntaSim;
	private Pergunta proximaPerguntaNao;
	public static final String PADRAO = "O animal que você pensou %s ?";

	public Pergunta(String descricao, Animal animalSim, Animal animalNao, Pergunta proximaPerguntaSim,
			Pergunta proximaPerguntaNao) {
		this.descricao = descricao;
		this.animalSim = animalSim;
		this.animalNao = animalNao;
		this.proximaPerguntaSim = proximaPerguntaSim;
		this.proximaPerguntaNao = proximaPerguntaNao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Animal getAnimalSim() {
		return animalSim;
	}

	public void setAnimalSim(Animal animalSim) {
		this.animalSim = animalSim;
	}

	public Animal getAnimalNao() {
		return animalNao;
	}

	public void setAnimalNao(Animal animalNao) {
		this.animalNao = animalNao;
	}

	public Pergunta getProximaPerguntaSim() {
		return proximaPerguntaSim;
	}

	public void setProximaPerguntaSim(Pergunta proximaPerguntaSim) {
		this.proximaPerguntaSim = proximaPerguntaSim;
	}

	public Pergunta getProximaPerguntaNao() {
		return proximaPerguntaNao;
	}

	public void setProximaPerguntaNao(Pergunta proximaPerguntaNao) {
		this.proximaPerguntaNao = proximaPerguntaNao;
	}

}
