package com.nttdata.practicadevara.projapp.ejb;

import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import com.nttdata.practicadevara.projapp.db.SubscriptionEntity;
import com.nttdata.practicadevara.projapp.db.SubscriptionBean;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author eduard.ioo
 */
@Stateless
public class SubscriptionEjb {

    @EJB
    private SubscriptionBean subscriptionDbBean;
   

    public List<SubscriptionDto> list(int appRoleId, int employeeId) {
        List<SubscriptionEntity> entities = subscriptionDbBean.findAll(appRoleId, employeeId);
        return toDtoSubscriptionList(entities);
   }
    
    public List<SubscriptionDto> listAll() {
        List<SubscriptionEntity> entities = subscriptionDbBean.findAllSubscriptions();
        return toDtoSubscriptionList(entities);
   }


}
