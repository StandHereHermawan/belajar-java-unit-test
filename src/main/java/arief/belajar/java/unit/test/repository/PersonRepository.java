package arief.belajar.java.unit.test.repository;

import arief.belajar.java.unit.test.data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person person);

}
