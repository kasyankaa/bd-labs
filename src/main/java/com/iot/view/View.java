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
  private final CountryController countryController = new CountryController();
  private final RegionController regionController = new RegionController();
  private final FactoryController factoryController = new FactoryController();
  private final DeliveryController deliveryController = new DeliveryController();
  private final WorkerDeliversController workerDeliversController = new WorkerDeliversController();
  private final WorkerController workerController = new WorkerController();


  public View() {
    //CHOOSE
    menu.put("11", this::getAllCountries);
    menu.put("12", this::getCountryByID);
    menu.put("13", this::createCountry);
    menu.put("14", this::updateCountry);
    menu.put("15", this::deleteCountry);
    menu.put("21", this::getAllRegions);
    menu.put("22", this::getRegionsByID);
    menu.put("23", this::createRegion);
    menu.put("24", this::updateRegion);
    menu.put("25", this::deleteRegion);
    menu.put("31", this::getAllFactories);
    menu.put("32", this::getFactoryByID);
    menu.put("33", this::createFactory);
    menu.put("34", this::updateFactory);
    menu.put("35", this::deleteFactory);
    menu.put("41", this::getAllDeliveries);
    menu.put("42", this::getDeliveryByID);
    menu.put("43", this::createDelivery);
    menu.put("44", this::updateDelivery);
    menu.put("45", this::deleteDelivery);
    menu.put("51", this::getAllWorkerDeliveries);
    menu.put("52", this::getWorkerDeliveryByID);
    menu.put("53", this::createWorkerDelivery);
    menu.put("54", this::updateWorkerDelivery);
    menu.put("55", this::deleteWorkerDelivery);
    menu.put("61", this::getAllWorkers);
    menu.put("62", this::getWorkerByID);
    menu.put("63", this::createWorker);
    menu.put("64", this::updateWorker);
    menu.put("65", this::deleteWorker);


  }

  //-----------------------------------------------
//                 COUNTRIES
// ----------------------------------------------
  private void getAllCountries() throws SQLException {
    System.out.println("\n--Getting all countries--");
    System.out.println(countryController.findAll() + "\n");
  }

  private void getCountryByID() throws SQLException {
    System.out.println("\n--Getting specific country.Enter id: ");
    Integer id = SCANNER.nextInt();
    System.out.println(countryController.findOne(id) + "\n");
  }

  private Country getCountriesInputs() {
    System.out.println("\nEnter country name: ");
    String countryName = SCANNER.next();
    return new Country(countryName);
  }

  private void createCountry() throws SQLException {
    System.out.println("\n--Creating country--");
    Country country = getCountriesInputs();
    countryController.create(country);
    System.out.println("--Country created--\n");
  }

  private void updateCountry() throws SQLException {
    System.out.println("\n--Updating country.Enter id:");
    Integer id = SCANNER.nextInt();
    Country country = getCountriesInputs();
    country.setId(id);

    countryController.update(country.getId(), country);
    System.out.println("Updated country with id=" + id + "\n");
  }

  private void deleteCountry() throws SQLException {
    System.out.println("\n--Deleting country.Enter id:");
    int id = SCANNER.nextInt();

    countryController.delete(id);
    System.out.println("--Deleted country with id=" + id + "\n");
  }


  //--------------------------------------
