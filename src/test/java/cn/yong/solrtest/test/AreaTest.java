package cn.yong.solrtest.test;

import cn.yong.solrtest.dao.AreaMapper;
import cn.yong.solrtest.model.Area;
import cn.yong.solrtest.service.AreaService;
import cn.yong.solrtest.solr.AreaSolr;
import cn.yong.solrtest.solrbean.AreaBean;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yong on 2017/3/3.
 */
public class AreaTest extends BaseTest {
    @Resource
    private AreaService areaService;

    @Resource
    private AreaSolr areaSolr;

    @Test
    public void buildIndex(){
        List<Area> areas = this.areaService.findAll();
        this.areaSolr.buildInxex(areas);
    }

    @Test
    public void queryAll(){
        List<AreaBean> areaList = this.areaSolr.query("_text_:\"城\"");
        logger.info(areaList);
    }

    @Test
    public void deleteAllIndex(){
        this.areaSolr.deleteAllIndex();
    }
}
