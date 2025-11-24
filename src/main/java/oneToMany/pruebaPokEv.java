package oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class pruebaPokEv {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPokemon2");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        Pokemon po = new Pokemon("Bulbasaur", 10, "Planta", null);

        po.addEvolucion("Ivysaur", 20, "Planta", null);
        po.addEvolucion("Venusaur", 38, "Planta", "Veneno");

        try {
            em.getTransaction().begin();
            em.persist(po);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("No ha funcionado");
        }

        em.close();
        emf.close();
    }
}
