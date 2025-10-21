package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mascotas")
@Getter
@Setter
public class Mascota {

    @Id//ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String raza;

    @Column(nullable = false)
    private Double precio;

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", precio=" + precio +
                '}';
    }

    public Mascota(Long id, String nombre, String raza, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.precio = precio;
    }

    public Mascota(){}
}
