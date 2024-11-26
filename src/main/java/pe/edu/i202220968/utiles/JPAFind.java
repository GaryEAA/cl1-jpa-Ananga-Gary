package pe.edu.i202220968.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220968.domain.City;
import pe.edu.i202220968.domain.Country;

import java.util.List;

public class JPAFind {
    public static void main(String[] args) {
        // Referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");

        // Verificar
        if (country != null) {
            System.out.println("================================================");
            System.out.println("Ciudades peruanas con población superior a 700k:");
            System.out.println("================================================");

            // Filtrar
            List<City> cities = country.getCities();
            cities.stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> {
                        System.out.println("Ciudad: " + city.getName());
                        System.out.println("Población: " + city.getPopulation());
                        System.out.println("--------------------------------------");
                    });
        } else {
            System.out.println("No se encontró el país con código 'PER'.");
        }

        em.close();
        emf.close();
    }
}
