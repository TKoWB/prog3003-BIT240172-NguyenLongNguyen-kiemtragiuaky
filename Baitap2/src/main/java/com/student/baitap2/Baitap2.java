/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.student.baitap2;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


/**
 *
 * @author Admin
 */
public class Baitap2 {

    public static void main(String[] args) {
        
        List<student> list = new ArrayList<>();
        

        list.add(new student("nguyen", 3.0, 3.0));
        list.add(new student("lam", 5.0, 4.0));
        list.add(new student("ngufdas", 3.0, 3.4));
        list.add(new student("lafdasf", 5.0, 4.6));        
        
        System.out.println("bat dau tien trinh chinh");
        
        CompletableFuture<Void>  future = 
            CompletableFuture.supplyAsync(() -> {
                sleep(1000);
                return list;
            })
            
                    
            .thenApply(result -> {
                List<student> ListGoc = new ArrayList<>();
                for (student n : list){
                    ListGoc.add(n);
                }
                return ListGoc;
                
            })
                    
            .thenApply(result ->{
                System.out.println("loc gpa >= 3.2: " + result);
                List<student> GPA = new ArrayList<>();
                for(student n : result){
                    if (n.getGpa() >= 3.3){
                        GPA.add(n);
                    }
                }
                return GPA;
            })
            
            .thenApply(result -> {
                System.out.println("Truoc khi sap xep: " + result);
                // Sort by GPA in descending order (highest first)
                result.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
                return result;
            })
                
            .thenAccept(result -> 
                System.out.println("ket qua: " + result)
            )
                
            .thenRun(() -> 
                    System.out.println("hoan thanh")
            );
        System.out.println("tien trinh chinh tiep tuc...");
        
        future.join();
        System.out.println("join");
               
        
    
      
        
    }
    
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

