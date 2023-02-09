package FirstClasswork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Education> educations = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("nces330_20.csv"))) {
			while (scanner.hasNextLine()) {
				String[] lineArray = scanner.nextLine().split(",");
				int year = Integer.parseInt(lineArray[0]);
				String[] lenght = lineArray[3].split("-");
				educations.add(new Education(year, lineArray[1], lineArray[2], lenght[0], lineArray[4], lineArray[5]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int sumLengths = 0;
		ArrayList<Integer> lengths = new ArrayList<>();
		for (Education education : educations) {
			lengths.add(Integer.parseInt(education.length));
			sumLengths += Integer.parseInt(education.length);
		}
		System.out.println(sumLengths);
		
		Integer[] valueArray = new Integer[lengths.size()];
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < valueArray.length; i++) {
			valueArray[i] = Integer.parseInt(educations.get(i).value);
			if (valueArray[i] > maxValue) {
				maxValue = valueArray[i];
			}
		}
		System.out.println(maxValue);
	}

}
