package com.HibernateJPA.HibernateJPA.loader;

import com.HibernateJPA.HibernateJPA.manyToMany.entity.Category;
import com.HibernateJPA.HibernateJPA.manyToMany.entity.Product;
import com.HibernateJPA.HibernateJPA.manyToMany.repo.CategoryRepo;
import com.HibernateJPA.HibernateJPA.oneToMany.entity.Address;
import com.HibernateJPA.HibernateJPA.oneToMany.entity.Person;
import com.HibernateJPA.HibernateJPA.oneToMany.repo.AddressRepo;
import com.HibernateJPA.HibernateJPA.oneToMany.repo.PersonRepo;
import com.HibernateJPA.HibernateJPA.oneToOne.entity.Laptop;
import com.HibernateJPA.HibernateJPA.oneToOne.entity.Student;
import com.HibernateJPA.HibernateJPA.oneToOne.repo.LaptopRepo;
import com.HibernateJPA.HibernateJPA.oneToOne.repo.StudentRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class DataLoader implements ApplicationRunner {

    private final StudentRepo studentRepo;
    private final LaptopRepo laptopRepo;
    private final PersonRepo personRepo;
    private final AddressRepo addressRepo;
    private final CategoryRepo categoryRepo;

    public DataLoader(StudentRepo studentRepo, LaptopRepo laptopRepo, PersonRepo personRepo, AddressRepo addressRepo, CategoryRepo categoryRepo) {
        this.studentRepo = studentRepo;
        this.laptopRepo = laptopRepo;
        this.personRepo = personRepo;
        this.addressRepo = addressRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //------ One To One----------
        //save into database
        Student student = new Student();
        student.setStudentName("Nafees");
        student.setAbout("Bachelor");

        Laptop laptop = new Laptop();
        laptop.setAbout("Lenevo");
        laptop.setModelName("LNV123");
        laptop.setStudent(student);
        student.setLaptop(laptop);
        
        studentRepo.save(student);

        //Get from database:
        Laptop byId1 = laptopRepo.findById(1).get();
        System.out.println(byId1.getStudent());
        Student byId = studentRepo.findById(1).get();
        System.out.println(byId.getLaptop());

        //-------OneToMany-------
        Person person = new Person();
        person.setName("Nafees");
        person.setAbout("Software Engineer");

        Address address = new Address();
        address.setCity("New Delhi");
        address.setStreet("22/4");
        address.setCountry("India");
        address.setPerson(person);
        person.setAddressList(Arrays.asList(address));

        personRepo.save(person);

        //-------ManyToMany-------
        Product product1 = new Product();
        product1.setpId("pId1");
        product1.setProductName("Iphone");

        Product product2 = new Product();
        product2.setpId("pId2");
        product2.setProductName("Honor");

        Product product3 = new Product();
        product3.setpId("pId3");
        product3.setProductName("Samsung");

        Category category1 = new Category();
        category1.setcId("cId1");
        category1.setTittle("Electronics");

        Category category2 = new Category();
        category2.setcId("cId2");
        category2.setTittle("Mobiles");

        List<Product> category1Products = category1.getProducts();
        category1Products.add(product1);
        category1Products.add(product2);
        category1Products.add(product3);

        List<Product> category2Products = category2.getProducts();
        category2Products.add(product1);
        category2Products.add(product2);

        categoryRepo.save(category1);
        categoryRepo.save(category2);


    }
}
