package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Service
@Transactional
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void save(Person person) {
        personDao.save(person);
    }

    public Person findById(Long id) {
        return personDao.findById(id);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void deleteById(Long id) {
        Person person = personDao.findById(id);
        personDao.delete(person);
    }
}
