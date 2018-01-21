package za.co.tangentsolutions.praticalassignment.domain;

public enum EmployeeReviewType {
    P ("Performance Increase"),
    S ("Starting Salary"),
    A ("Annual Increase"),
    E ("Expectation Review");

    private final String type;

    EmployeeReviewType(String type){
        this.type = type;
    }
}
