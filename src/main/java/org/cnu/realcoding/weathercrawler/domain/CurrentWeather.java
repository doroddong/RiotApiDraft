package org.cnu.realcoding.weathercrawler.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class CurrentWeather {

    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private String accountId;
    private String id;
    private long revisionDate;
}
