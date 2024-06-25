package dev.eyaz.exmpl.service.write.generator;

import dev.eyaz.exmpl.service.write.dto.request.OperationCreateRequest;
import dev.eyaz.exmpl.service.write.model.OperationEntity;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class LinkGenerator {

    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public LinkGenerator() {
    }

    public String generateLink(OperationCreateRequest request, OperationEntity entity) {

        return toBase62(getMD5Hash(request.getMessage()+entity.getCreated_at().toString())).substring(0, 10);
    }

    private BigInteger getMD5Hash(String input) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        byte[] messageDigest = md.digest(input.getBytes());

        return new BigInteger(1, messageDigest);
    }

    private String toBase62(BigInteger number) {
        StringBuilder base62 = new StringBuilder();

        while (number.compareTo(BigInteger.ZERO) > 0) {
            int mod = number.mod(BigInteger.valueOf(62)).intValue();
            base62.insert(0, BASE62.charAt(mod));
            number = number.divide(BigInteger.valueOf(62));
        }

        return base62.toString();
    }
}
