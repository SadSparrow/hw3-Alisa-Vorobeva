package util;

import com.google.gson.*;
import model.Companies;
import model.Company;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class CompaniesGsonDeserializer implements JsonDeserializer<Companies> {

    @Override
    public Companies deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        Company[] companies = new GsonBuilder().registerTypeAdapter(Company.class, new CompanyGsonDeserializer()).create()
                .fromJson(jsonObject.getAsJsonArray("companies"), Company[].class);

        return new Companies(new ArrayList<>(Arrays.asList(companies)));
    }
}