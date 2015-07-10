package fitnesse.app.fit;

import fitlibrary.ArrayFixture;
import fitlibrary.SetFixture;
import fitnesse.app.OMDBAPIClient;

public class OMDBAPISetFixture extends SetFixture {

    OMDBAPIClient omdbapiClient = OMDBAPIClient.getInstance();

    public OMDBAPISetFixture() {
        super();
        // args[] is populated post-construction
        setActualCollection(omdbapiClient.getCachedResults());
    }
}
