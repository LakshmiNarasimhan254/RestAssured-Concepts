package com.mln.pojoConcepts.jacksonannotations.jsonserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;


public class CustomSerializer extends StdSerializer<Student> {
    protected CustomSerializer(Class<Student> t) {
        super(t);
    }

    public CustomSerializer (){
        this(null);
    }



    @Override
    public void serialize(Student value, JsonGenerator generator, SerializerProvider provider) throws IOException {

         generator.writeStartObject();
         generator.writeStringField("firstName", value.getFirst_Name());
         generator.writeStringField("lastName", value.getLast_Name());
         generator.writeStringField("id", value.getId());
         generator.writeObjectField("skills",value.getSkills());
         generator.writeObjectField("devices",value.getDevice());
         generator.writeEndObject();



    }
}
