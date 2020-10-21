package com.demo.mgnt.dao.util;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class DtoHelper{

    public static <E,D>D EoToDto(E e,Class<E> eClass,Class<D> dClass){
        String s = JSON.toJSONString(e);
        D d = JSON.parseObject(s,dClass);
        return d;
    }

    public static <E,D>List<D> EoListToDtoList(List<E> eList,Class<E> eClass,Class<D> dClass){
        List<D> dList=new ArrayList<D>();
        for (E e:eList
             ) {
            String s = JSON.toJSONString(e);
            D d = JSON.parseObject(s,dClass);
            dList.add(d);
        }
        return dList;
    }

}
