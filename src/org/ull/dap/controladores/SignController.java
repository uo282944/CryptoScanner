package org.ull.dap.controladores;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.BuisnessFactory;
import org.ull.dap.modelo.buisness.user.UsersService.UserBLDto;
import org.ull.dap.vistas.MainWindow;
import org.ull.dap.vistas.PanelLogin;
import org.ull.dap.vistas.PanelRegistro;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SignController {

    public void pasarLogin(MainWindow m){
        m.pasarPanel("LOGIN");
    }
    public void login(PanelLogin pn, MainWindow m) {
        String nick = pn.getTxUsername().getText();
        String password = pn.getTxPassword().getText();

        try{
            var user = BuisnessFactory.forUserService().findUserByNick(nick);
            if (user.isPresent()){
                if (user.get().password.equals(password)){
                    m.pasarPanel("CONTROL");
                }else{
                    pn.getTxaErroresLogin().setText("The username and the password don't match");
                }
            }else{
                pn.getTxaErroresLogin().setText("The username doesn't exist");
            }
        }catch (BusinessException e){
            e.printStackTrace();
        }
    }
    public void pasarRegister(MainWindow m){
        m.pasarPanel("REGISTER");
    }

    public void register(PanelRegistro pn, MainWindow m) {
        String nick = pn.getTxNick().getText();
        String email = pn.getTxEmail().getText();
        String password = pn.getTxPassword().getText();

        UserBLDto u = new UserBLDto();
        u.nick = nick;u.password=password;u.email=email;

        try{
            String erroresNick = validacionNick(nick);
            String erroresEmail = validacionEmail(email);
            String erroresContraseña = validacionContraseña(password);
            var ev = erroresEmail.isEmpty();
            var nv = erroresNick.isEmpty();
            var pv = erroresContraseña.isEmpty();
            agregarErrores(pn, erroresNick,erroresEmail,erroresContraseña);
            if (ev && nv && pv){
                BuisnessFactory.forUserService().addUser(u);
                limpiarPanelRegistro(pn);
                m.pasarPanel("LOGIN");
            }
        }catch (BusinessException e){
            System.out.println("Error al añadir el usuario "+ e);
        }
    }

    private void limpiarPanelRegistro(PanelRegistro pn) {
        pn.getTxNick().setText("");
        pn.getTxEmail().setText("");
        pn.getTxPassword().setText("");
    }

    private void agregarErrores(PanelRegistro pn, String erroresNick, String erroresEmail, String erroresContraseña) {
        pn.getTxaErroresNick().setText(erroresNick);
        pn.getTxaErroresEmail().setText(erroresEmail);
        pn.getTxaErroresContraseña().setText(erroresContraseña);
    }

    private String validacionNick(String nick) throws BusinessException {
        String res = "";
        var user = BuisnessFactory.forUserService().findUserByNick(nick);
        if (user.isPresent()) {
            if (nickRepetido(user.get())) res = res + "The username is not available\n";
        }
        if(nick.isEmpty())res = res + "The username is requiered\n";
        if(longitudNick(nick))res = res + "The username is shorter than 5";
        return res;
    }


    private String validacionEmail(String email) throws BusinessException {
        String res = "";
        var user = BuisnessFactory.forUserService().findUserByEmail(email);
        if (user.isPresent()) {
            if (emailRepetido(user.get())) res = res + "The email is not available\n";
        }
        if(email.isEmpty())res = res + "The email is requiered\n";
        if(emailBienFormado(email))res = res + "The email is not correct";
        return res;
    }

    private String validacionContraseña(String contraseña) throws BusinessException {
        String res = "";
        if(contraseña.isEmpty())res = res + "The password is requiered\n";
        if(longitudContraseña(contraseña))res = res + "The password is shorter than 5";
        return res;
    }
    private boolean longitudContraseña(String contraseña){
        return contraseña.length() <= 5;
    }
    private boolean longitudNick(String nick){
        return nick.length() <= 5;
    }
    private boolean nickRepetido(UserBLDto user) throws BusinessException {
        return user != null;
    }

    private boolean emailBienFormado(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        if (email == null) {
            return true;
        }
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
    private boolean emailRepetido(UserBLDto user) throws BusinessException {
        return user != null;
    }
}
