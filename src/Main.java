import controladores.MainController;
import repositorios.BusinessException;
import repositorios.buisness.BuisnessFactory;
import repositorios.buisness.user.UsersService.UserBLDto;

public class Main {
    public static void main(String[] args) throws BusinessException {
        //UserBLDto a = new UserBLDto(); a.nick = "Javiernt02";a.email = "123@gmail.com";a.password = "123";
        //BuisnessFactory.forMechanicService().addMechanic(a);
        MainController m = new MainController();
        m.iniciar();
    }
}