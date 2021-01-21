package org.example.repository;

import org.example.SessionManager;
import org.example.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudRepositoryImplementation<T extends BaseEntity, ID extends Serializable> implements CrudRepository<T, ID> {

    private Session session;
    private Class<T> persistence;

    public CrudRepositoryImplementation() {
        this.session = SessionManager.getInstance();
        this.persistence = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public List<T> getAll() {
        Query<T> query = session.createQuery("FROM T");
        return query.list();
    }

    @Override
    public T get(ID id) {
        return session.load(persistence, id);
    }

    @Override
    public T save(T entity) {
        ID id = (ID) session.save(entity);
        return get(id);
    }

    @Override
    public void delete(ID id) {
        session.delete(get(id));
    }

}
