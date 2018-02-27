package com.lmx.demo.processor;

import com.lmx.demo.bean.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

/**
 * @author  liumingxin
 * @create   2018/2/26 10:30
 * @desc
 */
@Service
public class PersonItemProcessor implements ItemProcessor<Person, Person> {


    @Override
    public Person process(Person person) throws Exception {
        person.setAge(person.getAge() + 1);
        person.setName(person.getName() + "-_-");
        return person;
    }
}
