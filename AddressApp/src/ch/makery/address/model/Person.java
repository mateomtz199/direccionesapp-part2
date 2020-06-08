package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private StringProperty primerNombre;
	private StringProperty segundoNombre;
	private StringProperty calle;
	private IntegerProperty codigoPostal;
	private StringProperty ciudad;
	private ObjectProperty<LocalDate> onomastico;
	/**
	 * Constructor con algunos datos de inicio
	 * @param primerNombre
	 * @param segundoNombre
	 */
	public Person(String primerNombre, String segundoNombre){
		this.primerNombre = new SimpleStringProperty(primerNombre);
		this.segundoNombre = new SimpleStringProperty(segundoNombre);
		//Algunos datos ficticios iniciales, solo para pruebas convenientes
		this.calle = new SimpleStringProperty("Alguna calle");
		this.codigoPostal = new SimpleIntegerProperty(12454);
		this.ciudad = new SimpleStringProperty("Alguna ciudad");
		this.onomastico = new SimpleObjectProperty<LocalDate>(LocalDate.of(1993, 9, 22));
	}
	public Person(){
		this(null, null);
	}

	public StringProperty getPrimerNombre() {
		return primerNombre;
	}
	public StringProperty getSegundoNombre() {
		return segundoNombre;
	}
	public StringProperty getCalle() {
		return calle;
	}
	public IntegerProperty getCodigoPostal() {
		return codigoPostal;
	}
	public StringProperty getCiudad() {
		return ciudad;
	}
	public ObjectProperty<LocalDate> getOnomastico() {
		return onomastico;
	}
	public void setNombre(String nombre){
		this.primerNombre = new SimpleStringProperty(nombre);
	}
	public void setApellido(String apellido){
		this.segundoNombre = new SimpleStringProperty(apellido);
	}
	public void setCalle(String calle) {
		this.calle = new SimpleStringProperty(calle);
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = new SimpleIntegerProperty(codigoPostal);
	}
	public void setCiudad(String ciudad) {
		this.ciudad = new SimpleStringProperty(ciudad);
	}
	public void setOnomastico(LocalDate fecha) {
		this.onomastico = new SimpleObjectProperty<LocalDate>(fecha);
	}
}
