package modelo.buisness.user.crud.commands;

import modelo.BusinessException;
import modelo.buisness.user.UsersService.UserBLDto;
import modelo.buisness.util.Command;
import modelo.persistence.PersistenceFactory;
import modelo.buisness.user.assembler.UserAssembler;

import java.util.UUID;

public class AddUserTS implements Command<UserBLDto> {

    private UserBLDto user;
    public AddUserTS(UserBLDto user){
        this.user = user;
    }

    @Override
    public UserBLDto execute() throws BusinessException {
        if (PersistenceFactory.forUser().findByNick(user.nick).isPresent()) {
            throw new BusinessException("El usuario que se intenta añadir ya existe");
        }

        user.id = UUID.randomUUID().toString();
        PersistenceFactory.forUser().add(UserAssembler.toDALDto(user));
        return user;
    }
}
