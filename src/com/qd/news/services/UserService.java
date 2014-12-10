package com.qd.news.services;

import java.util.List;

import com.qd.news.model.User;
import com.qd.news.template.ServiceTemplate;

public interface UserService extends ServiceTemplate<User> {
    public boolean isExists(User user);

    public List<User> findAll();
}
