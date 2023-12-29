package repositorios.buisness.user.crud.commands;

import repositorios.BusinessException;
import repositorios.buisness.user.UsersService.UserBLDto;
import repositorios.buisness.util.Command;
import repositorios.persistence.PersistenceFactory;
import repositorios.buisness.user.assembler.UserAssembler;

import java.util.UUID;

public class AddUserTS implements Command<UserBLDto> {

    private UserBLDto user;
    public AddUserTS(UserBLDto user){
        this.user = user;
    }

    @Override
    public UserBLDto execute() throws BusinessException {
        if (PersistenceFactory.forUser().findByNick(user.nick).isPresent()) {
            throw new BusinessException("El mecanico que se intenta añadir ya existe");
        }

        user.id = UUID.randomUUID().toString();
        user.version = 1L;
        PersistenceFactory.forUser().add(UserAssembler.toDALDto(user));
        return user;
    }
}
