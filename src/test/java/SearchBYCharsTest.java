import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import service.JSONHelper;

import java.io.IOException;

public class SearchBYCharsTest extends ApiTestSuite {

    @Test
    public void searchWithDoubleChar() throws IOException, JSONException {
        totalResponse = JSONHelper.readJsonFromUrl(totalResUrlDoubleChar);
        boolean contentResult = totalResponse.toString().contains("error");
        Assert.assertTrue(contentResult);
    }

    @Test
    public void searchWithTripleChar() throws IOException, JSONException {
        totalResponse = JSONHelper.readJsonFromUrl(totalResUrlTripleChar);
        boolean contentResult = totalResponse.toString().contains("error");
        Assert.assertFalse(contentResult);
    }

    @Test
    public void searchWithThirtyOneChar() throws IOException, JSONException {
        totalResponse = JSONHelper.readJsonFromUrl(totalResUrlThirtyOneChar);
        boolean contentResult = totalResponse.toString().contains("error");
        Assert.assertTrue(contentResult);
    }
}
