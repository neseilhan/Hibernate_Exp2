package business.concretes;

import business.abstracts.ICustomerSerivce;
import dao.abstracts.ICustomerDao;
import entities.Customer;

import java.util.List;

public class CustomerManager implements ICustomerSerivce {

    private final ICustomerDao customerDao;

    //Dependency Injection
    public CustomerManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findbyMail(customer.getMail());
        if(checkMailCustomer != null){
            throw new RuntimeException(customer.getMail() + "bu e-posta adresi daha onceden eklenmis.") ;
        }
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
