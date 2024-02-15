data class Libro(val titulo:String,val autor:String,val anioPubli:Int)
data class Revista(val titulo:String,val issue:Int,val anio:Int)
data class DVD(val titulo:String,val director:String,val anio:Int)


sealed class Usuario {
    class Estudiante(val id:String,val nommbre:String, val carrera:String) : Usuario()
    class Profesor(val id:String,val nommbre:String, val departamento:String) : Usuario()
    class Visitante(val id:String,val nommbre:String) : Usuario()


    fun pillarlibro(usuario: Usuario,libro: Libro) = when (usuario) {
            is Visitante -> {
                "Un visitante no puede cojer libros"
            }

            is Estudiante -> {
                "El estudiante ha cogido prestado un libro "
            }

            is Profesor -> {
                "El profesor ha cogiddo un libro"
            }
        }
}


fun main() {

    val l1 = Libro("awanabum","Pele",1982)
    val l2 = Libro("Happy","Nazario",1992)

    val estu = Usuario.Estudiante("chuki3","fran","Narcotraficante")
    val profe = Usuario.Profesor("chuknorris","Piña","Awanabumbambam")
    val visi = Usuario.Visitante("pringao", "qwerty")

    println(estu.pillarlibro(estu, l1))
    println(estu.pillarlibro(estu, l2))


    println(profe.pillarlibro(profe,l1))
    println(profe.pillarlibro(profe,l2))


    println(visi.pillarlibro(visi,l1))
}