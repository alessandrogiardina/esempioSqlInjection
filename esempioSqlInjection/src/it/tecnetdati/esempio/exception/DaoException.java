package it.tecnetdati.esempio.exception;




public class DaoException extends Exception
{

	public DaoException(String message)
	{
		super(message);
	}
	
	public DaoException(String message, Exception e)
	{
		super(message, e);
	}

}
