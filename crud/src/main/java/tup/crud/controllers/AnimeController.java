package tup.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tup.crud.models.Anime;
import tup.crud.services.AnimeServiceImpl;

@RestController
// La URL que vaya en la anotación habrá que agregarla detrás del puerto :8080
// en todas las llamadas
// a esta aplicación. Por ejemplo @RequestMapping("/anime") resultaría en lo
// siguiente:
// localhost:8080/anime.... y detrás de esto habría que agregar el resto de la
// URL para ser RESTful.
// En este caso, no necesitamos nada, y queda simplemente localhost:8080
@RequestMapping("")
public class AnimeController {

    @Autowired
    private AnimeServiceImpl animeService;

    @GetMapping("/all")
    public ResponseEntity<List<Anime>> getAll() {
        return new ResponseEntity<List<Anime>>(this.animeService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Anime> save(@RequestBody Anime anime) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.animeService.save(anime));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Anime> delete(@PathVariable Long id) {
        this.animeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
