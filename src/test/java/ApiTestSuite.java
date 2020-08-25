import org.json.JSONObject;


public class ApiTestSuite {

    protected JSONObject totalResponse;
    protected static String totalResUrl = "https://regions-test.2gis.com/1.0/regions";
    protected static String totalResUrlDoubleChar = "https://regions-test.2gis.com/1.0/regions?q=Аа";
    protected static String totalResUrlTripleChar = "https://regions-test.2gis.com/1.0/regions?q=Ааa";
    protected static String totalResUrlThirtyOneChar = "https://regions-test.2gis.com/1.0/regions?q=Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

}
