package repository;

import entities.Mascota;

import java.util.List;

public interface IMascota {
    Mascota guardar(Mascota cargo);
    List<Mascota> listar();
    Mascota buscarPorId(Long id);
}
