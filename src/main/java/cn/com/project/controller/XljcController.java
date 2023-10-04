package cn.com.project.controller;

//帖子 控制器
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.project.domain.Diaocha;
import cn.com.project.domain.User;
import cn.com.project.service.CommService;
import cn.com.project.service.UserService;
import cn.com.project.utils.Comm;
import cn.com.project.utils.DateUtils;
import cn.com.project.utils.FileUtil;

/**
 * 
 * @描述:帖子controller
 * @作者:
 * @时间 2023年3月16日 下午5:39:37
 */
@Controller
@RequestMapping(value = "/comm")
public class XljcController {
    @Autowired
    private CommService commService;

    @Autowired
    private UserService userService;

    /**
     * 
     * @描述:添加帖子信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/addDc")
    public String addKh(@RequestParam("file") MultipartFile file,
            Diaocha record, HttpServletRequest request) throws Exception {
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
            record.setPhoto(path + fileName);
        }
        record.setAid(Comm.getUserInfoId(request));
        //添加日期
        record.setDcrq(DateUtils.GetNowDate());
        //添加人
        record.setLname(Comm.getUserInfoName(request));
        record.setKid(0);
        commService.insertSelective(record);
        return "redirect:/comm/selDc";
    }

    /**
     * 
     * @描述:查看帖子信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selDc")
    public ModelAndView selDc(Integer page, Diaocha g,
            HttpServletRequest request) throws Exception {
        String role = Comm.getUserRole(request);
        if ("1".equals(role)) {
            g.setAid(Comm.getUserInfoId(request));
        }
        ModelAndView mav = new ModelAndView();
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 10, true);
        List<Diaocha> list = commService.select(g);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Diaocha u1 : list) {
                if (u1.getPhoto()!=null) {
                    u1.setPhoto(u1.getPhoto()
                        .substring(u1.getPhoto().lastIndexOf("/") + 1));
                }
            }
        }
        PageInfo<Diaocha> pageInfo = new PageInfo<Diaocha>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("lastPage", pageInfo.getLastPage());
        mav.addObject("pageInfo", pageInfo);
        if ("0".equals(role)) {
            mav.setViewName("comm/dc/sel");
        } else if ("3".equals(role)) {
            mav.setViewName("comm/dc/sel1");
        }
        return mav;
    }

    /**
     * 
     * @描述:前端查看帖子信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selTz")
    public ModelAndView selTz(Integer page, Diaocha g,
            HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 100, true);
        List<Diaocha> list = commService.select(g);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Diaocha u1 : list) {
                if (u1.getPhoto()!=null) {
                    u1.setPhoto(u1.getPhoto()
                        .substring(u1.getPhoto().lastIndexOf("/") + 1));
                }
            }
        }
        PageInfo<Diaocha> pageInfo = new PageInfo<Diaocha>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("lastPage", pageInfo.getLastPage());
        mav.setViewName("temp/tz");
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询帖子
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showTz")
    public ModelAndView showTz(Integer id, User u) throws Exception {
        ModelAndView mav = new ModelAndView();
        Diaocha data = commService.selectByDc(id);
        if (data.getPhoto()!=null) {
            data.setPhoto(data.getPhoto()
                    .substring(data.getPhoto().lastIndexOf("/") + 1));
        }
        mav.addObject("data", data);
        mav.setViewName("temp/tzxx");
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
    @RequestMapping(value = "/selSp1")
    public ModelAndView selSp(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Diaocha data = commService.selectByDc(id);

        mav.addObject("data", data);
        mav.setViewName("comm/dc/content");
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询帖子
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showDc")
    public ModelAndView showDc(Integer id, User u) throws Exception {
        ModelAndView mav = new ModelAndView();
        Diaocha data = commService.selectByDc(id);

        mav.addObject("data", data);
        mav.setViewName("comm/dc/update");
        return mav;
    }
    
    /**
     * 
     * @描述:点赞
     * @作者:
     * @时间 2023年3月16日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/zan1")
    public String zan(Diaocha record) throws Exception {
        Diaocha data = commService.selectByDc(record.getId());
        Integer num = data.getKid();
        record.setKid(num + 1);
        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selTz";
    }

    /**
     * 
     * @描述:保存更新帖子信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/updateDc")
    public String updateGg(Diaocha record) throws Exception {

        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selDc";
    }

    /**
     * 
     * @描述:删除帖子信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: 
     * @返回值:
     */
    @RequestMapping(value = "/deleteDc")
    public String deleteDc(Integer id) throws Exception {

        commService.deleteByDc(id);

        return "redirect:/comm/selDc";
    }
}
