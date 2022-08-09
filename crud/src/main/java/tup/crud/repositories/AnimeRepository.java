package tup.crud.repositories;

import org.springframework.data.repository.CrudRepository;

import tup.crud.models.Anime;

// CrudRepository
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
// Interface for generic CRUD operations on a repository for a specific type.
// Publica los métodos count(), delete(), deleteAll(), deleteAllBiId(), deleteById(), existsById(), 
// findAll(), findAllById(), findById(), save() y saveAll().

// Vemos que AnimeRepository es una interfaz. Como tal, no implementa
// ningún método. No publica ni métodos ni propiedades. Se limita
// a extender CrudRepository, que es también una interfaz: publica pero no
// implementa. En otras palabras, no hemos implementado ni métodos ni propiedades.
// La magia ocurre en la clase AnimeServiceImpl, que tiene un campo de tipo
// AnimeRepository, y ese campo tiene la anotación @Autowired. Esa anotación
// es la que se ocupa de la inyección de dependencias.
// La interfaz CrudRepository es genérica en el tipo Anime. La clase
// Anime está en el paquete models.
public interface AnimeRepository extends CrudRepository<Anime, Long> {
}
