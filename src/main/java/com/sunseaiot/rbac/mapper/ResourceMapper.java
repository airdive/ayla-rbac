package com.sunseaiot.rbac.mapper;

import com.sunseaiot.rbac.model.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(String name);

    Resource selectByPrimaryKey(Integer resourceId);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);
}