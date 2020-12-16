package dk.aau.cs.d703e20.uppaal;

import com.uppaal.model.core2.Query;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelCheckingTest {

    @Test
    void testGetUserQueries() {
        ModelChecker modelChecker = new ModelChecker();
        List<Query> queryList = modelChecker.getUserQueries(System.getProperty("user.dir") + "\\Resources\\test_query_files\\test_imply.q");

        assertAll(
                () -> assertEquals(3, queryList.size()),
                () -> assertEquals("A[] At0.start imply At0.endAt", queryList.get(0).getFormula()),
                () -> assertEquals("At0.start --> At0.endAt", queryList.get(1).getFormula()),
                () -> assertEquals("A[] not deadlock", queryList.get(2).getFormula())
        );
    }

    @Test
    void testGetUserQueries2() {
        ModelChecker modelChecker = new ModelChecker();
        List<Query> queryList = modelChecker.getUserQueries(System.getProperty("user.dir") + "\\Resources\\test_query_files\\queries.txt");

        assertAll(
                () -> assertEquals(3, queryList.size()),
                () -> assertEquals("A[] At0.start imply At0.endAt", queryList.get(0).getFormula()),
                () -> assertEquals("At0.start --> At0.endAt", queryList.get(1).getFormula()),
                () -> assertEquals("A[] not deadlock", queryList.get(2).getFormula())
        );
    }
}
