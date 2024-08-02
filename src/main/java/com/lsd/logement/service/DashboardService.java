package com.lsd.logement.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsd.logement.repository.BailRepository;
import com.lsd.logement.repository.LocalRepository;

@Service
public class DashboardService {

    @Autowired
    private BailRepository bailRepository;

    @Autowired
    private LocalRepository localRepository;

    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();

        long closedCount = bailRepository.countByStatus("CLOTURER");
        long canceledCount = bailRepository.countByStatus("ANNULE");
        long confirmedCount = bailRepository.countByStatus("CONFIRME");
        long anonymousCount = bailRepository.countByStatus("ANONYME");

        stats.put("closed", closedCount);
        stats.put("canceled", canceledCount);
        stats.put("confirmed", confirmedCount);
        stats.put("annonymous", anonymousCount);

        return stats;
    }

    public LocalRepository getLocalRepository() {
        return localRepository;
    }

    public void setLocalRepository(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

}
