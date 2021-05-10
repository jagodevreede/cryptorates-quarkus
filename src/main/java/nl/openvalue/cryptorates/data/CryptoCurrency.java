package nl.openvalue.cryptorates.data;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class CryptoCurrency extends PanacheEntityBase {

    @Id
    public long id;
    public String name;
    public String symbol;
    public String slug;
    public Instant date_added;
    public Instant last_updated;
    public String cmc_rank;

}


