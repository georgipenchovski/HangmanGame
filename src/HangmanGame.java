
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"Айтос", "Аксаково", "Алфатар", "Антоново", "Априлци", "Ардино", "Асеновград", "Ахелой", "Ахтопол",
                "Балчик", "Банкя", "Банско", "Баня", "Батак", "Батановци", "Белене", "Белица", "Белово", "Белоградчик", "Белослав", "Благоевград",
                "Бойчиновци", "Болярово", "Борово", "Ботевград", "Брезово", "Брусарци", "Бургас", "Бухово", "Българово", "Бяла",
                "Варна", "Велинград", "Ветово", "Ветрен", "Видин", "Враца", "Вълчедръм", "Върбица", "Вършец",
                "Габрово", "Главиница", "Глоджево", "Годеч", "Грамада", "Гулянци", "Гурково", "Гълъбово",
                "Дебелец", "Девин", "Девня", "Джебел", "Димитровград",
                "Земен", "Златарица", "Златица", "Златоград",
                "Ивайловград", "Игнатиево", "Ихтиман",
                "Каблешково", "Каварна", "Казанлък", "Калофер", "Камено", "Каолиново", "Карлово", "Карнобат", "Каспичан", "Кермен", "Клисура",
                "Китен", "Кнежа", "Козлодуй", "Койнаре", "Кресна", "Криводол", "Крумовград", "Кубрат", "Куклен", "Кула", "Кърджали", "Кюстендил",
                "Левски", "Ловеч", "Лом", "Луковит", "Лъки", "Любимец", "Лясковец",
                "Маджарово", "Мартен", "Мелник", "Мездра",
                "Меричлери", "Мизия", "Момчилград", "Монтана", "Мъглиж",
                "Неделино", "Несебър", "Николаево", "Никопол",
                "Обзор", "Омуртаг", "Опака", "Оряхово",
                "Павликени", "Пазарджик", "Панагюрище", "Перник", "Перущица", "Петрич",
                "Разград", "Разлог", "Ракитово", "Раковски", "Рила", "Роман", "Рудозем", "Русе",
                "Садово", "Самоков", "Сандански", "Свиленград", "Септември", "Силистра", "Симеоновград", "Симитли", "Славяново", "Сливен",
                "Смолян", "Созопол", "Сопот", "София", "Средец", "Стражица", "Стралджа", "Стрелча",
                "Твърдица", "Тервел", "Тетевен", "Тополовград", "Троян", "Трън",
                "Шипка", "Шумен",
                "Ябланица", "Якоруда", "Ямбол"};

        int randomWordNumber = (int) (Math.random() * words.length);
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        int triesCount = 0;
        boolean wordIsGuessed = false;
        System.out.println("Познайте думата.");
        System.out.println("    _____ ");
        System.out.println("    |   | ");
        System.out.println("    |     ");
        System.out.println("    |     ");
        System.out.println("    |     ");
        System.out.println("    |     ");

        do {

            switch (enterLetter(words[randomWordNumber], enteredLetters)) {
                case 0:
                    triesCount++;
                    if (triesCount == 1) {
                        System.out.println("    _____ ");
                        System.out.println("    |   | ");
                        System.out.println("    |   O ");
                        System.out.println("    |     ");
                        System.out.println("    |     ");
                        System.out.println("    |     ");


                    } else if (triesCount == 2) {
                        System.out.println("    _____ ");
                        System.out.println("    |   | ");
                        System.out.println("    |   O ");
                        System.out.println("    |   | ");
                        System.out.println("    |     ");
                        System.out.println("    |     ");

                    } else if (triesCount == 3) {
                        System.out.println("    _____ ");
                        System.out.println("    |   | ");
                        System.out.println("    |   O ");
                        System.out.println("    |  -| ");
                        System.out.println("    |     ");
                        System.out.println("    |         ");
                    } else if (triesCount == 4) {
                        System.out.println("    _____ ");
                        System.out.println("    |   | ");
                        System.out.println("    |   O ");
                        System.out.println("    |  -|-");
                        System.out.println("    |     ");
                        System.out.println("    |     ");
                    } else if (triesCount == 5) {
                        System.out.println("    _____ ");
                        System.out.println("    |   | ");
                        System.out.println("    |   O ");
                        System.out.println("    |  -|-");
                        System.out.println("    |  /  ");
                        System.out.println("    |     ");
                    } else if (triesCount == 6) {
                        System.out.println("    _____ ");
                        System.out.println("    |   | ");
                        System.out.println("    |   O ");
                        System.out.println("    |  -|-");
                        System.out.println("    |  / \\");
                        System.out.println("    |     ");
                        System.out.println("   GAME OVER");
                        wordIsGuessed = true;
                        break;
                    }
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    wordIsGuessed = true;
                    break;
            }

        }
        while (!wordIsGuessed);
        System.out.println("\nДумата е " + "\"" + words[randomWordNumber] + "\"" + ".");

    }


    public static int enterLetter(String word, char[] enteredLetters) {

        System.out.print("Въведете буква на кирилица!");

        if (!printWord(word, enteredLetters))
            return 3;
        System.out.print(" > ");
        Scanner input = new Scanner(System.in);
        char userInput = input.nextLine().charAt(0);
        int emptyPosition = findEmptyPosition(enteredLetters);
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println(userInput + " вече е в думата");
            return 2;
        } else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        } else {
            System.out.println(userInput + " я няма в думата.");
            return 0;
        }
    }

    public static boolean printWord(String word, char[] enteredLetters) {

        boolean isPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (inEnteredLetters(letter, enteredLetters))
                System.out.print(letter);
            else {
                System.out.print('*');
                isPrinted = true;
            }
        }
        return isPrinted;
    }

    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }

    public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;
        while (enteredLetters[i] != '\u0000') i++;
        return i;

    }

}
