package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Comparator;



public class Main {

    public static class Ranking {
        String country;
        String region;
        char cOrT;
        int edition;
        int prRating;

        public Ranking() {

        }

        public Ranking(String country, String region, char cOrT,
                       int edition, int prRating) {
            this.country = country;
            this.region = region;
            this.cOrT = cOrT;
            this.edition = edition;
            this.prRating = prRating;
        }

        @Override
        public String toString() {
            return country + "/" + region + "/" +
                    cOrT + "/" + edition +
                    "/" + prRating;
        }
    }
    public static class ExtendedRanking extends Ranking {
        String status;
        int clRating;
        int valueOfCIndex;
        int totalValue;

        public ExtendedRanking() {
        }

        public ExtendedRanking(String country, String region, char cOrT,
                               int edition, int prRating, String status,
                               int clRating, int valueOfCIndex, int totalValue) {
            super(country, region, cOrT, edition, prRating);
            this.status = status;
            this.clRating = clRating;
            this.valueOfCIndex = valueOfCIndex;
            this.totalValue = totalValue;
        }

        @Override
        public String toString() {
            return country + "/" + region + "/" +
                    cOrT + "/" + edition +
                    "/" + prRating + "/" + status
                    + "/" + clRating + "/" + valueOfCIndex + "/" + totalValue;
        }
    }

    public static void main(String[] args) {
        ArrayList<Ranking> rankings = new ArrayList<>();
        ArrayList<ExtendedRanking> extendedRankings = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("ranking.csv"))) {
            while (scanner.hasNextLine()) {
                String[] lineArray = scanner.nextLine().split(",");
                String country = lineArray[0];
                String region = lineArray[1];
                char cOrT = lineArray[2].charAt(0);
                int edition = Integer.parseInt(lineArray[3]);
                int prRating = Integer.parseInt(lineArray[5]);
                String status = lineArray[4];
                int clRating = Integer.parseInt(lineArray[6]);
                int valueOfCIndex = Integer.parseInt(lineArray[19]);
                int totalValue = Integer.parseInt(lineArray[lineArray.length - 1]);
                rankings.add(new Ranking(country, region, cOrT, edition, prRating));
                extendedRankings.add(new ExtendedRanking(country, region, cOrT, edition, prRating,
                        status, clRating, valueOfCIndex, totalValue));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        findFirstCountryWithPRRating5(rankings);
        findFirstCountryWithPRRating5(extendedRankings);
        extendedRankings.sort(new Comparator<ExtendedRanking>() {
            @Override
            public int compare(ExtendedRanking o1, ExtendedRanking o2) {
                if (o1.valueOfCIndex > o2.valueOfCIndex) {
                    return 1;
                } else if (o1.valueOfCIndex == o2.valueOfCIndex) {
                    return 0;
                }
                return -1;
            }
        });
        addNExtendedRankings(extendedRankings, 3);
        System.out.println(extendedRankings.subList(extendedRankings.size() - 5, extendedRankings.size()));
        extendedRankings.sort(new ComparatorCountry());

    }
    public static void findFirstCountryWithPRRating5(List<? extends Ranking> rankings) {
        Comparator<Ranking> comp = new Comparator<Ranking>() {
            @Override
            public int compare(Ranking o1, Ranking o2) {
                if (o1.prRating > o2.prRating) {
                    return 1;
                } else if (o1.prRating == o2.prRating) {
                    return 0;
                }
                return -1;
            }
        };
        rankings.sort(comp);
        int index = -1;
        for (int i = 0; i < rankings.size(); i++) {
            if (rankings.get(i).prRating == 5) {
                index = i;
                System.out.println("First country with PR rating 5: " + rankings.get(i).country);
                break;
            }
        }
        if (index != -1) {
            System.out.println("Index of first country with PR rating 5: " + index);
        } else {
            System.out.println("No country with PR rating 5 found");
        }

    }
    public static void addNExtendedRankings(List<? super ExtendedRanking> rankings, int n) {
        Scanner in = new Scanner(System.in); // пустота так пустота, я то что могу поделать
        for (int i = 0; i < n; i++) {
            rankings.add(new ExtendedRanking());
        }
    }
    public static class ComparatorCountry implements Comparator<ExtendedRanking> {
        @Override
        public int compare(ExtendedRanking o1, ExtendedRanking o2) {
            if (o1.country == o2.country && o1.country == null) {
                return 0;
            }
            if (o1.country == null) {
                return -1;
            }
            if (o2.country == null) {
                return 1;
            }
            return o1.country.compareTo(o2.country);
        }
    }
    }
