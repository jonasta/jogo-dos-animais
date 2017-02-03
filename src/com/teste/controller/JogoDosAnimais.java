package com.teste.controller;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.teste.model.Animal;
import com.teste.model.Pergunta;
import com.teste.model.Resposta;

public class JogoDosAnimais {
	// lista com os animais/perguntas/respostas/resposta anterior
	private ArrayList<Resposta> respostas;
	// lista filtrada, de acordo com respostas do usu�rio
	private ArrayList<Resposta> filtro;
	private static final String TITULOSJANELAS = "Animais";

	// UI
	JFrame frame;
	JButton btnJogar;

	public JogoDosAnimais() {
		// inicializa animais perguntas/respostas/animais padr�o
		Pergunta p = new Pergunta("Vive na �gua");
		this.respostas = new ArrayList<>();
		this.respostas.add(new Resposta(p, new Animal("Tubar�o"), true, null));
		this.respostas.add(new Resposta(p, new Animal("Macaco"), false, null));

		// UI, apenas para que fique mais parecido com o exemplo original
		this.iniciaUI();
		
	}

	// Retorna a pr�xima pergunta/resposta, com base na pergunta atual
	// Caso retorne apenas 1 item, � a resposta final do jogo
	private void filtraRespostas(Pergunta p, boolean resposta) {
		this.filtro = (ArrayList<Resposta>) this.respostas.stream()
				.filter(r -> (r.getPergunta().equals(p)) && (r.isResposta() == resposta)|| 
					   (r.getRespostaAnterior() != null && (r.getRespostaAnterior().getPergunta().equals(p) && r.getRespostaAnterior().isResposta() == resposta)))
				.collect(Collectors.toList());
	}

	// M�todo principal
	public void jogar() {
		boolean acertou = false;
		// inicializa a pergunta padr�o "Vive na �gua"
		Pergunta perguntaAtual = this.respostas.get(0).getPergunta();
		// respostas de intera��o do JOptionPane
		int opcao = -1;
		// enquanto n�o acertar o animal em que o usu�rio pensou
		while (!acertou) {
			// Intera��es via JOptionPane, fiz uma valida��o simples para evitar
			// bugs no fluxo da aplica��o
			opcao = JOptionPane.showConfirmDialog(null,
					"O animal que voc� pensou " + perguntaAtual.getDescricao() + " ?", TITULOSJANELAS, JOptionPane.YES_NO_OPTION);
			if ((opcao != JOptionPane.YES_OPTION) && (opcao != JOptionPane.NO_OPTION)) {
				break;
			}
			boolean resposta = (opcao == JOptionPane.YES_OPTION);
			// Filtra a lista de poss�veis respostas, levando em considera��o a
			// �ltima pergunta e a resposta do usu�rio
			this.filtraRespostas(perguntaAtual, resposta);

			// se sobrou apenas 1 animal no filtro significa que...
			if (this.filtro.size() == 1) {
				// 1 : � o animal escolhido pelo usu�rio
				opcao = JOptionPane.showConfirmDialog(null,
						"O animal que voc� pensou � " + this.filtro.get(0).getAnimal().getNome() + " ?", TITULOSJANELAS,
						JOptionPane.YES_NO_OPTION);
				if ((opcao != JOptionPane.YES_OPTION) && (opcao != JOptionPane.NO_OPTION)) {
					break;
				}
				if (opcao == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Acertei de novo!", TITULOSJANELAS, JOptionPane.PLAIN_MESSAGE);
					acertou = true;
				} else {
					// 2 : o animal em que ele pensou ainda n�o consta na lista
					// de respostas, assim ser� "cadastrado"
					String nomeAnimal = JOptionPane.showInputDialog(null, "Qual o animal que voc� pensou ?", "Desisto", JOptionPane.QUESTION_MESSAGE);
					if ((nomeAnimal == null) || (nomeAnimal.equals(""))) {
						break;
					}
					Animal novoAnimal = new Animal(nomeAnimal);
					String pergunta = JOptionPane.showInputDialog(null, "Um(a) " + nomeAnimal + " _________ mas um(a) "
							+ this.filtro.get(0).getAnimal().getNome() + " n�o.", "Complete", JOptionPane.QUESTION_MESSAGE);
					if ((pergunta == null) || (pergunta.equals(""))) {
						break;
					}
					Pergunta p = new Pergunta(pergunta);
					// adiciona o novo animal com a pergunta na lista de
					// respostas
					this.respostas.add(new Resposta(p, novoAnimal, true, this.filtro.get(0)));
					this.respostas.add(new Resposta(p, this.filtro.get(0).getAnimal(), false, this.filtro.get(0)));
					break;
				}

			} else {
				// vai para a pr�xima pergunta, visto que ainda temos v�rios
				// animais na lista
				perguntaAtual = this.filtro.get(this.filtro.size() - 1).getPergunta();
			}

		}

	}

	public static void main(String[] args) {
		new JogoDosAnimais();
	}
	
	public void iniciaUI(){
		this.frame = new JFrame(TITULOSJANELAS);
		this.frame.setLocationRelativeTo(null);
		JLabel label = new JLabel("Pense em um animal");
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		this.frame.getContentPane().add(label, BorderLayout.NORTH);
		this.btnJogar = new JButton("OK");
		this.frame.getContentPane().add(this.btnJogar, BorderLayout.CENTER);
		this.btnJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// M�todo principal do jogo
				jogar();

			}
		});
		this.frame.pack();
		this.frame.setVisible(true);
	}
	

}
