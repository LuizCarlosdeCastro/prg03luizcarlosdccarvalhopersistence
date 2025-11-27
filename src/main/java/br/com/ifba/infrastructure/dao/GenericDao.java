package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 
 *
 * @param <Entity>
 */
@SuppressWarnings("unchecked")
public abstract class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {

    @PersistenceContext
    protected EntityManager entityManager;

    private  Class<Entity> type;

    public GenericDao() {
        this.type = (Class<Entity>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    
    @Override
    @Transactional
    public Entity save(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public Entity update(Entity entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(Entity entity) {
       
        Entity managed = entityManager.contains(entity) ? entity : entityManager.merge(entity);
        entityManager.remove(managed);
    }

    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery("FROM " + type.getName(), type).getResultList();
    }

    @Override
    public Entity findById(Long id) {
        return entityManager.find(type, id);
    }
}