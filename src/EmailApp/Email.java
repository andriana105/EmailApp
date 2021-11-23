package EmailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapactity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "abccompany.com";
//    private String changePassword;

    // Constructor to receive the first name and last name

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created : " + this.firstName + " " + this.lastName);

        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your assword is : " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email address is : " + email);
    }


    // Ask for the department

    private String setDepartment(){
        System.out.print("Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
//        Scanner in = new Scanner(System.in);
//        int deptChoice = in.nextInt();
//        if(deptChoice == 1){return "Sales";}
//        else if(deptChoice == 2){return "Dev";}
//        else if(deptChoice == 3){return "Acct";}
//        else {return "";}

        boolean flag = false;
        do {
            System.out.print("Enter Department Code: ");
            Scanner in = new Scanner(System.in);
            int deptChoice = in.nextInt();
            switch (deptChoice){
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid Choice");
            }
        } while (!flag);
        return null;
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapactity(int capacity){
        this.mailboxCapactity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this. alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapactity() {
        return mailboxCapactity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email : " + email +
                "\nMailbox Capacity : " + mailboxCapactity + "mb";
    }
}
