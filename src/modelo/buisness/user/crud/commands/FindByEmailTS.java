package modelo.buisness.user.crud.commands;

import modelo.BusinessException;
import modelo.buisness.user.UsersService.UserBLDto;
import modelo.buisness.user.assembler.UserAssembler;
import modelo.buisness.util.Command;
import modelo.persistence.PersistenceFactory;

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
