public class SecurePassword {
  private String website;
  private String username;
  private String password;

    // constructor
    public SecurePassword(String website, String username, String password) {
        this.website = website; 
        this.username = username;
        this.password = password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getWebsite() { 
      return website; 
    } 
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Returns true if password meets all of the requirements
    public boolean isSecure() {
        return isLongEnough() && containsLowercase() && containsUppercase() && containsDigit() && containsSpecialSymbol();
    }
    //received help from my great friend Bonnie Chen in creating the status method 
    //thank you Bonnie <3 
    
    // Returns a String that contains information about the security status of the current password
     public String status() {
        String conditions = "";
        if(isSecure()) {
            conditions += "Password is secure";
        }else {
            if (!isLongEnough()) {
                conditions += "The password must be at least 8 characters \n";
            }
            if (!containsLowercase()) {
                conditions += "The password must contain at least one lower case character \n";
            }
            if (!containsUppercase()) {
                conditions += "The password must contain at least one upper case character \n";
            }
            if (!containsDigit()) {
                conditions += "The password must contain at least one digit \n";
            }
            if (!containsSpecialSymbol()) {
                conditions += "The password must contain a special symbol: ! @ # $ % ^ & * ? \n";
            }
        }
            return conditions;
        }

    // PRIVATE "HELPER" METHODS

    // Checks to see if the password is long enough
    private boolean isLongEnough() {
        return password.length() >= 8;
    }

    // Returns true if the password has at least one uppercase letter and false otherwise
    private boolean containsUppercase() {
        return checkString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    // Returns true if the password has at least one lowercase letter and false otherwise
    private boolean containsLowercase() {
        return checkString("abcdefghijklmnopqrstuvwxyz");
    }

    // Returns true if the password has at least one digit and false otherwise
    private boolean containsDigit() {
        return password.matches(".*\\d.*");
    }

    // Returns true if the password has at least one of these special symbols: ! @ # $ % ^ & * ? and false otherwise
    private boolean containsSpecialSymbol() {
        return password.matches(".*[!@#$%^&*?].*");
    }

    // Checks characterString to see if password contains at least one character from that string
    private boolean checkString(String characterString) {
        for (int i = 0; i < password.length(); i++) {
            if (characterString.indexOf(password.charAt(i)) >= 0) {
                return true;
            }
        }
        return false;
    }
}