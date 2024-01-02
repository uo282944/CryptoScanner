package org.ull.dap.controladores;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.BuisnessFactory;
import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService.SeguimientoBLDto;
import org.ull.dap.vistas.MainWindow;
import org.ull.dap.vistas.PanelControl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;


public class PanelControlController {
    public void crearSeguimiento(MainWindow m, PanelControl pn){
        var user = m.getUserlog();
        try {
            var crypto = BuisnessFactory.forCryptoService().findCryptoByName(pn.getTxElegir().getText());
            if (crypto.isPresent()) {
                var seguimiento = BuisnessFactory.forSeguimientoService().findSeguimientoByIds(user.id,crypto.get().id);
                if (!seguimiento.isPresent()) {
                    SeguimientoBLDto s = new SeguimientoBLDto();
                    s.id_usuario = user.id;
                    s.id_crypto = crypto.get().id;
                    BuisnessFactory.forSeguimientoService().addSeguimiento(s);
                    pn.crearSeguimiento(pn.getTxElegir().getText());
                    pn.revalidate();
                    pn.repaint();
                }else{
                    JOptionPane.showMessageDialog(m, "Ya sigues a esta coin", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                pn.getTxElegir().setText("");
            }else{
                JOptionPane.showMessageDialog(m, "No existe ese coin o no esta registrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }catch (BusinessException e){
            JOptionPane.showMessageDialog(m, "No existe ese coin o no esta registrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void cambiarCryproSeleccionada(MainWindow m, String nombreCrypto){
        m.cryptoSelected = nombreCrypto;
        double maximo = Collections.max(m.precios.get(nombreCrypto));
        double minimo = Collections.min(m.precios.get(nombreCrypto));
        m.pnControl.txMaximo.setText(0+"");
        m.pnControl.txMinimo.setText(0+"");
        m.pnControl.lblCrypto.setText("Crypto: "+nombreCrypto);
        pintarExtremos(m, maximo);
        pintarExtremos(m, minimo);

        if (!m.cryptoSelected.isBlank()){
            String text = "";
            for (Double d: m.precios.get(m.cryptoSelected)){
                text = text+d+"\n";
            }
            m.pnControl.txaHistorico.setText(text);
        }
    }

    public void pintarHistorico(MainWindow m, String nameCrypto ,double price){
        if (!m.precios.containsKey(nameCrypto)){
            m.precios.put(nameCrypto, new ArrayList<Double>());
        }
        m.precios.get(nameCrypto).add(price);
        if (!m.cryptoSelected.isBlank() && m.cryptoSelected.equals(nameCrypto)){
            pintarExtremos(m, price);
            String text = "";
            for (Double d: m.precios.get(m.cryptoSelected)){
                 text = text+d+"\n";
            }
            m.pnControl.txaHistorico.setText(text);
        }
    }

    private void pintarExtremos(MainWindow m, double price) {
        if (Double.parseDouble(m.pnControl.txMaximo.getText()) < price || Double.parseDouble(m.pnControl.txMaximo.getText()) == 0){
            m.pnControl.txMaximo.setText(price+"");
        }
        if (Double.parseDouble(m.pnControl.txMinimo.getText()) > price || Double.parseDouble(m.pnControl.txMinimo.getText()) == 0){
            m.pnControl.txMinimo.setText(price+"");
        }
    }
}
