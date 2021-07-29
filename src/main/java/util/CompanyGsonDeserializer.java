package util;

import com.google.gson.*;
import model.Company;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompanyGsonDeserializer implements JsonDeserializer<Company> {

    @Override
    public Company deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        LocalDate localDate = DateUtil.parse(jsonObject.get("founded").getAsString());
        List<model.Security> securities = new ArrayList<>();

        jsonObject.getAsJsonArray("securities").forEach(x -> securities.add(
                new GsonBuilder().registerTypeAdapter(model.Security.class, new SecurityGsonDeserializer())
                        .create().fromJson(x, model.Security.class)));

        return new Company(
                jsonObject.get("id").getAsInt(),
                jsonObject.get("name").getAsString(),
                jsonObject.get("address").getAsString(),
                jsonObject.get("phoneNumber").getAsString(),
                jsonObject.get("INN").getAsString(),
                localDate,
                securities
        );
    }
}