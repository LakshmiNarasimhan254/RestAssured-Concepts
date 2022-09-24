package com.mln.pojoConcepts.usingFixtureFactory.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;
import com.mln.pojoConcepts.usingFixtureFactory.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectTemplate implements TemplateLoader {


    public static  Object[] getRandomSubjectID(){
        Faker faker = new Faker();
        List<String> randomSubjectIds = new ArrayList<String>();
        for (int iterator=1;iterator<10;iterator++) {
            randomSubjectIds.add(faker.idNumber().valid());
        }
        return randomSubjectIds.toArray();
    }


    private Object[] getRandomSubjectName(){
        Faker faker = new Faker();
        List<String> randomSubjectNames = new ArrayList<String>();
        for (int iterator=1;iterator<10;iterator++) {
            randomSubjectNames.add(faker.programmingLanguage().name());
        }
        return randomSubjectNames.toArray();
    }

    @Override
    public void load() {
        Fixture.of(Subject.class).addTemplate("Valid",new Rule(){{
            add("id",  random(getRandomSubjectID()));
            add("name",random(getRandomSubjectName()));
        }});
    }
}




