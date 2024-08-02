package com.lsd.logement.service;

import com.lsd.logement.entity.finance.Depense;

public interface DepenseService extends GenericService<Depense, Integer> {

    long countDepenseMois();

    long countDepenseAnnee();

    void validate(Depense depense);
}
