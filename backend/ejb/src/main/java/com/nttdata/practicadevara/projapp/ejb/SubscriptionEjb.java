package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.ApplicationRoleBean;
import com.nttdata.practicadevara.projapp.db.DbException;
import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import com.nttdata.practicadevara.projapp.db.SubscriptionEntity;
import com.nttdata.practicadevara.projapp.db.SubscriptionBean;
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

    @EJB
    private ApplicationRoleBean applicationRoleBean;

    public List<SubscriptionDto> list(int appRoleId, int employeeId) {
        List<SubscriptionEntity> entities = subscriptionDbBean.findAll(appRoleId, employeeId);
        return toDtoSubscriptionList(entities);
    }

    public List<SubscriptionDto> listAll() {
        List<SubscriptionEntity> entities = subscriptionDbBean.findAllSubscriptions();
        return toDtoSubscriptionList(entities);
    }

    public SubscriptionDto findById(int id) {
        SubscriptionEntity entity = subscriptionDbBean.findById(id);
        return toDto(entity);
    }
    
     private SubscriptionEntity fromDto(SubscriptionDto dto) {
        SubscriptionEntity e = new SubscriptionEntity();
        e.setStatus(dto.getStatus().name());
        e.setIdemplpoyee(DtoUtility.fromDto(dto.getEmployee()));
        e.setIdapprole(DtoUtility.fromDto(dto.getAppRole()));
        
        
        return e;
    }
    
    public SubscriptionDto create(SubscriptionDto dto) {
        SubscriptionEntity subs = fromDto(dto);
        SubscriptionEntity saved = subscriptionDbBean.create(subs);
        return toDto(saved);
    }

    public SubscriptionDto update(SubscriptionDto dto) throws DbException {
        SubscriptionEntity entity = subscriptionDbBean.findById(dto.getId());
        entity.setId(dto.getId());
        entity.setIdapprole(applicationRoleBean.findById(dto.getAppRole().getId()));
        entity.setIdemplpoyee(DtoUtility.fromDto(dto.getEmployee()));
        entity.setStatus(dto.getStatus().value());
        SubscriptionEntity updated = subscriptionDbBean.update(entity);
        return toDto(updated);
    }
    
    public void delete(int id) throws DbException {
        SubscriptionEntity entity = subscriptionDbBean.findById(id);
        subscriptionDbBean.delete(entity);
    }
}
