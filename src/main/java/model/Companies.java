package model;

import util.DateUtil;

import java.time.LocalDate;
import java.util.List;

public class Companies {
    private final List<Company> companies;

    public Companies(List<Company> companies) {
        this.companies = companies;
    }

    public void printALLCompaniesShort() {
        companies.forEach(c -> System.out.println(c.getName() + " - " + DateUtil.dateToStringSlash(c.getFounded())));
    }

    public void printSecurityExpired() {
        int count = 0;

        for (Company c : companies) {
            for (Security s : c.getSecurities()) {
                if (s.getDate().isBefore(LocalDate.now())) {
                    count++;
                    System.out.println(count + ". Security:");
                    System.out.println("code: " + s.getCode() +
                            "\ndate: " + DateUtil.dateToString(s.getDate()) +
                            "\ncompany owner: " + c.getName());
                }
            }
        }
        System.out.println("Count: " + count);
    }

    public void printCompaniesFoundedAfter(String date) {
        companies.forEach(c -> {
            LocalDate founded = c.getFounded();
            if (founded.isAfter(DateUtil.parse(date))) {
                System.out.println("Name: " + c.getName() + ", founded: " + DateUtil.dateToString(founded));
            }
        });
    }

    public void printSecurityByCurrency(Currency currency) {

        for (Company c : companies) {

            for (Security s : c.getSecurities()) {
                if (s.getCurrency().contains(currency)) {
                    System.out.println("company id: " + c.getId() + ", code: " + s.getCode());
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Companies companies1 = (Companies) o;

        return companies.equals(companies1.companies);
    }

    @Override
    public int hashCode() {
        return companies.hashCode();
    }

    @Override
    public String toString() {
        return "Companies {" +
                "companies: \n" + companies +
                '}';
    }
}
