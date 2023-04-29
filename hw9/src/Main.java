import java.util.Map;

public class Main {
    //Tests created by @ChatGPT
    public static void main(String[] args) {
        // Создание новой хэш-карты
        Map<String, Integer> map = new MyMap<>();

        // Проверка, что карта пуста
        if (map.isEmpty()) {
            System.out.println("Карта пуста");
        }

        // Добавление элементов в карту
        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);

        // Получение значения элемента из карты
        int value = map.get("один");
        System.out.println("Значение для ключа 'один': " + value);

        // Изменение значения элемента в карте
        map.put("один", 10);
        value = map.get("один");
        System.out.println("Новое значение для ключа 'один': " + value);

        // Удаление элемента из карты
        map.remove("два");
        System.out.println("Ключ 'два' был удален");

        // Проверка размера карты
        System.out.println("Размер карты: " + map.size());

        // Очистка карты
        map.clear();
        if (map.isEmpty()) {
            System.out.println("Карта очищена");
        }
    }
}
