package com.atguigu.java2;

import java.util.List;

/**
 * DAO:data(base) access object
 *
 * @author: 86173
 * @date: 2021/4/19 10:08
 */
public class DAO<T> {//表的共性操作

    //添加一条记录
    public void add(T t){}

    //删除一条记录
    public boolean remove(int index){
        return false;
    }

    //修改一条记录
    public void update(int index,T t){

    }

    //查询一条记录
    public T getIndex(int index){
        return null;
    }

    //查询多条记录
    public List<T> getForList(int index){

        return null;
    }
    //泛型方法
    public <E> E getValue(){

        return null;
    }

}
