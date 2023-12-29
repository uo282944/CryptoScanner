package repositorios.buisness.user.crud;

import repositorios.BusinessException;
import repositorios.buisness.user.UsersService;
import repositorios.buisness.user.crud.commands.AddUserTS;
import repositorios.buisness.user.crud.commands.FindByEmailTS;
import repositorios.buisness.user.crud.commands.FindByNickTS;
import repositorios.buisness.util.CommandExecutor;

import java.util.Optional;

public class UsersServiceImpl implements UsersService {
    @Override
    public UserBLDto addUser(UserBLDto user) throws BusinessException {
        return new CommandExecutor().execute(new AddUserTS(user));
    }

    @Override
    public Optional<UserBLDto> findUserByNick(String nickUsuario) throws BusinessException {
        return new CommandExecutor().execute(new FindByNickTS(nickUsuario));
    }

    @Override
    public Optional<UserBLDto> findUserByEmail(String emailUsuario) throws BusinessException {
        return new CommandExecutor().execute(new FindByEmailTS(emailUsuario));
    }
}
