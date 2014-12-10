package com.qd.news.services;

import java.util.List;
import com.qd.news.model.News;
import com.qd.news.template.ServiceTemplate;

public interface NewsService extends ServiceTemplate<News> {
    public List<News> findAll();
}
