
package org.cnu.realcoding.weathercrawler.domain;

import lombok.Data;

@Data
public class SummnorGameGrade {
    private String queueType;
    private String summnorName;
    private boolean hotStreak;
    private int wins;
    private boolean veteran;
    private int losses;
    private String rank;
    private String tier;
    private boolean inactive;
    private boolean freshBlood;
    private String leagueId;
    private String summnorId;
    private int leaguePoints;
}