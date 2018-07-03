package com.finance.testproject.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.finance.testproject.dto.TransitionsDTO;
import com.finance.testproject.model.Transition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionsDeserializer extends StdDeserializer<TransitionsDTO> {

    public TransitionsDeserializer() {
        this(null);
    }

    public TransitionsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TransitionsDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        TransitionsDTO transitionsDTO = new TransitionsDTO();
        transitionsDTO.setTransitions(new ArrayList<>());
        Iterator<String> itr = node.fieldNames();
        while (itr.hasNext()){
            String key = itr.next();
            for (JsonNode x : node.findValues(key)) {
                Transition transition = new Transition();
                transition.setSource(key);
                transition.setTarget(x.asText());
                transitionsDTO.getTransitions().add(transition);
                System.out.println(x.asText());
            }
        }

        return transitionsDTO;
    }
}
