package nl.openvalue.cryptorates.data;

import nl.openvalue.cryptorates.coinmarketcap.CoinMarketCapClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class CryptoCurrencyService {

    private final CoinMarketCapClient restClient;

    public CryptoCurrencyService(@RestClient CoinMarketCapClient restClient) {
        this.restClient = restClient;
    }

    public List<CryptoCurrency> findAll() {
        return CryptoCurrency.findAll().list();
    }

    public void update() {
        var listings = restClient.listingsLatest(1, 500, "EUR").data;
        clear();
        CryptoCurrency.persist(listings);
    }

    public void clear() {
        CryptoCurrency.deleteAll();
    }

    public CryptoCurrency findSymbol(String symbol) {
        return CryptoCurrency.find("symbol", symbol).firstResult();
    }

}
