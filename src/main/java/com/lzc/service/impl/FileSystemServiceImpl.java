package com.lzc.service.impl;

import com.lzc.entity.FileSystem;
import com.lzc.mapper.FileSystemMapper;
import com.lzc.service.FileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("fileSystemService")
@Transactional
public class FileSystemServiceImpl implements FileSystemService {
    @Autowired
    private FileSystemMapper fileSystemMapper;
    @Override
    public List<FileSystem> getFileSystemList() {
        return fileSystemMapper.getFileSystemList();
    }
}
