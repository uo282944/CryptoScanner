package repositorios.buisness.user.crud.commands;

import repositorios.BusinessException;
import repositorios.buisness.user.UsersService.UserBLDto;
import repositorios.buisness.user.assembler.UserAssembler;
import repositorios.buisness.user.crud.UsersServiceImpl;
import repositorios.buisness.util.Command;
import repositorios.persistence.PersistenceFactory;

import java.util.Optional;
import java.util.UUID;

public class FindByNickTS implements Command<Optional<UserBLDto>> {
    private String nick;
    public FindByNickTS(String nick){
        this.nick = nick;
    }

    @Override
    public Optional<UserBLDto> execute() throws BusinessException {
        return UserAssembler.toBLDto(PersistenceFactory.forUser()
                .findByNick(nick));
    }
}
