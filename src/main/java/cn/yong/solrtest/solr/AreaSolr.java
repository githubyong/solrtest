package cn.yong.solrtest.solr;

import cn.yong.solrtest.model.Area;
import cn.yong.solrtest.solrbean.AreaBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yong on 2017/3/3.
 */

@Component
public class AreaSolr {

    private static final Logger logger = LogManager.getLogger(AreaSolr.class);

    @Autowired
    HttpSolrClient solrClient;

    public void buildInxex(List<Area> areaList) {
        try {
            Collection<AreaBean> areaBeans = new ArrayList<>();
            for (Area area : areaList) {
                areaBeans.add(new AreaBean(area));
            }
            solrClient.addBeans(areaBeans);
            solrClient.commit();
        } catch (Exception e) {
            logger.info("创建索引失败:", e);
        }
    }

    public void deleteAllIndex() {
        try {
            solrClient.deleteByQuery("*:*");
            solrClient.commit();
        } catch (Exception e) {
            logger.info("删除索引失败:", e);
        }
    }

    public List<AreaBean> query(String crondition) {
        List<AreaBean> areaList = new ArrayList<>();
        SolrQuery query = new SolrQuery();
        try {
            query.setQuery(crondition);
            QueryResponse rsp = solrClient.query(query);
            areaList = rsp.getBeans(AreaBean.class);
        } catch (Exception e) {
            logger.info("查询错误:",e);
        }
        return areaList;
    }

    //_text_:"城"
}
