package com.lzc.mapper.impl;

import com.lzc.entity.FileSystem;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class MapperHelper<T> {
//    @Autowired
//    protected SqlSessionFactory sqlSessionFactory;
//
//    protected List<T> getFileSystemList() {
//        return sqlSessionFactory.openSession().getMapper();
//    }
}
