package me.dio.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account number is mandatory")
    @Size(min = 10, max = 20, message = "Account number must be between 10 and 20 characters")
    @Column(unique = true)
    private String number;

    @NotBlank(message = "Agency is mandatory")
    @Size(min = 5, max = 10, message = "Agency must be between 5 and 10 characters")
    private String agency;

    @DecimalMin(value = "0.0", inclusive = true, message = "Balance must be positive")
    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @DecimalMin(value = "0.0", inclusive = true, message = "Limit must be positive")
    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    // Getters and setters...
}
