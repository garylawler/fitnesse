package fitnesse.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MovieInfo {
    private static final String TRUE = "True";
    @JsonProperty(value = "Title")
    String title;
    @JsonProperty(value = "Response")
    String response;
    @JsonProperty(value = "Type")
    String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getResponse() {
        return TRUE.equals(response);
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MovieInfo> asList() {
        return new ArrayList<MovieInfo>(Arrays.asList(this));
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "title='" + title + '\'' +
                ", response='" + response + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
