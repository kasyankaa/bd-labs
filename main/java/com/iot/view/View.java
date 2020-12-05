package com.iot.view;

import com.iot.controller.CountryController;
import com.iot.controller.DeliveryController;
import com.iot.controller.FactoryController;
import com.iot.controller.RegionController;
import com.iot.model.entity.Country;
import com.iot.model.entity.Delivery;
import com.iot.model.entity.Factory;
import com.iot.model.entity.Region;

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



    }

    //-----------------------------------------------
//                 COUNTRIES
// ----------------------------------------------
    private void getAllCountries() throws SQLException {
        System.out.println("\nGetting all countries");
        System.out.println(countryController.findAll() + "\n");
    }

    private void getCountryByID() throws SQLException {
        System.out.println("\nGetting specific country.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(countryController.findOne(id) + "\n");
    }

    private Country getCountriesInputs() {
        System.out.println("\nEnter country name:");
        String countryName = SCANNER.next();
        return new Country(countryName);
    }

    private void createCountry() throws SQLException {
        System.out.println("\nCreating country");
        Country country = getCountriesInputs();
        countryController.create(country);
        System.out.println("Country created\n");
    }

    private void updateCountry() throws SQLException {
        System.out.println("\nUpdating country.Enter id:");
        Integer id = SCANNER.nextInt();
        Country country = getCountriesInputs();
        country.setId(id);

        countryController.update(country.getId(), country);
        System.out.println("Updated country with id:" + id + "\n");
    }

    private void deleteCountry() throws SQLException {
        System.out.println("\nDeleting country.Enter id:");
        int id = SCANNER.nextInt();
        countryController.delete(id);
        System.out.println("Deleted country with id:" + id + "\n");
    }
    //--------------------------------------
//                 REGIONS
//---------------------------------------
    private void getAllRegions() throws SQLException {
        System.out.println("\nGetting all regions");
        System.out.println(regionController.findAll() + "\n");
    }

    private void getRegionsByID() throws SQLException {
        System.out.println("\nGetting specific region.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(regionController.findOne(id) + "\n");
    }

    private Region getRegionsInputs() throws SQLException {
        System.out.println("\nEnter country:");
        Integer  id = SCANNER.nextInt();
        Country country = countryController.findOne(id);
        System.out.println("\nEnter region name:");
        String regionName = SCANNER.next();
        return new Region( country,regionName);
    }

    private void createRegion() throws SQLException {
        System.out.println("\nCreating region");
        Region region = getRegionsInputs();
        regionController.create(region);
        System.out.println("Region created\n");
    }

    private void updateRegion() throws SQLException {
        System.out.println("\nUpdating region.Enter id:");
        Integer id = SCANNER.nextInt();
        Region region = getRegionsInputs();
        region.setId(id);

        regionController.update(region.getId(), region);
        System.out.println("Updated region with id:" + id + "\n");
    }

    private void deleteRegion() throws SQLException {
        System.out.println("\nDeleting region.Enter id:");
        int id = SCANNER.nextInt();
        regionController.delete(id);
        System.out.println("Deleted region with id:" + id + "\n");
    }
    //--------------------------------------
//                 FACTORIES
//---------------------------------------
    private void getAllFactories() throws SQLException {
        System.out.println("\nGetting all factories:");
        System.out.println(factoryController.findAll() + "\n");
    }

    private void getFactoryByID() throws SQLException {
        System.out.println("\nGetting specific factory.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(factoryController.findOne(id) + "\n");
    }

    private Factory getFactoriesInputs() throws SQLException {
        System.out.println("\nEnter region id:");
        Integer  id = SCANNER.nextInt();
        Region region = regionController.findOne(id);
        System.out.println("\nEnter address:");
        String address = SCANNER.next();
        System.out.println("\nEnter number of workers:");
        Integer numberOfWorkers = Integer.valueOf(SCANNER.next());
        System.out.println("\nEnter phone number:");
        String phoneNumber = SCANNER.next();
        return new Factory(region, address, numberOfWorkers, phoneNumber);
    }

    private void createFactory() throws SQLException {
        System.out.println("\nCreating factory");
        Factory factory = getFactoriesInputs();
        factoryController.create(factory);
        System.out.println("Factory created\n");
    }

    private void updateFactory() throws SQLException {
        System.out.println("\nUpdating factory.Enter id:");
        Integer id = SCANNER.nextInt();
        Factory factory = getFactoriesInputs();
        factory.setId(id);

        factoryController.update(factory.getId(), factory);
        System.out.println("Updated factory with id:" + id + "\n");
    }

    private void deleteFactory() throws SQLException {
        System.out.println("\nDeleting factory.Enter id:");
        int id = SCANNER.nextInt();
        factoryController.delete(id);
        System.out.println("Deleted factory with id:" + id + "\n");
    }


    //--------------------------------------
//                 DELIVERIES
//---------------------------------------
    private void getAllDeliveries() throws SQLException {
        System.out.println("\nGetting all deliveries");
        System.out.println(deliveryController.findAll() + "\n");
    }

    private void getDeliveryByID() throws SQLException {
        System.out.println("\nGetting specific delivery.Enter id:");
        Integer id = SCANNER.nextInt();
        System.out.println(deliveryController.findOne(id) + "\n");
    }

    private Delivery getDeliveriesInputs() throws SQLException {
        System.out.println("\nEnter factory id:");
        Integer id = Integer.valueOf(SCANNER.next());
        Factory factory = factoryController.findOne(id);
        System.out.println("\nEnter car number:");
        String carNumber = SCANNER.next();
        return new Delivery(factory, carNumber);
    }

    private void createDelivery() throws SQLException {
        System.out.println("\nCreating delivery");
        Delivery delivery = getDeliveriesInputs();
        deliveryController.create(delivery);
        System.out.println("Delivery created\n");
    }

    private void updateDelivery() throws SQLException {
        System.out.println("\nUpdating delivery.Enter id:");
        Integer id = SCANNER.nextInt();
        Delivery delivery = getDeliveriesInputs();
        delivery.setId(id);

        deliveryController.update(delivery.getId(), delivery);
        System.out.println("Updated delivery with id:" + id + "\n");
    }

    private void deleteDelivery() throws SQLException {
        System.out.println("\nDeleting delivery.Enter id:");
        int id = SCANNER.nextInt();
        deliveryController.delete(id);
        System.out.println("Deleted delivery with id:" + id + "\n");
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


