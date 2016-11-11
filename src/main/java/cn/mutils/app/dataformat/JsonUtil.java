package cn.mutils.app.dataformat;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;

/**
 * Created by wenhua.ywh on 2016/11/9.
 */
public class JsonUtil {

    public static <T> T fromString(String jsonString, Class<T> cls) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = mapper.readValue(jsonString, cls);
        return obj;
    }

    public static <T> T fromPath(String jsonPath, Class<T> cls) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = mapper.readValue(new File(jsonPath), cls);
        return obj;
    }

    public static <T> T fromFile(File jsonFile, Class<T> cls) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = mapper.readValue(jsonFile, cls);
        return obj;
    }

    public static <T> T fromStream(InputStream jsonInputStream, Class<T> cls) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = mapper.readValue(jsonInputStream, cls);
        return obj;
    }

    public static <T> String toString(T bean) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(bean);
        return string;
    }

}
