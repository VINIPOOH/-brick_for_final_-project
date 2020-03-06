package ua.testing.internationalJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.testing.internationalJPA.entity.Person;
import ua.testing.internationalJPA.repository.PersonRepository;

import java.util.List;

@Service
public class UserService {

    PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllUsers(){
        return personRepository.findAll();
    }
}
