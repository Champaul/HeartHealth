package cn.com.project.service;

import java.util.List;

import cn.com.project.domain.Bf;
import cn.com.project.domain.Diaocha;
import cn.com.project.domain.Gonggao;
import cn.com.project.domain.Lxr;
import cn.com.project.domain.Ly;
import cn.com.project.domain.Message;
import cn.com.project.domain.Order;
import cn.com.project.domain.Schedule;

public interface CommService {

    void deleteByGg(Integer id);

    void insertSelective(Gonggao record);

    Gonggao selectByGg(Integer id);

    List<Gonggao> select(Gonggao record);

    void updateByPrimaryKeySelective(Gonggao record);

    void deleteByXx(Integer id);

    void insertSelective(Message record);

    Message selectByXx(Integer id);

    List<Message> select(Message record);

    void updateByPrimaryKeySelective(Message record);

    void deleteByRc(Integer id);

    void insertSelective(Schedule record);

    Schedule selectByRc(Integer id);

    List<Schedule> select(Schedule record);

    void updateByPrimaryKeySelective(Schedule record);

    void deleteByLx(Integer id);

    void insertSelective(Lxr record);

    Lxr selectByLx(Integer id);

    List<Lxr> select(Lxr record);

    void updateByPrimaryKeySelective(Lxr record);

    void deleteByBf(Integer id);

    void insertSelective(Bf record);

    Bf selectByBf(Integer id);

    List<Bf> select(Bf record);

    List<Bf> selectTj(Bf record);

    void updateByPrimaryKeySelective(Bf record);

    void deleteByLy(Integer id);

    void insertSelective(Ly record);

    Ly selectByLy(Integer id);

    List<Ly> select(Ly record);

    void updateByPrimaryKeySelective(Ly record);

    void deleteByDc(Integer id);

    void insertSelective(Diaocha record);

    Diaocha selectByDc(Integer id);

    List<Diaocha> select(Diaocha record);

    void updateByPrimaryKeySelective(Diaocha record);

    void deleteByDd(Integer id);

    void insertSelective(Order record);

    Order selectByDd(Integer id);

    List<Order> select(Order record);

    void updateByPrimaryKeySelective(Order record);
}
