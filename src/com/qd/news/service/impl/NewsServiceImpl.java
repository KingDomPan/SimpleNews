package com.qd.news.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;
import com.qd.news.model.News;
import com.qd.news.services.NewsService;

@Component("newsServiceImpl")
public class NewsServiceImpl implements NewsService {
    private MongoTemplate mongoTemplate;
    private GridFsTemplate gridFsTemplate;

    public GridFsTemplate getGridFsTemplate() {
        return gridFsTemplate;
    }

    @Resource
    public void setGridFsTemplate(GridFsTemplate gridFsTemplate) {
        this.gridFsTemplate = gridFsTemplate;
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(News model) {
        this.mongoTemplate.save(model);
    }

    public void delete(String keyId, Class<News> model) {
        this.mongoTemplate.remove(new Query(Criteria.where("id").is(keyId)),
                model);
    }

    public void update(String keyId, News tmodel, Class<News> model) {

    }

    public News findOne(News model) {
        return null;
    }

    public List<News> findAll() {
        return null;
    }

}
