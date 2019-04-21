package com.epam.controller;

public class Validator{
    public int checkId(int id) throws IncorrectValue{
        if(id < 0){
            throw new IncorrectValue("Negative id!");
        }
        return id;
    }
    public String checkString(String line) throws IncorrectValue{
        if(line.contains("*") || line.contains("+") ||line.contains("/") ||line.contains("$")||line.contains("#")){
            throw new IncorrectValue("Using special symbols!");
        }
        if(line.length() > 150){
            throw new IncorrectValue("Invalid size of sentence!");
        }
        return line;
    }
    public void checkYear(int year) throws IncorrectValue{
        if(year < 1550 || year > 2019){
            throw new IncorrectValue("Invalid year!");
        }
    }
    public void checkPages(int pages) throws IncorrectValue{
        if(pages < 1){
            throw new IncorrectValue("Invalid amount of pages");
        }
    }
    public void checkPrice(double price) throws IncorrectValue{
        if(price < 1 || price > 25000){
            throw new IncorrectValue("Invalid price! (from 1 to 25000)");
        }
    }
}