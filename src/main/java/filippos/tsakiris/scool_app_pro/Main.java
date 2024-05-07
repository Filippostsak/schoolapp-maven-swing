package filippos.tsakiris.scool_app_pro;

import filippos.tsakiris.scool_app_pro.dao.student.IStudentDAO;
import filippos.tsakiris.scool_app_pro.dao.student.StudentDAOImpl;
import filippos.tsakiris.scool_app_pro.dao.user.IUserDAO;
import filippos.tsakiris.scool_app_pro.dao.user.UserDAOImpl;
import filippos.tsakiris.scool_app_pro.service.students.StudentServiceImpl;
import filippos.tsakiris.scool_app_pro.service.user.IUserService;
import filippos.tsakiris.scool_app_pro.service.user.UserServiceImpl;
import filippos.tsakiris.scool_app_pro.viewcontroller.student.StudentInsertForm;
import filippos.tsakiris.scool_app_pro.viewcontroller.student.StudentUpdateAndDeleteForm;
import filippos.tsakiris.scool_app_pro.viewcontroller.student.StudentsSearchForm;
import filippos.tsakiris.scool_app_pro.viewcontroller.Menu;
import filippos.tsakiris.scool_app_pro.viewcontroller.teacher.InsertForm;
import filippos.tsakiris.scool_app_pro.viewcontroller.teacher.SearchForm;
import filippos.tsakiris.scool_app_pro.viewcontroller.teacher.UpdateDeleteForm;
import filippos.tsakiris.scool_app_pro.viewcontroller.user.LoginUser;

import java.awt.*;
import java.util.List;

public class Main {

    private static Menu menu;
    private static InsertForm insertForm;
    private static UpdateDeleteForm updateDeleteForm;
    private static SearchForm searchForm;
    private static StudentsSearchForm studentsSearchForm;
    private static StudentInsertForm studentInsertForm;
    private static StudentUpdateAndDeleteForm studentUpdateAndDeleteForm;
    private static StudentServiceImpl studentService;
    private static UserServiceImpl userService;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                studentService = new StudentServiceImpl(new StudentDAOImpl());
                studentsSearchForm = new StudentsSearchForm();

                menu = new Menu();
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);

                IUserDAO userDAO = new UserDAOImpl(); // Create UserDAO instance
                userService = new UserServiceImpl(userDAO); // Pass UserDAO to UserService

                searchForm = new SearchForm();
                searchForm.setLocationRelativeTo(null);
                searchForm.setVisible(false);

                studentsSearchForm = new StudentsSearchForm();
                studentsSearchForm.setLocationRelativeTo(null);
                studentsSearchForm.setVisible(false);

                studentInsertForm = new StudentInsertForm();
                studentInsertForm.setLocationRelativeTo(null);
                studentInsertForm.setVisible(false);

                studentUpdateAndDeleteForm = new StudentUpdateAndDeleteForm();
                studentUpdateAndDeleteForm.setLocationRelativeTo(null);
                studentUpdateAndDeleteForm.setVisible(false);

                insertForm = new InsertForm();
                insertForm.setLocationRelativeTo(null);
                insertForm.setVisible(false);

                updateDeleteForm = new UpdateDeleteForm();
                updateDeleteForm.setLocationRelativeTo(null);
                updateDeleteForm.setVisible(false);

                // New code for displaying LoginUser form
                IUserService userService = new UserServiceImpl(new UserDAOImpl());
                new LoginUser(userService);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Add getter for studentService
    public static StudentServiceImpl getStudentService() {
        return studentService;
    }

    public static Menu getMenu() {
        return menu;
    }

    public static SearchForm getSearchForm() {
        return searchForm;
    }

    public static InsertForm getInsertForm() {
        return insertForm;
    }

    public static UpdateDeleteForm getUpdateDeleteForm() {
        return updateDeleteForm;
    }

    public static StudentsSearchForm getStudentsSearchForm() {
        return studentsSearchForm;
    }

    public static StudentInsertForm getStudentInsertForm() {
        return studentInsertForm;
    }

    public static Component getStudentUpdateDeleteForm() {
        return studentUpdateAndDeleteForm;
    }

    public static IStudentDAO getStudentDAO() {
        return new StudentDAOImpl();
    }

    public static UserServiceImpl getUserService() {
        return userService;
    }
}
