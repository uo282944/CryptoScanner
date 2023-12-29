package repositorios.buisness.user.crud.commands;

import repositorios.BusinessException;
import repositorios.buisness.user.UsersService.UserBLDto;
import repositorios.buisness.user.assembler.UserAssembler;
import repositorios.buisness.util.Command;
import repositorios.persistence.PersistenceFactory;

import java.util.Optional;

public class FindByEmailTS implements Command<Optional<UserBLDto>> {

    private String email;

    public FindByEmailTS(String email){
        this.email = email;
    }
    @Override
    public Optional<UserBLDto> execute() throws BusinessException {
        return UserAssembler.toBLDto(PersistenceFactory.forUser()
                .findByNick(email));
    }
}
