package cn.com.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.domain.Diaocha;

@Repository
public interface DiaochaMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(Diaocha record);

    void insertSelective(Diaocha record);

    Diaocha selectByPrimaryKey(Integer id);

    List<Diaocha> select(Diaocha record);

    List<Diaocha> selectTj();

    void updateByPrimaryKeySelective(Diaocha record);

    void updateByPrimaryKey(Diaocha record);
}