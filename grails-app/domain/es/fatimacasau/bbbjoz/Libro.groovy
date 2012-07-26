package es.fatimacasau.bbbjoz

class Libro {
	
	String titulo
	String isbn
	Categoria categoria
	static belongsTo = [autor:Autor]

	static mapping = {
		categoria enumType:"ordinal"
	}
	
    static constraints = {
		titulo maxSize:100
		isbn maxSize:10
		categoria nullable:true
    }
	
}
