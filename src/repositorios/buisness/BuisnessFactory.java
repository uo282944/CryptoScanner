package repositorios.buisness;

import repositorios.buisness.user.UsersService;
import repositorios.buisness.user.crud.UsersServiceImpl;

public class BuisnessFactory {
    public static UsersService forMechanicService() {
        return new UsersServiceImpl();
    }
}
