package org.cnu.realcoding.weathercrawler.domain;

import lombok.Data;

@Data
public class SummonerInformation {

    private int profileIconId;
    private String name;
    private String puuid;
    private long summonerLevel;
    private String accountId;
    private String id;
    private long revisionDate;
}
