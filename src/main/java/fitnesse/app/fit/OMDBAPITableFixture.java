package fitnesse.app.fit;

import fitnesse.app.OMDBAPIClient;
import fitnesse.app.model.MovieInfo;
import fitnesse.fixtures.TableFixture;

public class OMDBAPITableFixture extends TableFixture {

    OMDBAPIClient omdbapiClient = OMDBAPIClient.getInstance();

    @Override
    protected void doStaticTable(int rows) {
        for(int i=0; i < rows; i++){
            String name = getText(i, 0);
            MovieInfo movieInfo = omdbapiClient.get(name);

            if(movieInfo.getResponse()) {
                if(getText(i, 1).equals(movieInfo.getTitle())) {
                    right(i, 1);
                }
                if(Boolean.parseBoolean(getText(i, 2)) == movieInfo.getResponse()) {
                    right(i, 2);
                }
            }
            else {
                wrong(i, 0);
                wrong(i, 1);
                wrong(i, 2);
            }
        }
    }
}
