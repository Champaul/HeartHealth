package cn.com.project.controller;

//文章 控制器


import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.project.domain.Gonggao;
import cn.com.project.service.CommService;
import cn.com.project.utils.Comm;
import cn.com.project.utils.DateUtils;
import cn.com.project.utils.FileUtil;

/**
 * 
 * @描述:文章controller
 * @作者:
 * @时间 2023年3月16日 下午5:39:37
 */
@Controller
@RequestMapping(value = "/comm")
public class GgController {
    @Autowired
    private CommService commService;

    Logger logger = LoggerFactory.getLogger(GgController.class);

    /**
     * 
     * @描述:添加文章
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/addGg")
    public String addKh(@RequestParam("file") MultipartFile file,
            Gonggao record, HttpServletRequest request) throws Exception {
        if (!file.isEmpty()) {
            // 获取文件名称,包含后缀          
            String fileName = file.getOriginalFilename();
            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
            String path = ClassUtils.getDefaultClassLoader().getResource("")
                    .getPath() + "static/";
            try {
                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法                
                FileUtil.fileupload(file.getBytes(), path, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入     
            record.setState(path + fileName);
        }
        record.setFname(Comm.getUserInfoName(request));
        record.setFdate(DateUtils.GetNowDate());
        record.setAid(Comm.getUserInfoId(request));
        record.setDz(0);
        record.setZd(0);
        commService.insertSelective(record);
        return "redirect:/comm/selGg";
    }

    /**
     * 
     * @描述:查看文章信息
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selGg")
    public ModelAndView selFl(Integer page, Gonggao g,
            HttpServletRequest request) throws Exception {
        String role = Comm.getUserRole(request);
        ModelAndView mav = new ModelAndView();
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 10, true);
        List<Gonggao> list = commService.select(g);
        for (Gonggao u1 : list) {
            if(u1.getState()!=null){
                u1.setState(
                        u1.getState().substring(u1.getState().lastIndexOf("/") + 1));
            }
        }
        list = list.stream()
                .sorted(Comparator.comparing(Gonggao::getZd).reversed())
                .collect(Collectors.toList());
        PageInfo<Gonggao> pageInfo = new PageInfo<Gonggao>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("lastPage", pageInfo.getLastPage());
        mav.addObject("pageInfo", pageInfo);
        if ("0".equals(role)) {
            mav.setViewName("comm/gg/sel");
        } else {
            mav.setViewName("comm/gg/sel1");
        }
        return mav;
    }

    /**
     * 
     * @描述:前台查看文章信息
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selXxYd")
    public ModelAndView selXx(Integer page, Gonggao g,
            HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Gonggao> list = commService.select(g);
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 100, true);
        PageInfo<Gonggao> pageInfo = new PageInfo<Gonggao>(list);
        list = list.stream()
                .sorted(Comparator.comparing(Gonggao::getZd).reversed())
                .collect(Collectors.toList());
        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("lastPage", pageInfo.getLastPage());
        mav.addObject("pageInfo", pageInfo);
        mav.setViewName("temp/team");
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询文章
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showXxYd")
    public ModelAndView showXx1(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Gonggao data = commService.selectByGg(id);
        if(data.getState()!=null) {
            data.setState(
                    data.getState().substring(data.getState().lastIndexOf("/") + 1));
        }
        mav.addObject("data", data);
        mav.setViewName("temp/news");
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询文章
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showGg")
    public ModelAndView showGg(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Gonggao data = commService.selectByGg(id);

        mav.addObject("data", data);
        mav.setViewName("comm/gg/update");
        return mav;
    }

    /**
     * 
     * @描述:跳转到查看内容信息页面
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selSp")
    public ModelAndView selSp(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Gonggao data = commService.selectByGg(id);

        mav.addObject("data", data);
        mav.setViewName("comm/gg/content");
        return mav;
    }

    /**
     * 
     * @描述:保存更新文章信息
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/updateGg")
    public String updateGg(Gonggao record) throws Exception {

        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selGg";
    }
    
    /**
     * 
     *
     * @描述:点赞
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/zan")
    public String zan(Gonggao record) throws Exception {
        Gonggao data = commService.selectByGg(record.getId());
        Integer num = data.getDz();
        record.setDz(num + 1);
        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selXxYd";
    }

    /**
     * 
     * @描述:置顶
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/zd")
    public String zd(Gonggao record) throws Exception {
        record.setZd(1);
        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selGg";
    }
    
    /**
     * 
     * @描述:取消置顶
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/qxzd")
    public String qxzd(Gonggao record) throws Exception {
        record.setZd(0);
        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selGg";
    }

    /**
     * 
     * @描述:删除文章信息
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: 
     * @返回值:
     */
    @RequestMapping(value = "/deleteGg")
    public String deleteGg(Integer id) throws Exception {
        commService.deleteByGg(id);
        return "redirect:/comm/selGg";
    }
}
