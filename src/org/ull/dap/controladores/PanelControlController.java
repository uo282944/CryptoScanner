package org.ull.dap.controladores;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.BuisnessFactory;
import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService.SeguimientoBLDto;
import org.ull.dap.vistas.MainWindow;
import org.ull.dap.vistas.PanelControl;

import javax.swing.*;

public class PanelControlController {
    public void crearSeguimiento(MainWindow m, PanelControl pn){
        var user = m.getUserlog();
        try {
            var crypto = BuisnessFactory.forCryptoService().findCryptoByName(pn.getTxElegir().getText());
            if (crypto.isPresent()) {
                SeguimientoBLDto s = new SeguimientoBLDto();
                s.id_usuario = user.id;
                s.id_crypto = crypto.get().id;
                BuisnessFactory.forSeguimientoService().addSeguimiento(s);
                pn.crearSeguimiento(pn.getTxElegir().getText());
                pn.getTxElegir().setText("");
                pn.revalidate();
                pn.repaint();
            }else{
                JOptionPane.showMessageDialog(m, "No existe ese coin o no esta registrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }catch (BusinessException e){
            JOptionPane.showMessageDialog(m, "No existe ese coin o no esta registrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
