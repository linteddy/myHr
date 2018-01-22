package za.co.tangentsolutions.praticalassignment.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Position {
    private Long id;
    private String name;
    private String level;
}
