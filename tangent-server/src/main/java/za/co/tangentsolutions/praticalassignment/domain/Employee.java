package za.co.tangentsolutions.praticalassignment.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@Data
public class Employee {
    private Long id;
    private User user;
    private Position position;
    private ArrayList<NextOfKin> employeeNextOfKin;
    private ArrayList<EmployeeReview> employeeReview;
    private String idNumber;
    private String phoneNumber;
    private String physicalAddress;
    private String taxNumber;
    private String email;
    private String personalEmail;
    private String github_user;
    private Date birth_date;
    private Date startDate;
    private Date endDate;
    private File idDocument;
    private File visaDocument;
    private boolean isEmployed;
    private boolean isForeigner;
    private Gender gender;
    private Race race;
    private int yearsWorked;
    private int age;
    private Date nextReview;
    private int daysToBirthday;
    private double  leaveRemaining;

}
