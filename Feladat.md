# Feladatleírás

A feladat egy könyvtárkezelő alkalmazás elkészítése. Az alkalmazás váza interface szinten el lett készítve.
A váz alapján nektek kell a funkciókat implementálni. 

### Elkészült osztályok:
#### Adattároló  osztályok:
- **Book:** Egy könyvet reprezentál a könyvtárban.
  - **String** isbn - A könyv ISBN kódja. Egyedinek kell lennie.
  - **String** title - A könyv címe.
  - **String** author - A könyv szerzője.
  - **String** genre - A könyv műfaja.
  - **boolean** available - Elérhető-e a könyv.

- **Patron:** Egy olvasót reprezentál a könyvtárban.
  - **String** name - Az olvasó neve.
  - **String** email - Az olvasó email címe.
  - **long** libraryCardNumber - Az olvasó kártya száma. Egyedinek kell lennie.
  - **List < Book >** borrowedBooks - Az olvasó által kikölcsönzött könyvek.

#### Repository osztályok:

- **IRepository** : Az alap repository interface.
- **IBookRepository** : A könyv repository interface-e, az **IRepository**-ból származik.
- **IPatronRepository** : Az olvasó repository interface-e, az **IRepository**-ból származik.
- **BookRepository** : A könyv repository osztálya, implementálja az **IBookRepository** interfacet.
  - Optional<Book> findBookByIsbn(String isbn) : Isbn alapján keresse meg a könyvet.
  - List<Book> findBookByAuthor(String author) : Keresse meg az összes könyvet szerző alapján.
  - List<Book> findBookByTitle(String title) : Keresse meg az összes könyvet cím alapján.
  - List<Book> findBookByGenre(String genre) : Keresse meg az összes könyvet műfaj alapján.
  - List<Book> findBookByTittlePrefixMatch(String prefix) : Keresse meg az összes könyvet, aminek a címének elejére illeszkedik a prefix.
  - List<Book> findAllAvailableBooks() : Keresse meg az összes elérhető könyvet.
  - List<Book> findAllUnAvailableBooks() : Keresse meg az összes nem elérhető könyvet.
  - boolean add(Book book) : Tároljon el egy könyvet.
  - boolean remove(Book book) : Töröljön egy könyvet, a könyvek közül.
- **PatronRepository** : Az olvasó repository osztálya, implementálja az **PatronRepository** interfacet.
  - Optional<Patron> findPatronByLibraryCardNumber(long libraryCardNumber) : Keresse meg az olvasót a kártyaszám alapján.
  - List<Patron> findPatronByName(String name) : Keresse meg az összes olvasót név alapján.
  - List<Patron> findPatronByEmail(String email) : Keresse meg az összes olvasót email cím alapján.
  - List<Patron> findPatronByBorrowedBook(Book book) : Keresse meg az összes olvasót a kikölcsönzött könyv alapján.
  - boolean add(Patron patron) : Tároljon el egy olvasót.
  - boolean remove(Patron patron) : Töröljön egy olvasót, a olvasók közül.

#### Service osztály:
- **ILibrarianService** : A könyvtáros szervíz osztályának interface-e.
- **LibrarianService** : A könyvtáros szervíz osztálya, implementálja a **ILibrarianService** interfacet.
  - boolean addBook() : Tároljon el egy könyvet.
  - boolean removeBook() : Töröljön egy könyvet, a könyvek közül.
  - boolean addPatron() : Tároljon el egy olvasót.
  - boolean removePatron() Töröljön egy olvasót, a olvasók közül.
  - void printBookInformation(Book book) : Írja ki a könyv paramétereit a konzolra.
  - void printPatronInformation(Patron patron) : Írja ki az olvasó paramétereit a konzolra.
  - void borrowBook(Patron patron, Book bookToBorrow) : Valósítsa meg a kölcsönzést. (Feltételezzük, hogy végtelen számú könyvünk van.)
  - void returnBook(Patron patron, Book bookToBorrow) Valósítsa meg a könyv visszavételét.

### Feladat
A feladatotok befejezni az implementációt a váz és a leírás alapján és az elkészült implementáció tesztelése. A teszteléshez minden implementálandó metódushoz találtok egy tesztesetet.

A megoldás során bármilyen segédanyag felhasználható. 

**Ha a program nem fordul, akkor a megoldásra nulla pont jár.**