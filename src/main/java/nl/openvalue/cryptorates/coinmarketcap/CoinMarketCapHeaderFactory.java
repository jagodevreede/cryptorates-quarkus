package nl.openvalue.cryptorates.coinmarketcap;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MultivaluedMap;

@ApplicationScoped
public class CoinMarketCapHeaderFactory implements ClientHeadersFactory {
    private static final String HEADER_API_KEY = "X-CMC_PRO_API_KEY";

    @ConfigProperty(name = "coinmarketcap.api.key")
    String apiKey;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> multivaluedMap, MultivaluedMap<String, String> multivaluedMap1) {
        var result = new MultivaluedMapImpl<String, String>();
        result.add(HEADER_API_KEY, apiKey);
        return result;
    }
}
