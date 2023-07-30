# Функция (и декоратор), предоставляющая
#   возможность перегрузки аргументов ...
from functools import singledispatchmethod


class Book():
  def __init__(self, title: str, author: str):
    self.title = title
    self.author = author


class Reader():
  '''
  >>> attrs = ['Иванов Александр Александрович', 'A741285', 'ПС', '1989-10-23', '+18452374123']
  >>> reader = Reader(*attrs)

  >>> reader.short_name
  'Иванов А.А.'

  >>> reader.take_book(4)
  Иванов А.А. взял 4 книги
  >>> reader.take_book('Атлант расправил плечи', 'Источник', 'Идеал')
  Иванов А.А. взял книги: Атлант расправил плечи, Источник, Идеал
  >>> reader.take_book(Book('Мы живые', 'Айн Ренд'), Book('Гимн', 'Айн Ренд'))
  Иванов А.А. взял книги: Мы живые, Гимн

  >>> reader.return_book(4)
  Иванов А.А. вернул 4 книги
  >>> reader.return_book('Атлант расправил плечи', 'Источник', 'Идеал')
  Иванов А.А. вернул книги: Атлант расправил плечи, Источник, Идеал
  >>> reader.return_book(Book('Мы живые', 'Айн Ренд'), Book('Гимн', 'Айн Ренд'))
  Иванов А.А. вернул книги: Мы живые, Гимн
  '''
  def __init__(self, full_name: str, card_number: str, faculty: str, birthdate: str, phone: str):
    self.surname, self.name, self.patronymic = full_name.split()
    self.card_number = card_number
    self.faculty = faculty
    self.birthdate = birthdate
    self.phone = phone


  @property
  def short_name(self) -> str:
    return f'{self.surname} {self.name[0]}.{self.patronymic[0]}.'


  @singledispatchmethod
  def take_book(self, count: int):
    print(f'{self.short_name} взял {count} книги')


  @take_book.register(str)
  def _(self, *books_names):
    print(f'{self.short_name} взял книги: {", ".join(books_names)}')


  @take_book.register(Book)
  def _(self, *books):
    books_names = [book.title for book in books]
    print(f'{self.short_name} взял книги: {", ".join(books_names)}')


  @singledispatchmethod
  def return_book(self, count: int):
    print(f'{self.short_name} вернул {count} книги')


  @return_book.register(str)
  def _(self, *books_names):
    print(f'{self.short_name} вернул книги: {", ".join(books_names)}')


  @return_book.register(Book)
  def _(self, *books):
    books_names = [book.title for book in books]
    print(f'{self.short_name} вернул книги: {", ".join(books_names)}')




if __name__ == '__main__':
    import doctest
    doctest.testmod()




# python3 -m doctest program.py -v

# Trying:
#     attrs = ['Иванов Александр Александрович', 'A741285', 'ПС', '1989-10-23', '+18452374123']
# Expecting nothing
# ok
# Trying:
#     reader = Reader(*attrs)
# Expecting nothing
# ok
# Trying:
#     reader.short_name
# Expecting:
#     'Иванов А.А.'
# ok
# Trying:
#     reader.take_book(4)
# Expecting:
#     Иванов А.А. взял 4 книги
# ok
# Trying:
#     reader.take_book('Атлант расправил плечи', 'Источник', 'Идеал')
# Expecting:
#     Иванов А.А. взял книги: Атлант расправил плечи, Источник, Идеал
# ok
# Trying:
#     reader.take_book(Book('Мы живые', 'Айн Ренд'), Book('Гимн', 'Айн Ренд'))
# Expecting:
#     Иванов А.А. взял книги: Мы живые, Гимн
# ok
# Trying:
#     reader.return_book(4)
# Expecting:
#     Иванов А.А. вернул 4 книги
# ok
# Trying:
#     reader.return_book('Атлант расправил плечи', 'Источник', 'Идеал')
# Expecting:
#     Иванов А.А. вернул книги: Атлант расправил плечи, Источник, Идеал
# ok
# Trying:
#     reader.return_book(Book('Мы живые', 'Айн Ренд'), Book('Гимн', 'Айн Ренд'))
# Expecting:
#     Иванов А.А. вернул книги: Мы живые, Гимн
# ok
# 6 items had no tests:
#     program
#     program.Book
#     program.Book.__init__
#     program.Reader._
#     program.Reader.__init__
#     program.Reader.short_name
# 1 items passed all tests:
#    9 tests in program.Reader
# 9 tests in 7 items.
# 9 passed and 0 failed.
# Test passed.
