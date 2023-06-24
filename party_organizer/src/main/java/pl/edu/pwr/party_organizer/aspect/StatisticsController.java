package pl.edu.pwr.party_organizer.aspect;

import pl.edu.pwr.party_organizer.aspect.StatisticAspect;
import pl.edu.pwr.party_organizer.model.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticAspect statisticAspect;

    @Autowired
    public StatisticsController(StatisticAspect statisticAspect) {
        this.statisticAspect = statisticAspect;
    }

    @GetMapping("/method-calls")
    public Map<String, Integer> getMethodCallStatistics() {
        return statisticAspect.getMethodCallsCount();
    }

    @GetMapping("/oldest-event")
    public Party getOldestEventStatistics() {
        return statisticAspect.getOldestEvent();
    }
}