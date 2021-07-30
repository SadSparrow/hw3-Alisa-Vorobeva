import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Companies;
import model.Currency;
import util.CompaniesGsonDeserializer;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Companies.class, new CompaniesGsonDeserializer())
                .create();

        Companies companies = gson.fromJson(new FileReader("./src/exampleHW.json"), Companies.class);

        companies.printALLCompaniesShort();
        companies.printSecurityExpired();
        companies.printCompaniesFoundedAfter("15.05,75");
        companies.printSecurityByCurrency(Currency.RUB);
    }
}