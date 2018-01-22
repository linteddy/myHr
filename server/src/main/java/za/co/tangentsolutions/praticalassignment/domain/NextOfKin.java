package za.co.tangentsolutions.praticalassignment.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NextOfKin {
    private Long id;
    private String name;
    private String relationship;

    @JsonProperty("phone_number")
    private String phoneNumber;
    private String email;

    @JsonProperty("physical_address")
    private String  physicalAddress;
    private Long employee;

}
