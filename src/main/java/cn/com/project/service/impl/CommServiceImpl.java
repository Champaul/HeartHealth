package cn.com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.project.domain.Bf;
import cn.com.project.domain.Diaocha;
import cn.com.project.domain.Gonggao;
import cn.com.project.domain.Lxr;
import cn.com.project.domain.Ly;
import cn.com.project.domain.Message;
import cn.com.project.domain.Order;
import cn.com.project.domain.Schedule;
import cn.com.project.mapper.BfMapper;
import cn.com.project.mapper.DiaochaMapper;
import cn.com.project.mapper.GonggaoMapper;
import cn.com.project.mapper.LxrMapper;
import cn.com.project.mapper.LyMapper;
import cn.com.project.mapper.MessageMapper;
import cn.com.project.mapper.OrderMapper;
import cn.com.project.mapper.ScheduleMapper;
import cn.com.project.service.CommService;

@Service
public class CommServiceImpl implements CommService {

    @Autowired
    private GonggaoMapper gonggaoMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private LxrMapper lxrMapper;

    @Autowired
    private BfMapper bfMapper;

    @Autowired
    private LyMapper lyMapper;

    @Autowired
    private DiaochaMapper diaochaMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void deleteByGg(Integer id) {
        gonggaoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Gonggao record) {
        gonggaoMapper.insertSelective(record);
    }

    @Override
    public Gonggao selectByGg(Integer id) {
        return gonggaoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Gonggao> select(Gonggao record) {
        return gonggaoMapper.select(record);
    }

    @Override
    public void updateByPrimaryKeySelective(Gonggao record) {
        gonggaoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteByXx(Integer id) {
        messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Message record) {
        messageMapper.insertSelective(record);
    }

    @Override
    public Message selectByXx(Integer id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Message> select(Message record) {
        return messageMapper.select(record);
    }

    @Override
    public void updateByPrimaryKeySelective(Message record) {
        messageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteByRc(Integer id) {
        scheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Schedule record) {
        scheduleMapper.insertSelective(record);
    }

    @Override
    public Schedule selectByRc(Integer id) {
        return scheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Schedule> select(Schedule record) {
        return scheduleMapper.select(record);
    }

    @Override
    public void updateByPrimaryKeySelective(Schedule record) {
        scheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteByLx(Integer id) {
        lxrMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Lxr record) {
        lxrMapper.insertSelective(record);
    }

    @Override
    public Lxr selectByLx(Integer id) {
        return lxrMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Lxr> select(Lxr record) {
        return lxrMapper.select(record);
    }

    @Override
    public void updateByPrimaryKeySelective(Lxr record) {
        lxrMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteByBf(Integer id) {
        bfMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Bf record) {
        bfMapper.insertSelective(record);
    }

    @Override
    public Bf selectByBf(Integer id) {
        return bfMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Bf> select(Bf record) {
        return bfMapper.select(record);
    }

    @Override
    public void updateByPrimaryKeySelective(Bf record) {
        bfMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteByLy(Integer id) {
        lyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Ly record) {
        lyMapper.insertSelective(record);
    }

    @Override
    public Ly selectByLy(Integer id) {
        return lyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Ly> select(Ly record) {
        return lyMapper.select(record);
    }

    @Override
    public void updateByPrimaryKeySelective(Ly record) {
        lyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteByDc(Integer id) {
        diaochaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Diaocha record) {
        diaochaMapper.insertSelective(record);
    }

    @Override
    public Diaocha selectByDc(Integer id) {
        return diaochaMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Diaocha> select(Diaocha record) {
        return diaochaMapper.select(record);
    }

    @Override
    public void updateByPrimaryKeySelective(Diaocha record) {
        diaochaMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public void deleteByDd(Integer id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSelective(Order record) {
        orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByDd(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> select(Order record) {
        return orderMapper.select(record);
    }

    @Override
    public void updateByPrimaryKeySelective(Order record) {
        orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Bf> selectTj(Bf record) {
        return bfMapper.selectTj(record);
    }
}
