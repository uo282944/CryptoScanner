package repositorios.persistence.user;

import repositorios.persistence.Gateway;
import repositorios.persistence.user.UserGateway.UserDALDto;

import java.util.Optional;

public interface UserGateway extends Gateway<UserDALDto> {
    Optional<UserDALDto> findByNick(String nick);
    Optional<UserDALDto> findByEmail(String email);


    public class UserDALDto{
        public String id;
        public String nick;
        public String email;
        public String password;
    }
}
