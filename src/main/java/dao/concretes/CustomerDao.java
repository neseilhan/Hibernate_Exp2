package dao.concretes;

import core.HibernateSession;
import dao.abstracts.ICustomerDao;
import entities.Customer;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CustomerDao implements ICustomerDao {

    //Burada sadece veritabanı işlemleri olacak.

    private final Session session;

    public CustomerDao() {
        this.session = HibernateSession.getSession(); //Artık Hibernate'in session'ına erişebiliyorum.
    }

    @Override
    public void save(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public Customer findById(int id) {
        return this.session.get(Customer.class, id);
    }

    @Override
    public void update(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public void delete(Customer customer) {
        this.session.beginTransaction();
        this.session.remove(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public List<Customer> findAll() {
        return this.session.createSelectionQuery("FROM customer", Customer.class).getResultList();
    }

    @Override
    public Customer findbyMail(String mail) {
        SelectionQuery<Customer> query = this.session.createSelectionQuery("FROM Customer WHERE mail = :mail", Customer.class);
        query.setParameter("mail", mail);
        return query.getSingleResultOrNull(); //veri varsa yollayacak yoksa null döndürecek.
    }
}