//                 REGIONS
//---------------------------------------
  private void getAllRegions() throws SQLException {
    System.out.println("\n--Getting all regions--");
    System.out.println(regionController.findAll() + "\n");
  }

  private void getRegionsByID() throws SQLException {
    System.out.println("\n--Getting specific region.Enter id:");
    Integer id = SCANNER.nextInt();
    System.out.println(regionController.findOne(id) + "\n");
  }

  private Region getRegionsInputs() {
    System.out.println("\nEnter country name:");
    String regionName = SCANNER.next();
    System.out.println("\nEnter region name:");
    String countryName = SCANNER.next();
    return new Region(countryName, regionName);
  }

  private void createRegion() throws SQLException {
    System.out.println("\n--Creating region--");
    Region region = getRegionsInputs();
    regionController.create(region);
    System.out.println("--Region created--\n");
  }

  private void updateRegion() throws SQLException {
    System.out.println("\n--Updating region.Enter id:");
    Integer id = SCANNER.nextInt();
    Region region = getRegionsInputs();
    region.setId(id);

    regionController.update(region.getId(), region);
    System.out.println("Updated region with id=" + id + "\n");
  }

  private void deleteRegion() throws SQLException {
    System.out.println("\n--Deleting region.Enter id:");
    int id = SCANNER.nextInt();

    regionController.delete(id);
    System.out.println("--Deleted region with id=" + id + "\n");
  }

  //--------------------------------------
//                 FACTORIES
//---------------------------------------
  private void getAllFactories() throws SQLException {
    System.out.println("\n--Getting all factories--");
    System.out.println(factoryController.findAll() + "\n");
  }

  private void getFactoryByID() throws SQLException {
    System.out.println("\n--Getting specific factory.Enter id:");
    Integer id = SCANNER.nextInt();
    System.out.println(factoryController.findOne(id) + "\n");
  }

  private Factory getFactoriesInputs() {
    System.out.println("\nEnter region:");
    String region = SCANNER.next();
    System.out.println("\nEnter address:");
    String address = SCANNER.next();
    System.out.println("\nEnter number of workers:");
    Integer numberOfWorkers = Integer.valueOf(SCANNER.next());
    System.out.println("\nEnter phone number:");
    String phoneNumber = SCANNER.next();
    return new Factory(region, address, numberOfWorkers, phoneNumber);
  }

  private void createFactory() throws SQLException {
    System.out.println("\n--Creating factory--");
    Factory factory = getFactoriesInputs();
    factoryController.create(factory);
    System.out.println("--Factory created--\n");
  }

  private void updateFactory() throws SQLException {
    System.out.println("\n--Updating factory.Enter id:");
    Integer id = SCANNER.nextInt();
    Factory factory = getFactoriesInputs();
    factory.setId(id);

    factoryController.update(factory.getId(), factory);
    System.out.println("Updated factory with id=" + id + "\n");
  }

  private void deleteFactory() throws SQLException {
    System.out.println("\n--Deleting factory.Enter id:");
    int id = SCANNER.nextInt();
    factoryController.delete(id);
    System.out.println("--Deleted factory with id=" + id + "\n");
  }


  //--------------------------------------
//                 DELIVERIES
//---------------------------------------
  private void getAllDeliveries() throws SQLException {
    System.out.println("\n--Getting all deliveries--");
    System.out.println(deliveryController.findAll() + "\n");
  }

  private void getDeliveryByID() throws SQLException {
    System.out.println("\n--Getting specific delivery.Enter id:");
    Integer id = SCANNER.nextInt();
    System.out.println(deliveryController.findOne(id) + "\n");
  }

  private Delivery getDeliveriesInputs() {
    System.out.println("\nEnter factoryId:");
    Integer factoryId = Integer.valueOf(SCANNER.next());
    System.out.println("\nEnter car number:");
    String carNumber = SCANNER.next();
    return new Delivery(factoryId, carNumber);
  }

  private void createDelivery() throws SQLException {
    System.out.println("\n--Creating delivery--");
    Delivery delivery = getDeliveriesInputs();
    deliveryController.create(delivery);
    System.out.println("--Delivery created--\n");
  }

  private void updateDelivery() throws SQLException {
    System.out.println("\n--Updating delivery.Enter id:");
    Integer id = SCANNER.nextInt();
    Delivery delivery = getDeliveriesInputs();
    delivery.setId(id);

    deliveryController.update(delivery.getId(), delivery);
    System.out.println("Updated delivery with id=" + id + "\n");
  }

  private void deleteDelivery() throws SQLException {
    System.out.println("\n--Deleting delivery.Enter id:");
    int id = SCANNER.nextInt();
    deliveryController.delete(id);
    System.out.println("--Deleted delivery with id=" + id + "\n");
  }


  //--------------------------------------
