package filippos.tsakiris.scool_app_pro.service.user.exceptions;

public class UserUpdateException extends Exception{

   public UserUpdateException(String s) {
       super("An error occurred while trying to update a user");
   }

    public UserUpdateException(String s, Throwable throwable) {
         super("An error occurred while trying to update a user", throwable);
    }

    public UserUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
        super("An error occurred while trying to update a user", throwable, b, b1);
    }
}
