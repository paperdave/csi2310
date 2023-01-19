package net.paperdave.csi2130.examples.lab1;

import net.paperdave.csi2130.runner.Lab;

import java.time.LocalDate;

public class Lab1 extends Lab {
    public void run() {
        Person x = new Person("Tony roberts", 22, 4, true);
        Person y = new Person("John benjamin", 22, 4, true);
        Person z = new Person("Tony roberts", 22, 4, true);

        System.out.println(x.getName());
        System.out.println(y.getName());
        System.out.println(z.getName());
    }

    // metadata

    public Lab1() {
        super();
    }

    @Override
    public String getName() {
        return "Lab 1: Interviewing";
    }

    @Override
    public String getDescription() {
        return """
                Dear Students,

                This week, you will work with the help of the TAs to write a Java program that emulates the interview of a candidate for a job position.\s

                You need to develop a class that models the data and actions of an applicant for a job position. What data and methods would you define?\s

                You shall write a class named Person, which you could store in a package of your choice. You will then create a program that imports your class. The project shall include code that creates 3 different “applicants”, and then interviews them. In other words, the program shall create three objects off the class "Person" by using the new operator. The program shall populate those objects with data, and then shall activate methods in those objects to retrieve and sometimes process their data. All answers provided by an applicant, i.e. object, shall be displayed on the standard output.

                Please note that this lab activity is for your practice only. It is not a graded activity, but rather practice with Java that aims at preparing you for the programming projects that I will assign soon.

                Regards,
                Dr. Julian Rrushi
                """;
    }

    @Override
    public LocalDate getCreatedDate() {
        return LocalDate.of(2023, 1, 18);
    }
}
