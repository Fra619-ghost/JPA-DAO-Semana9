package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@Getter
@Setter

@NamedQueries({
        @NamedQuery(name = "categorias.All",
                query = "select a from Categoria a")
})

public class Categoría {
    @Id//ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_categorias", length = 60, nullable = false)
    private String nombre;


}
