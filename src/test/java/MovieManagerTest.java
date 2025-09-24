import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    @Test
    public void shouldBeOneFilm() {  // добавление одного фильма
        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shoulBeTwoFilms() {  // отображение в правилном порядке, еогда больше одного фильма
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");

        String[] expected = {"Бладшот", "Вперёд"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shoulBeWithoutFilms() { // нет добавленных фильмов
        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastByDefaultIfFilmsMoreFive() {  // последние c лимитом по умолчанию, когда фильмов больше 5
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель <<Белград>>");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли.Мировой уровень");

        String[] expected = {"Тролли.Мировой уровень", "Человек-невидимка", "Джентельмены", "Отель <<Белград>>", "Вперёд"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastByDefaultIfFilmsLessFive() { // последние c лимитом по умолчанию, когда фильмов меньше 5
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель <<Белград>>");

        String[] expected = {"Отель <<Белград>>", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldLastByLimitSix() { // последние добавленые с лимитом 6
        MovieManager manager = new MovieManager(6);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель <<Белград>>");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли.Мировой уровень");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли.Мировой уровень", "Человек-невидимка", "Джентельмены", "Отель <<Белград>>", "Вперёд"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastByLimitThree() { // последние добавленые с лимитом 3
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель <<Белград>>");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли.Мировой уровень");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли.Мировой уровень", "Человек-невидимка"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
