package cn.yong.solrtest.dao;

import cn.yong.solrtest.model.Area;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaMapper {
    @Select({
            "select",
            "id, parent_id, name, short_name, longitude, latitude, level, sort, status",
            "from area",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Area selectByPrimaryKey(Integer id);

    @Select({"select * from area"})
    @ResultMap("BaseResultMap")
    List<Area> selectAll();
}