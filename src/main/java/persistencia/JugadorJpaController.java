package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import logica.Jugador; // Asegúrate de que este import coincida con tu paquete

public class JugadorJpaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf = null;

    // Este constructor conecta tu programa con el archivo persistence.xml
    public JugadorJpaController() {
        emf = Persistence.createEntityManagerFactory("Worlds2025PU");//Cambiar el nombre segun proyecto (nombrePU)
    }

    public JugadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para CREAR un Jugador en la Base de Datos
    public void create(Jugador jugador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(jugador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para LEER (traer) todos los Jugadors
    public List<Jugador> findJugadorEntities() {
        return findJugadorEntities(true, -1, -1);
    }

    public List<Jugador> findJugadorEntities(int maxResults, int firstResult) {
        return findJugadorEntities(false, maxResults, firstResult);
    }

    private List<Jugador> findJugadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jugador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para LEER un Jugador en específico por su ID
    public Jugador findJugador(int id) { 
        EntityManager em = getEntityManager();
        try {
            return em.find(Jugador.class, id);
        } finally {
            em.close();
        }
    }

    // Método para EDITAR un Jugador
    public void edit(Jugador jugador) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            jugador = em.merge(jugador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para ELIMINAR un Jugador
    public void destroy(int id) throws Exception { 
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugador jugador;
            try {
                jugador = em.getReference(Jugador.class, id);
                // Si tu getter de id en la clase Jugador no se llama getId(), ajusta esta línea
                jugador.getIdJugador(); 
            } catch (Exception enfe) {
                throw new Exception("El jugador con id " + id + " no existe.", enfe);
            }
            em.remove(jugador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}