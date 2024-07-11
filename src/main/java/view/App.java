package view;

import business.concretes.CustomerManager;
import dao.concretes.CustomerDao;
import entities.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {



        CustomerManager customerManager = new CustomerManager(new CustomerDao());
          /*
        Customer customer = new Customer();
        customer.setName("Spring dersleri");
        customer.setMail("info@example.dev"); //aynı maille bir daha eklenemez.
        customer.setGender(Customer.Gender.FEMALE);
        customer.setOndate(LocalDate.now());

        customerManager.save(customer);

         */

//        Customer firstCustomer = customerManager.findById(1);
//        System.out.println(firstCustomer.toString()); //ID'si 1 olan customer gelir.

//        customerManager.deleteById(2); //ID'si 2 olan veriyi siler.
//        Customer customer = customerManager.findById(1);
//        customer.setName("Update Test");
//        customerManager.update(customer); //Update ederken de mail aynı olmasını önlemek için managerda degisiklikler yapildi.

        List<Customer> customerList = customerManager.findAll(); //customerlar liste halinde çekilir.
        System.out.println(customerList.toString());




    }
}
