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
public class SearchByCityTest extends ApiTestSuite {

    private final String cityName;
    private final int result;

    public SearchByCityTest(String cityName, int result) {
        this.cityName = cityName;
        this.result = result;
    }

    /**
     * Returns the values count mapped by city if it exists. (cityName)
     * Compares with data. (result)
     */

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"Актау", 1},
                {"Актобе", 1},
                {"Алматы", 1},
                {"Бишкек", 1},
                {"Владикавказ", 1},
                {"Днепр", 1},
                {"Красноярск", 1},
                {"Магнитогорск", 1},
                {"Новосибирск", 1},
                {"Нижний%20Новгород", 1},
                {"Омск", 1},
                {"Орёл", 1},
                {"Петропавловск-Камчатский", 1},
                {"Прага", 1},
                {"Санкт-Петербург", 1},
                {"Усть-Каменогорск", 1},
                {"Уфа", 1},
                {"Томск", 1},
                {"Новокузнецк", 0},
                {"Самара", 0},
                {"Липецк", 0}
        });
    }

    @Test
    public void searchByCity() throws IOException, JSONException {
        JSONObject totalResponse = JSONHelper.readJsonFromUrl(totalResUrl + "?q=" + cityName);
        Assert.assertEquals(result, totalResponse.getJSONArray("items").length());
    }
}
