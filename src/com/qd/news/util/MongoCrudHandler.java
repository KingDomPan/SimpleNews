package com.qd.news.util;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * 增删改查通用组件
 * @author 张伟旭
 */
@Component("mongoCrudHandler")
public class MongoCrudHandler {
    private MongoTemplate mongoTemplate;

    /**
     * 添加记录
     * @param <E> 泛型类
     * @param model 实体Model
     */
    public <E> void save(E model) {
        this.mongoTemplate.save(model);
    }

    /**
     * 批量添加
     * @param <E> 泛型类
     * @param list 实体集合
     */
    public <E> void save(List<E> list) {
        int length = list.size();
        for (int i = 0; i < length; i++) {
            this.mongoTemplate.save(list.get(i));
        }
    }

    /**
     * 删除记录(前提：表的主键列名为id)
     * @param <E> 泛型类
     * @param model 实体Model的class
     * @param id 实体Model的Id
     */
    public <E> void delete(Class<E> model, String id) {
        this.mongoTemplate.remove(Query.query(Criteria.where("id").is(id)),
                model);
    }

    /**
     * 批量删除
     * @param <E> 泛型类
     * @param list 实体集合
     */
    public <E> void deleteByBatch(List<E> list) {
    }

    /**
     * 批量删除
     * @param <E> 泛型类
     * @param model 实体class
     * @param where 条件(语法：where obj.xxx > 1)
     */
    public <E> void deleteByBatch(Class<E> model, String where) {
    }

    /**
     * 更新记录
     * @param <E> 泛型类
     * @param obj 实体 Model
     */
    public <E> void update(E obj) {
    }

    /**
     * 批量更新
     * @param <E> 泛型类
     * @param list 实体集合
     */
    public <E> void updateByBatch(List<E> list) {
    }

    /**
     * 根据条件更新指定字段
     * @param <E> 泛型类
     * @param model 实体class
     * @param set HQL语句(语法：set obj.xxx=xxx)
     * @param where 条件(语法：where obj.xxx>1)
     */
    public <E> void updateByBatch(Class<E> model, String set, String where) {
    }

    /**
     * 读取顶部的N条数据
     * @param <E> 泛型类
     * @param model 实体class
     * @param top N条
     * @param where HQL语句(语法：where obj.xxx=xxx)
     * @return 实体集合
     */
    public <E> List<E> loadTopByCondition(Class<E> model, int top, String where) {
        return null;
    }

    /**
     * 读取记录
     * @param <E> 泛型类
     * @param model 实体class
     * @param id 主键Id
     * @return 实体
     */
    public <E> E loadById(Class<E> model, int id) {
        return null;
    }

    /**
     * 读取指定字段的记录(前提：该对象必须要有参数fields的构造方法)
     * @param <E> 泛型类
     * @param model 实体clss
     * @param id 主键Id
     * @param fields 要读取的字段(语法：new String[]{field1,field2})
     * @return 实体
     */
    public <E> E loadById(Class<E> model, int id, String[] fields) {
        return null;
    }

    /**
     * 根据条件读取记录
     * @param <E> 泛型类
     * @param model 实体class
     * @param where HQL语句(语法：where obj.xxx=xxx)
     * @return 实体
     */
    public <E> E loadById(Class<E> model, String where) {
        return null;
    }

    /**
     * 根据条件读取指定字段的记录(前提：该对象必须要有参数fields的构造方法)
     * @param <E> 泛型类
     * @param model 实体class
     * @param where HQL语句(语法：where obj.xxx=xxx)
     * @param fields 要读取的字段(语法：new String[]{field1,field2})
     * @return 实体
     */
    public <E> E loadById(Class<E> model, String where, String[] fields) {
        return null;
    }

    /**
     * 读取列表
     * @param <E> 泛型类
     * @param model 实体class
     * @return 实体集合
     */
    public <E> List<E> getList(Class<E> model) {
        return null;
    }

    /**
     * 读取指定字段的列表(前提：该对象必须要有fields的构造方法)
     * @param <E> 泛型类
     * @param model 实体class
     * @param fields 要读取的字段(语法：new String[]{field1,field2})
     * @return 实体集合
     */
    public <E> List<E> getList(Class<E> model, String[] fields) {
        return null;
    }

    /**
     * 读取指定字段的列表(前提：该对象必须要有fields的构造方法)
     * @param <E> 泛型类
     * @param model 实体class
     * @param fields 要读取的字段(语法：new String[]{field1,field2})
     * @param orderby 排序字段 (语法：obj.xxx)
     * @param desc 升序或降序(语法：Global.ASC)
     * @return 实体集合
     */
    public <E> List<E> getList(Class<E> model, String[] fields, String orderby,
            String desc) {
        return null;
    }

    /**
     * 根据条件读取列表
     * @param <E> 泛型类
     * @param model 实体class
     * @param where HQL语句(语法：where obj.xxx=xxx)
     * @return 实体集合
     */
    public <E> List<E> getList(Class<E> model, String where) {
        return null;
    }

    /**
     * 根据条件读取列表
     * @param <E> 泛型类
     * @param model 实体class
     * @param where HQL语句(语法：where obj.xxx=xxx)
     * @param orderby 排序字段 (语法：obj.xxx)
     * @param desc 升序或降序(语法：Global.ASC)
     * @return 实体集合
     */
    public <E> List<E> getList(Class<E> model, String where, String orderby,
            String desc) {
        return null;
    }

    /**
     * 根据条件读取指定字段的列表(前提：该对象必须要有fields的构造方法)
     * @param <E> 泛型类
     * @param model 实体class
     * @param where HQL语句(语法：where obj.xxx=xxx)
     * @param fields 要读取的字段(语法：new String[]{field1,field2})
     * @return 实体集合
     */
    public <E> List<E> getList(Class<E> model, String where, String[] fields) {
        return null;
    }

    /**
     * 根据条件读取指定字段的列表(前提：该对象必须要有fields的构造方法)
     * @param <E> 泛型类
     * @param model 实体class
     * @param where HQL语句(语法：where obj.xxx=xxx)
     * @param fields 要读取的字段(语法：new String[]{field1,field2})
     * @param orderby 排序字段 (语法：obj.xxx)
     * @param desc 升序或降序(语法：Global.ASC)
     * @return 实体集合
     */
    public <E> List<E> getList(Class<E> model, String where, String[] fields,
            String orderby, String desc) {
        return null;
    }

    public <E> List<E> getList(Class<E> model, String fetch, String where,
            String orderby, String sort) {
        return null;
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource(name = "mongoTemplate")
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
