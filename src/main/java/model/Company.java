package model;

import util.DateUtil;

import java.time.LocalDate;
import java.util.List;

public class Company {
    private final int id;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final String inn;
    private final LocalDate founded;
    private final List<Security> securities;

    public Company(int id, String name, String address, String phoneNumber, String inn, LocalDate founded, List<Security> securities) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inn = inn;
        this.founded = founded;
        this.securities = securities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (!name.equals(company.name)) return false;
        if (!address.equals(company.address)) return false;
        if (!phoneNumber.equals(company.phoneNumber)) return false;
        if (!inn.equals(company.inn)) return false;
        if (!founded.equals(company.founded)) return false;
        return securities.equals(company.securities);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + inn.hashCode();
        result = 31 * result + founded.hashCode();
        result = 31 * result + securities.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Company {" +
                "\n id: " + id +
                "\n name: " + name +
                "\n address: " + address +
                "\n phoneNumber: " + phoneNumber +
                "\n INN: " + inn +
                "\n founded: " + DateUtil.dateToString(founded) +
                "\n securities: " + securities + "}";
    }
}