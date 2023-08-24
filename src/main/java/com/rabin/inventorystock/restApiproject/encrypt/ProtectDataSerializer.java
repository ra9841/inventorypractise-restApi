package com.rabin.inventorystock.restApiproject.encrypt;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ProtectDataSerializer extends JsonSerializer<Object>  {

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		 String pii = value.toString().replaceAll("\\w(?=\\w{4})", "x");//except last four character all patteren with x
	        gen.writeString(pii);
	        	
	}

}
