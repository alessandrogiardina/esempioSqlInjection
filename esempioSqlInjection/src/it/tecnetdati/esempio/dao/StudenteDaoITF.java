/**
 * 
 */
package it.tecnetdati.esempio.dao;

import java.util.ArrayList;

import it.tecnetdati.esempio.dto.Studente;
import it.tecnetdati.esempio.exception.DaoException;

/**
 * @author Alessandro Giardina
 *
 * 21/ott/2017 16:00:49
 */
public interface StudenteDaoITF 
{
	public ArrayList<Studente> ricercaStudentePerCognome(String cognome) throws DaoException;
}
