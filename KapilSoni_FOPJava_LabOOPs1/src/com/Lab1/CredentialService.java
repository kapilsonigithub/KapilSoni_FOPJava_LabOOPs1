package com.Lab1;
import java.util.Random;
/*
 * Short comings:
 * Characters (or numerals) may repeat
 * Length can be specified for numeric/Caps/Small/Special, but hard coded.
 * Sequence of random characters may be modified, but hard coded.
 * */
class CredentialService {
    private Employee employee;

    /* Constructor with var */
    public CredentialService(Employee employee) {
        this.employee = employee;
    }

    public String generateEmail(String department, String company) {
        String email = employee.firstName.toLowerCase() + employee.lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company.toLowerCase() + ".com";
        return email;
    }
    
    /*Generate a random password which will contain 
     * (number, 
     * capital letter, 
     * small letter & 
     * special character)*/
    
    private String generatePasswordNumeric(int length) {
        String characters = "0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();    	
    }
    
    private String generatePasswordAplhaCapital(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();    	
    }
    
    private String generatePasswordAplhaSmall(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();    	
    }
    
    private String generatePasswordAplhaSpecial(int length) {
        String characters = "!@#$%^&*()-_"; /* Ignoring: =+ */
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();    	
    }
    

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        
        /*
         * number, 
		 * capital letter, 
		 * small letter & 
		 * special character
		 * */

        password.append("");
        password.append(generatePasswordNumeric(2));
        password.append(generatePasswordAplhaCapital(2));
        password.append(generatePasswordAplhaSmall(2));
        password.append(generatePasswordAplhaSpecial(2));
        return password.toString();
    }

    public void showCredentials(String dept, String Cmpny) {
        String[] departments = { "Technical", "Admin", "Human Resource", "Legal" };

        String department = dept;
        String company = Cmpny;

        boolean isValidDepartment = false;
        for (String dep : departments) {
            if (dep.equalsIgnoreCase(department)) {
                isValidDepartment = true;
                break;
            }
        }

        if (!isValidDepartment) {
            System.out.println("Invalid department");
            return;
        }

        String email = generateEmail(department, company);
        String password = generatePassword(); // Assuming Password length is 8

        System.out.println("Generated Credentials:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

}