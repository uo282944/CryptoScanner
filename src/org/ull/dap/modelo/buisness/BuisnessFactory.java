package org.ull.dap.modelo.buisness;

import org.ull.dap.modelo.buisness.user.UsersService;
import org.ull.dap.modelo.buisness.user.crud.UsersServiceImpl;

public class BuisnessFactory {
    public static UsersService forUserService() {
        return new UsersServiceImpl();
    }
}
