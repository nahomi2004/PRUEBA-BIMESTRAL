/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;

import Persistence.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.noHerencia.Entrega;
import entidades.herencia.Cliente;
import entidades.herencia.Bodeguero;
import entidades.noHerencia.Paquete;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author D E L L
 */
public class PaqueteJpaController implements Serializable {

    public PaqueteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
    public PaqueteJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia_uwu");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete paquete) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrega entrega = paquete.getEntrega();
            if (entrega != null) {
                entrega = em.getReference(entrega.getClass(), entrega.getCodigo());
                paquete.setEntrega(entrega);
            }
            Cliente cliente = paquete.getCliente();
            if (cliente != null) {
                cliente = em.getReference(cliente.getClass(), cliente.getCedula());
                paquete.setCliente(cliente);
            }
            Bodeguero bodeguero = paquete.getBodeguero();
            if (bodeguero != null) {
                bodeguero = em.getReference(bodeguero.getClass(), bodeguero.getCedula());
                paquete.setBodeguero(bodeguero);
            }
            em.persist(paquete);
            if (entrega != null) {
                entrega.getPaquetes().add(paquete);
                entrega = em.merge(entrega);
            }
            if (cliente != null) {
                cliente.getPaquetes().add(paquete);
                cliente = em.merge(cliente);
            }
            if (bodeguero != null) {
                bodeguero.getPaquetes().add(paquete);
                bodeguero = em.merge(bodeguero);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete paquete) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete persistentPaquete = em.find(Paquete.class, paquete.getIdPaquete());
            Entrega entregaOld = persistentPaquete.getEntrega();
            Entrega entregaNew = paquete.getEntrega();
            Cliente clienteOld = persistentPaquete.getCliente();
            Cliente clienteNew = paquete.getCliente();
            Bodeguero bodegueroOld = persistentPaquete.getBodeguero();
            Bodeguero bodegueroNew = paquete.getBodeguero();
            if (entregaNew != null) {
                entregaNew = em.getReference(entregaNew.getClass(), entregaNew.getCodigo());
                paquete.setEntrega(entregaNew);
            }
            if (clienteNew != null) {
                clienteNew = em.getReference(clienteNew.getClass(), clienteNew.getCedula());
                paquete.setCliente(clienteNew);
            }
            if (bodegueroNew != null) {
                bodegueroNew = em.getReference(bodegueroNew.getClass(), bodegueroNew.getCedula());
                paquete.setBodeguero(bodegueroNew);
            }
            paquete = em.merge(paquete);
            if (entregaOld != null && !entregaOld.equals(entregaNew)) {
                entregaOld.getPaquetes().remove(paquete);
                entregaOld = em.merge(entregaOld);
            }
            if (entregaNew != null && !entregaNew.equals(entregaOld)) {
                entregaNew.getPaquetes().add(paquete);
                entregaNew = em.merge(entregaNew);
            }
            if (clienteOld != null && !clienteOld.equals(clienteNew)) {
                clienteOld.getPaquetes().remove(paquete);
                clienteOld = em.merge(clienteOld);
            }
            if (clienteNew != null && !clienteNew.equals(clienteOld)) {
                clienteNew.getPaquetes().add(paquete);
                clienteNew = em.merge(clienteNew);
            }
            if (bodegueroOld != null && !bodegueroOld.equals(bodegueroNew)) {
                bodegueroOld.getPaquetes().remove(paquete);
                bodegueroOld = em.merge(bodegueroOld);
            }
            if (bodegueroNew != null && !bodegueroNew.equals(bodegueroOld)) {
                bodegueroNew.getPaquetes().add(paquete);
                bodegueroNew = em.merge(bodegueroNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paquete.getIdPaquete();
                if (findPaquete(id) == null) {
                    throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete paquete;
            try {
                paquete = em.getReference(Paquete.class, id);
                paquete.getIdPaquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete with id " + id + " no longer exists.", enfe);
            }
            Entrega entrega = paquete.getEntrega();
            if (entrega != null) {
                entrega.getPaquetes().remove(paquete);
                entrega = em.merge(entrega);
            }
            Cliente cliente = paquete.getCliente();
            if (cliente != null) {
                cliente.getPaquetes().remove(paquete);
                cliente = em.merge(cliente);
            }
            Bodeguero bodeguero = paquete.getBodeguero();
            if (bodeguero != null) {
                bodeguero.getPaquetes().remove(paquete);
                bodeguero = em.merge(bodeguero);
            }
            em.remove(paquete);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete> findPaqueteEntities() {
        return findPaqueteEntities(true, -1, -1);
    }

    public List<Paquete> findPaqueteEntities(int maxResults, int firstResult) {
        return findPaqueteEntities(false, maxResults, firstResult);
    }

    private List<Paquete> findPaqueteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete.class));
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

    public Paquete findPaquete(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