//                 WORKER_DELIVERIES
//---------------------------------------
  private void getAllWorkerDeliveries() throws SQLException {
    System.out.println("\n--Getting all worker deliveries--");
    System.out.println(workerDeliversController.findAll() + "\n");
  }

  private void getWorkerDeliveryByID() throws SQLException {
    System.out.println("\n--Getting specific worker delivery.Enter id:");
    Integer id = SCANNER.nextInt();
    System.out.println(workerDeliversController.findOne(id) + "\n");
  }

  private WorkerDelivers getWorkerDeliveriesInputs() {
    System.out.println("\nEnter delivery id:");
    Integer deliveryId = Integer.valueOf(SCANNER.next());
    System.out.println("\nEnter worker id:");
    Integer workerId = Integer.valueOf(SCANNER.next());
    System.out.println("\nEnter address of factory:");
    String addressOfFactory = SCANNER.next();
    System.out.println("\nEnter address of  automat:");
    String addressOfAutomat = SCANNER.next();
    return new WorkerDelivers(deliveryId, workerId, addressOfFactory, addressOfAutomat);
  }

  private void createWorkerDelivery() throws SQLException {
    System.out.println("\n--Creating worker delivery--");
    WorkerDelivers workerDelivers = getWorkerDeliveriesInputs();
    workerDeliversController.create(workerDelivers);
    System.out.println("--Delivery created--\n");
  }

  private void updateWorkerDelivery() throws SQLException {
    System.out.println("\n--Updating worker delivery.Enter id:");
    Integer id = SCANNER.nextInt();
    WorkerDelivers workerDelivers = getWorkerDeliveriesInputs();
    workerDelivers.setId(id);

    workerDeliversController.update(workerDelivers.getId(), workerDelivers);
    System.out.println("Updated delivery with id=" + id + "\n");
  }

  private void deleteWorkerDelivery() throws SQLException {
    System.out.println("\n--Deleting worker delivery.Enter id:");
    int id = SCANNER.nextInt();
    workerDeliversController.delete(id);
    System.out.println("--Deleted delivery with id=" + id + "\n");
  }

  //--------------------------------------
//                 WORKERS
//---------------------------------------
  private void getAllWorkers() throws SQLException {
    System.out.println("\n--Getting all workers--");
    System.out.println(workerController.findAll() + "\n");
  }

  private void getWorkerByID() throws SQLException {
    System.out.println("\n--Getting specific worker.Enter id:");
    Integer id = SCANNER.nextInt();
    System.out.println(workerController.findOne(id) + "\n");
  }

  private Worker getWorkersInputs() {
    System.out.println("\nEnter name:");
    String name = SCANNER.next();
    System.out.println("\nEnter surname:");
    String surname = SCANNER.next();
    System.out.println("\nEnter phone number:");
    String phoneNumber = SCANNER.next();
    return new Worker(name, surname, phoneNumber);
  }

  private void createWorker() throws SQLException {
    System.out.println("\n--Creating worker--");
    Worker worker = getWorkersInputs();
    workerController.create(worker);
    System.out.println("--Worker created--\n");
  }

  private void updateWorker() throws SQLException {
    System.out.println("\n--Updating worker.Enter id:");
    Integer id = SCANNER.nextInt();
    Worker worker = getWorkersInputs();
    worker.setId(id);

    workerController.update(worker.getId(), worker);
    System.out.println("Updated worker with id=" + id + "\n");
  }

  private void deleteWorker() throws SQLException {
    System.out.println("\n--Deleting worker.Enter id:");
    int id = SCANNER.nextInt();
    workerController.delete(id);
    System.out.println("--Deleted worker with id=" + id + "\n");
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