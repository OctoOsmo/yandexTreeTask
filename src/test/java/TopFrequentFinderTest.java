import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TopFrequentFinderTest {

    @Test
    public void test(){
        TopFrequentFinder topFrequentFinder = new TopFrequentFinder();
        List<Integer> kFrequent = topFrequentFinder.topKFrequent(Arrays.asList(5, 5, 5, 5, 5, 1, 1, 1, 2, 2, 6, 6, 6), 2);

        assertEquals(Arrays.asList(5, 6), kFrequent);
    }
}
