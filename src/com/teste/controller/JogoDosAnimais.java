package com.teste.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.teste.model.Animal;
import com.teste.model.Pergunta;
import com.teste.view.Mensagem;
import com.teste.view.TelaPrincipal;

public class JogoDosAnimais implements ActionListener {

	private TelaPrincipal view;
	private Mensagem msg;
	private Pergunta perguntaInicial;

	public JogoDosAnimais() {
		this.view = new TelaPrincipal();
		this.view.getBtnOk().addActionListener(this);
	}

	public void jogar() {
		if (this.perguntaInicial == null) {
			this.perguntaInicial = new Pergunta(String.format(Pergunta.PADRAO, "vive na água"), new Animal("Tubarao"),
					new Animal("Macaco"), null, null);
		}

		Pergunta p = this.perguntaInicial;
		Animal animalResposta;
		while (p != null) {
			msg = new Mensagem(p.getDescricao(), Mensagem.MSG_SIM_NAO, "Jogo dos Animais");
			if (msg.cancelou()) {
				break;
			}
			if (msg.clicouSim()) {
				if (p.getProximaPerguntaSim() != null) {
					p = p.getProximaPerguntaSim();
					continue;
				} else {
					animalResposta = p.getAnimalSim();
				}
			} else {
				if (p.getProximaPerguntaNao() != null) {
					p = p.getProximaPerguntaNao();
					continue;
				} else {
					animalResposta = p.getAnimalNao();
				}
			}
			msg = new Mensagem("O animal que você pensou é " + animalResposta.getNome() + " ?", Mensagem.MSG_SIM_NAO,
					"Jogo dos Animais");
			if (msg.cancelou()) {
				break;
			}
			if (msg.clicouSim()) {
				new Mensagem("Acertei de novo!", Mensagem.MSG_SIMPLES, "Jogo dos Animais");
				break;
			} else {
				this.novaPergunta(p, animalResposta);
				break;
			}

		}

	}

	public void novaPergunta(Pergunta p, Animal animal) {
		msg = new Mensagem("Qual o animal que você pensou ?", Mensagem.MSG_QUESTAO, "Desisto");
		if (msg.cancelou()) {
			return;
		}
		Animal novoAnimal = new Animal(msg.getResposta());
		msg = new Mensagem("Um(a) " + novoAnimal.getNome() + " _________ mas um(a) " + animal.getNome() + " não.",
				Mensagem.MSG_QUESTAO, "Complete");
		if (msg.cancelou()) {
			return;
		}
		// define a próxima pergunta
		// Move o animal da pergunta atual para a próxima
		if (p.getAnimalSim() != null && p.getAnimalSim().equals(animal)) {
			p.setProximaPerguntaSim(new Pergunta(String.format(Pergunta.PADRAO, msg.getResposta()), novoAnimal,
					p.getAnimalSim(), null, null));
			p.setAnimalSim(null);
		} else {
			p.setProximaPerguntaNao(new Pergunta(String.format(Pergunta.PADRAO, msg.getResposta()), novoAnimal,
					p.getAnimalNao(), null, null));
			p.setAnimalNao(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.view.getBtnOk()) {
			this.jogar();
		}

	}

	public static void main(String[] args) {
		new JogoDosAnimais();
	}

}
