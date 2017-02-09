package com.teste.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1130495065011633153L;
	private JLabel label = new JLabel("Pense em um animal");
	private JButton btnOk = new JButton("OK");

	public TelaPrincipal() {
		super("Jogo dos Animais");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.label.setFont(new Font("Serif", Font.PLAIN, 18));
		this.add(label, BorderLayout.NORTH);
		this.add(btnOk, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

}
