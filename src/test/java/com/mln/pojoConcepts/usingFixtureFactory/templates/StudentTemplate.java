package com.mln.pojoConcepts.usingFixtureFactory.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;
import com.mln.pojoConcepts.usingFixtureFactory.Skills;
import com.mln.pojoConcepts.usingFixtureFactory.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTemplate implements TemplateLoader {


    @Override
    public void load() {
        Fixture.of(Student.class).addTemplate("Valid",new Rule(){{
            add("first_Name",random(getRandomFirstName()));
            add("last_Name",random(getRandomLastName()));
            add("subjectId", random(SubjectTemplate.getRandomSubjectID()));
            add("age",random(Integer.class,range(15,60)));
            add("id",random(getRandomStudentId()));
            add("skills", Arrays.asList(Skills.values()));
           }});
    }

    private Object[] getRandomStudentId() {
        Faker faker = new Faker();
        List<String> randomStudentIds = new ArrayList<String>();
        for (int iterator=1;iterator<10;iterator++){
            randomStudentIds.add(faker.idNumber().valid());
        }
        return randomStudentIds.toArray();

    }


    private Object[] getRandomLastName() {
        Faker faker  = new Faker();
        List<String> randomLastNames = new ArrayList<String>();
        for (int iterator=1;iterator<10;iterator++) {
            randomLastNames.add(faker.name().lastName());
        }
        return randomLastNames.toArray();
    }

    private Object[] getRandomFirstName() {
        Faker faker  = new Faker();
        List<String> randomFirstNames = new ArrayList<String>();
        for (int iterator=1;iterator<10;iterator++) {
            randomFirstNames.add(faker.name().lastName());
        }
        return randomFirstNames.toArray();

    }
}
