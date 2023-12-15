class Videojuego {
    var nombre: String = ""
    var plataforma: String = ""
    var ano: Int = 0

    constructor(nombre: String, ano: Int, plataforma: String) {
        this.nombre = nombre
        this.ano = ano
        this.plataforma = plataforma
    }

    fun filtraJuegos(listaJuegos: List<Videojuego>, ano: Int): MutableList<String> {
        var juegosFiltrados: MutableList<String> = mutableListOf()
        listaJuegos.forEach { videojuego ->
            if (videojuego.ano == ano) {
                juegosFiltrados.add(videojuego.nombre)
            }
        }
        return juegosFiltrados
    }

    fun mapaJuegos(videojuegos: List<Videojuego>): MutableMap<String, MutableList<Videojuego>>{
        var mapaJuegos: MutableMap<String, MutableList<Videojuego>> = mutableMapOf()
        videojuegos.forEach { videojuego ->
            if(videojuego.plataforma !in mapaJuegos){
                mapaJuegos[videojuego.plataforma] = mutableListOf(videojuego)
            }else{
                mapaJuegos[videojuego.plataforma]?.add(videojuego)
            }
        }
        return mapaJuegos
    }

    fun plataformas(listaJuegos: List<Videojuego>): MutableList<String> {
        var listaPlataformas: MutableList<String> = mutableListOf()
        listaJuegos.forEach { videojuego ->
            if(videojuego.plataforma !in listaPlataformas){
                listaPlataformas.add(videojuego.plataforma)
            }
        }
        return listaPlataformas
    }
}

fun main(args: Array<String>) {
    var videojuegos: MutableList<Videojuego> = mutableListOf()
    videojuegos.add(Videojuego("Halo", 2001, "Xbox"))
    videojuegos.add(Videojuego("Halo Infinite", 2022, "Xbox"))
    videojuegos.add(Videojuego("God of War", 2005, "PlayStation"))
    videojuegos.add(Videojuego("God of War: Ragnarok", 2022, "PlayStation"))
    videojuegos.add(Videojuego("The Legend of Zelda", 1986, "Nintendo"))
    videojuegos.add(Videojuego("The Legend of Zelda: Breath of the Wild", 2017, "Nintendo"))
    videojuegos.add(Videojuego("Super Mario Odyssey", 2017, "Nintendo"))
    videojuegos.add(Videojuego("Crash Bandicoot", 1996, "PlayStation"))

    print(videojuegos[0].filtraJuegos(videojuegos, 2022))
    print(videojuegos[0].mapaJuegos(videojuegos))
    print(videojuegos[0].plataformas(videojuegos))
}
