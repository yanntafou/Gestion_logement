package com.lsd.logement.service;

import java.io.InputStream;

import com.lsd.logement.entity.finance.Caisse;
import com.lsd.logement.entity.finance.Payement;

public interface CaisseService extends GenericService<Caisse, Integer> {

    Caisse findOpened(int appUserId);

    Caisse findByUserId(Integer id);

    Caisse open(Caisse caisse);

    Caisse validate(Integer id);

    Caisse pay(Payement payement, int appUserId);

    Caisse closeRequest(Caisse caisse);

    Caisse close(Integer id);

    boolean hasPrincipalCaisse();

    InputStream generatePdf(Integer id) throws Exception;

    void debitPrincipal(int montant);

    void creditPrincipal(int montant);
}
