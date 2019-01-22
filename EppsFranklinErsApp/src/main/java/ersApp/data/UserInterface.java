package ersApp.data;

import ersApp.entities.User;

public interface UserInterface {
    User getByUsername(String username);
}
