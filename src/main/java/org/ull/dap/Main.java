package org.ull.dap;

import org.ull.dap.controladores.MainController;
import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.BuisnessFactory;
import org.ull.dap.modelo.buisness.crypto.CryptosService;

public class Main {
    public static void main(String[] args) throws BusinessException {
        //UserBLDto a = new UserBLDto(); a.nick = "Javiernt02";a.email = "123@gmail.com";a.password = "123";
        //var a = BuisnessFactory.forSeguimientoService().findCryptosById("8a2f0071-9702-41a9-a66f-8598d6");
        //for (CryptosService.CryptoBLDto c: a) {
        //    System.out.println(c.nombre);
        //}
        MainController m = new MainController();
        m.iniciar();
    }
}