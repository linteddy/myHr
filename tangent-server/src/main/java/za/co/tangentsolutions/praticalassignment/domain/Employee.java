package za.co.tangentsolutions.praticalassignment.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class Employee {
    private Long id;
    private User user;
    private Position position;

    @JsonProperty("employee_next_of_kin")
    private List<NextOfKin> employeeNextOfKin;

    @JsonProperty("employee_review")
    private List<EmployeeReview> employeeReview;

    @JsonProperty("id_number")
    private String idNumber;

    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("physical_address")
    private String physicalAddress;

    @JsonProperty("tax_number")
    private String taxNumber;
    private String email;

    @JsonProperty("personal_email")
    private String personalEmail;

    @JsonProperty("github_user")
    private String githubUser;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("birth_date")
    private Date birthDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("start_date")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("end_date")
    private Date endDate;

    @JsonProperty("id_document")
    private File idDocument;

    @JsonProperty("visa_document")
    private File visaDocument;

    @JsonProperty("is_employed")
    private boolean isEmployed;

    @JsonProperty("is_foreigner")
    private boolean isForeigner;
    private Gender gender;
    private Race race;

    @JsonProperty("years_worked")
    private int yearsWorked;
    private int age;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("next_review")
    private Date nextReview;

    @JsonProperty("days_to_birthday")
    private int daysToBirthday;

    @JsonProperty("leave_remaining")
    private double leaveRemaining;

}
