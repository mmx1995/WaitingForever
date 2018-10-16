package com.mmxin.pojo;

import java.io.Serializable;
import java.util.Date;

public class StoryHistoryKey implements Serializable {
    private Integer storyid;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getStoryid() {
        return storyid;
    }

    public void setStoryid(Integer storyid) {
        this.storyid = storyid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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
        StoryHistoryKey other = (StoryHistoryKey) that;
        return (this.getStoryid() == null ? other.getStoryid() == null : this.getStoryid().equals(other.getStoryid()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStoryid() == null) ? 0 : getStoryid().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }
}