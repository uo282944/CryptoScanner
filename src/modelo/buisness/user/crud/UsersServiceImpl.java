package modelo.buisness.user.crud;

import modelo.BusinessException;
import modelo.buisness.user.UsersService;
import modelo.buisness.user.crud.commands.AddUserTS;
import modelo.buisness.user.crud.commands.FindByEmailTS;
import modelo.buisness.user.crud.commands.FindByNickTS;
import modelo.buisness.util.CommandExecutor;

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
