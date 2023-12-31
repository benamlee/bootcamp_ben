public class Conditionals {
  public static void main(String[] ags) {
    // if, else if, else
    int i = 10;
    if (i > 9) { // asking if i>9, if yes, execute block of the codes
      System.out.println("i=" + i); // i=10
    }
    // flow control, if-else
    if (i < 8) { // not fulfill
      System.out.println("i is smaller than 8");
    } else {
      System.out.println("i is larger than or equals to 8");
    }
    i = -4;
    // else-if
    if (i > 12) {
      System.out.println("i > 12");
    } else if (i <= 12 && i >= 0) { // 第一個唔中，第二個條件
      System.out.println("i <= 12 and i >= 0");
    } else { // 之前都唔中，直接執行
      System.out.println("i is negative");
    }

    int a = 2;
    int b = 5;
    int box = 0; // assignment of int box is not necessary here, cos below will do, but always assign is good habit
    if (a > b) {
      box = 10; // declaration made inside if{} is not good, even still can run, cos int box may be used everywhere
    } else {
      box = 19;
      System.out.println(box);
    } // box=19

    int try1 = 10;
    if (try1 > 1000) {
      try1 = 5;
      System.out.println(try1);
    } else if (try1 <= 1000 && try1 > 99) {
      try1 *= 11;
      System.out.println(try1); // no else, condition not meet, nothing to execute
    } else if (try1 > 1000) {
      try1 = 6;
      System.out.println(try1);
    } else {
      System.out.println(try1);
    }

    int number = 12;
    if (number % 2 == 1) {
      System.out.println("number is an odd number");
    } else {
      System.out.println("number is an even number");
    }

    // String
    String str = "Monday";
    if (str.equals("Monday")) {
      System.out.println("str=Monday");
    }
    if (str.charAt(4) == 'd') { // false, chatAt(4) -> 'a'
      System.out.println("yes");
    }
    if (str.length() >= 6) {
      System.out.println("length>=6");
    }
    if (str.equals("Monday") || str.charAt(4) == 'd' && str.length() >= 6) {
      System.out.println("TRue");
    }
    // String use str.equals(""), not str == ""
    int score = 89;
    char grade = ' ';
    if (score >= 90) { // false
      grade = 'A'; // NOT executed
    } else if (score >= 80) { // true
      grade = 'B'; // executed
    } else if (score >= 70) { // checking? No
      grade = 'C';
    } else if (score >= 60) {
      grade = 'D';
    } else {
      grade = 'F';
    }
    System.out.println(grade);

    int age = 65;
    boolean isElderly = age >= 65; // i.e. already is true
    // this defination is good, cos when change the elderly age condition, correct one statment at a general place is the clearest
    if (isElderly) { // above declaration is more readable by using a clear NAME to define what is elderly
      // if (age >=65){} is also ok but no one know meaning. this condition may appear more than one place and change them is difficult
      System.out.println("yes he is elderly");
    }
    int try3 = 7;
    if (try3 > 1) {
      if (try3 < 6) {
        System.out.println("good");
      } else if (try3 == 6) {
        System.out.println("hi");
      } else {
        System.out.println("try3 > 6");
      }
    }


    // switch
    // Simple Version
    int dayOfWeek = 3;
    String dayName = "";
    switch (dayOfWeek) { // check if the value equals to the following cases
      case 1:
        dayName = "Monday";
        break; // exit
      case 2:
        dayName = "Tuesday";
        break;
      case 3:
        dayName = "Wednesday";
        break;
      case 4:
        dayName = "Thursday";
        break;
      case 5:
        dayName = "Friday";
        break;
      case 6:
        dayName = "Saturday";
        break;
      case 7:
        dayName = "Sunday";
        break;
    }
    System.out.println(dayName);

    int dayOfWeek2 = 3;
    String dayName2 = "";
    switch (dayOfWeek2) {
      case 1:
        dayName2 = "Monday";
        System.out.println(1);
      case 2:
        dayName2 = "Tuesday";
        System.out.println(2);
      case 3:
        dayName2 = "Wednesday";
        System.out.println(3);
      case 4:
        dayName2 = "Thursday";
        System.out.println(4);
      case 5:
        dayName2 = "Friday";
        System.out.println(5);
        break; // stop until here is a break
      case 6:
        dayName2 = "Saturday";
        System.out.println(6);
      case 7:
        dayName2 = "Sunday";
        System.out.println(7);
    }
    System.out.println(dayName2);


    String try4 = "C";
    int try41 = 0;
    switch (try4) {
      case "A":
        try41 = 1;
        System.out.println(try41);
        break;
      case "B":
        try41 = 2;
        System.out.println(try41);
        break;
      default: // if there is no default, and nothing match -> no action
        System.out.println(try41);
        break;
    }

    char grade2 = 'B';
    int pocketMoney = 0;
    switch (grade2) {
      case 'A':
        pocketMoney += 100;
        break;
      case 'B':
        pocketMoney += 70;
        break;
      case 'C':
        pocketMoney += 20;
        break;
      default:
        pocketMoney += 5;
        break;
    }
    System.out.println(pocketMoney); // cout one time after switch case

    // switch 好處:一眼睇哂有咩case, so no "if, else" inside "switch"
    // switch 會比較少用,
    


  }

}
