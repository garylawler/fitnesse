package fitnesse.app.fit;

import fit.ColumnFixture;
import fitlibrary.SetUpFixture;
import fitnesse.app.OMDBAPIClient;

public class OMDBAPISetUpFixture extends SetUpFixture {

    public void requestsViaGetRequestsViaGetWithParameters(int value1, int value2) {
        // value1 and value2 can be used to initalise values
        OMDBAPIClient.getInstance().resetCounts();
    }
}
