package com.rookie.stack.ai.data;

import java.util.List;

/**
 * @author eumenides
 * @description
 * @date 2024/5/30
 */
public class Movies {
    List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movies=" + movies +
                '}';
    }
}

class Movie {



    private String name;

    private String releaseTime;

    private String reason;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
