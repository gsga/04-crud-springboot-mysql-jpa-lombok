package tup.crud.models;

import java.time.LocalDateTime;
import jakarta.persistence.*;

import lombok.Data;

// https://www.educative.io/edpresso/what-is-the-data-annotation-in-lombok
// The @Data annotation does the following work:
//   It generates the getter methods for all the fields.
//   It generates the setter methods for all the non-final fields.
//   It generates the toString() method implementation.
//   It generates appropriate equals() and hashCode() implementations, involving the fields of class.
//   It generates a constructor that initializes all the final fields, as well as all the
//      non-final fields with no initializer that have been marked with @NonNull, in order
//      to ensure that the field is never null.
@Data
// La anotación @Entity de JPA indica a la plataforma que inyecte a esta clase
// las dependencias necesarias para ser una entidad persistente. Para eso, la
// clase necesita por ejemplo un constructor,
// pero de eso ya se ocupó la anotación @Data de Lombok.
@Entity
// Permite especificar el nombre de la tabla en la base de datos que JPA usará
// en las operaciones de persistencia de esta entidad.
// También podemos dar el nombre de la base de datos.
// https://www.baeldung.com/jpa-entities#table
@Table(name = "anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    // El tipo Long del campo id viene forzado por la interfaz genérica
    // CrudRepository.
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "anio")
    private String anio;

    @Column(name = "fecha_creacion")
    private LocalDateTime fecha_creacion;
}
