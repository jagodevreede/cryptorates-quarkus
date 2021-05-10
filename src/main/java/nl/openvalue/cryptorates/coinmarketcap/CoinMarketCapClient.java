package nl.openvalue.cryptorates.coinmarketcap;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@RegisterClientHeaders(CoinMarketCapHeaderFactory.class)
@RegisterRestClient(configKey = "coinmarketcap.api")
public interface CoinMarketCapClient {
    @GET
    @Path("listings/latest")
    CoinMarketCapResponse listingsLatest(@QueryParam("start") int start, @QueryParam("limit") int limit, @QueryParam("convert") String convert);
}
