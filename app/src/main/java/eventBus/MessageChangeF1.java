package eventBus;

import com.augustosalazar.as_android_importantlibraries.User;

import java.util.List;

public class MessageChangeF1 {
    public final List<User> users;

    public MessageChangeF1(List<User> users) {
        this.users = users;
    }
}