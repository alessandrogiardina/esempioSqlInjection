/**
 * 
 */
package it.tecnetdati.esempio.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.tecnetdati.esempio.dto.Studente;
import it.tecnetdati.esempio.exception.DaoException;

/**
 * @author Alessandro Giardina
 *
 * 21/ott/2017 16:08:53
 */
public class StudenteDao extends GenericDao implements StudenteDaoITF 
{


	/**
	 * @throws DaoException
	 */
	public StudenteDao() throws DaoException 
	{
		super();	
	}
	
	public ArrayList<Studente> ricercaStudentePerCognome(String cognome) throws DaoException 
	{
		String query ="SELECT id_studente, matricola, nome, cognome FROM studente WHERE cognome ='"+cognome+"'";
		ArrayList<Studente> result = new ArrayList<Studente>();
		
		Connection con = getConnection();
		
		try 
		{
			Statement st = con.createStatement();
			try 
			{
				ResultSet rs=st.executeQuery(query);
				try
				{
					 while (rs.next()) 
					 {
						 int idStudenteRS = rs.getInt(1);
						 int matricolaRS = rs.getInt(2);
						 String nomeRS = rs.getString(3);
						 String cognomeRS = rs.getString(4);
						 
						 Studente s = new Studente(idStudenteRS, matricolaRS, nomeRS, cognomeRS);
						 result.add(s);
					 }
				}
				catch (SQLException e) 
				{
					throw new DaoException("Errore accesso al Database");
				}
				finally
				{
					rs.close();
				}
			} 
			catch (SQLException e) 
			{
				throw new DaoException("Errore accesso al Database");
			}
			finally
			{
				st.close();
			}			
		} 
		catch (SQLException e) 
		{
			throw new DaoException("Errore accesso al Database");
		}
		finally
		{
			closeConnection(con);
		}
		
 
		return result;
	}

}
