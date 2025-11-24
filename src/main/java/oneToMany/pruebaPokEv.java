package oneToMany;

import crud.Pokemon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class pruebaPokEv {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPokemon");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        Pokemon po = new Pokemon(nombre, nivel, tipo1, tipo2);

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
    }

}
