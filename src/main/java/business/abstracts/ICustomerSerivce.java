package business.abstracts;

import dao.abstracts.ICustomerDao;
import entities.Customer;

import java.util.List;

public interface ICustomerSerivce {

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void deleteById(int id);

    List<Customer> findAll();
}
