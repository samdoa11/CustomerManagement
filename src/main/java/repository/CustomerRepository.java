package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import repository.entity.Customer;

/**
 * Created by Veronika on 01.03.2016.
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{
}
