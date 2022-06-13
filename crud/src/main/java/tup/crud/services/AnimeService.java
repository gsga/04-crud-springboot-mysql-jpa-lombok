package tup.crud.services;

/* AnimeService no es una clase, sino una interfaz. Publica métodos, pero
 * no implementa nada. Esto se llama interfaz contractual. Si vamos a
 * organizar nuestra aplicación publicando en una o más APIs los
 * servicios o microservicios que queremos que nuestros clientes consuman,
 * esta interfaz es lo que vamos a dar a conocer a nuestros clientes.
 * Todas las implementaciones están en la clase AnimeServiceImpl.
 * Están encapsuladas, ocultas a los clientes. En realidad, a los
 * clientes no deberían interesarles los detalles de la implementación,
 * en tanto en cuanto cumplamos a rajatabla con lo que la interfaz contractual
 * promete.
 */
import java.util.List;

import tup.crud.models.Anime;

public interface AnimeService {

    public List<Anime> getAll();

    public Anime save(Anime anime);

    public void deleteById(Long id);

}
