package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;//getter,setter,toString 자동으로 만들어줌. Constructor는 x
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//database와 동일하게..
//table과 같이,,

public class Product {

    private int id;
    private String name;
    private int price;
    private LocalDate regdate;


}