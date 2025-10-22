package ch1;

import java.util.*;
import javax.swing.*;
import java.awt.*;

class Book{
    private String title;
    private String author;
    private int publicationYear;
    Book(String title,String author,int publicationYear){
        this.title=title;
        this.author=author;
        this.publicationYear=publicationYear;
    }
    void displayDetails(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Publication Year: "+publicationYear);
        System.out.println("---------------------------");
    }
}

public class Q4 {
    public static void main(String[] args){
        Book book1=new Book("The Great Gatsby","F.Scott Fitzgerald",1925);
        Book book2=new Book("1984","George Orwell",1949);
        Book book3=new Book("To Kill a Mockingbird","Harper Lee",1960);

        System.out.println("Library Book Details:");
        book1.displayDetails();
        book2.displayDetails();
        book3.displayDetails();
    }
}
