package cn.com.project.controller;

import java.awt.Font;
import java.awt.Rectangle;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.project.domain.Bf;
import cn.com.project.domain.Lxr;
import cn.com.project.domain.Message;
import cn.com.project.domain.Order;
import cn.com.project.domain.Schedule;
import cn.com.project.domain.User;
import cn.com.project.service.CommService;
import cn.com.project.service.UserService;
import cn.com.project.utils.Comm;
import cn.com.project.utils.DateUtils;
import cn.com.project.utils.DecisionTreeUtil;


/**
 * 
 * @描述:测试controller
 * @作者:
 * @时间 2023年3月16日 下午5:39:37
 */
@Controller
@RequestMapping(value = "/comm")
public class CommController {
    @Autowired
    private CommService commService;

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(CommController.class);

    /**
     * @描述: 心理测试分析
     * @作者:
     * @时间 2023年2月26日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selFx")
    public ModelAndView selXb(HttpServletRequest request,
                              HttpServletResponse response, HttpSession session,
                              Bf g) throws Exception {
        String role = Comm.getUserRole(request);

        //匹配三种结果 健康 亚健康 需要就医
        if ("3".equals(role)) {
            g.setAid(Comm.getUserInfoId(request));
        }

        ModelAndView mav = new ModelAndView();
        List<Bf> list = commService.selectTj(g);
        DefaultPieDataset dataset = new DefaultPieDataset();


        if (list.size() > 0) {
            for (Bf row : list) {
                dataset.setValue(row.getFk(), row.getNumber());
            }
        }

        JFreeChart chart = ChartFactory.createPieChart3D("心理测试分析", dataset,
                true, true, true);
        // 副标题
        chart.addSubtitle(new TextTitle("2023年度"));

        PiePlot pieplot = (PiePlot) chart.getPlot();
        pieplot.setLabelFont(new Font("宋体", 0, 11));
        // 设置饼图是圆的（true），还是椭圆的（false）；默认为true
        pieplot.setCircular(true);
        // 没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据显示");


        StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator(
                "{0}:({1}.{2})", NumberFormat.getNumberInstance(),
                NumberFormat.getPercentInstance());
        pieplot.setLabelGenerator(standarPieIG);

        PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();

        //设置开始角度

        pieplot3d.setStartAngle(120D);
        //设置方向为”顺时针方向“
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        //设置透明度，0.5F为半透明，1为不透明，0为全透明
        pieplot3d.setForegroundAlpha(0.7F);
        String filename = ServletUtilities.saveChartAsPNG(chart, 800, 500, null,
                session);


        request.setAttribute("filename", filename);

        mav.setViewName("admin/count/selFx");
        return mav;
    }

    /**
     * 使用 JFreeChart 技术画折线图
     *
     * @describe
     * @author zfc
     * @date 2017年12月28日 下午7:21:51
     */
    @RequestMapping(value = "/history")
    public Object selXHis(HttpServletRequest request,
                          HttpServletResponse response, HttpSession session,Bf g) throws Exception {
        String role = Comm.getUserRole(request);

        //匹配三种结果 健康 亚健康 需要就医
        if ("3".equals(role)) {
            g.setAid(Comm.getUserInfoId(request));
        }

        ModelAndView mav = new ModelAndView();
        List<Bf> list = commService.select(g);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if (list.size() > 0) {
            for (Bf row : list) {

                dataset.addValue(Double.parseDouble(row.getLname()), "心理健康概率", row.getBfrq());
            }
        }

                // 数据编辑
//                dataset.addValue(98, "数学", "张三");
//                dataset.addValue(68, "数学", "李四");
//                dataset.addValue(56, "数学", "王五");

                JFreeChart chart = ChartFactory.createLineChart("心理健康测试历史记录", // 主标题的名称
                        "日期", // X轴的标签
                        "概率", // Y轴的标签
                        (CategoryDataset) dataset, // 图标显示的数据集合
                        PlotOrientation.VERTICAL, // 图像的显示形式（水平或者垂直）
                        true, // 是否显示子标题
                        true, // 是否生成提示的标签
                        true); // 是否生成URL链接 // 处理图形上的乱码 // 处理主标题的乱码
                chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
                // 处理子标题乱码
                chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
                // 获取图表区域对象
                CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
                // 获取X轴的对象
                CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
                // 获取Y轴的对象
                NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
                // 处理X轴上的乱码
                categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
                // 处理X轴外的乱码
                categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
                // 处理Y轴上的乱码
                numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
                // 处理Y轴外的乱码
                numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
                // 处理Y轴上显示的刻度，以10作为1格
                numberAxis.setAutoTickUnitSelection(false);
                NumberTickUnit unit = new NumberTickUnit(10);




                numberAxis.setTickUnit(unit);
                // 获取绘图区域对象   11111
                LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
                // 在图形上显示数字
                lineAndShapeRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
                lineAndShapeRenderer.setBaseItemLabelsVisible(true);
                lineAndShapeRenderer.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));
                // 在图形上添加转折点（使用小矩形显示）
                Rectangle shape = new Rectangle(10, 10);
                lineAndShapeRenderer.setSeriesShape(0, shape);
                lineAndShapeRenderer.setSeriesShapesVisible(0, true);


                /* 8、生成相应的图片 */
                File file = new File("LineChart.JPEG");
                try {
                    ChartUtilities.saveChartAsJPEG(file, chart, 1600, 1200);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 使用ChartFrame对象显示图像
//                ChartFrame frame = new ChartFrame("zfc", chart);
        //         frame.setVisible(true);
//                frame.pack();

        String filename = ServletUtilities.saveChartAsPNG(chart, 1600, 1200, null,
                session);
                request.setAttribute("filename",filename);



        mav.setViewName("admin/count/History");
        return mav;

    }



    /**
     * 
     * @描述:添加出诊信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/addRc")
    public String addRc(Schedule record,
            HttpServletRequest request) throws Exception {

        commService.insertSelective(record);
        return "redirect:/comm/selRc";
    }

    /**
     * 
     * @描述:查看出诊信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selRc")
    public ModelAndView selDc(Integer page, Schedule g,
            HttpServletRequest request) throws Exception {
        String role = Comm.getUserRole(request);
        ModelAndView mav = new ModelAndView();
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 10, true);
        List<Schedule> list = commService.select(g);

        PageInfo<Schedule> pageInfo = new PageInfo<Schedule>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("pageInfo", pageInfo);
        if ("0".equals(role)) {
            mav.setViewName("comm/rc/sel");
        } else {
            mav.setViewName("comm/rc/sel1");
        }
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询出诊
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showRc")
    public ModelAndView showRc(Integer id, User u) throws Exception {
        ModelAndView mav = new ModelAndView();
        Schedule data = commService.selectByRc(id);
        u.setRole("1");
        List<User> userList = userService.selectUserList(u);

        mav.addObject("data", data);
        mav.addObject("list", userList);
        mav.setViewName("comm/rc/update");
        return mav;
    }

    /**
     * 
     * @描述:保存更新出诊信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/updateRc")
    public String updateRc(Schedule record) throws Exception {

        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selRc";
    }

    /**
     * 
     * @描述:删除出诊信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: 
     * @返回值:
     */
    @RequestMapping(value = "/deleteRc")
    public String deleteRc(Integer id) throws Exception {

        commService.deleteByRc(id);

        return "redirect:/comm/selRc";
    }
    
    /**
     * 
     * @描述:添加预约
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/addDd")
    @ResponseBody
    public Map<String, Object> add(Order record,
            HttpServletRequest request) throws Exception {
        Order o = new Order();
        o.setDdrq(record.getDdrq());
        o.setAid(record.getAid());
        Map<String, Object> map = new HashMap<String, Object>();
        List<Order> list = commService.select(o);
        record.setKid(Comm.getUserInfoId(request));
        record.setState("未预约");
        commService.insertSelective(record);
        map.put("flag", "预约成功");
        return map;
    }

    /**
     * 
     * @描述:查看预约信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selDd")
    public ModelAndView selDd(Integer page, Order g,
            HttpServletRequest request) throws Exception {
        String role = Comm.getUserRole(request);
        if ("3".equals(role)) {
            g.setKid(Comm.getUserInfoId(request));
        }
        ModelAndView mav = new ModelAndView();
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 10, true);
        List<Order> list = commService.select(g);

        PageInfo<Order> pageInfo = new PageInfo<Order>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("pageInfo", pageInfo);
        if ("0".equals(role)) {
            mav.setViewName("comm/dd/sel");
        } else if ("3".equals(role)) {
            mav.setViewName("comm/dd/sel2");
        } else {
            mav.setViewName("comm/dd/sel1");
        }
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询预约
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showDd")
    public ModelAndView showDd(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Order data = commService.selectByDd(id);
        User u = new User();
        u.setRole("3");
        List<User> list = userService.selectUserList(u);
        mav.addObject("list", list);
        mav.addObject("data", data);
        mav.setViewName("comm/dd/update");
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询预约
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showSp")
    public ModelAndView showSp(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Order data = commService.selectByDd(id);
        mav.addObject("data", data);
        mav.setViewName("comm/dd/sp");
        return mav;
    }
    
    /**
     * 
     * @描述:保存更新预约信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/ty")
    public String ty(Order record) throws Exception {
        record.setState("已预约");
        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selDd";
    }
    
    /**
     * 
     * @描述:保存更新预约信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/updateDd")
    public String updateDd(Order record) throws Exception {

        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selDd";
    }

    /**
     * 
     * @描述:删除预约信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: 
     * @返回值:
     */
    @RequestMapping(value = "/deleteDd")
    public String deleteDd(Integer id) throws Exception {

        commService.deleteByDd(id);

        return "redirect:/comm/selDd";
    }
    /**
     * 
     * @描述: 跳转到答题页面
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/tzcs")
    public ModelAndView tzcs(Message g) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Message> list = commService.select(g);

        mav.addObject("list", list);
        mav.setViewName("comm/cs/add");
        return mav;
    }

    /**
     * 
     * @描述:添加测试记录信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/addBf")
    public String addBf(Bf record, Message g,
            HttpServletRequest request) throws Exception {
        String xs = "";
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Message> list = commService.select(g);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                xs = request.getParameter("xs" + list.get(i).getId());
                hashMap.put(i, Integer.valueOf(xs));
            }
        }
        // 调用决策树算法进行分析
        HashMap<String, String> result = DecisionTreeUtil.Test(hashMap);
        //保存测试结果
        record.setFk(result.get("state"));
        record.setLname(result.get("gl"));
        record.setKid(Comm.getUserInfoId(request));
        record.setAid(Comm.getUserInfoId(request));
        //测试日期
        record.setBfrq(DateUtils.GetNowDate());
        commService.insertSelective(record);
        return "redirect:/comm/selBf";
    }

    /**
     * 
     * @描述:添加测试题目
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/addXx")
    public String addXx(Message record,
            HttpServletRequest request) throws Exception {
        //测试人
        record.setFname(Comm.getUserInfoName(request));
        //测试日期
        record.setFdate(DateUtils.GetNowDate());
        //用户id
        record.setAid(Comm.getUserInfoId(request));
        commService.insertSelective(record);
        return "redirect:/comm/selXx";
    }

    /**
     * 
     * @描述:查看测试题目信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selXx")
    public ModelAndView selXx(Integer page, Message g,
            HttpServletRequest request) throws Exception {
        String role = Comm.getUserRole(request);
        //用户查看自己的测试信息
        if (StringUtils.equals("3", role)) {
            g.setAid(Comm.getUserInfoId(request));
        }
        ModelAndView mav = new ModelAndView();
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 10, true);
        List<Message> list = commService.select(g);

        PageInfo<Message> pageInfo = new PageInfo<Message>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("lastPage", pageInfo.getLastPage());
        mav.addObject("pageInfo", pageInfo);
        if ("0".equals(role)) {
            mav.setViewName("comm/xx/sel");
        } else {
            mav.setViewName("comm/xx/sel2");
        }

        return mav;
    }

    /**
     * 
     * @描述: 根据id查询测试题目
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showXx")
    public ModelAndView showXx(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Message data = commService.selectByXx(id);

        mav.addObject("data", data);
        mav.setViewName("comm/xx/update");
        return mav;
    }

    /**
     * 
     * @描述:保存更新测试题目信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/updateXx")
    public String updateGg(Message record) throws Exception {

        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selXx";
    }

    /**
     * 
     * @描述:删除测试题目信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: 
     * @返回值:
     */
    @RequestMapping(value = "/deleteXx")
    public String deleteXx(Integer id) throws Exception {

        commService.deleteByXx(id);

        return "redirect:/comm/selXx";
    }

    /**
     * 
     * @描述:查看测试记录信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selBf")
    public ModelAndView selBf(Integer page, Bf g,
            HttpServletRequest request) throws Exception {
        String role = Comm.getUserRole(request);
        if ("3".equals(role)) {
            g.setAid(Comm.getUserInfoId(request));
        }
        ModelAndView mav = new ModelAndView();
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 10, true);
        List<Bf> list = commService.select(g);

        PageInfo<Bf> pageInfo = new PageInfo<Bf>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("lastPage", pageInfo.getLastPage());
        mav.addObject("pageInfo", pageInfo);
        if ("0".equals(role)) {
            mav.setViewName("comm/bf/sel");
        } else if ("3".equals(role)) {
            mav.setViewName("comm/bf/sel1");
        }
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询测试记录
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showBf")
    public ModelAndView showBf(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Bf data = commService.selectByBf(id);

        mav.addObject("data", data);
        mav.setViewName("comm/bf/update");
        return mav;
    }

    /**
     * 
     * @描述:保存更新测试记录信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/updateBf")
    public String updateBf(Bf record) throws Exception {

        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selBf";
    }

    /**
     * 
     * @描述:删除测试记录信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: 
     * @返回值:
     */
    @RequestMapping(value = "/deleteBf")
    public String deleteBf(Integer id) throws Exception {

        commService.deleteByBf(id);

        return "redirect:/comm/selBf";
    }

    /**
     * 
     * @描述: 跳转页面
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/tz")
    public ModelAndView tzdc(User u, String type) throws Exception {
        ModelAndView mav = new ModelAndView();
        //查询用户用户
        u.setRole("3");
        List<User> userList = userService.selectUserList(u);
        mav.addObject("list", userList);
        if ("rc".equals(type)) {//预约
            u.setRole("1");
            List<User> list = userService.selectUserList(u);
            mav.addObject("list", list);
            mav.setViewName("comm/rc/add");
        } else if ("ssjl".equals(type)) {
            u.setRole("1");
            List<User> userList1 = userService.selectUserList(u);
            mav.addObject("list", userList1);
            mav.setViewName("comm/dd/add");
        } else if ("dc".equals(type)) {//帖子
            mav.setViewName("comm/dc/add");
        }
        return mav;
    }

    /**
     * 
     * @描述:添加建议信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/addLx")
    public String addLx(Lxr record,
            HttpServletRequest request) throws Exception {

        commService.insertSelective(record);
        return "redirect:/comm/selLx";
    }

    /**
     * 
     * @描述:查看建议信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/selLx")
    public ModelAndView selLx(Integer page, Lxr g,
            HttpServletRequest request) throws Exception {
        String role = Comm.getUserRole(request);
        ModelAndView mav = new ModelAndView();
        if ("3".equals(role)) {
            if (g.getFs() >= 20 && g.getFs() <= 30) {//分数大于20小于30查询出20分的建议，下边同理，这主要是根据分数给出建议
                g.setTel(20);
            } else if (g.getFs() > 30 && g.getFs() <= 40) {
                g.setTel(30);
            } else if (g.getFs() > 40 && g.getFs() <= 50) {
                g.setTel(40);
            } else if (g.getFs() > 50 && g.getFs() <= 60) {
                g.setTel(50);
            } else if (g.getFs() > 60 && g.getFs() <= 70) {
                g.setTel(60);
            } else if (g.getFs() > 70 && g.getFs() <= 80) {
                g.setTel(70);
            } else {
                g.setTel(10);
            }
        }
        //分页
        if (page == null) {
            page = 1;
        }
        //分页        
        PageHelper.startPage(page, 10, true);
        List<Lxr> list = commService.select(g);

        PageInfo<Lxr> pageInfo = new PageInfo<Lxr>(list);

        mav.addObject("list", list);
        mav.addObject("page", new PageInfo(list));
        mav.addObject("count", pageInfo.getTotal());
        mav.addObject("countPage", pageInfo.getPages());
        mav.addObject("lastPage", pageInfo.getLastPage());
        if ("0".equals(role)) {
            mav.setViewName("comm/lxr/sel");
        } else if ("3".equals(role)) {
            mav.setViewName("comm/lxr/sel1");
        }
        return mav;
    }

    /**
     * 
     * @描述: 根据id查询建议
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/showLx")
    public ModelAndView showLx(Integer id) throws Exception {
        ModelAndView mav = new ModelAndView();
        Lxr data = commService.selectByLx(id);
        mav.addObject("data", data);
        mav.setViewName("comm/lxr/update");
        return mav;
    }

    /**
     * 
     * @描述:保存更新建议信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: toadd
     * @返回值:ModelAndView
     */
    @RequestMapping(value = "/updateLx")
    public String updateLx(Lxr record) throws Exception {

        commService.updateByPrimaryKeySelective(record);
        return "redirect:/comm/selLx";
    }

    /**
     * 
     * @描述:删除建议信息
     * @作者:
     * @时间 2023年3月13日 下午5:39:37
     * @获取一个: 
     * @返回值:
     */
    @RequestMapping(value = "/deleteLx")
    public String deleteLx(Integer id) throws Exception {

        commService.deleteByLx(id);

        return "redirect:/comm/selLx";
    }

}
