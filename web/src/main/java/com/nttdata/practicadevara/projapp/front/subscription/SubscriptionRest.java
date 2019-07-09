/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.front.subscription;

/**
 *
 * @author stefana.sireanu
 */

import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean


public class SubscriptionRest {
    
    private int tempIndex = 0;           //to be delete when REST services are ready
    private int ide=0,ida=0;
   
    private List<SubscriptionDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        for(int i=0; i<5; i++) { 
            SubscriptionDto e = new SubscriptionDto(tempIndex++, "Subscription " + tempIndex, ide++, ida++);
            tempList.add(e);
        }
    }

    public List<SubscriptionDto> listSubscriptions() {
        return tempList;
    }

    public SubscriptionDto update(SubscriptionDto entry) {
        return entry;
    }

    public SubscriptionDto create(SubscriptionDto entry) {
        entry.setId(tempIndex++);
        tempList.add(entry);
        return entry;
    }
    
}
