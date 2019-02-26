package com.example.demo.bean;

public class User {


    private long u_id;
//二
    private String u_name;

    private int u_age;

    private String u_desc;

    public void setU_id(long u_id) {
        this.u_id = u_id;
    }

    public long getU_id() {
        return u_id;
    }

    public void setU_name(String u_name) {
		this.u_name = u_name == null ? null : u_name.trim();
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_age(int u_age) {
        this.u_age = u_age;
    }

    public int getU_age() {
        return u_age;
    }

    public void setU_desc(String u_desc) {
		this.u_desc = u_desc == null ? null : u_desc.trim();
    }

    public String getU_desc() {
        return u_desc;
    }
}
