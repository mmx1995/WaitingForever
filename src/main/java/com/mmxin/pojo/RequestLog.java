package com.mmxin.pojo;

import java.io.Serializable;
import java.util.Date;

public class RequestLog implements Serializable {
    private Integer id;

    private String url;

    private String method;

    private String classmethod;

    private String request;

    private String response;

    private String ip;

    private Date requesttime;

    private Date reponsetime;

    private Long usetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getClassmethod() {
        return classmethod;
    }

    public void setClassmethod(String classmethod) {
        this.classmethod = classmethod == null ? null : classmethod.trim();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(Date requesttime) {
        this.requesttime = requesttime;
    }

    public Date getReponsetime() {
        return reponsetime;
    }

    public void setReponsetime(Date reponsetime) {
        this.reponsetime = reponsetime;
    }

    public Long getUsetime() {
        return usetime;
    }

    public void setUsetime(Long usetime) {
        this.usetime = usetime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RequestLog other = (RequestLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getClassmethod() == null ? other.getClassmethod() == null : this.getClassmethod().equals(other.getClassmethod()))
            && (this.getRequest() == null ? other.getRequest() == null : this.getRequest().equals(other.getRequest()))
            && (this.getResponse() == null ? other.getResponse() == null : this.getResponse().equals(other.getResponse()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getRequesttime() == null ? other.getRequesttime() == null : this.getRequesttime().equals(other.getRequesttime()))
            && (this.getReponsetime() == null ? other.getReponsetime() == null : this.getReponsetime().equals(other.getReponsetime()))
            && (this.getUsetime() == null ? other.getUsetime() == null : this.getUsetime().equals(other.getUsetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getClassmethod() == null) ? 0 : getClassmethod().hashCode());
        result = prime * result + ((getRequest() == null) ? 0 : getRequest().hashCode());
        result = prime * result + ((getResponse() == null) ? 0 : getResponse().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getRequesttime() == null) ? 0 : getRequesttime().hashCode());
        result = prime * result + ((getReponsetime() == null) ? 0 : getReponsetime().hashCode());
        result = prime * result + ((getUsetime() == null) ? 0 : getUsetime().hashCode());
        return result;
    }
}