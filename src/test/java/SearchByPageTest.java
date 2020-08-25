import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import service.JSONHelper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SearchByPageTest extends ApiTestSuite {

    private final String page;
    private final int result;

    public SearchByPageTest(String page, int result) {
        this.page = page;
        this.result = result;
    }

    /**
     * Returns the values count mapped by page if it exists. (page)
     * Compares with data. (result)
     */

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"1", 10},
                {"2", 10},
                {"3", 3},
        });
    }

    @Test
    public void searchByCity() throws IOException, JSONException {
        JSONObject totalResponse = JSONHelper.readJsonFromUrl(totalResUrl + "?page=" + page);
        Assert.assertEquals(result, totalResponse.getJSONArray("items").length());
    }
}
