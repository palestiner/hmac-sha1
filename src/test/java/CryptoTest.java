import com.inmartech.crypto.Crypto;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CryptoTest {

    private final String SECRET = "secret";
    private final String BODY = "Some body";

    @Test
    @DisplayName("Проверка работы com.inmartech.crypto.Crypto.generateSignature")
    public void generateSignature() throws InvalidKeyException, NoSuchAlgorithmException {
        String actual = Crypto.generateSignature(BODY, SECRET);
        String expected = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, SECRET).hmacHex(BODY);
        assertEquals(expected, actual);
    }
}