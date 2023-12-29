package repositorios.persistence;

import repositorios.persistence.user.UserGateway;
import repositorios.persistence.user.impl.UserGatewayImpl;

public class PersistenceFactory {


	public static UserGateway forUser() {
		return new UserGatewayImpl();
	}
}

