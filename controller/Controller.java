package com.epam.controller;
import com.epam.model.Book;
import com.epam.model.Books;
import com.epam.view.View;

import java.util.Scanner;

public class Controller {

    int id = 0;
    String name = "";
    String author = "";
    String publishingHouse = "";
    int yearOfPublishing = 0;
    int pages = 0;
    double price = 0.0;

    Scanner sc = new Scanner(System.in);
    View view = new View();
    Validator val = new Validator();
    int size = 0;
    Books array;

    public void getInput()
    {
        view.printMessage(view.amountOfBooks);
        size = sc.nextInt();
        array = new Books(size);

        for (int i = 0; i < size; i++) {
            view.printMessage(view.space);
            array.addBook(enterBook());
        }
        view.printBooks(array.getBooks());

        int choice = 0;
        do {
            view.printMessage(view.choose);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    view.printMessage(view.percent);
                    double per = sc.nextDouble();
                    array.changePrice(per);
                    view.printBooks(array.getBooks());
                    break;
                case 2:
                    view.printMessage(view.addAuthor);
                    String searchAuthor = sc.nextLine();
                    Books ob = array.searchByAuthor(searchAuthor);
                    view.printBooks(ob.getBooks());
                    break;
                case 3:
                    view.printMessage(view.addYear);
                    int year = sc.nextInt();
                    Books search = array.searchByYear(year);
                    view.printBooks(search.getBooks());
                    break;
                case 4:
                    view.printMessage("Sort By Author");
                    array.sortByAuthor();
                    break;
                case 5:
                    view.printMessage("Sort By Publishing house");
                    array.sortByPublishingHouse();
                    break;
                case 6:
                    view.printMessage("Sort By price");
                    array.sortByPrice();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    public Book enterBook(){
        boolean isValidId = false;
        boolean isValidName = false;
        boolean isValidAuthor = false;
        boolean isValidHouse = false;
        boolean isValidYear = false;
        boolean isValidPages = false;
        boolean isValidPrice = false;
        do {
            view.printMessage(view.id);
            int input = sc.nextInt();
            sc.nextLine();
            try {
                val.checkId(input);
                id = input;
                isValidId = true;
            }
            catch (IncorrectValue ee){
                System.out.println(ee.getMessage());
            }
        }while(isValidId != true);

        do{
            view.printMessage(view.name);
            String inputStr = sc.nextLine();
            try {
                val.checkString(inputStr);
                name = inputStr;
                isValidName = true;
            }
            catch (IncorrectValue ee){
                System.out.println(ee.getMessage());
            }
        }while (isValidName != true);

        do {
            view.printMessage(view.author);
            String line = sc.nextLine();
            try {
                val.checkString(line);
                author = line;
                isValidAuthor = true;
            }
            catch (IncorrectValue ee){
                System.out.println(ee.getMessage());
            }
        }while (!isValidAuthor);

        do {
            view.printMessage(view.house);
            String publishing = sc.nextLine();
            try {
                val.checkString(publishing);
                publishingHouse = publishing;
                isValidHouse = true;
            }
            catch (IncorrectValue ee){
                System.out.println(ee.getMessage());
            }
        }while (!isValidHouse);

        do {
            view.printMessage(view.year);
            int year = sc.nextInt();
            try {
                val.checkYear(year);
                yearOfPublishing = year;
                isValidYear = true;
            }
            catch (IncorrectValue ee){
                System.out.println(ee.getMessage());
            }
        }while (!isValidYear);

        do {
            view.printMessage(view.pages);
            int page = sc.nextInt();
            try {
                val.checkPages(page);
                pages = page;
                isValidPages = true;
            }
            catch (IncorrectValue ee){
                System.out.println(ee.getMessage());
            }
        }while (!isValidPages);

        do {
            view.printMessage(view.price);
            double prices = sc.nextDouble();
            try {
                val.checkPrice(prices);
                price = prices;
                isValidPrice = true;
            }
            catch (IncorrectValue ee){
                System.out.println(ee.getMessage());
            }
        }while (!isValidPrice);

            Book item = new Book(id, name, author, publishingHouse, yearOfPublishing,
                    pages, price);
        return item;
    }
}