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
public class SearchByPageSizeTest extends ApiTestSuite {

    private final String pageSize;
    private final int result;

    public SearchByPageSizeTest(String pageSize, int result) {
        this.pageSize = pageSize;
        this.result = result;
    }

    /**
     * Returns the values count mapped by page if it exists. (page)
     * Compares with data. (result)
     */

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"5", 5},
                {"10", 10},
                {"15", 15},
        });
    }

    @Test
    public void searchByCity() throws IOException, JSONException {
        JSONObject totalResponse = JSONHelper.readJsonFromUrl(totalResUrl + "?page=1&page_size=" + pageSize);
        System.out.println(totalResUrl + "?page=1&page_size=" + pageSize);
        System.out.println(totalResponse.getJSONArray("items").length());
        Assert.assertEquals(result, totalResponse.getJSONArray("items").length());
    }
}
