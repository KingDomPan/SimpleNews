package com.qd.news.action;

import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import com.mongodb.gridfs.GridFSDBFile;

public class DownloadAction implements ServletResponseAware {
    private GridFsTemplate gridFsTemplate;
    private String filename;
    private HttpServletResponse response;

    public String download() throws Exception {
        GridFSDBFile file = this.gridFsTemplate.findOne(new Query(Criteria
                .where("filename").is(filename)));
        response.setCharacterEncoding("UTF-8");
        InputStream is = file.getInputStream();
        response.reset();
        response.setContentType("application/octet-stream;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment; filename="
                + filename);// 强制用户下载
        response.setHeader("Content_Length", is.available() + "");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) > 0)
            os.write(buffer, 0, len);
        os.flush();
        os.close();
        is.close();
        return null;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public GridFsTemplate getGridFsTemplate() {
        return gridFsTemplate;
    }

    public String getPath() {
        return filename;
    }

    @Resource
    public void setGridFsTemplate(GridFsTemplate gridFsTemplate) {
        this.gridFsTemplate = gridFsTemplate;
    }

    public void setPath(String path) {
        this.filename = path;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
