package com.hyy.kcb.utils;


import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


/**
 * 
 */
public final class RSAUtils{

	public static final String KEY_ALGORITHM = "RSA";
	private static final int MAX_ENCRYPT_BLOCK = 117;
	private static final int MAX_DECRYPT_BLOCK = 128;

	public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
		byte[] keyBytes = Base64Utils.decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}
	
	public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey)
			throws Exception {
		byte[] keyBytes = Base64Utils.decode(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;
	}

	public static final String readTextFile(File file) {
		try {
			
			FileReader fr = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();

			String temp = "";// 用于临时保存每次读取的内容
			temp = br.readLine();
			while ((temp = br.readLine()) != null) {
				if (temp.charAt(0) == '-') {
					continue;
				}
				sb.append(temp);
			}
			return sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	


}