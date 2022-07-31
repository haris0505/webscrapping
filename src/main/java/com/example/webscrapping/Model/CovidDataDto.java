package com.example.webscrapping.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CovidDataDto {
    String country;
    int cases;
    int deaths;
    int recoveries;


}
