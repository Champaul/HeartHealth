package cn.com.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.domain.Schedule;

@Repository
public interface ScheduleMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(Schedule record);

    void insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer id);

    List<Schedule> select(Schedule record);

    void updateByPrimaryKeySelective(Schedule record);

    void updateByPrimaryKey(Schedule record);
}