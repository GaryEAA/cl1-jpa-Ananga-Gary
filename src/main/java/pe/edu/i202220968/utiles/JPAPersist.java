package pe.edu.i202220968.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220968.domain.City;
import pe.edu.i202220968.domain.Country;
import pe.edu.i202220968.domain.CountryLanguage;
import pe.edu.i202220968.domain.CountryLanguagePk;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {
        // Referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Country country = new Country(
                "IMG", // Código del país
                "Imaginaria", // Nombre
                "Europe", // Continente
                "Región Imaginaria", // Región
                5000.0, // Superficie
                1500, // Año de independencia
                1000000, // Población
                75.0, // Expectativa de vida
                50000.0, // GNP
                45000.0, // GNP antiguo
                "Imaginaria", // Nombre local
                "Democracia", // Forma de gobierno
                "Jefe Imaginario", // Jefe de Estado
                1, // Capital
                "IM", // Código 2
                null, // List cities
                null  // List countrylanguages
        );

        City city1 = new City(4080, "Ciudad Imaginaria 1", country, "Distrito 1", 300000);
        City city2 = new City(4081, "Ciudad Imaginaria 2", country, "Distrito 2", 500000);
        City city3 = new City(4082, "Ciudad Imaginaria 3", country, "Distrito 3", 200000);

        CountryLanguagePk langPk1 = new CountryLanguagePk("IMG", "Imaginario");
        CountryLanguagePk langPk2 = new CountryLanguagePk("IMG", "Fantástico");

        CountryLanguage lang1 = new CountryLanguage(langPk1, "T", 90.0, country);
        CountryLanguage lang2 = new CountryLanguage(langPk2, "F", 10.0, country);

        country.setCities(Arrays.asList(city1, city2, city3));
        country.setCountryLanguages(Arrays.asList(lang1, lang2));

        em.persist(country);
        em.getTransaction().commit();
        System.out.println("El país 'Imaginaria' ha sido registrado exitosamente junto con sus ciudades y lenguajes.");
        em.close();
    }
}
