package com.mmxin.pojo;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
    private Integer replyid;

    private String replycontent;

    private Integer parentreply;

    private Integer storyid;

    private String status;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public Integer getParentreply() {
        return parentreply;
    }

    public void setParentreply(Integer parentreply) {
        this.parentreply = parentreply;
    }

    public Integer getStoryid() {
        return storyid;
    }

    public void setStoryid(Integer storyid) {
        this.storyid = storyid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        Reply other = (Reply) that;
        return (this.getReplyid() == null ? other.getReplyid() == null : this.getReplyid().equals(other.getReplyid()))
            && (this.getReplycontent() == null ? other.getReplycontent() == null : this.getReplycontent().equals(other.getReplycontent()))
            && (this.getParentreply() == null ? other.getParentreply() == null : this.getParentreply().equals(other.getParentreply()))
            && (this.getStoryid() == null ? other.getStoryid() == null : this.getStoryid().equals(other.getStoryid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReplyid() == null) ? 0 : getReplyid().hashCode());
        result = prime * result + ((getReplycontent() == null) ? 0 : getReplycontent().hashCode());
        result = prime * result + ((getParentreply() == null) ? 0 : getParentreply().hashCode());
        result = prime * result + ((getStoryid() == null) ? 0 : getStoryid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }
}