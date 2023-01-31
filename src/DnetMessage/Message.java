
package DnetMessage;

import java.io.Serializable;
import javax.swing.Icon;


public class Message implements Serializable {
    
    private int msgid;
    private String name;
    private String message;
    private String date_time;
    private Icon avatar;
    

    public int getMsgid() {
        return msgid;
    }

    public Icon getAvatar() {
        return avatar;
    }

    public void setAvatar(Icon avatar) {
        this.avatar = avatar;
    }

    public void setMsgid(int msgid) {
        this.msgid = msgid;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
    
}
