package com.qwm.spring1.bean;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author: wiming
 * @date: 2017-09-27 16:10:40  星期三
 * @decription:
 * 用于测试复杂类型注入
 */
public class ComplexBean implements Serializable {
    private Object[] arr;
    private List list;//List/Set 一样的
    private Map map;
    private Properties prop;

    //get/set方法
    public Object[] getArr() { return arr; }
    public void setArr(Object[] arr) { this.arr = arr; }
    public List getList() { return list; }
    public void setList(List list) { this.list = list; }
    public Map getMap() { return map; }
    public void setMap(Map map) { this.map = map; }
    public Properties getProp() { return prop; }
    public void setProp(Properties prop) { this.prop = prop; }

    @Override
    public String toString() { return "ComplexBean{arr=" + Arrays.toString(arr) + ", list=" + list + ", map=" + map + ", prop=" + prop + '}'; }
}