package run;

import config.JPAUtil;
import entities.Mascota;
import jakarta.persistence.EntityManager;
import repository.dao.MascotaDao;

import java.util.Scanner;

public class Main {

    static EntityManager em = JPAUtil.getEntityManager();

    static MascotaDao mascotaDao = new MascotaDao(em);

    //MENU

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Crear mascota");
            System.out.println("2. Eliminar mascota");
            System.out.println("3. Listar mascotas");
            System.out.println("4. Actualizar mascota");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); // consumir la nueva línea pendiente

            switch (opcion) {
                case 1:

                    System.out.println("Crear mascota: ");

                    //ID
                    System.out.println("Ingrese el ID: ");
                    Long id = sc.nextLong();
                    sc.nextLine(); // consumir la nueva línea pendiente

                    //Nombre
                    System.out.println("Ingrese el nombre: ");
                    String nombre = sc.nextLine();

                    //Raza
                    System.out.println("Ingrese la raza: ");
                    String raza = sc.nextLine();

                    //Precio
                    System.out.println("Ingrese el precio: ");
                    Double precio = sc.nextDouble();
                    sc.nextLine(); // consumir la nueva línea pendiente

                    Mascota mascota = new Mascota(id, nombre, raza, precio);
                    mascotaDao.guardar(mascota);

                    break;
                case 2:
                    System.out.println("Eliminar mascota");
                    System.out.println("Lista de mascotas");
                    mascotaDao.listar().forEach(System.out::println);
                    System.out.println("Ingrese el ID de la mascota a eliminar: ");
                    Long idEliminar = sc.nextLong();
                    sc.nextLine(); // consumir la nueva línea pendiente

                    mascotaDao.Eliminar(idEliminar);
                    break;
                case 3:
                    System.out.println("Listar mascotas");
                    mascotaDao.listar().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Actualizar mascota");
                    System.out.println("Lista de mascotas");
                    mascotaDao.listar().forEach(System.out::println);
                    System.out.println("Ingrese el ID de la mascota a actualizar: ");
                    Long idActualizar = sc.nextLong();
                    sc.nextLine(); // consumir la nueva línea pendiente

                    mascotaDao.Modificar(idActualizar);
                    break;
                case 5:
                    System.out.println("Bye");
                    // Cerrar recursos si corresponde
                    if (em != null && em.isOpen()) {
                        em.close();
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        }while (opcion != 5);
    }
}






