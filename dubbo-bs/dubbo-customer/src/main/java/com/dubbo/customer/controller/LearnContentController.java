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
    public Object selectAll(String id, String start, String num) {
        List<LearnContent> learnContents = learnContentService.selectAll(id,start,num);
        if(learnContents != null) return learnContents;
        else return "学习线路不存在!";
    }

    @GetMapping("/gethot")
    public Object selectHot(String id) {
        List<LearnContent> learnContents = learnContentService.selectHot(id);
        if(learnContents != null) return learnContents;
        else return "学习线路不存在!";
    }
    @GetMapping("/getrouterbyid")
    public Object getrouterbyid(String id){
        if(id != null) {
            List<LearnRouter1> learnRouter1s = learnContentService.getrouterbyid(id);
            if(learnRouter1s != null) return learnRouter1s;
            else return "线路没有内容!";
        }else return "参数缺失！";
    }
    @GetMapping("/getlearncontent1")
    public Object getlearncontent(String id,String author){
        List<LearnContent> learnContents = learnContentService.getlearncontent(id,author);
        if(learnContents != null) return learnContents;
        else return "没有该线路!";
    }
    @RequestMapping("/deletelearncontent")
    public String deletelearncontent(String id){
        if(id != null) {
            int a = learnContentService.deletelearncontent(id);
            if (a > 0) return "删除学习线路成功!";
            else return "删除学习线路失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/insertlearncontent")
    public String insertlearncontent(LearnContent learnContent){
        if(learnContent != null) {
            int a = learnContentService.insertlearncontent(learnContent);
            if (a > 0) return "添加学习线路成功!";
            else return "添加学习线路失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/updatelearncontent")
<<<<<<< HEAD
    public boolean updatelearncontent(LearnContent learnContent){
        return learnContentService.updatelearncontent(learnContent);
=======
    public String updatelearncontent(LearnContent learnContent){
        if(learnContent != null) {
            int a = learnContentService.updatelearncontent(learnContent);
            if (a > 0) return "修改学习线路成功!";
            else return "修改学习线路失败!";
        }else return "参数缺失！";
>>>>>>> b817bb3d3a22c0c4694457d79fcc82f7f0c6e5d4
    }

    @RequestMapping("/insertlearnrouter")
    public String insertlearnrouter(LearnRouter1 learnRouter1){
        if(learnRouter1 != null) {
            int a = learnContentService.insertlearnrouter(learnRouter1);
            if (a > 0) return "添加线路内容成功!";
            else return "添加线路内容失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/deletelearnrouter")
    public String deletelearnrouter(String id){
        if(id != null) {
            int a = learnContentService.deletelearnrouter(id);
            if (a > 0) return "删除线路内容成功!";
            else return "删除线路内容失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/updatelearnrouter")
    public String updatelearnrouter(LearnRouter1 learnRouter1){
        if(learnRouter1 != null) {
            int a = learnContentService.updatelearnrouter(learnRouter1);
            if (a > 0) return "修改线路内容成功!";
            else return "修改线路内容失败!";
        }else return "参数缺失！";
    }
    @RequestMapping("/updatelearnrouter1")
    public String updatelearnrouter1(LearnRouter1 learnRouter1){
        if(learnRouter1 != null) {
            int a = learnContentService.updatelearnrouter1(learnRouter1);
            if (a > 0) return "修改线路内容成功!";
            else return "修改线路内容失败!";
        }else return "参数缺失！";
    }

    @GetMapping("/1")
    public void getStreamData(HttpServletResponse response, String id, String zj) {
        File file = new File("F:\\bs\\video\\"+id+"\\"+zj+".mp4");
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
//                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    String trueFileName = zj+fileName.substring(fileName.indexOf("."));
                    path = "F:\\bs\\video\\"+title+"\\" + trueFileName;
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
        if("kc".equals(a.substring(0,2))) cc=1;
        else cc=2;
        byte[] imageContent ;
        String path = "your image path with image_name";
        try {
            imageContent = fileToByte(new File("F:\\bs\\image\\"+cc+"\\"+a));
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
        int cc;
        if("l".equals(a.substring(0,1))) cc=2;
        else cc=1;
        if (!file.isEmpty()) {
            try {
                String newCompanyImagepath = "F:\\bs\\image\\"+cc+"\\"+a;
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
