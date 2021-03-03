package com.lzc.entity;

public class FileSystem {
    private Integer id;
    private String fileName;
    private String fileParent;
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileParent() {
        return fileParent;
    }

    public void setFileParent(String fileParent) {
        this.fileParent = fileParent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "FileSystem{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileParent='" + fileParent + '\'' +
                ", level=" + level +
                '}';
    }
}
