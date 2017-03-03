package cn.yong.solrtest.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/spring-root.xml"})
@Transactional
public class BaseTest {
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
}
