package by.it.meshchenko.jd01_12;

public class Runner12 {
    public static void main(String[] args){
        // A.1 Создать список оценок учеников с помощью ArrayList, заполнить
        // случайными оценками (1-10). Удалить неудовлетворительные оценки из
        // списка (1-4). Вывести на консоль оба варианта.
        System.out.println("A.1  **************************");
        TaskA.exampleA1();

        // A.2 Определить два множества (A и B) на основе целых чисел. Создать
        // отдельный класс MyCollect и статические методы в нем для определения
        // пересечения множеств getCross и объединения множеств getUnion. Показать
        // работу этих методов на примере двух множеств (A и B).
        System.out.println("A.2  **************************");
        TaskA.exampleA2();

        // A.3 Не используя вспомогательных объектов (т.е. без обмена местами
        // переменных), переставить отрицательные элементы произвольного списка
        // чисел в конец, а положительные — в начало списка.
        System.out.println("A.3  **************************");
        TaskA.exampleA3();

        // B.1 Задать текст на английском языке (100 и более слов). Вывести
        // все различные слова. Для каждого слова подсчитать частоту его
        // встречаемости. Слова, отличающиеся регистром букв, считать различными.
        System.out.println("B.1  **************************");
        TaskB.exampleB1();

        // B.2 В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета
        // по кругу вычеркивается каждый второй человек, пока не останется один.
        // Составить два метода processArray и prоcessLinked моделирующие процесс.
        // Первый должен использовать класс ArrayList, а второй — LinkedList. Какой из
        // двух методов работает быстрее? Почему? Докажите. (см. пример на слайдах).
        //      На Intel Core i5 2,6 ГГц ArrayList работает быстрее
        //      при N = 150000
        //      ArrayList добавление - 12, удаление - 1822
        //      LinkedList добавление - 17, удаление - 10405
        //      ArrayList быстрее находит элемент О(1), LinkedList - O(n)
        //      При удалении n-го элемента, опять-таки LinkedList должен сделать поиск
        System.out.println("B.2  **************************");
        TaskB.processArray(150000);
        TaskB.prоcessLinked(150000);

        // C.1 Во входном тексте хранятся наименования некоторых объектов. Построить
        // список C1, элементы которого содержат наименования и шифры данных объектов,
        // причем элементы списка должны быть упорядочены по возрастанию шифров
        // (шифр – некоторое уникальное число). Затем «сжать» список C1, удаляя
        // дублирующиеся наименования объектов.
        System.out.println("C.1  **************************");
        // Представим, что Student[] listStudents это десериализованный входной текст
        final Student[] listStudents = new Student[]{
                new Student("Oleg", "M"),
                new Student("Vova", "P"),
                new Student("Sasha", "L"),
                new Student("Kolya", "L"),
                new Student("Dima", "M"),
                new Student("Donald", "T"),
                new Student("Barak", "O"),
                new Student("Angela", "M"),
                new Student("George", "B"),
                new Student("Bill", "K"),
        };
        TaskC.exampleС1(listStudents, 14);

        //C.2 Решить задачу A2 для произвольных и заранее неизвестных типов
        // данных во множествах.
        System.out.println("\nC.2  **************************");
        System.out.println("Методы getCross и getUnion для пита данных Student");
        TaskC.exampleС2(listStudents, 11);

        // C.3 Задана строка, состоящая из выражений и символов «(», «)», «[», «]», «{», «}».
        // Проверить корректность расстановки скобок с помощью коллекций.
        System.out.println("\n\nC.3  **************************");
        TaskC.exampleС3("2*(3+5)-{1,2,3}*{[5,6],[7,9]}");
        TaskC.exampleС3("[5]*{1,2,3}}*9");
        TaskC.exampleС3("({[9]})*{([8])}");
        TaskC.exampleС3("({[9])}*{([8])}");


    }
}
