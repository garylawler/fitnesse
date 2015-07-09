package fitnesse.app.fit;

import fit.ColumnFixture;
import fitnesse.app.OMDBAPIClient;

public class OMDBAPIColumnFixture extends ColumnFixture {

    private String title;
    private String expected;
    private String name;
    private String successResponse;
    private int theCount = 0;

    OMDBAPIClient omdbapiClient = OMDBAPIClient.getInstance();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String name() {
        return omdbapiClient.get(title).getTitle();
    }

    public boolean successResponse() {
        return omdbapiClient.get(title).getResponse();
    }

    public int count() {
        return theCount++;
    }
}
