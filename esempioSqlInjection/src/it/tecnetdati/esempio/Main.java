/**
 * 
 */
package it.tecnetdati.esempio;

import it.tecnetdati.esempio.dao.StudenteDao;
import it.tecnetdati.esempio.dao.StudenteDaoConPreparedStatement;
import it.tecnetdati.esempio.dao.StudenteDaoITF;
import it.tecnetdati.esempio.dto.Studente;
import it.tecnetdati.esempio.exception.DaoException;

import java.util.ArrayList;

/**
 * @author Alessandro Giardina
 *
 * 21/ott/2017 15:59:43
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("Begin");
		//String cognome="Giardina";
		String cognome ="Alessio ora ci crede!!!!' OR '1=1";

		//io invece qui
		
		
		StudenteDaoITF studenteDao=null;
		try 
		{
			//studenteDao = new StudenteDao();
			studenteDao = new StudenteDaoConPreparedStatement();
			
			ArrayList<Studente> result = studenteDao.ricercaStudentePerCognome(cognome);
				
			for (Studente studente : result) 
			{
				System.out.println(studente);
			}
		
		} 
		catch (DaoException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("End");
		
		
	}

}
