package modelo.buisness;

import modelo.buisness.user.UsersService;
import modelo.buisness.user.crud.UsersServiceImpl;

public class BuisnessFactory {
    public static UsersService forUserService() {
        return new UsersServiceImpl();
    }
}
