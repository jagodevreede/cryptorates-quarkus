package nl.openvalue.cryptorates;

import nl.openvalue.cryptorates.data.CryptoCurrency;
import nl.openvalue.cryptorates.data.CryptoCurrencyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("/")
public class CryptoCurrencyResource {

    @Inject
    CryptoCurrencyService service;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CryptoCurrency> hello() {
        return service.findAll();
    }

    @GET
    @Path("clear")
    public String clear() {
        service.clear();
        return "clear done";
    }

    @GET
    @Path("update")
    public String update() {
        service.update();;
        return "update done";
    }

    @GET
    @Path("symbol/{symbol}")
    public CryptoCurrency getSingle(@PathParam("symbol") String symbol) {
        return service.findSymbol(symbol);
    }
}