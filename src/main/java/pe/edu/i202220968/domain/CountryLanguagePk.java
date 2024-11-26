package pe.edu.i202220968.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CountryLanguagePk {
    @Column(name = "CountryCode")
    private String countryCode;
    @Column(name = "Language")
    private String language;

    public CountryLanguagePk() {
    }

    public CountryLanguagePk(String countryCode, String language) {
        this.countryCode = countryCode;
        this.language = language;
    }

    @Override
    public String toString() {
        return "CountryLanguagePk{" +
                "countryCode='" + countryCode + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
