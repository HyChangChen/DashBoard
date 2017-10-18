package com.hxqh.eam.common.hxqh;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class AlgorithmUtils {

    private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
            'B', 'C', 'D', 'E', 'F' };

    public static String md5Hex(final String message) {
        return md5Hex(message.getBytes());
    }

    public static String md5Hex(final byte[] bytes) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(bytes);
            return encodeHex(digest.digest());
        } catch (final NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String encodeHex(final byte[] binaryData) {
        final int l = binaryData.length;
        final char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & binaryData[i]) >>> 4];
            out[j++] = DIGITS[0x0F & binaryData[i]];
        }
        return new String(out);
    }


}
