package repositorios.buisness.user;

import repositorios.BusinessException;

import java.util.Optional;

public interface UsersService {
    UserBLDto addMechanic(UserBLDto user) throws BusinessException;
    Optional<UserBLDto> findUserByNick(String nickUsuario) throws BusinessException;

    public class UserBLDto {

        public String id;
        public long version;
        public String nick;
        public String email;
        public String password;
    }
}
