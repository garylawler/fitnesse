package fitnesse.app.fit;

import fitlibrary.ArrayFixture;
import fitnesse.app.OMDBAPIClient;

public class OMDBAPIArrayFixture extends ArrayFixture {

    OMDBAPIClient omdbapiClient = OMDBAPIClient.getInstance();

    public OMDBAPIArrayFixture() {
        super();
        // args[] is populated post-construction
        setActualCollection(omdbapiClient.getCachedResult().asList());
    }
}
