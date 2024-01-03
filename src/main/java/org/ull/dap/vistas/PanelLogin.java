package org.ull.dap.vistas;

import org.ull.dap.controladores.SignController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelLogin extends JPanel {
	private JLabel lblTitulo;
	private JLabel lblUsername;
	private JTextField txUsername;
	private JLabel lblPassword;
	private JTextField txPassword;
	private JButton btnLogin;
	private JLabel lblRegistrarse;
	private JTextArea txaErroresLogin;

	private MainWindow m;
	/**
	 * Create the panel.
	 */
	public PanelLogin(MainWindow m) {
		this.m = m;
		setBackground(new Color(243, 238, 234));
		setLayout(null);
		add(getLblTitulo());
		add(getLblUsername());
		add(getTxUsername());
		add(getLblPassword());
		add(getTxPassword());
		add(getBtnLogin());
		add(getLblRegistrarse());
		add(getTxaErroresLogin());

	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Login");
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));

			lblTitulo.setBounds(205, 20, 219, 57);
		}
		return lblTitulo;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username");
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsername.setBounds(65, 74, 157, 29);
		}
		return lblUsername;
	}
	public JTextField getTxUsername() {
		if (txUsername == null) {
			txUsername = new JTextField();
			txUsername.setBorder(null);
			txUsername.setBackground(Color.white);
			txUsername.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 0));
			txUsername.setBounds(65, 113, 369, 29);
			txUsername.setColumns(10);
		}
		return txUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPassword.setBounds(65, 152, 157, 29);
		}
		return lblPassword;
	}
	public JTextField getTxPassword() {
		if (txPassword == null) {
			txPassword = new JTextField();
			txPassword.setBorder(null);
			txPassword.setBackground(Color.white);
			txPassword.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 0));
			txPassword.setColumns(10);
			txPassword.setBounds(65, 191, 369, 29);
		}
		return txPassword;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setBackground(new Color(178, 165, 155));
			btnLogin.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
			btnLogin.setBorderPainted(false);

			// Agrega un manejador de eventos del ratón para cambiar la apariencia en hover
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnLogin.setBackground(new Color(142, 132, 125));

				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnLogin.setBackground(new Color(178, 165, 155));

				}
			});
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SignController().login(PanelLogin.this, m);
				}
			});
			btnLogin.setBounds(175, 308, 155, 29);
		}
		return btnLogin;
	}
	private JLabel getLblRegistrarse() {
		if (lblRegistrarse == null) {
			lblRegistrarse = new JLabel("Sign Up");

			// Agrega un manejador de eventos del ratón para cambiar la apariencia en hover
			lblRegistrarse.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblRegistrarse.setText("<html><u>Sign Up</u></html>");

				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblRegistrarse.setText("Sign Up");

				}
			});
			lblRegistrarse.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new SignController().pasarRegister(m);
				}
			});
			lblRegistrarse.setForeground(Color.black);
			lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblRegistrarse.setBounds(230, 269, 69, 29);
		}
		return lblRegistrarse;
	}
	public JTextArea getTxaErroresLogin() {
		if (txaErroresLogin == null) {
			txaErroresLogin = new JTextArea();
			txaErroresLogin.setWrapStyleWord(true);
			txaErroresLogin.setForeground(Color.RED);
			txaErroresLogin.setEditable(false);
			txaErroresLogin.setBackground(new Color(243, 238, 234));
			txaErroresLogin.setBounds(25, 230, 369, 33);
		}
		return txaErroresLogin;
	}
}