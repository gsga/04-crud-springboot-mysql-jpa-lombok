package tup.crud.services;

import java.util.List;

import tup.crud.models.Anime;

public interface AnimeService {

    public List<Anime> getAll();

    public Anime save(Anime anime);

     public void deleteById(Long id);

}
