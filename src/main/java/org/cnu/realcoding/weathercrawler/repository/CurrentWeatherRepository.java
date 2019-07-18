package org.cnu.realcoding.weathercrawler.repository;

import org.cnu.realcoding.weathercrawler.domain.SummonerInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public SummonerInformation insertOrUpdatedCurrentWeather(SummonerInformation summonerInformation) {
        return mongoTemplate.save(summonerInformation);
    }

    public SummonerInformation findCurrentSummnorBySummnorName(String summonerName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(summonerName));

        return mongoTemplate.findOne(query, SummonerInformation.class);
    }
}
