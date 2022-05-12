package com.modernjava.streams;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorMappingExample {
    public static void main(String[] args) {
        //map
        List<String> namesList = Instructors.getAll().stream()
                .map(Instructor::getName)
                .collect(Collectors.toList());
        namesList.forEach(System.out::println);

        //mapping
        namesList= Instructors.getAll().stream()
                .collect(Collectors.mapping(Instructor::getName, Collectors.toList()));

        namesList.forEach(System.out::println);

        //Instructors by their years of experience
        System.out.println("-----------------------------");
        System.out.println(Instructors.getAll());
        Map<Integer, List<String>> mapYearsOfExperienceAndNames = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                        Collectors.mapping(Instructor::getName, Collectors.toList())));
        Map<Integer, List<Instructor>> mapYearsOfExperienceAndNames1 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience, Collectors.toList()));
        Map<Integer, List<Instructor>> mapYearsOfExperienceAndNames2 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience));
        mapYearsOfExperienceAndNames.forEach((key,value) ->{
            System.out.println("key = " + key + " value = " + value);
        });
        System.out.println("-----------------------------");

        mapYearsOfExperienceAndNames1.forEach((key,value) ->{
            System.out.println("key = " + key + " value = " + value);
        });
        System.out.println("-----------------------------");

        mapYearsOfExperienceAndNames2.forEach((key,value) ->{
            System.out.println("key = " + key + " value = " + value);
        });







    }
}
