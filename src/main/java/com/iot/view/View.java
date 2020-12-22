package com.iot.view;

import com.iot.controller.*;
import com.iot.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class View {
    private  final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private final CompanyController companyController = new CompanyController();
    private final WebsiteController websiteController = new WebsiteController();
    private final ProgramController programController = new ProgramController();
    private final ReporterController reporterController = new ReporterController();

    public View() {
        //CHOOSE
        menu.put("11", this::getAllCompanies);
        menu.put("12", this::getCompanyByID);
        menu.put("13", this::createCompany);
        menu.put("14", this::updateCompany);
        menu.put("15", this::deleteCompany);
        menu.put("21", this::getAllWebsite);
        menu.put("22", this::getWebsiteByID);
        menu.put("23", this::createWebsite);
        menu.put("24", this::updateWebsite);
        menu.put("25", this::deleteWebsite);
        menu.put("31", this::getAllPrograms);
        menu.put("32", this::getProgramsByID);
        menu.put("33", this::createProgram);
        menu.put("34", this::updateProgram);
        menu.put("35", this::deleteProgram);
        menu.put("41", this::getAllReporters);
        menu.put("42", this::getReportedByID);
        menu.put("43", this::createReporter);
        menu.put("44", this::updateReporter);
        menu.put("45", this::deleteReporter);



    }

    //-----------------------------------------------
//                 Companies
// ----------------------------------------------
    private void getAllCompanies() throws SQLException {
        System.out.println("\n--Getting all companies--");
        System.out.println(companyController.findAll() + "\n");
    }

    private void getCompanyByID() throws SQLException {
        System.out.println("\n--Getting specific company.Enter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(companyController.findOne(id) + "\n");
    }

    private Company getCompaniesInputs() {
        System.out.println("\nEnter company name: ");
        String name = SCANNER.next();
        return new Company(name);
    }

    private void createCompany() throws SQLException {
        System.out.println("\n--Creating company--");
        Company company = getCompaniesInputs();
        companyController.create(company);
        System.out.println("--Company created--\n");
    }

    private void updateCompany() throws SQLException {
        System.out.println("\n--Updating company.Enter id:");
        Integer id = SCANNER.nextInt();
        Company company = getCompaniesInputs();
        company.setId(id);

        companyController.update(company.getId(), company);
        System.out.println("Updated company with id=" + id + "\n");
    }

    private void deleteCompany() throws SQLException {
        System.out.println("\n--Deleting company.Enter id:");
        int id = SCANNER.nextInt();

        companyController.delete(id);
        System.out.println("--Deleted company with id=" + id + "\n");
    }



    //--------------------------------------
//                 Website
//---------------------------------------
    private void getAllWebsite() throws SQLException {
        System.out.println("\n--Getting all websites--");
        System.out.println(websiteController.findAll() + "\n");
    }

    private void getWebsiteByID() throws SQLException {
        System.out.println("\n--Getting specific website.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(websiteController.findOne(id) + "\n");
    }

    private Website getWebsiteInputs() {
        System.out.println("\nEnter company id:");
        Integer companyId = Integer.valueOf(SCANNER.next());
        System.out.println("\nEnter website link:");
        String link = SCANNER.next();
        return new Website(companyId,link);
    }

    private void createWebsite() throws SQLException {
        System.out.println("\n--Creating website--");
        Website website = getWebsiteInputs();
        websiteController.create(website);
        System.out.println("--Website created--\n");
    }

    private void updateWebsite() throws SQLException {
        System.out.println("\n--Updating website.Enter id:");
        Integer id = SCANNER.nextInt();
        Website website = getWebsiteInputs();
        website.setId(id);

        websiteController.update(website.getId(), website);
        System.out.println("Updated website with id=" + id + "\n");
    }

    private void deleteWebsite() throws SQLException {
        System.out.println("\n--Deleting website.Enter id:");
        int id = SCANNER.nextInt();

        websiteController.delete(id);
        System.out.println("--Deleted website with id=" + id + "\n");
    }

    //--------------------------------------
//                 Program
//---------------------------------------
    private void getAllPrograms() throws SQLException {
        System.out.println("\n--Getting all programs--");
        System.out.println(programController.findAll() + "\n");
    }

    private void getProgramsByID() throws SQLException {
        System.out.println("\n--Getting specific program.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(programController.findOne(id) + "\n");
    }

    private Program getProgramInputs() {
        System.out.println("\nEnter company id:");
        Integer companyId = Integer.valueOf(SCANNER.next());
        System.out.println("\nEnter name:");
        String name = SCANNER.next();
        System.out.println("\nEnter language:");
        String language = SCANNER.next();
        return new Program(companyId,name, language);
    }

    private void createProgram() throws SQLException {
        System.out.println("\n--Creating program--");
        Program program = getProgramInputs();
        programController.create(program);
        System.out.println("--Program program--\n");
    }

    private void updateProgram() throws SQLException {
        System.out.println("\n--Updating program.Enter id:");
        Integer id = SCANNER.nextInt();
        Program program = getProgramInputs();
        program.setId(id);

        programController.update(program.getId(), program);
        System.out.println("Updated program with id=" + id + "\n");
    }

    private void deleteProgram() throws SQLException {
        System.out.println("\n--Deleting program.Enter id:");
        int id = SCANNER.nextInt();
        programController.delete(id);
        System.out.println("--Deleted program with id=" + id + "\n");
    }


    //--------------------------------------
//                 Reporter
//---------------------------------------
    private void getAllReporters() throws SQLException {
        System.out.println("\n--Getting all reporters--");
        System.out.println(reporterController.findAll() + "\n");
    }

    private void getReportedByID() throws SQLException {
        System.out.println("\n--Getting specific reporter.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(reporterController.findOne(id) + "\n");
    }

    private Reporter getReportersInputs() {
        System.out.println("\nEnter program id:");
        Integer programId = Integer.valueOf(SCANNER.next());
        System.out.println("\nEnter first name:");
        String first_name = SCANNER.next();
        System.out.println("\nEnter last name:");
        String last_name = SCANNER.next();
        return new Reporter(programId, first_name, last_name);
    }

    private void createReporter() throws SQLException {
        System.out.println("\n--Creating reporter--");
        Reporter reporter = getReportersInputs();
        reporterController.create(reporter);
        System.out.println("--Reporter created--\n");
    }

    private void updateReporter() throws SQLException {
        System.out.println("\n--Updating reporter.Enter id:");
        Integer id = SCANNER.nextInt();
        Reporter reporter = getReportersInputs();
        reporter.setId(id);

        reporterController.update(reporter.getId(), reporter);
        System.out.println("Updated reporter with id=" + id + "\n");
    }

    private void deleteReporter() throws SQLException {
        System.out.println("\n--Deleting reporter.Enter id:");
        int id = SCANNER.nextInt();
        reporterController.delete(id);
        System.out.println("--Deleted reporter with id=" + id + "\n");
    }
    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nSO what now?:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }
}