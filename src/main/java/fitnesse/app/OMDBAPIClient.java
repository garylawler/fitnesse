package fitnesse.app;

import fitnesse.app.model.MovieInfo;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class OMDBAPIClient extends RestTemplate {

    private static final String BASE_URL = "http://www.omdbapi.com/";
    private static List<MovieInfo> cachedResults = new ArrayList<MovieInfo>();
    private static OMDBAPIClient instance;
    private static int requestsViaGet = 0;
    private static int requestsViaGetWithParameters = 0;

    private OMDBAPIClient() {
        super(new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault()));
        getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public List<MovieInfo> getCachedResults() {
        return cachedResults;
    }

    public MovieInfo get(String name) {
        MovieInfo movieInfo = getForObject(BASE_URL + "?t=" + name, MovieInfo.class);
        if(movieInfo.getResponse()){
            cachedResults.add(movieInfo);
        }
        requestsViaGet++;
        return movieInfo;
    }

    public MovieInfo get(String name, String id, String type) {
        MovieInfo movieInfo = getForObject(
                MessageFormat.format(BASE_URL + "?t={0}&type={1}&id={2}", name, type, id), MovieInfo.class);
        if(movieInfo.getResponse()){
            cachedResults.add(movieInfo);
        }
        requestsViaGetWithParameters++;
        return movieInfo;
    }

    public static OMDBAPIClient getInstance() {
        if(instance==null) {
            instance = new OMDBAPIClient();
        }
        return instance;
    }

    public int getRequestsViaGet() {
        return requestsViaGet;
    }

    public int getRequestsViaGetWithParameters() {
        return requestsViaGetWithParameters;
    }

    public void resetCounts() {
        requestsViaGet = 0;
        requestsViaGetWithParameters = 0;
        cachedResults = new ArrayList<MovieInfo>();
    }
}
