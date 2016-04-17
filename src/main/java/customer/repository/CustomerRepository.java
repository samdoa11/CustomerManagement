package customer.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import customer.repository.entity.Customer;

/**
 * Created by Veronika on 01.03.2016.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{

}
