package com.crashcourse;

import java.awt.*;
import java.awt.event.*;

public class Iks_oks {
	
	private static boolean game_over = false;
	private static String pobednik = null;
	private static boolean is_iks = true;
	
	private static void igra(Button[][] polja) {
		
		String s = polja[0][0].getLabel();
		if (!s.equals("Izaberite X/O") && polja[0][1].getLabel().equals(s) && polja[0][2].getLabel().equals(s)) {
			pobednik = s;
			game_over = true;
		}
		s = polja[1][0].getLabel();
		if (!s.equals("Izaberite X/O") && polja[1][1].getLabel().equals(s) && polja[1][2].getLabel().equals(s)) {
			pobednik = s;
			game_over = true;
		}
		s = polja[2][0].getLabel();
		if (!s.equals("Izaberite X/O") && polja[2][1].getLabel().equals(s) && polja[2][2].getLabel().equals(s)) {
			pobednik = s;
			game_over = true;
		}
		s = polja[0][0].getLabel();
		if (!s.equals("Izaberite X/O") && polja[1][0].getLabel().equals(s) && polja[2][0].getLabel().equals(s)) {
			pobednik = s;
			game_over = true;
		}
		s = polja[0][1].getLabel();
		if (!s.equals("Izaberite X/O") && polja[1][1].getLabel().equals(s) && polja[2][1].getLabel().equals(s)) {
			pobednik = s;
			game_over = true;
		}
		s = polja[0][2].getLabel();
		if (!s.equals("Izaberite X/O") && polja[1][2].getLabel().equals(s) && polja[2][2].getLabel().equals(s)) {
			pobednik = s;
			game_over = true;
		}
		s = polja[0][0].getLabel();
		if (!s.equals("Izaberite X/O") && polja[1][1].getLabel().equals(s) && polja[2][2].getLabel().equals(s)) {
			pobednik = s;
			game_over = true;
		}
		s = polja[2][0].getLabel();
		if (!s.equals("Izaberite X/O") && polja[1][1].getLabel().equals(s) && polja[0][2].getLabel().equals(s)) {
			pobednik = s;
			game_over = true;
		}
	}
	
	private static void GameOver() {
		
		Frame kraj = new Frame("Kraj igre");
		kraj.setSize(250,250);
		Label kraj_igre = new Label("GAME OVER");
		kraj_igre.setBackground(Color.RED);
		kraj_igre.setBounds(70,70,80,50);
		Label pobednik_igre = new Label("Pobednik je " + pobednik);
		pobednik_igre.setBackground(Color.GREEN);
		pobednik_igre.setBounds(70,120,100,50);
		Button zavrsi = new Button("Zavrsi");
		zavrsi.setBounds(170,200,50,30);
		zavrsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kraj.dispose();
			}
		});
		kraj.add(kraj_igre);
		kraj.add(pobednik_igre);
		kraj.add(zavrsi);
		kraj.setLayout(null);
		kraj.setVisible(true);
		
	}
	
	public static void main(String args[]) {
		
		Frame prozor = new Frame("X-O");
		prozor.setSize(500,500);
		prozor.setBackground(Color.GREEN);
		prozor.setLayout(null);
		prozor.setVisible(true);
		
		Button b = new Button("Izadji");
		b.setBounds(340,400,50,40);
		prozor.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prozor.dispose();
			}
		});
		
		Button b1 = new Button("Izaberite X/O");
		Button b2 = new Button("Izaberite X/O");
		Button b3 = new Button("Izaberite X/O");
		Button b4 = new Button("Izaberite X/O");
		Button b5 = new Button("Izaberite X/O");
		Button b6 = new Button("Izaberite X/O");
		Button b7 = new Button("Izaberite X/O");
		Button b8 = new Button("Izaberite X/O");
		Button b9 = new Button("Izaberite X/O");
		
		Button[][] polja = {{b1, b2, b3}, {b4, b5, b6}, {b7, b8, b9}};
		
		b1.setBounds(50,80,100,50);
		prozor.add(b1);
		b2.setBounds(180,80,100,50);
		prozor.add(b2);
		b3.setBounds(310,80,100,50);
		prozor.add(b3);
		b4.setBounds(50,190,100,50);
		prozor.add(b4);
		b5.setBounds(180,190,100,50);
		prozor.add(b5);
		b6.setBounds(310,190,100,50);
		prozor.add(b6);
		b7.setBounds(50,300,100,50);
		prozor.add(b7);
		b8.setBounds(180,300,100,50);
		prozor.add(b8);
		b9.setBounds(310,300,100,50);
		prozor.add(b9);
		
		for (int i = 0; i<3; i++)
			for (int j = 0; j<3; j++) {
			polja[i][j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Button b = (Button)e.getSource();
					if (b.getLabel().equals("Izaberite X/O")) {
					if (is_iks == true) {
						b.setLabel("X");
						is_iks = false;
					}
					else {
						b.setLabel("O");
						is_iks = true;
					}
						igra(polja);
						if (game_over == true) {
						GameOver();
						}
					}
				}
			});
		}
		
		Button p = new Button("Igraj opet");
		p.setBounds(70,400,70,40);
		prozor.add(p);
		p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game_over = false;
				is_iks = true;
				pobednik = null;
				for (int i = 0; i<3; i++)
					for (int j = 0; j<3; j++) {
						polja[i][j].setLabel("Izaberite X/O");
					}
			}
		});

	}
}
