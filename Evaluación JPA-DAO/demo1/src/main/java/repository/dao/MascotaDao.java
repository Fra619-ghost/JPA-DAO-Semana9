package repository.dao;

import entities.Mascota;
import jakarta.persistence.EntityManager;
import repository.IMascota;

import java.util.List;

public class MascotaDao implements IMascota {
    private final EntityManager em;

    public MascotaDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Mascota guardar(Mascota mascota) {
        em.getTransaction().begin();
        if (mascota.getId() == null) {
            em.persist(mascota);
        } else {
            em.merge(mascota);
        }
        em.getTransaction().commit();
        return mascota;
    }

    @Override
    public List<Mascota> listar() {
        return em.createQuery("from Mascota ", Mascota.class).getResultList();
    }

    @Override
    public Mascota buscarPorId(Long id) {
        return em.find(Mascota.class, id);
    }


    public Mascota Modificar(Long id) {
        Mascota cargo = em.find(Mascota.class, id);
        if (cargo != null) {
            return cargo;
        }
        return null;
    }


    public boolean Eliminar(Long id) {
        Mascota cargo = em.find(Mascota.class, id);
        if (cargo != null) {
            em.getTransaction().begin();
            em.remove(cargo);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }
}
