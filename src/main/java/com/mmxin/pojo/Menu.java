package com.mmxin.pojo;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.parentId
     *
     * @mbggenerated
     */
    private Long parentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.in_use
     *
     * @mbggenerated
     */
    private Boolean inUse;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.position
     *
     * @mbggenerated
     */
    private String position;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.updateTime
     *
     * @mbggenerated
     */
    private Date updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table menu
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.id
     *
     * @return the value of menu.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.id
     *
     * @param id the value for menu.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.parentId
     *
     * @return the value of menu.parentId
     *
     * @mbggenerated
     */
    public Long getParentid() {
        return parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.parentId
     *
     * @param parentid the value for menu.parentId
     *
     * @mbggenerated
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.title
     *
     * @return the value of menu.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.title
     *
     * @param title the value for menu.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.url
     *
     * @return the value of menu.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.url
     *
     * @param url the value for menu.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.in_use
     *
     * @return the value of menu.in_use
     *
     * @mbggenerated
     */
    public Boolean getInUse() {
        return inUse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.in_use
     *
     * @param inUse the value for menu.in_use
     *
     * @mbggenerated
     */
    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.position
     *
     * @return the value of menu.position
     *
     * @mbggenerated
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.position
     *
     * @param position the value for menu.position
     *
     * @mbggenerated
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.updateTime
     *
     * @return the value of menu.updateTime
     *
     * @mbggenerated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.updateTime
     *
     * @param updatetime the value for menu.updateTime
     *
     * @mbggenerated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.createTime
     *
     * @return the value of menu.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.createTime
     *
     * @param createtime the value for menu.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
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
        Menu other = (Menu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getInUse() == null ? other.getInUse() == null : this.getInUse().equals(other.getInUse()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getInUse() == null) ? 0 : getInUse().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }
}