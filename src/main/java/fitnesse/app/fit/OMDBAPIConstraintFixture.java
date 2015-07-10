package fitnesse.app.fit;

import fit.Fixture;
import fitlibrary.CalculateFixture;
import fitlibrary.ConstraintFixture;

public class OMDBAPIConstraintFixture extends ConstraintFixture {

    public boolean arg1Arg2(String arg1, String arg2) {
        return Integer.parseInt(String.valueOf(Fixture.getSymbol(arg1))) < Integer.parseInt(String.valueOf(Fixture.getSymbol(arg2)));
    }
}
