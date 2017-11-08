package it.tecnetdati.esempio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import it.tecnetdati.esempio.exception.DaoException;


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
		String url = "jdbc:mysql://localhost:3306/db_esempio_sql_injection";
		String user = "esempio";
		String password = "esempio";
		
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
