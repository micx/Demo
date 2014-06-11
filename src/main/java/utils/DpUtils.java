package utils;

import config.Config;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by chenxi.chen on 2014/06/11/上午9:34.
 */
public class DpUtils {
    private static String md5Key = Config.md5Key;
    /**
     * 生成MD5验签名
     * @param xml
     * @return
     */
    public static String buildMD5Sign(String xml){
        String content = "xml="+ xml + md5Key;
        String encryText;
        try {
            encryText = MD5Encrypt(content, "utf-8");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }catch(UnsupportedEncodingException e){
            return null;
        }
        return encryText;
    }
    private static String MD5Encrypt(String plainText, String encode) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String encText = StringUtils.EMPTY;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plainText.getBytes(encode));
        byte b[] = md.digest();
        StringBuilder buf = new StringBuilder();
        for (int offset = 0; offset < b.length; offset++) {
            int i = b[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        encText = buf.toString();
        return encText;
    }
}
