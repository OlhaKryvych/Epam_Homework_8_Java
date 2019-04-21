package com.epam.model;

import com.epam.view.View;

import java.util.Arrays;
import java.util.Comparator;

public class Books {
    Book[] books;
    int lastIndex = 0;
    View view = new View();

    public Book[] getBooks() {
        return books;
    }

    public Books(int size) {
        books = new Book[size];
    }

    public void addBook(Book inputBook){
        books[lastIndex] = inputBook;
        lastIndex++;
    }

    public void changePrice(double percent){
        if (percent > 100 || percent < -100) {
            return;
        }
        for(int i = 0; i < books.length; i++) {
            books[i].setPrice(books[i].getPrice() +
                    (books[i].getPrice() * (percent / 100)));
        }
    }

    public Books searchByAuthor(String author){
        int count = 0;
        for(int i = 0; i < books.length; i++){
            if(author.equals(books[i].getAuthor())){
                count++;
            }
        }
        Books object = new Books(count);
        for(int i = 0; i < books.length; i++){
            if(author.equals(books[i].getAuthor())){
                object.addBook(books[i]);
            }
        }
        if(object != null){
            return object;
        }
        else {
            view.printMessage(view.empty);
            return new Books(0);
        }
    }

    public Books searchByYear(int year){
        int count = 0;
        for(int i = 0; i < books.length; i++){
            if(books[i].getYearOfPublishing() > year){
                count++;
            }
        }
        Books years = new Books(count);
        for(int i = 0; i < books.length; i++){
            if(books[i].getYearOfPublishing() > year){
                years.addBook(books[i]);
            }
        }
        if(years != null){
            return years;
        }
        else {
            view.printMessage(view.empty);
            return new Books(0);
        }
    }

    public void sortByAuthor(){
        Book[] copyArray = Arrays.copyOf(books, books.length);
        Arrays.sort(copyArray, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        view.printBooks(copyArray);
    }

    public void sortByPublishingHouse(){
        Book[] copyArray = Arrays.copyOf(books, books.length);
        Arrays.sort(copyArray, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPublishingHouse().compareTo(o2.getPublishingHouse());
            }
        });
        view.printBooks(copyArray);
    }
    public void sortByPrice(){
        Book[] copyArray = Arrays.copyOf(books, books.length);
        Arrays.sort(copyArray, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        view.printBooks(copyArray);
    }
}
