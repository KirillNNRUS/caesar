package caesar;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    // Т.к. чуствую повеселюсь, все делаю в Main, простите :-)
    int shiftToRight = 66;
    String alphabetAllSymbolNormal = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    String alphabetAllSymbolShift;
    String[] alphabet = new String[alphabetAllSymbolNormal.length()];
    String[] alphabetShiftToRight = new String[alphabetAllSymbolNormal.length()];
    String encodedString =
        "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв."
            + " Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд "
            + "аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. Ф юэимюб чхни южздёюу ю чгыж"
            + " юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. Ю зъв гъ въгъъ,"
            + " еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ"
            + " жзёъвбъгюъ ад чжъви шхёвдгюмгдви. Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех,"
            + " жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. Въгф вдьгд гхэчхзс"
            + " дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";

    String[] encodedArray = new String[encodedString.length()];
    String[] decodedArray = new String[encodedString.length()];

    StringBuilder builderAlphabetAllSymbolShiftToRight = new StringBuilder();

    System.out.println("Алфавит:\t\t\t\t\t" + alphabetAllSymbolNormal);

    alphabet = stringToArr(alphabetAllSymbolNormal);
    System.out.println("Алфавит массив:\t\t\t\t" + Arrays.toString(alphabet));

    shiftArrayToRight(shiftToRight, alphabet, alphabetShiftToRight);
    System.out.println("Алфавит массив сдвиг:\t\t" + Arrays.toString(alphabetShiftToRight));

    alphabetAllSymbolShift =
        builderAppend(builderAlphabetAllSymbolShiftToRight, alphabetShiftToRight).toString();
    System.out.println("Алфавит сдвиг:\t\t\t\t" + alphabetAllSymbolShift);
  }

  public static void shiftArrayToRight(int shift, String[] arrNormal, String[] arrToShift) {
    if (shift > arrNormal.length) {
      System.out.println(
          "Вы вышли за пределы сдвига, количество символов в алфавите: " + arrNormal.length);
      return;
    }
    if (shift < 0) {
      System.out.println("Можно использовать только положительные значения!");
      return;
    }
    for (int i = 0, j = i + shift; i < arrNormal.length; i++, j++) {
      if (j > arrNormal.length - 1) {
        arrToShift[i] = arrNormal[j - arrNormal.length];
      } else {
        arrToShift[i] = arrNormal[j];
      }
    }
  }

  public static String[] stringToArr(String string) {
    String[] array = new String[string.length()];
    for (int i = 0; i < string.length(); i++) {
      array[i] = String.valueOf(string.charAt(i));
    }
    return array;
  }

  public static StringBuilder builderAppend(StringBuilder stringBuilder, String[] array) {
    for (String value : array) {
      stringBuilder.append(value);
    }
    return stringBuilder;
  }
}
