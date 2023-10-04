package cn.com.project.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.project.domain.Bf;

@Repository
public interface BfMapper {
    void deleteByPrimaryKey(Integer id);

    void insert(Bf record);

    void insertSelective(Bf record);

    Bf selectByPrimaryKey(Integer id);

    List<Bf> select(Bf record);

    List<Bf> selectTj(Bf record);

    void updateByPrimaryKeySelective(Bf record);

    void updateByPrimaryKey(Bf record);
}