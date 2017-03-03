package cn.yong.solrtest.web.spring;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by zhaoy on 2015/10/13.
 */
public class CustomJsonMapper extends ObjectMapper {

    private String date_format = "yyyy-MM-dd HH:mm:ss";

    public CustomJsonMapper() {
        super();
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);//
        this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        DateFormat dateFormat = new SimpleDateFormat(date_format, Locale.ENGLISH);
        this.setDateFormat(dateFormat);
        this.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        this.enable(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS);
    }

}
