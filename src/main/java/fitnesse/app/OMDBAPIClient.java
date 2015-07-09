package fitnesse.app;

import fitnesse.app.model.MovieInfo;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

public class OMDBAPIClient extends RestTemplate {

    private static final String BASE_URL = "http://www.omdbapi.com/";
    private MovieInfo cachedResult;
    private static OMDBAPIClient instance;

    private OMDBAPIClient() {
        super(new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault()));
        getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public MovieInfo getCachedResult() {
        return cachedResult;
    }

    public MovieInfo get(String name) {
        MovieInfo movieInfo = getForObject(BASE_URL + "?t=" + name, MovieInfo.class);
        cachedResult = movieInfo;
        return movieInfo;
    }

    public MovieInfo get(String name, String id, String type) {
        MovieInfo movieInfo = getForObject(
                MessageFormat.format(BASE_URL + "?t={0}&type={1}&id={2}", name, type, id), MovieInfo.class);
        cachedResult = movieInfo;
        return movieInfo;
    }

    public static OMDBAPIClient getInstance() {
        if(instance==null) {
            instance = new OMDBAPIClient();
        }
        return instance;
    }
}
