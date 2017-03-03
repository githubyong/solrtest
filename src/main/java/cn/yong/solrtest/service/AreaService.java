package cn.yong.solrtest.service;

import cn.yong.solrtest.dao.AreaMapper;
import cn.yong.solrtest.model.Area;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yong on 2017/3/3.
 */
@Service
public class AreaService {

    @Resource
    private AreaMapper areaMapper;

    public List<Area> findAll(){
        return this.areaMapper.selectAll();
    }
}
