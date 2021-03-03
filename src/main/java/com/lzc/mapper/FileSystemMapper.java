package com.lzc.mapper;

import com.lzc.entity.FileSystem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileSystemMapper {
    List<FileSystem> getFileSystemList();
}
