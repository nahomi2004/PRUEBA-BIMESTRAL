/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;

import Persistence.exceptions.NonexistentEntityException;
import Persistence.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.herencia.Repartidor;
import entidades.noHerencia.Entrega;
import entidades.noHerencia.Paquete;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author D E L L
 */
public class EntregaJpaController implements Serializable {

    public EntregaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
    public EntregaJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia_uwu");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entrega entrega) throws PreexistingEntityException, Exception {
        if (entrega.getPaquetes() == null) {
            entrega.setPaquetes(new ArrayList<Paquete>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Repartidor repartidor = entrega.getRepartidor();
            if (repartidor != null) {
                repartidor = em.getReference(repartidor.getClass(), repartidor.getCedula());
                entrega.setRepartidor(repartidor);
            }
            List<Paquete> attachedPaquetes = new ArrayList<Paquete>();
            for (Paquete paquetesPaqueteToAttach : entrega.getPaquetes()) {
                paquetesPaqueteToAttach = em.getReference(paquetesPaqueteToAttach.getClass(), paquetesPaqueteToAttach.getIdPaquete());
                attachedPaquetes.add(paquetesPaqueteToAttach);
            }
            entrega.setPaquetes(attachedPaquetes);
            em.persist(entrega);
            if (repartidor != null) {
                repartidor.getEntregas().add(entrega);
                repartidor = em.merge(repartidor);
            }
            for (Paquete paquetesPaquete : entrega.getPaquetes()) {
                Entrega oldEntregaOfPaquetesPaquete = paquetesPaquete.getEntrega();
                paquetesPaquete.setEntrega(entrega);
                paquetesPaquete = em.merge(paquetesPaquete);
                if (oldEntregaOfPaquetesPaquete != null) {
                    oldEntregaOfPaquetesPaquete.getPaquetes().remove(paquetesPaquete);
                    oldEntregaOfPaquetesPaquete = em.merge(oldEntregaOfPaquetesPaquete);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntrega(entrega.getCodigo()) != null) {
                throw new PreexistingEntityException("Entrega " + entrega + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Entrega entrega) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrega persistentEntrega = em.find(Entrega.class, entrega.getCodigo());
            Repartidor repartidorOld = persistentEntrega.getRepartidor();
            Repartidor repartidorNew = entrega.getRepartidor();
            List<Paquete> paquetesOld = persistentEntrega.getPaquetes();
            List<Paquete> paquetesNew = entrega.getPaquetes();
            if (repartidorNew != null) {
                repartidorNew = em.getReference(repartidorNew.getClass(), repartidorNew.getCedula());
                entrega.setRepartidor(repartidorNew);
            }
            List<Paquete> attachedPaquetesNew = new ArrayList<Paquete>();
            for (Paquete paquetesNewPaqueteToAttach : paquetesNew) {
                paquetesNewPaqueteToAttach = em.getReference(paquetesNewPaqueteToAttach.getClass(), paquetesNewPaqueteToAttach.getIdPaquete());
                attachedPaquetesNew.add(paquetesNewPaqueteToAttach);
            }
            paquetesNew = attachedPaquetesNew;
            entrega.setPaquetes(paquetesNew);
            entrega = em.merge(entrega);
            if (repartidorOld != null && !repartidorOld.equals(repartidorNew)) {
                repartidorOld.getEntregas().remove(entrega);
                repartidorOld = em.merge(repartidorOld);
            }
            if (repartidorNew != null && !repartidorNew.equals(repartidorOld)) {
                repartidorNew.getEntregas().add(entrega);
                repartidorNew = em.merge(repartidorNew);
            }
            for (Paquete paquetesOldPaquete : paquetesOld) {
                if (!paquetesNew.contains(paquetesOldPaquete)) {
                    paquetesOldPaquete.setEntrega(null);
                    paquetesOldPaquete = em.merge(paquetesOldPaquete);
                }
            }
            for (Paquete paquetesNewPaquete : paquetesNew) {
                if (!paquetesOld.contains(paquetesNewPaquete)) {
                    Entrega oldEntregaOfPaquetesNewPaquete = paquetesNewPaquete.getEntrega();
                    paquetesNewPaquete.setEntrega(entrega);
                    paquetesNewPaquete = em.merge(paquetesNewPaquete);
                    if (oldEntregaOfPaquetesNewPaquete != null && !oldEntregaOfPaquetesNewPaquete.equals(entrega)) {
                        oldEntregaOfPaquetesNewPaquete.getPaquetes().remove(paquetesNewPaquete);
                        oldEntregaOfPaquetesNewPaquete = em.merge(oldEntregaOfPaquetesNewPaquete);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = entrega.getCodigo();
                if (findEntrega(id) == null) {
                    throw new NonexistentEntityException("The entrega with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Entrega entrega;
            try {
                entrega = em.getReference(Entrega.class, id);
                entrega.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entrega with id " + id + " no longer exists.", enfe);
            }
            Repartidor repartidor = entrega.getRepartidor();
            if (repartidor != null) {
                repartidor.getEntregas().remove(entrega);
                repartidor = em.merge(repartidor);
            }
            List<Paquete> paquetes = entrega.getPaquetes();
            for (Paquete paquetesPaquete : paquetes) {
                paquetesPaquete.setEntrega(null);
                paquetesPaquete = em.merge(paquetesPaquete);
            }
            em.remove(entrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Entrega> findEntregaEntities() {
        return findEntregaEntities(true, -1, -1);
    }

    public List<Entrega> findEntregaEntities(int maxResults, int firstResult) {
        return findEntregaEntities(false, maxResults, firstResult);
    }

    private List<Entrega> findEntregaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entrega.class));
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

    public Entrega findEntrega(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entrega.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntregaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entrega> rt = cq.from(Entrega.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
