package lsn.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer age;
     private String fullContent;
     private List<String> schools =new  ArrayList<String>();
     private Address address ;
     private Set<String> cloth = new HashSet<String>();
    // Constructors

    /** default constructor */
    public User() {
    }

	public Set<String> getCloth() {
		return cloth;
	}

	public void setCloth(Set<String> cloth) {
		this.cloth = cloth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/** minimal constructor */
    public User(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public List<String> getSchools() {
		return schools;
	}

	public void setSchools(List<String> schools) {
		this.schools = schools;
	}

	public String getFullContent() {
		return fullContent;
	}

	public void setFullContent(String fullContent) {
		this.fullContent = fullContent;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
   








}