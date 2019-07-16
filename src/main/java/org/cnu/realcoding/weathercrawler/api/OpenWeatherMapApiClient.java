package org.cnu.realcoding.weathercrawler.api;

import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.cnu.realcoding.weathercrawler.domain.SummnorGameGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-6a061c31-7be4-455d-a50d-fef5968260a7";

    //private final String encryptId = "9LLZkK4mzi8P7lTXGn_HMaoSDMPLIpGTJ-J-8GgcYKxaAg";

    private final String currentSummnor = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{cityName}?api_key={apiKey}";
    private final String currentSummnorGrade = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptId}?api_key={apiKey}";

    private String encryptId = null;

    public CurrentWeather getCurrentWeather(String cityName) {
        CurrentWeather currentWeather = restTemplate.exchange(currentSummnor, HttpMethod.GET, null, CurrentWeather.class, cityName, apiKey)
                .getBody();
        encryptId = currentWeather.getId();
        System.out.println("ID를 받아오는가\n\n\n"+currentWeather.getId());
        return currentWeather;
    }

    public SummnorGameGrade getSummnorGameGrade(String encryptId){
        SummnorGameGrade summnorGameGrade = restTemplate.exchange(currentSummnorGrade, HttpMethod.GET, null, SummnorGameGrade.class, encryptId, apiKey)
                .getBody();
        System.out.println("정보를 받아오는가\n\n\n"+summnorGameGrade.getQueueType());
        return summnorGameGrade;
    }
}