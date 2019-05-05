package eoms.cn.commons.component;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class LongJsonComponent {

    public static class LongJsonSerializer extends JsonSerializer<Long> {

        @Override
        public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            // TODO Auto-generated method stub
            if (!ObjectUtils.isEmpty(value)) {
                gen.writeString(value.toString());
            }
        }

    }

    public static class LongJsonDeserializer extends JsonDeserializer<Long> {

        @Override
        public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            // TODO Auto-generated method stub
            if(ObjectUtils.isEmpty(p.getText())) {
                return null;
            }
            return Long.parseLong(p.getText());
        }

    }

}
