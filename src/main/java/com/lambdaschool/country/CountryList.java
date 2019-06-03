package com.lambdaschool.country;

import java.util.ArrayList;

public class CountryList
{

    public ArrayList<Country> countryList = new ArrayList<>();

    public CountryList()
    {
        countryList.add(new Country("China",1420062022,9388211,39));
        countryList.add(new Country("India",1368737513,2973190,28));
        countryList.add(new Country("U.S.",329093110,9147420,38));
        countryList.add(new Country("Indonesia",269536482,1811570,29));
        countryList.add(new Country("Brazil",212392717,8358140,33));
        countryList.add(new Country("Pakistan",204596442,770880,23));
        countryList.add(new Country("Nigeria",200962417,910770,18));
        countryList.add(new Country("Bangladesh",168065920,130170,27));
        countryList.add(new Country("Russia",143895551,16376870,40));
        countryList.add(new Country("Mexico",132328035,1943950,29));
        countryList.add(new Country("Japan",126854745,364555,48));
        countryList.add(new Country("Ethiopia",110135635,1000000,20));
        countryList.add(new Country("Philippines",108106310,298170,25));
        countryList.add(new Country("Egypt",101168745,995450,25));
        countryList.add(new Country("Viet Nam",97429061,310070,33));
        countryList.add(new Country("DR Congo",86727573,2267050,17));
        countryList.add(new Country("Turkey",82961805,769630,32));
        countryList.add(new Country("Iran",82820766,1628550,32));
        countryList.add(new Country("Germany",82438639,348560,47));
        countryList.add(new Country("Thailand",69306160,510890,40));
        countryList.add(new Country("U.K.",66959016,241930,41));
        countryList.add(new Country("France",65480710,547557,42));
        countryList.add(new Country("Tanzania",60913557,885800,18));
        countryList.add(new Country("Italy",59216525,294140,48));
        countryList.add(new Country("South Africa",58065097,1213090,27));
    }

    public ArrayList<Country> findCountries(CheckCountry tester)
    {
        ArrayList<Country> tempCountryList = new ArrayList<>();

        for (Country c: countryList)
        {
            if(tester.test(c))
            {
                tempCountryList.add(c);
            }
        }

        return tempCountryList;
    }
}
