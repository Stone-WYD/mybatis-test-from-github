package xyz.coolblog.chapter4.model;

import java.io.Serializable;
import java.util.List;

/**
 * Author
 *
 * @author Tian ZhongBo
 * @date 2018-07-14 21:54:45
 */
public class Author implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private String email;

    private List<Article> articleList;

    public Author() {
    }

    public Author(String name, Integer age, Integer sex, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public Author(Integer id, String name, Integer age, Integer sex, String email, List<Article> articleList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.articleList = articleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", articleList=" + articleList +
                '}';
    }
}
