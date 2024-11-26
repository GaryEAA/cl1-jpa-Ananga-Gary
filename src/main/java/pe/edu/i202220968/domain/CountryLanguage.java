package pe.edu.i202220968.domain;

import jakarta.persistence.*;

@Entity
@Table
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguagePk countryLanguagePk;
    private String isOfficial;
    private Double percentage;

    @ManyToOne
    @MapsId("countryCode")
    @JoinColumn(name = "CountryCode", referencedColumnName = "code", insertable = false, updatable = false)
    private Country country;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguagePk countryLanguagePk) {
        this.countryLanguagePk = countryLanguagePk;
    }

    public CountryLanguage(CountryLanguagePk countryLanguagePk, String isOfficial, Double percentage, Country country) {
        this.countryLanguagePk = countryLanguagePk;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
        this.country = country;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "countryLanguagePk=" + countryLanguagePk +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                ", country=" + country +
                '}';
    }

    public CountryLanguagePk getCountryLanguagePk() {
        return countryLanguagePk;
    }

    public void setCountryLanguagePk(CountryLanguagePk countryLanguagePk) {
        this.countryLanguagePk = countryLanguagePk;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
