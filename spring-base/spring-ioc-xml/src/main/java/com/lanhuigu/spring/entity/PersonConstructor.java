package com.lanhuigu.spring.entity;

/**
 * 个人信息（构造器注入使用）
 */
public class PersonConstructor {

    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private int age;
    /**
     * 兴趣爱好
     */
    private String hobby;

    /**
     * 构造器注入时打开构造器--setter注入时注释掉构造器
     *
     * @param name
     * @param sex
     * @param age
     * @param hobby
     */
    public PersonConstructor(String name, String sex, int age, String hobby) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
