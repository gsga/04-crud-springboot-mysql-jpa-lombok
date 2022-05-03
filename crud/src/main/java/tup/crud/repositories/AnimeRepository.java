package tup.crud.repositories;

import org.springframework.data.repository.CrudRepository;

import tup.crud.models.Anime;

public interface AnimeRepository extends CrudRepository<Anime, Long> {
}
