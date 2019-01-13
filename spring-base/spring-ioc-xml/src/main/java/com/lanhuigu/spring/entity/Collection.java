package com.lanhuigu.spring.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Spring 注入集合
 */
public class Collection {
    private Set<String> set;
    private List<String> list;
    private Map<String, String> map;
    private String[] array;

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "  set=" + set +
                ", list=" + list +
                ", map=" + map +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
