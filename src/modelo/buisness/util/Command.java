package modelo.buisness.util;


import modelo.BusinessException;

public interface Command<T> {

	T execute() throws BusinessException;
}
