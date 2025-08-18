package pahana.dao;

import java.util.ArrayList;

import pahana.model.User;

public class check {
	public static void main(String[] args) {
        UserDao dao = new UserDao();
        ArrayList<User> list = dao.getAllUsers();

        System.out.println("Total Products: " + list.size());
        for (User p : list) {
            System.out.println(
                p.getCashierId() + " | " +
                p.getCashierName() + " | " +
                p.getCashierUsername() + " | " +
                p.getCashierspassword()
            );
        }
    }
}
