package com.finance.testproject.deserializator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.finance.testproject.dto.ActionDTO;

import java.io.IOException;

public class ActionDeserializer extends StdDeserializer<ActionDTO> {

    public ActionDeserializer() {
        this(null);
    }

    public ActionDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ActionDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        ActionDTO actionDTO = new ActionDTO();
        if (node.asText().length() > 0) {
            actionDTO.setType(node.asText());
        } else {
            actionDTO.setType(node.get("type").asText());
        }

        if ((actionDTO.getType() == null) || (actionDTO.getType().length() == 0))
            throw new IOException("JsonProcessingException in parsing field 'action'");

        return actionDTO;
    }
}
