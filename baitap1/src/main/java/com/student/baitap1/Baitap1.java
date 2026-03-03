/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



package com.student.baitap1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Baitap1 {
    

    public CompletableFuture<Double> calculateAverageGpa(List<student> students) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Dang tinh toan...");
                double tong = 0;
                

                for (student s : students) {
                    tong += s.getGpa();
                }
                Thread.sleep(1000);

                return students.isEmpty() ? 0.0 : tong / students.size();
                
            } catch (InterruptedException e) {
                return 0.0;
            }
        });
    }

    public static void main(String[] args) {
        Baitap1 t = new Baitap1();
        List<student> list = new ArrayList<>();
        

        list.add(new student("nguyen", 3.0, 3.5));
        list.add(new student("lam", 5.0, 4.0));


        t.calculateAverageGpa(list).thenAccept(result -> {
            System.out.println("Trung binh GPA: " + result);
        });


        try { Thread.sleep(2000); } catch (Exception e) {}
    }
}
