package com.lzc.mapper.impl;

import com.lzc.entity.FileSystem;
import com.lzc.mapper.FileSystemMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


public class FileSystemMapperImpl implements FileSystemMapper {

    @Override
    public List<FileSystem> getFileSystemList() {
        return null;
    }
}
