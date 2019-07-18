package org.cnu.realcoding.weathercrawler.api;

import org.cnu.realcoding.weathercrawler.domain.SummonerInformation;
import org.cnu.realcoding.weathercrawler.domain.SummonerGameGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RiotGamesApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-3f3f2955-af1e-4654-a35c-400a5d823465";

    private final ParameterizedTypeReference<List<SummonerGameGrade>> summnorGameGradeType = new ParameterizedTypeReference<List<SummonerGameGrade>>() {};

    private final String currentSummnorURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{cityName}?api_key={apiKey}";
    private final String currentSummnorGradeURL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={apiKey}";


    public SummonerInformation getCurrentWeather(String cityName) {
        SummonerInformation summonerInformation = restTemplate.exchange(this.currentSummnorURL, HttpMethod.GET, null, SummonerInformation.class, cityName, apiKey)
                .getBody();
        return summonerInformation;
    }

    public List<SummonerGameGrade> getSummnorGameGrade(String encryptedSummonerId){
        return  restTemplate.exchange(currentSummnorGradeURL, HttpMethod.GET, null, summnorGameGradeType, encryptedSummonerId, apiKey).getBody();
    }
}