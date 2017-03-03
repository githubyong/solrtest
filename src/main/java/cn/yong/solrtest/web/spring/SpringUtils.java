package cn.yong.solrtest.web.spring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    public static <B> B getBean(Class<B> cls) {
        if (applicationContext != null && cls != null)
            return applicationContext.getBean(cls);
        else {
            throw new RuntimeException("Component Not Found: " + cls);
        }
    }

    public static <B> B getBean(String id) {
        if (applicationContext != null && StringUtils.isNotBlank(id))
            return (B) applicationContext.getBean(id);
        else
            throw new RuntimeException("Component Not Found: " + id);
    }

    public static <B> B getBean(String id, Object... properties) {
        if (applicationContext != null && StringUtils.isNotBlank(id))
            return (B) applicationContext.getBean(id, properties);
        else
            throw new RuntimeException("Component Not Found: " + id);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
