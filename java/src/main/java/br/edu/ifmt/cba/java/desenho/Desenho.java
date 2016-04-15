package br.edu.ifmt.cba.java.desenho;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.ifmt.lpi.Pessoa;

@SuppressWarnings("serial")
public class Desenho extends JPanel {
		
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 400);
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 30, 30);
	}
	
	public static void main(String[] args) {
		JPanel pnl = new Desenho();
		JFrame frm = new JFrame();
		frm.getContentPane().add(pnl);
		frm.setSize(400,400);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}