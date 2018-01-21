package za.co.tangentsolutions.praticalassignment.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NextOfKin {
    private Long id;
    private String name;
    private String relationship;
    private String phoneNumber;
    private String email;
    private String  physicalAddress;
    private Employee employee;

}
