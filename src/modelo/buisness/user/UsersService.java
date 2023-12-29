package modelo.buisness.user;

import modelo.BusinessException;

import java.util.Optional;

public interface UsersService {
    UserBLDto addUser(UserBLDto user) throws BusinessException;
    Optional<UserBLDto> findUserByNick(String nickUsuario) throws BusinessException;
    Optional<UserBLDto> findUserByEmail(String emailUsuario) throws BusinessException;

    public class UserBLDto {

        public String id;
        public String nick;
        public String email;
        public String password;
    }
}
