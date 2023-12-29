package modelo.buisness.util;

import modelo.BusinessException;
import modelo.PersistenceException;
import modelo.utils.*;

import java.sql.Connection;
import java.sql.SQLException;


public class CommandExecutor {

	public <T> T execute(Command<T> cmd) throws BusinessException {
		Connection c = null;
		try {
			try {
				c = Jdbc.createThreadConnection();
				c.setAutoCommit(false);

				T res = cmd.execute();
				
				c.commit();
				
				return res;

			} catch (BusinessException e) {
				c.rollback();
				throw e;
			}
		} catch (SQLException | PersistenceException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(c);
		}
		
	}

}
