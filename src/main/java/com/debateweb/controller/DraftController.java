package com.debateweb.controller;

import com.debateweb.entity.Draft;
import com.debateweb.entity.User;
import com.debateweb.service.DraftService;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * (Draft)表控制层
 *
 * @author makejava
 * @since 2020-03-26 15:29:23
 */
@Controller
@RequestMapping("draft")
public class DraftController {
    /**
     * 服务对象
     */
    @Resource
    private DraftService draftService;

    @PostMapping("/search")
    public ModelAndView queryByKeyword(@RequestParam String keyword){
        ModelAndView mv = new ModelAndView();
        List<Draft> drafts = draftService.queryByKeyword(keyword);
        mv.addObject("drafts", drafts);
        mv.setViewName("front/draftPages/draft-list");
        return mv;
    }

    @PostMapping("/upload")
    public String draftUpload(HttpServletRequest request, MultipartFile draft, @RequestParam String draftName, @RequestParam String draftSchool, @RequestParam String draftType) throws Exception {
        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/drafts/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }
        //说明上传文件项
        //获取上传文件的名称
        String filename = draft.getOriginalFilename();
        //把文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        draft.transferTo(new File(path, filename));
        //获取当前用户
        HttpSession session = request.getSession();
        User uploader = (User) session.getAttribute("loginUser");
        //获取当前用户名
        String nickname = uploader.getNickname();
        //获取当前用户id
        Integer Uid = uploader.getId();
        String address = "../../../drafts/" + filename;
        if (draftService.upload(draftName, draftSchool, draftType, nickname, address, Uid)) {
            return "SorF/success";
        }
        return "SorF/fail";
    }

    //无法正常运行，重定向稿件路径错误
/*    @RequestMapping("download")
    public String download(@RequestParam(name = "did", required = true) Integer did) {
        Draft draft = this.draftService.queryById(did);
        draft.setDowntimes(draft.getDowntimes() + 1);
        this.draftService.update(draft);
        return "redirect:"+draft.getAddress();
    }*/

    //分页查询所有稿件
    @RequestMapping("findAll")
    public String findAll(Map<String, Object> map, @RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size", required = true,defaultValue = "5") int size) {
        map.put("pageInfo", this.draftInfo(page,size));
        return "back/draftPages/draft-list";
    }

    //跳转到修改页面
    @RequestMapping("revise")
    public String revise(Map<String, Object> map, @RequestParam(name = "did", required = true, defaultValue = "1") int did) {
        Draft draft = draftService.queryById(did);
        map.put("draft", draft);
        return "back/draftPages/draft-revise";
    }

    @RequestMapping("update")
    public String update(@RequestParam Integer did,
                         @RequestParam String draftName,
                         @RequestParam String draftSchool,
                         @RequestParam String draftType) {
        Draft draft = new Draft();
        draft.setDid(did);
        draft.setDraftname(draftName);
        draft.setDraftschool(draftSchool);
        draft.setDrafttype(draftType);
        if (this.draftService.update(draft)) {
            return "SorF/draftUpdate-success";
        }
        return "SorF/Update-fail";
    }

    //删除稿件数据
    @RequestMapping("delete")
    public String deleteById(Map<String, Object> map, @RequestParam(name = "did", required = true) int did) {
        //根据id删除稿件数据
        this.draftService.deleteById(did);
        //加载数据重新跳转到视频列表页面
        map.put("pageInfo", this.draftInfo(1, 5));
        return "back/draftPages/draft-list";
    }

    /**
     * 得到视频分页数据
     *
     * @param page 页码
     * @param size 每页大小
     * @return  分页Bean
     */
    public PageInfo draftInfo(int page, int size) {
        //获取稿件数据并进行分页处理
        List<Draft> drafts = draftService.queryAll(page, size);
        //PageInfo 为一个分页Bean
        PageInfo pageInfo = new PageInfo(drafts);
        return pageInfo;
    }

    @RequestMapping("reading")
    public String reading(Map<String, Object> map, @RequestParam(name = "did", required = true) int did) throws IOException {
        Draft draft = draftService.queryById(did);
        //获取稿件路径
        String address = draft.getAddress();
        //删除路径前面的相对路径部分，得到文件名
        address = address.substring(8, address.length());
        //将文件名改为绝对路径
        address = "F:\\IDEAproject\\debate_website\\target\\debate_website"+address;
        //检测后缀名
        String addressFormat = address.substring(address.length() - 4, address.length());
        File file = new File(address);
        String buffer = "";
        FileInputStream is = new FileInputStream(file);
        try {
            //doc格式文件
            if (addressFormat.equals(".doc")) {
                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();
            //docx格式文件
            } else if (addressFormat.equals("docx")) {
                XWPFDocument xdoc = new XWPFDocument(is);
                XWPFWordExtractor ex = new XWPFWordExtractor(xdoc);
                buffer = ex.getText();
                ex.close();
            }
            //添加稿件名
            map.put("draftName", draft.getDraftname());
            //添加稿件内容
            map.put("draftContent", buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return "front/draftPages/draft-reading";
    }
}