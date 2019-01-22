package ersApp.data;

import ersApp.entities.Reimbursement;
import ersApp.entities.Type;
import ersApp.entities.User;

import java.util.List;

public interface ReimbursmentInterface {
    List <Reimbursement> listByUserId(User u);
    void createNew(User u, double amt, String description, int type);
    void changeStatus(User u, int reimbId, int status);
}
