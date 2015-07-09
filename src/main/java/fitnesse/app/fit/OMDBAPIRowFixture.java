package fitnesse.app.fit;

import fit.RowFixture;
import fitnesse.app.OMDBAPIClient;
import fitnesse.app.model.MovieInfo;

public class OMDBAPIRowFixture extends RowFixture {

    OMDBAPIClient omdbapiClient = OMDBAPIClient.getInstance();

    @Override
    public Object[] query() throws Exception {
        return omdbapiClient.get(args[0]).asList().toArray();
    }

    @Override
    public Class<MovieInfo> getTargetClass() {
        return MovieInfo.class;
    }
}
