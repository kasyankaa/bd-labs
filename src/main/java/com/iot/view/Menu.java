package com.iot.view;

public class Menu {
  public void displayMenu() {


    System.out.println(" _______________________________________________________________________");
    System.out.println("|                                                                        |");
    System.out.println("|       Enter any combination of existing entity and CRUD number :       |");
    System.out.println("|________________________________________________________________________|");
    System.out.println("|                                   |                                    |");
    System.out.println("|        entity number:             |           CRUD number:             |");
    System.out.println("|___________________________________|_____________________________________|");
    System.out.println("|   |                               |   |                                |");
    System.out.println("| 1 | country                       | 1 | GET ALL                        |");
    System.out.println("| 2 | region                        | 2 | GET ONE                        |");
    System.out.println("| 3 | factory                       | 3 | CREATE                         |");
    System.out.println("| 4 | delivery                      | 4 | UPDATE                         |");
    System.out.println("| 5 | worker_delivers               | 5 | DELETE                         |");
    System.out.println("| 6 | worker                        |   |                                |");
    System.out.println("|___|_______________________________|___|________________________________|");
  }
}