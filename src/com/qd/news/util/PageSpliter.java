package com.qd.news.util;

import javax.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * 通用的分页类
 * @author 杨霖
 */
@Component("pageSpliter")
public class PageSpliter {
    private MongoTemplate mongoTemplate;

    /**
     * 分页读取数据(包括所有字段)
     * @param <E> 映射数据库的类
     * @param model 映射数据库的Model的Class
     * @param page 页码
     * @param rows 每一页的记录条数
     * @param orderby 排序的字段(语法：obj.xxx)
     * @param sort 升序还是降序(语法：Global.DESC)
     * @return 分页数据容器
     */
    public <E> Container<E> getListByPage(Class<E> model, int page, int rows,
            String orderby, String sort) {
        Container<E> container = new Container<E>();
        Query query = Query.query(new Criteria());
        query.skip((page - 1) * rows);
        query.limit(rows);
        container.setDataContainer(this.mongoTemplate.find(query, model));
        int records = this.mongoTemplate.findAll(model).size();
        container.setTotal(records);
        container.setTotalPages(records % rows == 0 ? records / rows : records
                / rows + 1);
        return container;
    }

    /**
     * 分页读取数据(包括所有字段)
     * @param <E> 映射数据库的类
     * @param model 映射数据库的Model的Class
     * @param page 页码
     * @param rows 每一页的记录条数
     * @param where 筛选条件(语法：where obj.xxx > 1)
     * @param orderby 排序的字段(语法：obj.xxx)
     * @param sort 升序还是降序(语法：Global.DESC)
     * @return 分页数据容器
     */
    @SuppressWarnings("static-access")
    public <E> Container<E> getListByPage(Class<E> model, int page, int rows,
            String[] where, Object[] answer, String orderby, String sort) {
        Container<E> container = new Container<E>();
        Criteria criteria = new Criteria();
        for (int i = 0; i < where.length; i++) {
            criteria.where(where[i]).is(answer[i]);
        }
        Query query = Query.query(criteria);
        query.skip((page - 1) * rows);
        query.limit(rows);
        container.setDataContainer(this.mongoTemplate.find(query, model));
        int records = this.mongoTemplate.find(query, model).size();
        container.setTotal(records);
        container.setTotalPages(records % rows == 0 ? records / rows : records
                / rows + 1);
        return container;
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

}
