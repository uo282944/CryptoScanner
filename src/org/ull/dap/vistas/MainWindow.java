package org.ull.dap.vistas;

import org.ull.dap.controladores.InicioController;
import org.ull.dap.controladores.MainController;
import org.ull.dap.modelo.apicrypto.user.User;
import org.ull.dap.modelo.buisness.user.UsersService.UserBLDto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private UserBLDto userlog;
	private JPanel panelPrincipal;
	private JPanel pnLogin;

	private JPanel pnRegister;
	public PanelControl pnControl;
	private JPanel pnInicio;
	private JLabel lblTituloAplicacion;
	private JPanel pnInicioInferior;
	private JButton btnInicioEmpezar;
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 491);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		panelPrincipal.add(getPnInicio(), "INICIO");
		panelPrincipal.add(getPnLogin(), "LOGIN");
		panelPrincipal.add(getPnRegister(), "REGISTER");
		panelPrincipal.add(getPnControl(), "CONTROL");
	}

	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new PanelLogin(this);
		}
		return pnLogin;
	}

	private JPanel getPnRegister() {
		if (pnRegister == null) {
			pnRegister = new PanelRegistro(this);
		}
		return pnRegister;
	}

	private JPanel getPnControl() {
		if (pnControl == null) {
			pnControl = new PanelControl(this);
		}
		return pnControl;
	}
	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setLayout(new GridLayout(2, 1, 0, 0));
			pnInicio.add(getLblTituloAplicacion());
			pnInicio.add(getPnInicioInferior());
		}
		return pnInicio;
	}
	private JLabel getLblTituloAplicacion() {
		if (lblTituloAplicacion == null) {
			lblTituloAplicacion = new JLabel("CryptoScanner");
			lblTituloAplicacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblTituloAplicacion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return lblTituloAplicacion;
	}
	private JPanel getPnInicioInferior() {
		if (pnInicioInferior == null) {
			pnInicioInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInicioInferior.getLayout();
			flowLayout.setVgap(100);
			pnInicioInferior.add(getBtnInicioEmpezar());
		}
		return pnInicioInferior;
	}
	private JButton getBtnInicioEmpezar() {
		if (btnInicioEmpezar == null) {
			btnInicioEmpezar = new JButton("EMPEZAR");
			btnInicioEmpezar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InicioController().pasarLogin(MainWindow.this);
				}
			});
			btnInicioEmpezar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return btnInicioEmpezar;
	}

	public void pasarPanel(String nombre){
		CardLayout cl = (CardLayout) (panelPrincipal.getLayout());
		cl.show(panelPrincipal, nombre);
	}

	public UserBLDto getUserlog(){
		return userlog;
	}

	public void setUserlog(UserBLDto userlog){
		this.userlog = userlog;
	}
}
