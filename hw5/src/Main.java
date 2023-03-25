package hw5.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		MyStack<Car> cars = new MyStack<>();
		try (Scanner scanner = new Scanner(new File("honda.csv"))) {
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] lineArray = scanner.nextLine().split(",");
				Integer year = Integer.parseInt(lineArray[0]);
				String[] hh= lineArray[1].split(" ");
				int kmsDriven = Integer.parseInt(hh[0]);
				String fuelType = lineArray[2];
				String suspension = lineArray[3];
				String[] ff = lineArray[4].split(" ");
				Double price = Double.parseDouble(ff[0]);
				String modelOfCar = lineArray[5];
				cars.push(new Car(year, kmsDriven, fuelType, suspension, price, modelOfCar));

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		List<Car> carList = cars.stream().toList(); //Сделали List из Car из MyStack


		//Получить и вывести список машин, у которых тип топлива бензин и автоматическая коробка передач (в 1 строчку)
		carList.stream()
				 .filter(car -> car.suspension.equals("Automatic") && car.fuelType.equals("Petrol"))
				 .forEach(car -> System.out.println(car.modelOfCar));


		//Получить список цен на машины, перевести их в тип Integer и вывести количество четных значений (в 1 строчку)
		System.out.println(carList.stream()
				  .filter(car -> Integer.valueOf((int) car.price) % 2 == 0)
				  .count());


		//Получить список цен на машины, посчитать среднюю цену, вывести количество машин, которые больше этой цены
		double averagePriceOfCar = carList.stream()
				  .mapToDouble(car -> car.price)
				  .average()
				  .getAsDouble();
		long countOfRichCars = carList.stream()
				  .filter(car -> car.price > averagePriceOfCar)
				  .count();
		System.out.println(countOfRichCars);


		//Получить список машин, на которых ездили меньше чем 10 тысяч километров в год. (в 1 строчку)
		List<Car> carWithLowKmsDriven = carList.stream()
				  .filter(car -> car.kmsDriven <= ((10000)*((2023) - car.year)))
				  .toList();


		//Получить количество машин, название которых начинается с Honda City и год выпуска не меньше 2015.
		long countOfFilter5 = carList.stream()
				  .filter(car -> car.year >= 2015 && car.modelOfCar.startsWith("Honda City"))
				  .count();

	}
	static class Car {
		int year;
		int kmsDriven;
		String fuelType;
		String suspension;
		double price;
		String modelOfCar;

		@Override
		public String toString() {
			return "Car{" +
					  "year=" + year +
					  ", kmsDriven=" + kmsDriven +
					  ", fuelType='" + fuelType + '\'' +
					  ", suspension='" + suspension + '\'' +
					  ", price=" + price +
					  ", modelOfCar='" + modelOfCar + '\'' +
					  '}';
		}

		public Car(int year, int kmsDriven, String fuelType,
		           String suspension, double price, String modelOfCar) {
			this.year = year;
			this.kmsDriven = kmsDriven;
			this.fuelType = fuelType;
			this.suspension = suspension;
			this.price = price;
			this.modelOfCar = modelOfCar;
		}
	}
	static class MyStack<T> extends AbstractCollection<T> {

		List<T> list = new ArrayList<>();

		public T push(T elem) {
			list.add(elem);
			return elem;
		}

		public T pop() {
			if (size() == 0) {
				throw new EmptyStackException();
			}
			T elementik = list.get(size() - 1);
			list.remove(size() - 1);
			return elementik;
		}

		public T peek() {
			if (size() == 0) {
				throw new EmptyStackException();
			}
			return list.get(size() - 1);
		}

		public boolean empty() {
			if (size() == 0) {
				return true;
			}
			return false;
		}

		public int search(Object o) {
			int i = list.lastIndexOf(o);

			if (i >= 0) {
				return size() - i;
			}
			return -1;
		}

		@Override
		public Iterator<T> iterator() {
			return list.iterator();
		}

		@Override
		public int size() {
			return list.size();
		}
	}
	static class MyCarIterator implements Iterator<Car> {

		List<Car> array;
		Iterator<Car> iterator;


		public MyCarIterator(Collection<Car> array) {
			this.array = array.stream().filter(car -> car.year > 2010).collect(Collectors.toList());
			this.iterator = array.iterator();

		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public Car next() {
			return iterator.next();
		}
	}

}

