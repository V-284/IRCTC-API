package api.endpoint;

public class temp {

   public String username;
   public String password;


   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "temp{" +
              "username='" + username + '\'' +
              ", password='" + password + '\'' +
              '}';
   }
}
