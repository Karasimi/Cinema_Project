package Info;

import java.util.Date;

public class customer {
    private String Name_Cus;
    private int Phone_Number;
    private String Email_Cus;
    private Date Birthday_Cus;



    public String getName_Cus() {
        return Name_Cus;
    }

    public void setName_Cus(String name_Cus) {
        Name_Cus = name_Cus;
    }

    public int getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(int phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getEmail_Cus() {
        return Email_Cus;
    }

    public void setEmail_Cus(String email_Cus) {
        Email_Cus = email_Cus;
    }

    public Date getBirthday_Cus() {
        return Birthday_Cus;
    }

    public void setBirthday_Cus(Date birthday_Cus) {
        Birthday_Cus = birthday_Cus;
    }
}
