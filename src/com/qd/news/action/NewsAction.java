package com.qd.news.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ModelDriven;
import com.qd.news.model.News;
import com.qd.news.service.impl.NewsServiceImpl;
import com.qd.news.template.ActionTemplate;
import com.qd.news.util.Container;
import com.qd.news.util.Global;
import com.qd.news.util.SerialNumberUtil;

@SuppressWarnings("serial")
@Component("newsAction")
@Scope("prototype")
public class NewsAction extends ActionTemplate implements ModelDriven<News> {
    private News news = new News();
    private NewsServiceImpl newsServiceImpl;
    private File file;
    // 文件名
    private String fileFileName;
    // 文件类型
    private String fileContentType;
    // 文件大小
    private Long maximumSize = Global.maximumSize;
    // 上传允许的文件类型
    private String allowedTypes = Global.allowedTypes;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String findListByPage() {
        Container<News> container = this.getPageSpliter().getListByPage(
                News.class, page, rows, null, null);
        this.getResult().put(ROWS, container.getDataContainer());
        this.getResult().put(TOTAL, container.getTotal());
        return SUCCESS;
    }

    public News getModel() {
        return news;
    }

    public NewsServiceImpl getNewsServiceImpl() {
        return newsServiceImpl;
    }

    public String save() {
        boolean flag = false;
        String[] allowedTypesStr = allowedTypes.split(",");
        for (int i = 0; i < allowedTypesStr.length; i++) {
            if (fileContentType.equals(allowedTypesStr[i])) {
                flag = true;
                break;
            }
        }

        if (flag == false) {
            this.getResult().put("message", "文件格式不符合要求!!!!");
            return SUCCESS;
        }

        if (file.length() > maximumSize) {
            this.getResult().put("message", "文件超过上传限制!!!!");
            return SUCCESS;
        }
        news.setCreateDate(new Date());
        news.setLastModifyTime(new Date());
        String filePath;
        try {
            filePath = SerialNumberUtil.toSerialNumber() + fileFileName;
            this.newsServiceImpl.getGridFsTemplate().store(
                    new FileInputStream(file), filePath);
            news.setFilePath(filePath);
            this.newsServiceImpl.save(news);
            this.getResult().put("message", "新闻添加成功!!!!");
            return SUCCESS;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Resource
    public void setNewsServiceImpl(NewsServiceImpl newsServiceImpl) {
        this.newsServiceImpl = newsServiceImpl;
    }
}
