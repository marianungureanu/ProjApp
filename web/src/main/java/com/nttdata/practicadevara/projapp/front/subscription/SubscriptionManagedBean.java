package com.nttdata.practicadevara.projapp.front.subscription;

import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionStatusEnumDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author stefana.sireanu
 */
@SessionScoped
@Named("subscriptionMBean")
public class SubscriptionManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    @EJB
    private SubscriptionRest subscriptionRest;

    private SubscriptionDto selected;

    /**
     * Creates a new instance
     */
    public SubscriptionManagedBean() {
    }

    public List<SubscriptionDto> getSubscriptions() {
        return subscriptionRest.listSubscriptions();
    }

    public SubscriptionDto getSelected() {
        return selected;
    }

    public void setSelected(SubscriptionDto selectedSubscription) {
        this.selected = selectedSubscription;
    }

    public String accept() {
        selected.setStatus(SubscriptionStatusEnumDto.ACCEPTED);
        subscriptionRest.update(selected);
        selected = null;
        return "";
    }

    public String reject() {
        selected.setStatus(SubscriptionStatusEnumDto.REJECTED);
        subscriptionRest.update(selected);
        selected = null;
        return "";
    }

    public String delete() {
        try {
            subscriptionRest.delete(selected);
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null && t != t.getCause()) {
                t = t.getCause();
            }
            FacesContext.getCurrentInstance().addMessage("delete subscription", new FacesMessage("Error", "Cannot delete subscription: " + t.getMessage()));
        }
        selected = null;
        return "";
    }
}
