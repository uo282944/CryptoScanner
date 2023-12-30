package org.ull.dap.modelo.persistence;

import org.ull.dap.modelo.persistence.user.UserGateway;
import org.ull.dap.modelo.persistence.user.impl.UserGatewayImpl;

public class PersistenceFactory {


	public static UserGateway forUser() {
		return new UserGatewayImpl();
	}
}

