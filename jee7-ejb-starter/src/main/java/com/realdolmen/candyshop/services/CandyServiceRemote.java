package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.repository.CandyRepository;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CandyServiceRemote {

    List<Candy> findAllCandy();

    List<Candy> findCandyByColor(CandyColor candyColor);
}
