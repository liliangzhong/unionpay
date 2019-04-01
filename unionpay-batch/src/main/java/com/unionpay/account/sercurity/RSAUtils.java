package com.unionpay.account.sercurity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.druid.util.StringUtils;
import com.unionpay.account.utils.StreamUtil;

/**
 * 
 * <p>Title: RSAUtils</p>
 * <p>Description: </p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2018年3月13日 上午10:20:33
 * @version 1.0
 *
 */
public class RSAUtils
{
	private static Logger log = LoggerFactory.getLogger(RSAUtils.class);
	
	//RSA签名
	public static String rsaSign(String content, String privateKey, String charset)
	{
		String sign = null;
		try
		{
			PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));

			Signature signature = Signature.getInstance("SHA1WithRSA");

			signature.initSign(priKey);

			if (StringUtils.isEmpty(charset))
				signature.update(content.getBytes());
			else
			{
				signature.update(content.getBytes(charset));
			}

			byte[] signed = signature.sign();
            sign = new String(Base64Method.EncryptBase64(signed));
		}
		catch(Exception e)
		{
			log.error("RSA私钥格式不正确，请检查是否正确配置了PKCS8格式的私钥", e);
		}
		return sign;
	}
	
	//私钥处理
	public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception
	{
		if ((ins == null) || (StringUtils.isEmpty(algorithm)))
		{
			return null;
		}

		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

		byte[] encodedKey = StreamUtil.readText(ins).getBytes();

		encodedKey = Base64.decodeBase64(encodedKey);

		return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
	}
	
	//RSA验签
	public static boolean rsaCheckContent(String content, String sign, String publicKey, String charset)
	{
		boolean result = false;
		try
		{
			PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));

			Signature signature = Signature.getInstance("SHA1WithRSA");

			signature.initVerify(pubKey);

			if (StringUtils.isEmpty(charset))
				signature.update(content.getBytes());
			else
			{
				signature.update(content.getBytes(charset));
			}
			result = signature.verify(Base64.decodeBase64(sign.getBytes()));
		} 
		catch (Exception e)
		{
			log.error("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, e);
			return false;
		}
		return result;
	}
	
	//公钥处理
	public static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception
	{
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

		StringWriter writer = new StringWriter();
		StreamUtil.io(new InputStreamReader(ins), writer);

		byte[] encodedKey = writer.toString().getBytes();

		encodedKey = Base64.decodeBase64(encodedKey);

		return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
	}
	
	public static String rsaEncrypt(String content, String publicKey, String charset)
	{
		String result = null;
		ByteArrayOutputStream out = null;
		try
		{
			PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));
			Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);

			byte[] data = StringUtils.isEmpty(charset) ? content.getBytes() : content.getBytes(charset);

			int inputLen = data.length;
			out = new ByteArrayOutputStream();
			int offSet = 0;

			int i = 0;

			while (inputLen - offSet > 0)
			{
				byte[] cache;
				if (inputLen - offSet > 117)
					cache = cipher.doFinal(data, offSet, 117);
				else
				{
					cache = cipher.doFinal(data, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * 117;
			}
			byte[] encryptedData = Base64.encodeBase64(out.toByteArray());
            result = StringUtils.isEmpty(charset) ? new String(encryptedData) : new String(encryptedData, charset);
		} 
		catch (Exception e)
		{
			log.error("EncryptContent = " + content + ",charset = " + charset, e);
		}
		finally
		{
			if(out != null)
				try
				{
					out.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

	public static String rsaDecrypt(String content, String privateKey, String charset)
	{
		String result = null;
		ByteArrayOutputStream out = null;
		try
		{
			PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));
			Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, priKey);
			byte[] encryptedData = StringUtils.isEmpty(charset) ? Base64.decodeBase64(content.getBytes())
					: Base64.decodeBase64(content.getBytes(charset));

			int inputLen = encryptedData.length;
			out = new ByteArrayOutputStream();
			int offSet = 0;
			int i = 0;
			while (inputLen - offSet > 0)
			{
				byte[] cache;
				if (inputLen - offSet > 128)
					cache = cipher.doFinal(encryptedData, offSet, 128);
				else
				{
					cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * 128;
			}
			byte[] decryptedData = out.toByteArray();
			out.close();
            result = StringUtils.isEmpty(charset) ? new String(decryptedData) : new String(decryptedData, charset);
		}
		catch (Exception e)
		{
			log.error("EncodeContent = " + content + ",charset = " + charset, e);
		}
		finally
		{
			if(out != null)
				try
				{
					out.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

	public static String rsa256Sign(String content, String privateKey, String charset)
	{
		String rsaSign = null;
		try
		{
			PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));

			Signature signature = Signature.getInstance("SHA256WithRSA");

			signature.initSign(priKey);

			if (StringUtils.isEmpty(charset))
				signature.update(content.getBytes());
			else
			{
				signature.update(content.getBytes(charset));
			}

			byte[] signed = signature.sign();
			rsaSign = new String(Base64.encodeBase64(signed));
		} 
		catch (Exception e)
		{
			log.error("RSAcontent = " + content + "; charset = " + charset, e);
			return null;
		}
		return rsaSign;
	}
	
	public static boolean rsa256CheckContent(String content, String sign, String publicKey, String charset)
	{
		boolean results = false;
		try
		{
			PublicKey pubKey = getPublicKeyFromX509("RSA", new ByteArrayInputStream(publicKey.getBytes()));

			Signature signature = Signature.getInstance("SHA256WithRSA");

			signature.initVerify(pubKey);

			if (StringUtils.isEmpty(charset))
				signature.update(content.getBytes());
			else
			{
				signature.update(content.getBytes(charset));
			}
			results = signature.verify(Base64.decodeBase64(sign.getBytes()));
		}
		catch (Exception e)
		{
			log.error("RSAcontent = " + content + ",sign=" + sign + ",charset = " + charset, e);
			return false;
		}
		return results;
	}
}
