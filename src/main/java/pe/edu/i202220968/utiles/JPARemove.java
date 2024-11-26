package pe.edu.i202220968.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220968.domain.Country;

public class JPARemove {
    public static void main(String[] args) {
        // Referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "IMG");

        if (country != null) {
            em.getTransaction().begin();
            em.remove(country);
            em.getTransaction().commit();
            System.out.println("El país ha sido eliminado exitosamente.");
        } else {
            System.out.println("El país con el código 'IMG' no fue encontrado.");
        }

        em.close();
        emf.close();
    }
}
