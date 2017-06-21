/**
 * Created by derekhsieh on 6/14/17.
 */
public class TestClass {
    private String key;
    private String value;
    private String friend;

    public TestClass(String key, String value, String friend) {
        this.key = key;
        this.value = value;
        this.friend = friend;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }
}
