 package eoms.cn.commons.component;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
@JsonComponent
public class LongJsonSerializer extends JsonSerializer<Long> {

    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // TODO Auto-generated method stub
        if(!ObjectUtils.isEmpty(value)) {
            gen.writeString(value.toString());
        }
    }

}
