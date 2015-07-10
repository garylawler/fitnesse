package fitnesse.app.fit;

import fit.Fixture;
import fitlibrary.CalculateFixture;
import fitlibrary.SetUpFixture;
import fitnesse.app.OMDBAPIClient;

public class OMDBAPICalculateFixture extends CalculateFixture {

    public int totalArg1Arg2(String arg1, String arg2) {
        return Integer.parseInt(String.valueOf(Fixture.getSymbol(arg1))) + Integer.parseInt(String.valueOf(Fixture.getSymbol(arg2)));
    }
}
