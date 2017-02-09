package com.teste.view;

import javax.swing.JOptionPane;

public class Mensagem {

	public static final int MSG_SIMPLES = 0;
	public static final int MSG_SIM_NAO = 1;
	public static final int MSG_QUESTAO = 2;
	private boolean cancelou;
	private boolean clicouSim;
	private String resposta;

	public Mensagem(String msg, int tipo, String titulo) {
		switch (tipo) {
		case MSG_SIMPLES:
			JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.PLAIN_MESSAGE);
			break;

		case MSG_SIM_NAO:
			int opcao = JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
			if ((opcao != JOptionPane.YES_OPTION) && (opcao != JOptionPane.NO_OPTION)) {
				this.cancelou = true;
			} else {
				this.cancelou = false;
				this.clicouSim = ((opcao == JOptionPane.YES_OPTION));
			}
			break;
		case MSG_QUESTAO:
			String resposta = JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.QUESTION_MESSAGE);
			if ((resposta == null) || (resposta.equals(""))) {
				this.cancelou = true;
			} else {
				this.cancelou = false;
				this.resposta = resposta;
			}
			break;
		default:
			break;
		}
	}

	public boolean clicouSim() {
		return clicouSim;
	}

	public void setClicouSim(boolean clicouSim) {
		this.clicouSim = clicouSim;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public boolean cancelou() {
		return cancelou;
	}

	public void setCancelou(boolean cancelou) {
		this.cancelou = cancelou;
	}

}
