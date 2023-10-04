package cn.com.project.controller;

//留言 控制器


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.project.domain.Ly;
import cn.com.project.service.CommService;
import cn.com.project.utils.Comm;

/**
 * 
 * @描述:留言controller
 * @作者:
 * @时间 2023年3月8日 下午5:39:37
 */
@Controller
@RequestMapping(value = "/comm")
public class LyController {
    @Autowired
    private CommService commService;

    Logger logger = LoggerFactory.getLogger(LyController.class);

    /**
     * 
     * @描述:添加留言信息
     * @作者:
     * @时间 2023年3月12日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/addLy")
    public String addLy(Ly record,
            HttpServletRequest request) throws Exception {
        //保存留言人id
        record.setAid(Comm.getUserInfoId(request));
        //留言人姓名
        record.setLname(Comm.getUserInfoName(request));
        commService.insertSelective(record);
        return "redirect:/comm/selLy";
    }

    /**
     * 
     * @描述:查看留言信息
     * @作者:
     * @时间 2023年3月12日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selLy")
    public ModelAndView selLy(Integer page, Ly cou,
            HttpServletRequest request) throws Exception {
        String role = Comm.getUserRole(request);
        ModelAndView mav = new ModelAndView();
        //用户查看自己留言的信息
        if ("3".equals(role)) {
            cou.setAid(Comm.getUserInfoId(request));
        }
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 10, true);
        List<Ly> list = commService.select(cou);

        PageInfo<Ly> pageInfo = new PageInfo<Ly>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("lastPage", pageInfo.getLastPage());
        mav.addObject("pageInfo", pageInfo);
        if ("0".equals(role) || "1".equals(role)) {
            mav.setViewName("comm/ly/sel");
        } else if ("3".equals(role)) {
            mav.setViewName("comm/ly/sel1");
        }
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询留言
     * @作者:
     * @时间 2023年3月12日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showLy")
    public ModelAndView showLy(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Ly c = commService.selectByLy(id);

        mav.addObject("data", c);
        mav.setViewName("comm/ly/hf");
        return mav;
    }

    /**
     * 
     * @描述:保存更新留言信息
     * @作者:
     * @时间 2023年3月12日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/updateLy")
    public String updateLy(Ly record) throws Exception {

        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selLy";

    }

    /**
     * 
     * @描述:删除留言信息
     * @作者:
     * @时间 2023年3月12日 下午5:39:37
     * @获取一个: 
     * @返回值:
     */
    @RequestMapping(value = "/deleteLy")
    public String deleteLy(Integer id) throws Exception {

        commService.deleteByLy(id);

        return "redirect:/comm/selLy";
    }

}
