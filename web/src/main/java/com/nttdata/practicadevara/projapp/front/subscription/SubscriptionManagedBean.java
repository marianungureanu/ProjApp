/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.front.subscription;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author stefana.sireanu
 */

@SessionScoped
@Named("subscriptionMBean")


public class SubscriptionManagedBean implements Serializable{
    
     private static final long serialVersionUID = 10001;

    private static final String SUBSCRIPTION_XHTML = "/admin/subscription/index";
    private static final String ACCEPT_OR_REJECT_XHTML = "/admin/subscription/acceptOrRejectSubscription";

    @EJB
    private SubscriptionRest subscriptionRest;

    private SubscriptionDto selected;
    private List<SubscriptionDto> subscriptionList;
    private boolean isAccept;
    private boolean isReject;

    /**
     * Creates a new instance
     */
    public SubscriptionManagedBean() {
    }

    public void init() {
        subscriptionList = subscriptionRest.listSubscriptions();
    }

    public List<SubscriptionDto> getSubscriptions() {
        if (subscriptionList == null) {
            init();
        }
        return subscriptionList;
    }

    public SubscriptionDto getSelected() {
        return selected;
    }

    public void setSelected(SubscriptionDto selectedSubscription) {
        this.selected = selectedSubscription;
    }

    public String startAccept() {
        isAccept = true;
        isReject = false;
        return ACCEPT_OR_REJECT_XHTML;
    }

    public String startReject() {
        isAccept = false;
        isReject= true;
        selected = new SubscriptionDto();
        return ACCEPT_OR_REJECT_XHTML;
    }

    public boolean isIsAccept() {
        return isAccept;
    }

    public boolean isIsReject() {
        return isReject;
    }

    public void reload() {
       subscriptionList = null;
    }

    public String accept() {
        subscriptionRest.update(selected);
        selected = null;
        reload();
        isAccept = false;
        return SUBSCRIPTION_XHTML;
    }

    public String reject() {
        subscriptionRest.update(selected);
        selected = null;
        reload();
        isReject= false;
        return SUBSCRIPTION_XHTML;
    }

    public String toSubscriptionIndex() {
        return SUBSCRIPTION_XHTML;
    }
    
}



