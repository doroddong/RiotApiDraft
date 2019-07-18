package org.cnu.realcoding.weathercrawler.repository;

import org.cnu.realcoding.weathercrawler.domain.SummonerGameGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SummonerGameGradeRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public SummonerGameGrade insertOrUpdatedSummnorGameGrade(SummonerGameGrade summonerGameGrade) {
        return mongoTemplate.save(summonerGameGrade);
    }

    public SummonerGameGrade findGameGradeBySummnorName(String summonerName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("summonerName").is(summonerName));

        return mongoTemplate.findOne(query, SummonerGameGrade.class);
    }
}
