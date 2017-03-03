package cn.yong.solrtest.web.controller;

import cn.yong.solrtest.model.Area;
import cn.yong.solrtest.service.AreaService;
import cn.yong.solrtest.solr.AreaSolr;
import cn.yong.solrtest.solrbean.AreaBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yong on 2017/3/3.
 */


@RestController
@RequestMapping("/area")
@Api(value = "/area", description = "area controller", position = 1)
public class AreaController {

    @Resource
    private AreaService areaService;

    @Resource
    private AreaSolr areaSolr;

    @RequestMapping(value = "/mybatisQuery", method = RequestMethod.GET)
    @ApiOperation(value = "用mybatis查询", response = List.class, position = 1, produces = "application/json")
    public List<Area> mybatisQuery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.areaService.findAll();
    }

    @RequestMapping(value = "/solrQuery", method = RequestMethod.GET)
    @ApiOperation(value = "用solr查询", response = List.class, position = 2, produces = "application/json")
    public List<AreaBean> solrQuery(@ApiParam(value = "solr查询表达式", defaultValue = "_text_:\"城\"") @RequestParam("cron")String cron, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.areaSolr.query(cron);
    }

    @RequestMapping(value = "/buildIndex", method = RequestMethod.POST)
    @ApiOperation(value = "从数据库查询所有数据，并建立索引", response = List.class, position = 3, notes = "建立索引之后才能用solr搜索")
    public String buildIndex(HttpServletRequest request, HttpServletResponse response) {
        List<Area> areaList = this.areaService.findAll();
        this.areaSolr.buildInxex(areaList);
        return "建立索引成功";
    }

    @RequestMapping(value = "/delIndex", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除全部索引", response = List.class, position = 4, notes = "删除索引后，将搜索不到")
    public String delndex(HttpServletRequest request, HttpServletResponse response) {
        this.areaSolr.deleteAllIndex();
        return "删除索引成功";
    }

}
