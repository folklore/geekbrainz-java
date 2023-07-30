import java.util.ArrayList;
import java.util.List;

class Book {
  String title;
  String author;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }
}

class Reader {
  String surname;
  String name;
  String patronymic;
  String card_number;
  String faculty;
  String birthdate;
  String phone;

  public Reader(String full_name, String card_number, String faculty, String birthdate, String phone) {
    String[] names = full_name.split(" ");
    this.surname = names[0];
    this.name = names[1];
    this.patronymic = names[2];
    this.card_number = card_number;
    this.faculty = faculty;
    this.birthdate = birthdate;
    this.phone = phone;
  }

  public String getShortName() {
    return this.surname + " " + this.name.charAt(0) + "." + this.patronymic.charAt(0) + ".";
  }

  public void takeBook(int count) {
    System.out.println(this.getShortName() + " взял " + count + " книги");
  }

  public void takeBook(String... books_names) {
    System.out.println(this.getShortName() + " взял книги: " + String.join(", ", books_names));
  }

  public void takeBook(Book... books) {
    List<String> books_names = new ArrayList<>();
    for (Book book : books) {
      books_names.add(book.title);
    }
    System.out.println(this.getShortName() + " взял книги: " + String.join(", ", books_names));
  }

  public void returnBook(int count) {
    System.out.println(this.getShortName() + " вернул " + count + " книги");
  }

  public void returnBook(String... books_names) {
    System.out.println(this.getShortName() + " вернул книги: " + String.join(", ", books_names));
  }

  public void returnBook(Book... books) {
    List<String> books_names = new ArrayList<>();
    for (Book book : books) {
      books_names.add(book.title);
    }
    System.out.println(this.getShortName() + " вернул книги: " + String.join(", ", books_names));
  }
}
