package com.mln.pojoConcepts.usingFixtureFactory;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Serializer {


    @BeforeSuite
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("com.mln.pojoConcepts.usingFixtureFactory.templates");
    }

    File jsonFile = new File("src/test/resources/JSON_Files/SerializedSMS.json");
    ObjectMapper mapper = new ObjectMapper();

    @DataProvider
    public Object[][] getStudentData(){
        SMS object1 = Fixture.from(SMS.class).gimme("Valid");
        return new Object[][]{
                {object1}
        };
    }

    @Test(dataProvider = "getStudentData")
     public void postStudent(SMS sms) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile,sms );
    }


}
