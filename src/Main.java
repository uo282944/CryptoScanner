import controladores.MainController;
import modelo.BusinessException;

public class Main {
    public static void main(String[] args) throws BusinessException {
        //UserBLDto a = new UserBLDto(); a.nick = "Javiernt02";a.email = "123@gmail.com";a.password = "123";
        //BuisnessFactory.forMechanicService().addMechanic(a);
        MainController m = new MainController();
        m.iniciar();
    }
}