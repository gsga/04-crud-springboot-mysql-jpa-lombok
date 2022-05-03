package tup.crud.services;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tup.crud.models.Anime;
import tup.crud.repositories.AnimeRepository;

@Service
public class AnimeServiceImpl implements AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public List<Anime> getAll() {

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
