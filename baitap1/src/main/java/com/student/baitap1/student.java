/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.student.baitap1;

public class student { // Capitalized class name
    private String ten;
    private double diem; // Fixed 'dupble'
    private double gpa;

    public student(String T, double D, double G) {
        this.ten = T;
        this.diem = D;
        this.gpa = G;
    }

    // Getter needed to access private data
    public double getGpa() {
        return gpa;
    }
}