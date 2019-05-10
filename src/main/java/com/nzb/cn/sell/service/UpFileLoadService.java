package com.nzb.cn.sell.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UpFileLoadService {

    List<Object> get(String filePath);

    Boolean getUploadList(String filePath);

     void upLoadImg(String path)throws IOException;
}
