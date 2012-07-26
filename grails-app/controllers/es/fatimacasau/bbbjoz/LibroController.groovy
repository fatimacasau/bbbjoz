package es.fatimacasau.bbbjoz

class LibroController {

    def index() {
		[libros: Libro.list(), totalLibros: Libro.count(),categorias:Categoria.values()]
	}
	
	def search() {
		def libros = Libro.createCriteria().list(){
			ilike("titulo", "%${params.titulo ?: ''}%")
			and{
				if(params.categoria) eq("categoria",Categoria.valueOf(params.categoria))
			}
		}
		[libros: libros, totalLibros: libros.size()]
	}
	
	def delete(){
		if(params.id){
			def libro = Libro.get(params.id)
			if(libro){
				libro.delete()
				flash.message = "El libro se ha borrado correctamente"
			}else{
				flash.message = "El libro no se ha encontrado"
			}
		}else{
			flash.message = "Se ha producido un error"
		}
		chain action:'index'
	}
}
