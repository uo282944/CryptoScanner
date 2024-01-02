package org.ull.dap.vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PanelControl extends JPanel {
	private JPanel pnControl;
	private JPanel pnSeguimiento;
	private JLabel lblSeguimiento;
	private JLabel lblControl;
	private JPanel pnHistorico;
	private JLabel lblHistorico;
	private JTextArea txaHistorico;
	private JPanel pnControlCentro;
	private JPanel pnExtremos;
	private JPanel pnMaximo;
	private JPanel pnMinimo;
	private JPanel pnTitulo;
	private JLabel lblCrypto;
	private JLabel lblMaximo;
	private JTextField txMaximo;
	private JLabel lblMinimo;
	private JTextField txMinimo;
	private JPanel pnGrafica;
	private JPanel pnElegir;
	private JTextField txElegir;
	private JButton btnElegir;
	private JPanel pnCryptosElegidas;

	private MainWindow m;
	/**
	 * Create the panel.
	 */
	public PanelControl(MainWindow m) {
		this.m = m;
		setLayout(new BorderLayout(0, 0));
		add(getPnControl(), BorderLayout.CENTER);
		add(getPnSeguimiento(), BorderLayout.EAST);

	}

	private JPanel getPnControl() {
		if (pnControl == null) {
			pnControl = new JPanel();
			pnControl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			pnControl.setLayout(new BorderLayout(0, 0));
			pnControl.add(getLblControl(), BorderLayout.NORTH);
			pnControl.add(getPnHistorico(), BorderLayout.EAST);
			pnControl.add(getPnControlCentro(), BorderLayout.CENTER);
		}
		return pnControl;
	}
	private JPanel getPnSeguimiento() {
		if (pnSeguimiento == null) {
			pnSeguimiento = new JPanel();
			pnSeguimiento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			pnSeguimiento.setLayout(new BorderLayout(0, 0));
			pnSeguimiento.add(getLblSeguimiento(), BorderLayout.NORTH);
			pnSeguimiento.add(getPnElegir(), BorderLayout.SOUTH);
			pnSeguimiento.add(getPnCryptosElegidas(), BorderLayout.CENTER);
		}
		return pnSeguimiento;
	}
	private JLabel getLblSeguimiento() {
		if (lblSeguimiento == null) {
			lblSeguimiento = new JLabel("   Seguimiento   ");
			lblSeguimiento.setFont(new Font("Tahoma", Font.BOLD, 30));
		}
		return lblSeguimiento;
	}
	private JLabel getLblControl() {
		if (lblControl == null) {
			lblControl = new JLabel("Panel de control");
			lblControl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			lblControl.setFont(new Font("Tahoma", Font.BOLD, 30));
		}
		return lblControl;
	}
	private JPanel getPnHistorico() {
		if (pnHistorico == null) {
			pnHistorico = new JPanel();
			pnHistorico.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			pnHistorico.setLayout(new BorderLayout(0, 0));
			pnHistorico.add(getLblHistorico(), BorderLayout.NORTH);
			pnHistorico.add(getTxaHistorico(), BorderLayout.CENTER);
		}
		return pnHistorico;
	}
	private JLabel getLblHistorico() {
		if (lblHistorico == null) {
			lblHistorico = new JLabel("   Histórico   ");
			lblHistorico.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return lblHistorico;
	}
	private JTextArea getTxaHistorico() {
		if (txaHistorico == null) {
			txaHistorico = new JTextArea();
			txaHistorico.setEditable(false);
			txaHistorico.setWrapStyleWord(true);
			txaHistorico.setLineWrap(true);
		}
		return txaHistorico;
	}
	private JPanel getPnControlCentro() {
		if (pnControlCentro == null) {
			pnControlCentro = new JPanel();
			pnControlCentro.setLayout(new BorderLayout(0, 0));
			pnControlCentro.add(getPnExtremos_1(), BorderLayout.SOUTH);
			pnControlCentro.add(getPnGrafica(), BorderLayout.CENTER);
		}
		return pnControlCentro;
	}
	private JPanel getPnExtremos_1() {
		if (pnExtremos == null) {
			pnExtremos = new JPanel();
			pnExtremos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			pnExtremos.setLayout(new GridLayout(3, 1, 0, 0));
			pnExtremos.add(getPnTitulo());
			pnExtremos.add(getPnMaximo());
			pnExtremos.add(getPnMinimo());
		}
		return pnExtremos;
	}
	private JPanel getPnMaximo() {
		if (pnMaximo == null) {
			pnMaximo = new JPanel();
			pnMaximo.setLayout(new GridLayout(0, 2, 0, 0));
			pnMaximo.add(getLabel_2());
			pnMaximo.add(getTxMaximo());
		}
		return pnMaximo;
	}
	private JPanel getPnMinimo() {
		if (pnMinimo == null) {
			pnMinimo = new JPanel();
			pnMinimo.setLayout(new GridLayout(1, 2, 0, 0));
			pnMinimo.add(getLabel_3());
			pnMinimo.add(getTxMinimo());
		}
		return pnMinimo;
	}
	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setLayout(new GridLayout(0, 1, 0, 0));
			pnTitulo.add(getLabel_1());
		}
		return pnTitulo;
	}
	private JLabel getLabel_1() {
		if (lblCrypto == null) {
			lblCrypto = new JLabel("Crypto:");
			lblCrypto.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return lblCrypto;
	}
	private JLabel getLabel_2() {
		if (lblMaximo == null) {
			lblMaximo = new JLabel("Precio máximo");
			lblMaximo.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return lblMaximo;
	}
	private JTextField getTxMaximo() {
		if (txMaximo == null) {
			txMaximo = new JTextField();
			txMaximo.setHorizontalAlignment(SwingConstants.CENTER);
			txMaximo.setFont(new Font("Tahoma", Font.BOLD, 25));
			txMaximo.setText("0");
			txMaximo.setEditable(false);
			txMaximo.setColumns(10);
		}
		return txMaximo;
	}
	private JLabel getLabel_3() {
		if (lblMinimo == null) {
			lblMinimo = new JLabel("Precio mínimo");
			lblMinimo.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return lblMinimo;
	}
	private JTextField getTxMinimo() {
		if (txMinimo == null) {
			txMinimo = new JTextField();
			txMinimo.setText("0");
			txMinimo.setHorizontalAlignment(SwingConstants.CENTER);
			txMinimo.setFont(new Font("Tahoma", Font.BOLD, 25));
			txMinimo.setEditable(false);
			txMinimo.setColumns(10);
		}
		return txMinimo;
	}
	private JPanel getPnGrafica() {
		if (pnGrafica == null) {
			pnGrafica = new JPanel();
		}
		return pnGrafica;
	}
	private JPanel getPnElegir() {
		if (pnElegir == null) {
			pnElegir = new JPanel();
			pnElegir.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			pnElegir.setLayout(new BorderLayout(0, 0));
			pnElegir.add(getTxElegir(), BorderLayout.CENTER);
			pnElegir.add(getBtnElegir(), BorderLayout.EAST);
		}
		return pnElegir;
	}
	private JTextField getTxElegir() {
		if (txElegir == null) {
			txElegir = new JTextField();
			txElegir.setColumns(10);
		}
		return txElegir;
	}
	private JButton getBtnElegir() {
		if (btnElegir == null) {
			btnElegir = new JButton("OK");
		}
		return btnElegir;
	}
	private JPanel getPnCryptosElegidas() {
		if (pnCryptosElegidas == null) {
			pnCryptosElegidas = new JPanel();
		}
		return pnCryptosElegidas;
	}
}
