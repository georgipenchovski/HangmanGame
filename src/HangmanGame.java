
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"Айтос", "Аксаково", "Антоново", "Априлци", "Ардино", "Асеновград", "Ахелой", "Ахтопол",
                "Балчик", "Банкя", "Банско", "Баня", "Батак", "Бяла Слатина", "Белене", "Белица", "Белово", "Белоградчик", "Благоевград",
                "Бойчиновци", "Болярово", "Борово", "Ботевград", "Брезово", "Брусарци", "Бургас", "Бухово", "Българово", "Бяла",
                "Варна", "Велинград", "Ветово", "Велико Търново", "Видин", "Враца", "Върбица", "Вършец",
                "Габрово", "Главиница", "Глоджево", "Годеч", "Грамада", "Гурково",
                "Дебелец", "Девин", "Девня", "Джебел", "Димитровград",
                "Земен", "Златарица", "Златица", "Златоград",
                "Ивайловград", "Игнатиево", "Ихтиман",
                "Каварна", "Казанлък", "Калофер", "Камено", "Карлово", "Карнобат", "Каспичан", "Кермен", "Клисура",
                "Китен", "Кнежа", "Козлодуй", "Койнаре", "Кресна", "Криводол", "Кубрат", "Куклен", "Кула", "Кърджали", "Кюстендил",
                "Левски", "Ловеч", "Лом", "Луковит", "Лъки", "Любимец", "Лясковец",
                "Маджарово", "Мартен", "Мелник", "Мездра",
                "Меричлери", "Мизия", "Момчилград", "Монтана", "Мъглиж",
                "Неделино", "Несебър", "Николаево", "Никопол",
                "Обзор", "Оряхово",
                "Павликени", "Пазарджик", "Панагюрище", "Перник", "Перущица", "Петрич",
                "Разград", "Разлог", "Ракитово", "Раковски", "Рила", "Роман", "Рудозем", "Русе",
                "Садово", "Самоков", "Сандански", "Свиленград", "Силистра", "Симитли", "Славяново", "Сливен",
                "Смолян", "Созопол", "Сопот", "София", "Средец", "Стражица", "Стралджа", "Стрелча",
                "Твърдица", "Тервел", "Тетевен", "Тополовград", "Троян", "Трън",
                "Шипка", "Шумен",
                "Ябланица", "Якоруда", "Ямбол"};

        int randomWordNumber = (int) (Math.random() * words.length);

        play(words, randomWordNumber);
    }

    public static void play(String[] words, int randomWordNumber) {
        char[] enteredLetters = new char[words[randomWordNumber].length()];
        int triesCount = 0;
        boolean wordIsGuessed = false;

        System.out.println("Вие започнахте играта \"Бесеница\".");
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
        if (triesCount != 6) {
            System.out.print("\nТи победи!");
        }
        System.out.println("\nДумата е " + "\"" + words[randomWordNumber] + "\"" + ".");

    }

    public static boolean isCyrillic(char c) {
        return Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(c));
    }

    public static int enterLetter(String word, char[] enteredLetters) {
        word = word.toLowerCase();
        int emptyPosition = findEmptyPosition(enteredLetters);
        System.out.print("Познайте думата: ");
        if (!printWord(word, enteredLetters))
            return 3;
        System.out.print("\nВъведете буква: ");
        Scanner input = new Scanner(System.in);
        char userInput = input.nextLine().toLowerCase().charAt(0);
        if (!isCyrillic(userInput)) {
            System.out.println("Въведете буква на кирилица!");
            return 1;
        }
        if (inEnteredLetters(userInput, enteredLetters)) {
            System.out.println("\"" + userInput + "\"" + " вече е в думата");
            return 1;
        } else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            return 1;
        } else {
            System.out.println("\"" + userInput + "\"" + " я няма в думата.");
            return 0;
        }
    }

    public static boolean printWord(String word, char[] enteredLetters) {
        boolean isPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (inEnteredLetters(letter, enteredLetters)) {
                if (i == 0 || word.charAt(i - 1) == ' ') {
                    System.out.print(Character.toUpperCase(letter));
                } else {
                    System.out.print(letter);
                }
            } else if (letter == ' ') {
                System.out.print(' ');
            } else {
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
