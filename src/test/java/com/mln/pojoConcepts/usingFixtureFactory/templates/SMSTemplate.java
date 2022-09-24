package com.mln.pojoConcepts.usingFixtureFactory.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.mln.pojoConcepts.usingFixtureFactory.SMS;
import com.mln.pojoConcepts.usingFixtureFactory.Student;
import com.mln.pojoConcepts.usingFixtureFactory.Subject;

import java.util.Arrays;

public class SMSTemplate implements TemplateLoader {
    @Override
    public void load() {
        //FixtureFactoryLoader.loadTemplates("com.mln.pojoConcepts.usingFixtureFactory.templates");
        Fixture.of(SMS.class).addTemplate("Valid",new Rule(){{
            add("students", has(3).of(Student.class,"Valid"));
            add("subjects",has(3).of(Subject.class,"Valid"));
        }});

    }
}
