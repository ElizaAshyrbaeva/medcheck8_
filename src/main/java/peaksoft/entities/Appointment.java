package com.example.medcheckb8.entities;

import com.example.medcheckb8.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "appointments")
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_gen")
    @SequenceGenerator(name = "appointment_seq",allocationSize = 1)
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private Status status;
    private LocalDateTime dateOfVisit;
    @ManyToOne(cascade = {DETACH,
            MERGE,
            PERSIST,
            REFRESH})
    private User user;
    @ManyToOne(cascade = {PERSIST,
            MERGE,
            REFRESH,
            DETACH})
    private Doctor doctor;
    @ManyToOne(cascade = {PERSIST,
            MERGE,
            REFRESH,
            DETACH})
    private Department department;

}