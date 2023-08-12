package com.Lab1;

public class KapilSoni_FOPJava_LabOOPs1 {



    public static void main(String[] args) {
        // Input first name and last name
        String firstName = "Kapil"; // Replace with input or desired value
        String lastName = "Soni"; // Replace with input or desired value

        Employee newEmployee = new Employee(firstName, lastName);
        CredentialService credentialService = new CredentialService(newEmployee);
        credentialService.showCredentials("Technical", "TestCompany");
    }
}
