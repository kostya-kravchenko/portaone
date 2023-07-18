import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.portaone.UniquenessUtils;

public class UniqueCharTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void getUniqueCharTest(String expected, String sample) {
        Assertions.assertEquals(expected, UniquenessUtils.getUniqueChar(sample));
    }

    public static Object[][] dataProvider() {
        return new Object[][]{
                {"e", "C makes it easy for you to shoot yourself in the foot. C++ makes that harder, but when you do, it blows away your whole leg. (с) Bjarne Stroustrup R# R++"},
                {"m", "The Tao gave birth to machine language.  Machine language gave birth\n" +
                        "to the assembler.\n" +
                        "The assembler gave birth to the compiler.  Now there are ten thousand\n" +
                        "languages.\n" +
                        "Each language has its purpose, however humble.  Each language\n" +
                        "expresses the Yin and Yang of software.  Each language has its place within\n" +
                        "the Tao.\n" +
                        "But do not program in COBOL if you can avoid it.\n" +
                        "        -- Geoffrey James, \"The Tao of Programming\""},
                {"", ""},
                {"1", "1"},
                {"W", "QQQ EWE TTT"},
                {"", "QWQ EWE TWT"},
                {"H", "Hello World"},
                {"r", "bbookkeepper"},
                {"T", "Testing"},
        };
    }
}

