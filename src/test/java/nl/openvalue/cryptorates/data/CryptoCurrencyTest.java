package nl.openvalue.cryptorates.data;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@QuarkusTest
public class CryptoCurrencyTest {

    @Test
    void doTest() {
        var crypto = new CryptoCurrency();
        assertFalse(crypto.isPersistent());
        crypto.name = "crypto1-name";
        crypto.slug = "crypto1-slug";
        crypto.symbol ="crypto1-symbol";
        crypto.persist();

        assertTrue(crypto.isPersistent());
    }

}
