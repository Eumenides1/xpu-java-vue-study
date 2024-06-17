package com.rookie.stack.mybatis.entity;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public class Major {

    private String id;

    private String name;

    private String mark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
