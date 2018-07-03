package com.finance.testproject.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.finance.testproject.dto.TransitionsDTO;
import com.finance.testproject.model.Transition;

import java.io.IOException;

public class TransitionsSerializer extends StdSerializer<TransitionsDTO> {

    public TransitionsSerializer() {
        this(null);
    }

    public TransitionsSerializer(Class<TransitionsDTO> t) {
        super(t);
    }

    @Override
    public void serialize(TransitionsDTO transitionsDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for (Transition x : transitionsDTO.getTransitions()) {
            jsonGenerator.writeStringField(x.getSource(), x.getTarget());
        }
    }
}
