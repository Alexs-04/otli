package com.korebit.model;

import com.korebit.model.enums.CPU;
import com.korebit.model.enums.Trademark;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Trademark trademark;

    private String model;

    @Enumerated(EnumType.STRING)
    private CPU cpu;

    private Boolean isTouchScreen;
}
