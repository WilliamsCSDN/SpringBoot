package com.dubbo.customer.controller;


import com.dubbo.api.model.LearnContent;
import com.dubbo.api.model.LearnRouter1;
import com.dubbo.api.service.LearnContentService;
import com.dubbo.api.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@RestController
@CrossOrigin
public class LearnContentController {
    @Resource
    LearnContentService learnContentService;
    @Resource
    SearchService searchService;

    @GetMapping("/getlearncontent")
    public List<LearnContent> selectAll(String id, String start, String num) {

        return learnContentService.selectAll(id,start,num);
    }

    @GetMapping("/gethot")
    public List<LearnContent> selectHot(String id) {
        return learnContentService.selectHot(id);
    }
    @GetMapping("/getrouterbyid")
    public Object getrouterbyid(String id){
        return learnContentService.getrouterbyid(id);
    }
    @GetMapping("/getlearncontent1")
    public List<LearnContent> getlearncontent(String id,String author){return learnContentService.getlearncontent(id,author);}

    @RequestMapping("/deletelearncontent")
    public void deletelearncontent(String id){learnContentService.deletelearncontent(id);}
    @RequestMapping("/insertlearncontent")
    public void insertlearncontent(LearnContent learnContent){learnContentService.insertlearncontent(learnContent);}
    @RequestMapping("/updatelearncontent")
    public void updatelearncontent(LearnContent learnContent){
        learnContentService.updatelearncontent(learnContent);
    }

    @RequestMapping("/insertlearnrouter")
    public void insertlearnrouter(LearnRouter1 learnRouter1){
        learnContentService.insertlearnrouter(learnRouter1);
    }
    @RequestMapping("/deletelearnrouter")
    public void deletelearnrouter(String id){learnContentService.deletelearnrouter(id);}
    @RequestMapping("/updatelearnrouter")
    public void updatelearnrouter(LearnRouter1 learnRouter1){learnContentService.updatelearnrouter(learnRouter1);}
    @RequestMapping("/updatelearnrouter1")
    public void updatelearnrouter1(LearnRouter1 learnRouter1){learnContentService.updatelearnrouter1(learnRouter1);}


    @GetMapping("/1")
    public void getStreamData(HttpServletResponse response, String id, String zj) {
        File file = new File("E:\\bs\\video\\"+id+"\\"+zj+".mp4");
        ServletOutputStream out = null;
        try {
            FileInputStream instream = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length = 0;
            BufferedInputStream buf = new BufferedInputStream(instream);

            out = response.getOutputStream();
            BufferedOutputStream bot = new BufferedOutputStream(out);
            while ((length = buf.read(b)) != -1) {
                bot.write(b, 0, b.length);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @PostMapping("/2")
    public String uploadWork(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        request.setCharacterEncoding("UTF-8");
        String zj = request.getParameter("zj");
        String title = request.getParameter("title");

        if(!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {
                if ("mp4".equals(type.toUpperCase())||"MP4".equals(type.toUpperCase())) {
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    String trueFileName = zj+fileName.substring(fileName.indexOf("."));
                    path = "E:\\bs\\video\\"+title+"\\" + trueFileName;
                    File dest = new File(path);
                    if (!dest.getParentFile().exists()) {
                        dest.getParentFile().mkdir();
                    }
                    file.transferTo(dest);
                    return trueFileName;
                }else {
                    return "error";
                }
            }else {
                return "error";
            }
        }else {
            return "error";
        }
    }
    @RequestMapping(value = "/3",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(HttpServletResponse response, String a){
        int cc;
        System.out.println(a.substring(0,2));
        if("kc".equals(a.substring(0,2))) cc=1;
        else cc=2;
        byte[] imageContent ;
        String path = "your image path with image_name";
        try {
            imageContent = fileToByte(new File("E:\\bs\\image\\"+cc+"\\"+a));
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static byte[] fileToByte(File img) throws Exception {
        byte[] bytes = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            BufferedImage bi;
            bi = ImageIO.read(img);
            ImageIO.write(bi, "png", baos);
            bytes = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baos.close();
        }
        return bytes;
    }
    @RequestMapping("/4")
    public String addImage(@RequestParam(name = "image_data", required = false) MultipartFile file,String a) {
        //文件上传
        int cc;
        if("l".equals(a.substring(0,1))) cc=2;
        else cc=1;
        if (!file.isEmpty()) {
            try {
                String newCompanyImagepath = "E:\\bs\\image\\"+cc+"\\"+a;
                File newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "图片上传失败！";
            } catch (IOException e) {
                e.printStackTrace();
                return "图片上传失败！";
            }
        }
        return "图片上传失败！";
    }





}
