package cm.mutils.app.dataformat;

import cn.mutils.app.dataformat.JsonUtil;
import cn.mutils.app.dataformat.XmlUtil;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by wenhua.ywh on 2016/11/11.
 */
public class DataFormatTest {

    public static class User {

        @JacksonXmlProperty(isAttribute = true)
        public String name;

        public int age;

        public String province;

        public ArrayList<String> alias;

    }

    public static class BookedUser extends User {

        public static class Location {
            @JacksonXmlProperty(isAttribute = true)
            public String name;
            @JacksonXmlProperty(isAttribute = true,localName = "start")
            public int startYear;
            @JacksonXmlProperty(isAttribute = true,localName = "end")
            public int endYear;

            public Location() {

            }

            public Location(String name, int startYear, int endYear) {
                this.name = name;
                this.startYear = startYear;
                this.endYear = endYear;
            }

        }

        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "location")
        public ArrayList<Location> locations;
    }

    @Test
    public void testUserJson() throws Exception {
        User u = new User();
        u.name = "杨文华";
        u.age = 26;
        u.province = "北京";
        u.alias = new ArrayList<>();
        u.alias.add("wavinsun");
        u.alias.add("堇花");
        u.alias.add("wenhua.ywh");
        String json = JsonUtil.toString(u);
        System.out.println(json);
        User uu = JsonUtil.fromString(json, User.class);
        assert json.equals(JsonUtil.toString(uu));
    }

    @Test
    public void testUserXml() throws Exception {
        User u = new User();
        u.name = "杨文华";
        u.age = 26;
        u.province = "北京";
        u.alias = new ArrayList<>();
        u.alias.add("wavinsun");
        u.alias.add("堇花");
        u.alias.add("wenhua.ywh");
        String xml = XmlUtil.toString(u);
        System.out.println(xml);
        User uu = XmlUtil.fromString(xml, User.class);
        assert xml.equals(XmlUtil.toString(uu));
    }

    @Test
    public void testBookedUserJson() throws Exception {
        BookedUser u = new BookedUser();
        u.name = "杨文华";
        u.age = 26;
        u.province = "北京";
        u.alias = new ArrayList<>();
        u.alias.add("wavinsun");
        u.alias.add("堇花");
        u.alias.add("wenhua.ywh");
        u.locations = new ArrayList<>();
        u.locations.add(new BookedUser.Location("云南", 1989, 2014));
        u.locations.add(new BookedUser.Location("北京", 2014, 2016));
        String json = JsonUtil.toString(u);
        System.out.println(json);
        BookedUser uu = JsonUtil.fromString(json, BookedUser.class);
        assert json.equals(JsonUtil.toString(uu));
    }

    @Test
    public void testBookedUserXml() throws Exception {
        BookedUser u = new BookedUser();
        u.name = "杨文华";
        u.age = 26;
        u.province = "北京";
        u.alias = new ArrayList<>();
        u.alias.add("wavinsun");
        u.alias.add("堇花");
        u.alias.add("wenhua.ywh");
        u.locations = new ArrayList<>();
        u.locations.add(new BookedUser.Location("云南", 1989, 2014));
        u.locations.add(new BookedUser.Location("北京", 2014, 2016));
        String xml = XmlUtil.toString(u);
        System.out.println(xml);
        BookedUser uu = XmlUtil.fromString(xml, BookedUser.class);
        assert xml.equals(XmlUtil.toString(uu));
    }


}
