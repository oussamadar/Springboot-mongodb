package service;

import org.sid.springbootcrudmongodb.Exception.CustomException;
import org.sid.springbootcrudmongodb.entities.Customer;
import org.sid.springbootcrudmongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return
                customerRepository.save(customer);
    }

    public List<Customer> saveListCustomers(List<Customer> customers){
        return customerRepository.saveAll(customers);
    }

    public List<Customer> getAllCustomer(){
       return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Long id,Customer customer) throws CustomException {
        Optional<Customer> c = customerRepository.findById(id);
        if(!c.isPresent()){
            throw  new CustomException("404","can not find a customer for updatting");
        }
        Customer customerToUpdate = c.get();
        customerToUpdate.affectCustomer(customer);

        return customerRepository.save(customerToUpdate);

    }

    public void deleteCustomerById( Long id){
        customerRepository.deleteById(id);
    }

    public void deleteAll(){
        customerRepository.deleteAll();
    }


}
