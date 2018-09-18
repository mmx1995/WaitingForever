package com.mmxin.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : mmxin
 * @className : menu
 * @date : 2018/9/12 10:53
 */
@Entity
public class Menu  implements Serializable {

    private static final long serialVersionUID = 4262272613344062898L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(length = 6)
    private String title ;

    @Column(length = 100)
    private String url ;

    @Column(length = 2)
    private boolean inUse ;

    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
