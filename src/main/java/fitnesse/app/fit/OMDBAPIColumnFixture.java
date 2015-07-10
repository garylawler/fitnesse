package fitnesse.app.fit;

import fit.ColumnFixture;
import fitnesse.app.OMDBAPIClient;
import fitnesse.app.model.MovieInfo;

public class OMDBAPIColumnFixture extends ColumnFixture {

    private String title;
    private String expected;
    private String name;
    private String successResponse;
    private MovieInfo movieInfo;

    OMDBAPIClient omdbapiClient = OMDBAPIClient.getInstance();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String name() {
        movieInfo = omdbapiClient.get(title);

        return movieInfo.getTitle();
    }

    public boolean successResponse() {
        return movieInfo.getResponse();
    }

    public int requestsViaGet() {
        return omdbapiClient.getRequestsViaGet();
    }

    public int requestsViaGetWithParameters() {
        return omdbapiClient.getRequestsViaGetWithParameters();
    }

    public int count() {
        return omdbapiClient.getRequestsViaGet() + omdbapiClient.getRequestsViaGetWithParameters();
    }
}
