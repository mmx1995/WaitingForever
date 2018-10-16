package com.mmxin.pojo;

import java.io.Serializable;
import java.util.Date;

public class StoryHistory extends StoryHistoryKey implements Serializable {
    private String storytitle;

    private String storysummary;

    private String topic;

    private String label;

    private Integer authorid;

    private String status;

    private Integer replynumber;

    private Integer commentnumber;

    private Date createtime;

    private String storycontent;

    private static final long serialVersionUID = 1L;

    public String getStorytitle() {
        return storytitle;
    }

    public void setStorytitle(String storytitle) {
        this.storytitle = storytitle == null ? null : storytitle.trim();
    }

    public String getStorysummary() {
        return storysummary;
    }

    public void setStorysummary(String storysummary) {
        this.storysummary = storysummary == null ? null : storysummary.trim();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getReplynumber() {
        return replynumber;
    }

    public void setReplynumber(Integer replynumber) {
        this.replynumber = replynumber;
    }

    public Integer getCommentnumber() {
        return commentnumber;
    }

    public void setCommentnumber(Integer commentnumber) {
        this.commentnumber = commentnumber;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStorycontent() {
        return storycontent;
    }

    public void setStorycontent(String storycontent) {
        this.storycontent = storycontent == null ? null : storycontent.trim();
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
        StoryHistory other = (StoryHistory) that;
        return (this.getStoryid() == null ? other.getStoryid() == null : this.getStoryid().equals(other.getStoryid()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getStorytitle() == null ? other.getStorytitle() == null : this.getStorytitle().equals(other.getStorytitle()))
            && (this.getStorysummary() == null ? other.getStorysummary() == null : this.getStorysummary().equals(other.getStorysummary()))
            && (this.getTopic() == null ? other.getTopic() == null : this.getTopic().equals(other.getTopic()))
            && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
            && (this.getAuthorid() == null ? other.getAuthorid() == null : this.getAuthorid().equals(other.getAuthorid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getReplynumber() == null ? other.getReplynumber() == null : this.getReplynumber().equals(other.getReplynumber()))
            && (this.getCommentnumber() == null ? other.getCommentnumber() == null : this.getCommentnumber().equals(other.getCommentnumber()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getStorycontent() == null ? other.getStorycontent() == null : this.getStorycontent().equals(other.getStorycontent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStoryid() == null) ? 0 : getStoryid().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getStorytitle() == null) ? 0 : getStorytitle().hashCode());
        result = prime * result + ((getStorysummary() == null) ? 0 : getStorysummary().hashCode());
        result = prime * result + ((getTopic() == null) ? 0 : getTopic().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        result = prime * result + ((getAuthorid() == null) ? 0 : getAuthorid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReplynumber() == null) ? 0 : getReplynumber().hashCode());
        result = prime * result + ((getCommentnumber() == null) ? 0 : getCommentnumber().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getStorycontent() == null) ? 0 : getStorycontent().hashCode());
        return result;
    }
}