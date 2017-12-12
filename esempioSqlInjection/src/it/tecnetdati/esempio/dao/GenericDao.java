package it.tecnetdati.esempio.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import it.tecnetdati.esempio.exception.DaoException;
import it.tecnetdati.esempio.properties.PropertyFileLoader;
import it.tecnetdati.esempio.properties.PropertyFileLoaderITF;
import it.tecnetdati.esempio.util.Costanti;


public class GenericDao 
{
	public GenericDao() throws DaoException 
	{
		
		try 
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} 
		catch (SQLException e) 
		{
			throw new DaoException("Errore Driver Mysql",e);
		}
		
		
	}
	
	protected void closeResult(ResultSet rs) throws SQLException 
	{
		rs.close();
	}

	protected void closeStatement(Statement st) throws SQLException 
	{
		st.close();
	}

	protected void closePreparedStatement(PreparedStatement st) throws SQLException 
	{
		st.close();
	}
	
	protected void closeConnection(Connection con) throws DaoException 
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			throw new DaoException("Errore durante la chiusura della connessione",e);
		}
	}
	
	protected Connection getConnection() throws DaoException 
	{
		PropertyFileLoaderITF propertyFileLoader = new PropertyFileLoader();
		
		String user=null;
		String password=null;
		String url=null;
		try 
		{
			Properties properties = propertyFileLoader.getPropertyFile();
			
			
			user = (String) properties.get(Costanti.USER);
			password = (String) properties.get(Costanti.PASSWORD);
			url = (String) properties.get(Costanti.URL);
			
		} 
		catch (IOException e) 
		{
			throw new DaoException("Errore reperimento file di properties",e);
		}
		
		
		
		Connection connection = null;
		try 
		{
			connection = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException e) 
		{
			throw new DaoException("Errore reperimento connessione",e);
		}
		return connection;

	}
	
	
	

}
