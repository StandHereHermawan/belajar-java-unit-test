package arief.belajar.java.unit.test.service;

import arief.belajar.java.unit.test.data.Person;
import arief.belajar.java.unit.test.repository.PersonRepository;

import java.util.UUID;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(String id) {
        Person person = personRepository.selectById(id);
        if (person != null) {
            return person;
        } else {
            throw new IllegalArgumentException("Person Not Found");
        }
    }

    public Person register(String name){
        var person = new Person(UUID.randomUUID().toString(), name);
        personRepository.insert(person);
        return person;
    }
}
