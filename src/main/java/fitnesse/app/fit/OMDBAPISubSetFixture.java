package fitnesse.app.fit;

import fitlibrary.SetFixture;
import fitlibrary.SubsetFixture;
import fitnesse.app.OMDBAPIClient;

public class OMDBAPISubSetFixture extends SubsetFixture {

    OMDBAPIClient omdbapiClient = OMDBAPIClient.getInstance();

    public OMDBAPISubSetFixture() {
        super();
        // args[] is populated post-construction
        setActualCollection(omdbapiClient.getCachedResults());
    }
}
