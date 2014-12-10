package com.qd.news.template;

public interface ServiceTemplate<T> {
    public void save(T model);

    public void delete(String keyId, Class<T> model);

    public void update(String keyId, T tmodel, Class<T> model);

    public T findOne(T model);
}
