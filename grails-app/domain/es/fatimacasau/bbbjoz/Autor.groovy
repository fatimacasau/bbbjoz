package es.fatimacasau.bbbjoz

class Autor {

	String nombre
	String apellido
	
	static hasMany = [libros:Libro]
	
    static constraints = {
    }
}
