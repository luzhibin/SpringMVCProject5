package web.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.Executable;
import java.net.URLEncoder;

@Controller
public class MyController {
    @RequestMapping("/download/{filename:.+}")
    public ResponseEntity download(@PathVariable String filename,HttpSession session) throws Exception {
        System.out.println(filename);

        //1.获取文件路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/download/" + filename);

        //2.二进制输入流把文件读到程序中
        InputStream io = new FileInputStream(realPath);
        byte[] body = new byte[io.available()];
        io.read(body);

        //3.创建请求头，直接响应给浏览器
        HttpHeaders httpHeaders = new HttpHeaders();

        //解决中文文件名称乱码问题
        filename = URLEncoder.encode(filename,"UTF-8");
        //创建响应头并以附件形式下载，并且传入文件名
        httpHeaders.add("Content-Disposition","attachment;filename"+filename);

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, httpHeaders, HttpStatus.OK);
        System.out.println(responseEntity);

        return responseEntity;
    }
    @RequestMapping("upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file,HttpSession session) throws IOException {
        //CommonsMultipartResolver会把上传的文件进行封装
        System.out.println("表单项name属性名称："+file.getName());
        System.out.println("文件名："+file.getOriginalFilename());
        System.out.println("文件类型："+file.getContentType());
        System.out.println("文件大小："+file.getSize());

        //确定上传的路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        File uploadPath = new File(realPath);
        if (!uploadPath.exists()){//如果路径不存在，创建一个新的
            uploadPath.mkdirs();
        }//

        //需要的最终路径是:文件夹路径+文件名
        String filename = file.getOriginalFilename();
        uploadPath = new File(uploadPath+"/"+filename);

        //开始上传
        file.transferTo(uploadPath);

        return "success";

    }

    @RequestMapping("exception")
    public String exception(){
        int i = 1/0;
        return "success";
    }

/*    @ExceptionHandler(value = ArithmeticException.class)
    public String doexception1(Exception ex){
        System.out.println(ex);
        return "error";
    }
    @ExceptionHandler(value = RuntimeException.class)
    public String doexception2(Exception ex){
        System.out.println(ex);
        return "error";
    }

    @ExceptionHandler(value = Exception.class)
    public String doexception3(Exception ex){
        System.out.println(ex);
        return "error";
    }*/

    @RequestMapping("local")
    public String local(){
        return "local";
    }
}
