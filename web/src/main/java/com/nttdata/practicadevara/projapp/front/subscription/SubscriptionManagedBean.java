package com.nttdata.practicadevara.projapp.front.subscription;

import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionStatusEnumDto;
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

public class SubscriptionManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    private static final String SUBSCRIPTION_XHTML = "/admin/subscription/index";

    @EJB
    private SubscriptionRest subscriptionRest;

    private SubscriptionDto selected;
    private List<SubscriptionDto> subscriptionList;

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

    public void reload() {
        subscriptionList = null;    
    }

    public String accept() {
        selected.setStatus(SubscriptionStatusEnumDto.ACCEPTED);
        subscriptionRest.update(selected);
        selected = null;
        reload();
        return SUBSCRIPTION_XHTML;
    }

    public String reject() {
        selected.setStatus(SubscriptionStatusEnumDto.REJECTED);
        subscriptionRest.update(selected);
        selected = null;
        reload();
        return SUBSCRIPTION_XHTML;
    }

    public String delete() {
        subscriptionRest.delete(selected);
        selected = null;
        reload();
        return SUBSCRIPTION_XHTML;
    }

    public String toSubscriptionIndex() {
        return SUBSCRIPTION_XHTML;
    }

}
