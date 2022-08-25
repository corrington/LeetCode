import java.util.Arrays;

import static java.lang.Math.max;

public class MaximumPopulationYear {

    private final static int MIN_YEAR = 1950;
    private final static int MAX_YEAR = 2050;
    private final static int NUM_OF_YEARS = MAX_YEAR - MIN_YEAR;


    private static int[] calcPopulationEachYear(int[][] logs) {
        int[] populationEachYear = new int[NUM_OF_YEARS + 1];
        Arrays.fill(populationEachYear, 0);

        for (var person : logs) {
            int birthYear = person[0];
            int deathYear = person[1];

            for (var year = birthYear; year < deathYear; ++year) {
                int yearsAlive = year - MIN_YEAR;
                populationEachYear[yearsAlive]++;
            }
        } // for person

        return populationEachYear;

    }  // calcPopulationEachYear()

    private static int getMaxPopulation(int[] populationEachYear) {
        int maxPopulation = 0;
        for (int j : populationEachYear) {
            maxPopulation = max(maxPopulation, j);
        } // for i
        return maxPopulation;
    } // maxPopulation()

    private static int getFirstYearOfTargetPopulation(int[] populationEachYear, int populationTarget) {
        for (var i = 0; i < populationEachYear.length; ++i) {
            if (populationEachYear[i] == populationTarget) {
                return i;
            } // if
        } // for i
        return 0;
    } // firstYearOfTargetPopulation()

    public static int maximumPopulation(int[][] logs) {
        // <year, population>
        int[] populationEachYear = calcPopulationEachYear(logs);
        int maxPopulation = getMaxPopulation(populationEachYear);
        int firstYearOfMaxPopulation = getFirstYearOfTargetPopulation(populationEachYear, maxPopulation);
        return firstYearOfMaxPopulation + MIN_YEAR;
    } // maximumPopulation()

    public static void main(String[] args) {
        int[][] logs1 = {{1993, 1999}, {2000, 2010}};
        int[][] logs2 = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        int[][] logs3 = {{1982,1998},{2013,2042},{2010,2035},{2022,2050},{2047,2048}};
        int[][] logs4 = {{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}};

        System.out.println(maximumPopulation(logs1));
        System.out.println(maximumPopulation(logs2));
        System.out.println(maximumPopulation(logs3));
        System.out.println(maximumPopulation(logs4));

    } // main()
} // class MaximumPopulationYear