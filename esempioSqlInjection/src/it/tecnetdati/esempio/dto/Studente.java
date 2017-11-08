/**
 * 
 */
package it.tecnetdati.esempio.dto;

/**
 * @author Alessandro Giardina
 *
 * 21/ott/2017 16:53:48
 */
public class Studente 
{
	private int	   idStudente;
	private int	   matricola;
	private String nome;
	private String cognome;
	
	public Studente(int	idStudente, int matricola, String nome, String cognome)
	{
		this.idStudente = idStudente;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getIdStudente() 
	{
		return idStudente;
	}
	public void setIdStudente(int idStudente) 
	{
		this.idStudente = idStudente;
	}
	public int getMatricola() 
	{
		return matricola;
	}
	public void setMatricola(int matricola) 
	{
		this.matricola = matricola;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getCognome() 
	{
		return cognome;
	}
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	
	@Override
	public String toString() {
		return "idStudente=" + idStudente + ", matricola="
				+ matricola + ", nome=" + nome + ", cognome=" + cognome;
	}
	
	
	
	
}
