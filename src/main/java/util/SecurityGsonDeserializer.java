package util;

import com.google.gson.*;
import model.Currency;
import model.Security;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SecurityGsonDeserializer implements JsonDeserializer<Security> {

    @Override
    public Security deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        LocalDate localDate = DateUtil.parse(jsonObject.get("date").getAsString());
        List<Currency> currencyList = new ArrayList<>();
        jsonObject.getAsJsonArray("currency").forEach(x -> currencyList.add(Currency.valueOf(x.getAsString())));

        return new Security(
                jsonObject.get("name").getAsString(),
                currencyList,
                jsonObject.get("code").getAsString(),
                localDate);
    }
}