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
            SeguimientoBLDto s = new SeguimientoBLDto();
            s.id_usuario = user.id;
            s.id_crypto = crypto.get().id;
            BuisnessFactory.forSeguimientoService().addSeguimiento(s);
        }catch (BusinessException e){
            JOptionPane.showMessageDialog(m, "No existe en coin!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
