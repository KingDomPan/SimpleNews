package com.qd.news.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import com.qd.news.model.User;
import com.qd.news.services.UserService;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {
    @SuppressWarnings("static-access")
    public User findOne(User model) {
        return mongoTemplate
                .findOne(
                        new Query(Criteria.where("username")
                                .is(model.getUsername()).where("password")
                                .is(model.getPassword())), User.class);
    }

    private MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    @Resource(name = "mongoTemplate")
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(User model) {
        this.mongoTemplate.save(model);
    }

    public boolean isExists(User user) {
        return (mongoTemplate.findOne(
                new Query(Criteria.where("username").is(user.getUsername())),
                User.class)) == null ? false : true;
    }

    public void delete(String keyId, Class<User> model) {
        this.mongoTemplate.remove(new Query(Criteria.where("id").is(keyId)),
                model);
    }

    public void update(String keyId, User user, Class<User> model) {
        this.mongoTemplate.updateFirst(
                new Query(Criteria.where("id").is(keyId)),
                new Update().set("username", user.getUsername())
                        .set("password", user.getPassword())
                        .set("realname", user.getRealname())
                        .set("sex", user.getSex()).set("job", user.getJob())
                        .set("email", user.getEmail()), model);
    }

    public List<User> findAll() {
        return this.mongoTemplate.findAll(User.class);
    }

}
