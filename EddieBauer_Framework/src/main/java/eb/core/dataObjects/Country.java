package eb.core.dataObjects;

import org.apache.commons.lang3.StringUtils;

public enum Country {
    US("us"), CA("ca");

    private final String countryName;

    Country(final String envName) {
        countryName = envName;
    }

    public String getCountryName() {
        return countryName;
    }

    public static Country getCountryByName(final String countryName) {
        if (StringUtils.isNotBlank(countryName)) {
            for (final Country ctr : Country.values())
                if (ctr.getCountryName().equalsIgnoreCase(countryName)) {
                    return ctr;
                }
        }
        return null;
    }

}
