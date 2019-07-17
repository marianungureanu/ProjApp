package com.nttdata.practicadevara.projapp.front.subscription;

/**
 *
 * @author stefana.sireanu
 */
import com.nttdata.practicadevara.projapp.front.RestClient;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class SubscriptionRest extends RestClient {

    public List<SubscriptionDto> listSubscriptions() {
        Response resp = super.path("subscription").request(MediaType.APPLICATION_JSON).get(Response.class);
        return resp.readEntity(new GenericType<List<SubscriptionDto>>() {
        });
    }

    public SubscriptionDto update(SubscriptionDto entry) {
        Entity<SubscriptionDto> obj = Entity.entity(entry, MediaType.APPLICATION_JSON);
        Response resp = super.path("subscription").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).put(obj);
        return resp.readEntity(new GenericType<SubscriptionDto>() {
        });
    }

    public SubscriptionDto create(SubscriptionDto entry) {
        Entity<SubscriptionDto> obj = Entity.entity(entry, MediaType.APPLICATION_JSON);
        Response resp = super.path("subscription").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(obj);
        return resp.readEntity(new GenericType<SubscriptionDto>() {
        });
    }

    public void delete(SubscriptionDto entry) throws ClientErrorException {
        Response resp = super.path("subscription/"+entry.getId()).request(MediaType.APPLICATION_JSON).delete(Response.class);
        if(resp.getStatus() >= 300) {
            throw new ClientErrorException("Error deleting application "+entry.getId()+": "+resp.getStatusInfo(), resp);
        }
    }
}
