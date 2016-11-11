package cn.mutils.app.dataformat;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.stream.XMLOutputFactory;
import java.io.File;
import java.io.InputStream;

/**
 * Created by wenhua.ywh on 2016/11/9.
 */
public class XmlUtil {

    public static <T> T fromString(String xmlString, Class<T> cls) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = mapper.readValue(xmlString, cls);
        return obj;
    }

    public static <T> T fromPath(String xmlPath, Class<T> cls) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = mapper.readValue(new File(xmlPath), cls);
        return obj;
    }

    public static <T> T fromFile(File xmlFile, Class<T> cls) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = mapper.readValue(xmlFile, cls);
        return obj;
    }

    public static <T> T fromStream(InputStream xmlInputStream, Class<T> cls) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = mapper.readValue(xmlInputStream, cls);
        return obj;
    }

    public static <T> String toString(T bean) throws Exception {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        XMLOutputFactory factory = mapper.getFactory().getXMLOutputFactory();
        factory.setProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES, false);
        String string = mapper.writeValueAsString(bean);
        return string;
    }
}
