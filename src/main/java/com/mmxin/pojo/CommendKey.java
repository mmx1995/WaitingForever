package com.mmxin.pojo;

import java.io.Serializable;

public class CommendKey implements Serializable {
    private Integer storyid;

    private Integer userid;

    private static final long serialVersionUID = 1L;

    public Integer getStoryid() {
        return storyid;
    }

    public void setStoryid(Integer storyid) {
        this.storyid = storyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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
        CommendKey other = (CommendKey) that;
        return (this.getStoryid() == null ? other.getStoryid() == null : this.getStoryid().equals(other.getStoryid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStoryid() == null) ? 0 : getStoryid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        return result;
    }
}