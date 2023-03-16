package arief.belajar.java.unit.test.service;

import arief.belajar.java.unit.test.data.Person;
import arief.belajar.java.unit.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {

        Mockito.when(personRepository.selectById("java"))
                .thenReturn(new Person("java","Java"));

        var person = personService.get("java");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("java", person.getId());
        Assertions.assertEquals("Java", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Jaya");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Jaya", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Jaya"));
    }
}
