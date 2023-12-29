package modelo.persistence;

import modelo.persistence.user.UserGateway;
import modelo.persistence.user.impl.UserGatewayImpl;

public class PersistenceFactory {


	public static UserGateway forUser() {
		return new UserGatewayImpl();
	}
}

