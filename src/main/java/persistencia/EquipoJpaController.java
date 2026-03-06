package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import logica.Equipo; // Asegúrate de que este import coincida con tu paquete

public class EquipoJpaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf = null;

    // Este constructor conecta tu programa con el archivo persistence.xml
    public EquipoJpaController() {
        emf = Persistence.createEntityManagerFactory("Worlds2025PU");//Cambiar el nombre segun proyecto (nombrePU)
    }

    public EquipoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para CREAR un Equipo en la Base de Datos
    public void create(Equipo equipo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(equipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para LEER (traer) todos los Equipos
    public List<Equipo> findEquipoEntities() {
        return findEquipoEntities(true, -1, -1);
    }

    public List<Equipo> findEquipoEntities(int maxResults, int firstResult) {
        return findEquipoEntities(false, maxResults, firstResult);
    }

    private List<Equipo> findEquipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipo.class));
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

    // Método para LEER un Equipo en específico por su ID
    public Equipo findEquipo(int id) { 
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipo.class, id);
        } finally {
            em.close();
        }
    }

    // Método para EDITAR un Equipo
    public void edit(Equipo equipo) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            equipo = em.merge(equipo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para ELIMINAR un Equipo
    public void destroy(int id) throws Exception { 
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo equipo;
            try {
                equipo = em.getReference(Equipo.class, id);
                // Si tu getter de id en la clase Equipo no se llama getId(), ajusta esta línea
                equipo.getIdEquipo(); 
            } catch (Exception enfe) {
                throw new Exception("El equipo con id " + id + " no existe.", enfe);
            }
            em.remove(equipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
