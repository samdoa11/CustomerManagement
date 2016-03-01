package repository.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Veronika on 01.03.2016.
 */
@Entity
@Table
@XStreamAlias("customer")
public class Customer implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
