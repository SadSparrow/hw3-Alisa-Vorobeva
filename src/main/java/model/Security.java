package model;

import util.DateUtil;

import java.time.LocalDate;
import java.util.List;

public class Security {
    private final String name;
    private final List<Currency> currency;
    private final String code;
    private final LocalDate date;

    public Security(String name, List<Currency> currency, String code, LocalDate date) {
        this.name = name;
        this.currency = currency;
        this.code = code;
        this.date = date;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Security security = (Security) o;

        if (!name.equals(security.name)) return false;
        if (!currency.equals(security.currency)) return false;
        if (!code.equals(security.code)) return false;
        return date.equals(security.date);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + currency.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Security {" +
                "\n name: " + name +
                "\n currency: " + currency +
                "\n code: " + code +
                "\n date: " + DateUtil.dateToString(date) + "}";
    }
}