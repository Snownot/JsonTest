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
public class SearchByCountryCodeTest extends  ApiTestSuite {

    private final String countryCode;
    private final int result;

    public SearchByCountryCodeTest(String countryCode, int result) {
        this.countryCode = countryCode;
        this.result = result;
    }

    /**
     * Returns the values count mapped by countries if it exists. (countryCode)
     * Compares with data. (result)
     */

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"ru", 10},
                {"kg", 6},
                {"kz", 6},
                {"cz", 1},
        });
    }

    @Test
    public void searchByCity() throws IOException, JSONException {
        JSONObject totalResponse = JSONHelper.readJsonFromUrl(totalResUrl + "?country_code=" + countryCode);
        Assert.assertEquals(result, totalResponse.getJSONArray("items").length());
    }
}
