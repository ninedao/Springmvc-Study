package com.lzc.mapper;

import com.lzc.config.SpringApplicationConfig;
import com.lzc.entity.FileSystem;
import com.lzc.service.FileSystemService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MapperTest {
    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        FileSystemService fileSystemService = context.getBean("fileSystemService", FileSystemService.class);
        List<FileSystem> lists = fileSystemService.getFileSystemList();
        for(int i = 0; i < 10; i++){
            System.out.println(lists.get(i));
        }
    }
}
