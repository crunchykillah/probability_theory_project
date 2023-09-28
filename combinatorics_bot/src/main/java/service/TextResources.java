package service;


public class TextResources {
    public static final String DEFINITIONS = "Сочетанием называется неупорядоченная выборка элементов конечного множества с фиксированным числом и без повторений элементов. Различные сочетания должны отличаться хотя бы одним элементом, а порядок расположения элементов не имеет значения.\n" +
            "\n" +
            "Сочетания с повторениями – это комбинации, составленные из n различных элементов по k элементов, среди которых встречаются одинаковые. Комбинации отличаются хотя бы одним элементом.\n" +
            "\n" +
            "Перестановкой множества из n элементов называется любой упорядоченный набор из всех элементов этого множества, среди которых нет одинаковых.\n" +
            "\n" +
            "Перестановкой с повторениями из n элементов состава n1, n2,…,nm называют кортеж длины суммы n1+n2+…+nm, где n1 – число повторений одного элемента множества, n2 – число повторений другого элемента множества и т.д., nm – количество повторений оставшегося элемента множества.\n" +
            "\n" +
            "Размещениями без повторений называются упорядоченные выборки, содержащие k различных элементов из данных n элементов. Обратим внимание на следующие важные положения: Любой элемент может оказаться на любом из k мест, но использоваться может в выборке только один раз.\n" +
            "\n" +
            "Размещение с повторениями — это размещение предметов в предположении, что каждый предмет может участвовать в размещении сколь угодно раз.\n" +
            "\n" +
            "Урновая модель первого типа - Имеются n предметов, среди которых m меченых. Наугад извлекаются k предметов (k < m). Это вероятность того что все извлеченные предметы - меченные.\n" +
            "\n" +
            "Урновая модель второго типа - Имеются n предметов, среди которых m меченых.Наугад извлекаются k предметов  (k < m). Это вероятность того, что среди извлеченных предметов окажутся r меченых.";
    public static final String START_MESSAGE = "Привет, я бот который поможет посчитать различные комбинации. Введи /formula, чтобы получить необходимые формулы комбинаторики, введи /def чтобы получить определения. Нажми на нужную кнопку:";
    public static final String ERROR_MESSAGE = "Сообщение не распознано, или вы не выбрали режим калькулятора";
    public static final String PHOTO_URL = "https://disk.yandex.lt/i/Bsp-_Qk53VHxpA";
    public static final String BOT_NAME = "combinatorics_bot";
    public static final String ERROR_COMMAND = "Неизвестная команда";
    public static final String COMBINATIONS_WITHOUT_REP = "Сочетания без повторений. Введите n и k (n > k) через пробел чтобы получить ответ.";
    public static final String COMBINATIONS_WITH_REP = "Сочетания с повторениями. Введите n и k (n > k) через пробел чтобы получить ответ.";
    public static final String PERMUTATIONS_WITHOUT_REP = "Перестановки без повторений. Введите n чтобы получить ответ.";
    public static final String PERMUTATIONS_WITH_REP = "Перестановки с повторениями. Введите общее число объектов n, и затем количество объектов каждого типа n1 ... nk через пробел чтобы получить ответ.";
    public static final String PLACEMENTS_WITHOUT_REP = "Размещения без повторений. Введите n и k через пробел чтобы получить ответ.";
    public static final String PLACEMENTS_WITH_REP = "Размещения с повторениями. Введите n и k через пробел чтобы получить ответ.";
    public static final String URN_MODEL_FIRST = "Урновая модель первого типа. Введите n, m и k (n > m, m > k) через пробел чтобы получить ответ.";
    public static final String URN_MODEL_SECOND = "Урновая модель второго типа. Введите n, m, k и r (n > m, m > k) через пробел чтобы получить ответ.";

    //метод создания data для callback
    public static String callbackText(int num) {
        return "callback_data_" + num;
    }
}
