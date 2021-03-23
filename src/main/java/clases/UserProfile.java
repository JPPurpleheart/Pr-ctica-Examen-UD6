package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 * Esta clase perfil de usuario tiene los datos del usuario
 * en una famosa red Social
 * 
 * @author eserrano
 *
 */
public class UserProfile implements Comparable<UserProfile>, Comparator<UserProfile>{
	
	/**
	 * Atributos de la clase
	 * 
	 * <b>nick</b> atributo de tipo cadena. Los nick son unicos. Solo
	 * puede haber un usuario con el mismo nick. No se distingue entre
	 * Mayusculas y minusculas 
	 * 
	 * <b>regDate</b> atributo de tipo fecha "LocalDate". Registra la fecha en la que
	 * el usuario se dio de alta en la red social. La fecha sigue el formato
	 * "dd/MM/yyyy"
	 * 
	 * <b>rating</b> atributo de tipo Float. almacena la media de las puntuaciones
	 * recibidas por popularidad recibida de otros usuarios.
	 */
	private String nick;
	private LocalDate regDate;
	private Float rating;
	
	/**
	 * Metodos de la clase
	 * 
	 * Generar el constructor por defecto 
	 * Generar constructor sobrecargado con todos los atributos.
	 * Generar todos los getters/setters
	 * Generar un metodo equals que devuelve verdadero cuando el
	 * nick es el mismo y falso en caso contrario
	 */
	public UserProfile() {
		
	}
	
	public UserProfile(String nick, LocalDate regDate, Float rating) {
		super();
		this.nick = nick;
		this.regDate = regDate;
		this.rating = rating;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	
	public LocalDate getRegDate() {
		return regDate;
	}
	
	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Float getRating() {
		return rating;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean retorno=false;
		if (o instanceof UserProfile) {
			UserProfile ob = (UserProfile) o;
			retorno = nick.equals(ob.nick);
		}
		return retorno;
	}
	
	public String getFileFormat() {
		String cadena = nick;
		cadena += ">";
		String fecha = regDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		cadena += fecha;
		cadena += ">";
		cadena += rating;
		cadena += "\n";
		return cadena;
	}

	@Override
	public int compareTo(UserProfile arg0) {
		int retorno = 0;
		retorno = nick.compareToIgnoreCase(arg0.nick);
		if(retorno == 0) {
			retorno = regDate.compareTo(arg0.regDate);
		}
		return retorno;
	}

	@Override
	public int compare(UserProfile a, UserProfile b) {
		int retorno = 0;
		retorno = a.rating.compareTo(b.rating);
		return retorno;
	}

}
