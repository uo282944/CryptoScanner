package repositorios.buisness.util;


import repositorios.BusinessException;

public interface Command<T> {

	T execute() throws BusinessException;
}
