package nl.openvalue.cryptorates.data;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.SystemException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class CryptoCurrencyServiceTest {

    @Inject
    CryptoCurrencyService service;

    @Test
    void clearThenFindAllWithNothing() throws SystemException {
        service.clear();
        assertEquals(0, service.findAll().size());
    }

    @Test
    void findAfterUpdate() throws SystemException {
        service.update();
        assertEquals(500, service.findAll().size());
    }

}