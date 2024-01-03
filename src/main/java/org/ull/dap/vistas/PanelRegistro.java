package org.ull.dap.vistas;

import org.ull.dap.controladores.SignController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelRegistro extends JPanel {
	private JTextField txNick;
	private JTextField txEmail;
	private JTextField txPassword;
	private JButton btnRegistrar;
	private JLabel lblTitulo;
	private JTextArea txaErroresNick;
	private JTextArea txaErroresEmail;
	private JTextArea txaErroresContraseña;
	private JLabel lblContraseña;
	private JLabel lblEmail;
	private JLabel lblNick;
	private MainWindow m;

	/**
	 * Create the panel.
	 */
	public PanelRegistro(MainWindow m) {
		this.m = m;
		setBackground(new Color(243, 238, 234));
		setLayout(null);
		add(getTxNick());
		add(getTxEmail());
		add(getTxPassword());
		add(getBtnRegistrar());
		add(getLblTitulo());
		add(getTxaErroresNick());
		add(getTxaErroresEmail());
		add(getTxaErroresContraseña());
		add(getLblContraseña());
		add(getLblEmail());
		add(getLblNick());

	}

	public JTextField getTxNick() {
		if (txNick == null) {
			txNick = new JTextField();
			txNick.setBorder(null);
			txNick.setBackground(Color.white);
			txNick.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 0));
			txNick.setBounds(65, 100, 369, 29);
			txNick.setColumns(10);
		}
		return txNick;
	}

	public JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setBorder(null);
			txEmail.setBackground(Color.white);
			txEmail.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 0));
			txEmail.setBounds(65, 200, 369, 29);
			txEmail.setColumns(10);
		}
		return txEmail;
	}

	public JTextField getTxPassword() {
		if (txPassword == null) {
			txPassword = new JTextField();
			txPassword.setBorder(null);
			txPassword.setBackground(Color.white);
			txPassword.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 0));
			txPassword.setBounds(65, 300, 369, 29);
			txPassword.setColumns(10);
		}
		return txPassword;
	}

	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Register");
			btnRegistrar.setBackground(new Color(178, 165, 155));
			btnRegistrar.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
			btnRegistrar.setBorderPainted(false);
			// Agrega un manejador de eventos del ratón para cambiar la apariencia en hover
			btnRegistrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnRegistrar.setBackground(new Color(142, 132, 125));

				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnRegistrar.setBackground(new Color(178, 165, 155));

				}
			});
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SignController().register(PanelRegistro.this, m);
				}
			});
			btnRegistrar.setBounds(175, 370, 155, 29);
		}
		return btnRegistrar;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Register");
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblTitulo.setBounds(205, 10, 249, 40);
		}
		return lblTitulo;
	}

	public JTextArea getTxaErroresNick() {
		if (txaErroresNick == null) {
			txaErroresNick = new JTextArea();
			txaErroresNick.setEditable(false);
			txaErroresNick.setForeground(Color.RED);
			txaErroresNick.setWrapStyleWord(true);
			txaErroresNick.setBackground(new Color(243, 238, 234));
			txaErroresNick.setBounds(65, 130, 369, 33);
		}
		return txaErroresNick;
	}

	public JTextArea getTxaErroresEmail() {
		if (txaErroresEmail == null) {
			txaErroresEmail = new JTextArea();
			txaErroresEmail.setWrapStyleWord(true);
			txaErroresEmail.setForeground(Color.RED);
			txaErroresEmail.setEditable(false);
			txaErroresEmail.setBackground(new Color(243, 238, 234));
			txaErroresEmail.setBounds(65, 230, 369, 33);
		}
		return txaErroresEmail;
	}

	public JTextArea getTxaErroresContraseña() {
		if (txaErroresContraseña == null) {
			txaErroresContraseña = new JTextArea();
			txaErroresContraseña.setEditable(false);
			txaErroresContraseña.setForeground(Color.RED);
			txaErroresContraseña.setWrapStyleWord(true);
			txaErroresContraseña.setBackground(new Color(243, 238, 234));
			txaErroresContraseña.setBounds(65, 330, 369, 33);
		}
		return txaErroresContraseña;
	}

	private JLabel getLblContraseña() {
		if (lblContraseña == null) {
			lblContraseña = new JLabel("Password");
			lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblContraseña.setBounds(65, 270, 192, 28);
		}
		return lblContraseña;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEmail.setBounds(65, 170, 192, 28);
		}
		return lblEmail;
	}

	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("Username");
			lblNick.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNick.setBounds(65, 70, 192, 28);
		}
		return lblNick;
	}
}