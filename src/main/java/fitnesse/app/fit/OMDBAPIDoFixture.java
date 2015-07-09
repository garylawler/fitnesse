package fitnesse.app.fit;

import fitlibrary.DoFixture;
import fitnesse.app.OMDBAPIClient;
import fitnesse.app.model.MovieInfo;

public class OMDBAPIDoFixture extends DoFixture {

    private String expected;
    private MovieInfo movieInfo;

    OMDBAPIClient omdbapiClient = OMDBAPIClient.getInstance();

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public void queryWithIdAndType(String name, String id, String type) {
        movieInfo = omdbapiClient.get(name, id, type);
    }

    public boolean isExpectedTitle() {
        if(movieInfo == null) {
            return false;
        }
        return expected.equals(movieInfo.getTitle());
    }
}
