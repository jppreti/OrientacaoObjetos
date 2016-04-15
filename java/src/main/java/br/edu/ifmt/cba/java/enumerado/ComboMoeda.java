package br.edu.ifmt.cba.java.enumerado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboMoeda {

	public static void main(String[] args) {
		JFrame frm = new JFrame();
		frm.setSize(200, 50);
		frm.setLayout(new BorderLayout());
		JComboBox<Currency> cmbMoeda = new JComboBox<>(Currency.values());
		
		cmbMoeda.addActionListener((evt) -> {
			System.out.println(cmbMoeda.getSelectedItem().getClass() + ": "
					+ cmbMoeda.getSelectedItem());
		});
		
		cmbMoeda.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(cmbMoeda.getSelectedItem().getClass() + ": "
						+ cmbMoeda.getSelectedItem());				
			}
			
		});
		frm.getContentPane().add(cmbMoeda, BorderLayout.NORTH);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(Currency.DIME.value + Currency.QUARTER.value);
	}
	
}
