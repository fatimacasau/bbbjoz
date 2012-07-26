import es.fatimacasau.bbbjoz.Categoria
import es.fatimacasau.bbbjoz.Autor
import es.fatimacasau.bbbjoz.Libro
import grails.util.Environment;

class BootStrap {

    def init = { servletContext ->
		
		Environment.executeForCurrentEnvironment {
			production {
			}
			development {
					addDevelopmentData()
			}
			test {
			}
		}
    }
	
	private addDevelopmentData(){
		new Autor(nombre:'J.R.R', apellido:'Tolkien').addToLibros(new Libro(titulo:'El Señor de los Anillos', isbn:'1234567890', categoria:Categoria.ACCION)).save(flush:true)
		new Autor(nombre:'J.R.R', apellido:'Tolkien').addToLibros(new Libro(titulo:'El Hobbit', isbn:'1234567891', categoria:Categoria.ACCION)).save(flush:true)
	}
	
    def destroy = {
    }
}
