package per.dh.object;

import java.util.LinkedHashSet;
import java.util.Set;

public class UserSetForm {
    private Set<User> users;

    private UserSetForm(){
        // set的size方法不同于list，需要初始化是添加对象
        users = new LinkedHashSet<User>();
        users.add(new User());
        users.add(new User());
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserSetForm{" +
                "users=" + users +
                '}';
    }
}
