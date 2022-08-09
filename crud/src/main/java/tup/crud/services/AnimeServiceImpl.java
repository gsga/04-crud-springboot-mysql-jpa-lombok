package tup.crud.services;

/* La clase AnimeServiceImpl encapsula la implementación de todo lo que
 * promete la interfaz contractual AnimeService.
 * Esta clase no es para ser mostrada a los consumidores de los servicios.
 * Podemos modificar a gusto esta clase, y siempre que nuestra implementación
 * cumpla lo que promete la interfaz contractual, nadie puede objetar, porque no 
 * vamos a incurrir en ninguna incompatibilidad.
 */
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

// public class IteratorUtils extends Object
// Provides static utility methods and decorators for Iterator instances. The implementations
// are provided in the iterators subpackage.
// https://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/IteratorUtils.html
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tup.crud.models.Anime;
import tup.crud.repositories.AnimeRepository;

/*
 * @Service Annotation
 * In an application, the business logic resides within the service
 * layer so we use the @Service Annotation to indicate that a 
 * class belongs to that layer. It is also a specialization 
 * of @Component Annotation like the @Repository Annotation. 
 * One most important thing about the @Service Annotation 
 * is it can be applied only to classes. It is used to mark 
 * the class as a service provider. So overall @Service 
 * annotation is used with classes that provide some business 
 * functionalities. Spring context will autodetect these 
 * lasses when annotation-based configuration and classpath 
 * scanning is used.
 */
@Service
public class AnimeServiceImpl implements AnimeService {

    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public List<Anime> getAll() {
        // animeRepository es de tipo AnimeRepository, que es una interfaz.
        // AnimeRepository a su vez extiende la interfaz CrudRepository.
        // La interfaz CrudRepository es genérica. En nuestro caso, la declaración es
        // CrudRepository<Anime, Long>. Anime es el tipo sobre el que implementa la
        // programación genérica, y Long es el tipo que se requiere para el campo Id.
        // Esto significa que el repositorio almacena objetos (instancias) del tipo
        // Anime.
        // La anotación @Autowired está justo antes de la declaración de
        // animeRepository,
        // de modo que afecta solo a este campo. Esta anotación elimina la necesidad de
        // implementar constructores, getters y setters. No necesitamos hacerlo
        // nosotros, sino que la plataforma lo hace automáticamente.
        // El método findAll() retorna todas las instancias de la clase Anime
        // contenidas en el repositorio. O sea, trae todos los registros de la
        // tabla asociada con el tipo Anime. Pero los retorna de un modo preciso,
        // como un objeto de tipo Iterable<Anime>.
        // https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html?is-external=true
        // La interfaz Iterable hace lo que su nombre indica. En particular, el método
        // iterator() retorna un objeto de tipo Iterator<Anime>.
        // La interfaz Iterator permite iterar una colección.
        // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
        // Y así llegamos a la declaración Iterator<Anime> animeIterator.
        // Este tipo tiene solo 4 métodos, y ninguno de ellos nos sirve.
        //

        Iterator<Anime> animeIterator = this.animeRepository.findAll().iterator();
        List<Anime> animeList = IteratorUtils.toList(animeIterator);

        return animeList;
    }

    @Override
    public Anime save(Anime anime) {
        anime.setFecha_creacion(LocalDateTime.now());
        return this.animeRepository.save(anime);
    }

    @Override
    public void deleteById(Long id) {
        this.animeRepository.deleteById(id);
    }

}
