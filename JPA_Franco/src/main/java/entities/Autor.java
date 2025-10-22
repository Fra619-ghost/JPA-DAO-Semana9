package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autores")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "autores.All",
        query = "select a from Autor a")
})
public class Autor {
    @Id//ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_autor", length = 60, nullable = false)
    private String nombre;

    @Column(name = "nacionalidad", length = 30, nullable = false)
    private String nacionalidad;

    private localDate fechaNac;
}
