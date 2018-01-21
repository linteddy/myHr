package za.co.tangentsolutions.praticalassignment.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class EmployeeReview {
    private Long id;
    private Date date;
    private double salary;
    private char type;
}
