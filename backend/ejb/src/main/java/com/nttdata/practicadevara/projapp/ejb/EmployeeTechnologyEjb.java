/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.ejb;



import com.nttdata.practicadevara.projapp.db.EmployeetechnologyBean;
import com.nttdata.practicadevara.projapp.db.EmployeetechnologyEntity;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;



/**
 *
 * @author sebabstian.stoica
 */


@Stateless
@LocalBean
public class EmployeeTechnologyEjb {

    @EJB
    private EmployeetechnologyBean employeeTechnologyDbBean;
    
    public List<EmployeeTechnologyDto> findById(int id) {
        List<EmployeetechnologyEntity> entity = employeeTechnologyDbBean.findById(id);
        return toDtoEmployeeTechnologyList(entity);
    }

 
    public List<EmployeeTechnologyDto> listRequest(){
        List<EmployeetechnologyEntity> reqEntities =  employeeTechnologyDbBean.findAll();
       return toDtoEmployeeTechnologyList(reqEntities);
    }
    
    
  
    
  
    
}
