package com.qd.news.template;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.qd.news.util.PageSpliter;

/**
 * Action模板
 * @author QingDao
 */
@SuppressWarnings({ "serial" })
public class ActionTemplate extends ActionSupport implements
        ServletRequestAware {

    public String keyId;
    public Integer page;// this field for easyui
    private HttpServletRequest request;

    private Map<String, Object> result = null;

    public Integer rows;// this field for easyui

    public String ROWS = "rows";// this field for result

    private HttpSession session;

    public Integer total;// this field for easyui

    public String TOTAL = "total";// this field for result

    private PageSpliter pageSpliter;

    public PageSpliter getPageSpliter() {
        return pageSpliter;
    }

    @Resource
    public void setPageSpliter(PageSpliter pageSpliter) {
        this.pageSpliter = pageSpliter;
    }

    public ActionTemplate() {
        result = new HashMap<String, Object>();
        result.put("success", true);
    }

    public String getKeyId() {
        return keyId;
    }

    public Integer getPage() {
        return page;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public Integer getRows() {
        return rows;
    }

    public String getROWS() {
        return ROWS;
    }

    public HttpSession getSession() {
        return session;
    }

    public Integer getTotal() {
        return total;
    }

    public String getTOTAL() {
        return TOTAL;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public void setROWS(String rOWS) {
        ROWS = rOWS;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        this.session = request.getSession();
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setTOTAL(String tOTAL) {
        TOTAL = tOTAL;
    }
}
