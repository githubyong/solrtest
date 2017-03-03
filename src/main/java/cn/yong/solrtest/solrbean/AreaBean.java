package cn.yong.solrtest.solrbean;

import cn.yong.solrtest.model.Area;
import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by yong on 2017/3/3.
 */
public class AreaBean {
    @Field("id")
    private String id;
    @Field
    private String name;
    @Field
    private String shortName;

    public AreaBean() {
    }

    public AreaBean(Area area) {
        this.id = area.getId();
        this.name = area.getName();
        this.shortName = area.getShortName();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
