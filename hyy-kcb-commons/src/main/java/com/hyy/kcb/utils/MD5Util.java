package com.hyy.kcb.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {
	
	
	private static final String PUBLIC_KEY="https://www.fenmiaojinrong.com";
	
	/**
	 * 加密算法，加密密钥保存在配置文件中。
	 * 
	 * @param s
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
    public final static String MD5(String s) throws NoSuchAlgorithmException {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
    }
    
	/**
	 * 
	 * 随机盐值
	 * @return
	 */
	public static String randomSalt(){
		SecureRandomNumberGenerator randomNumberGenerator =  
			     new SecureRandomNumberGenerator();  
		
			randomNumberGenerator.setSeed(PUBLIC_KEY.getBytes());  
			String hex = randomNumberGenerator.nextBytes().toHex();  
			
			return hex;
	}
    
    
    /**
     * 加密
     * @param password
     * @param salt
     * @return
     */
	public static String[] generatePasswd(String password,String salt){
		
		String tmp_salt = randomSalt();
		
		SimpleHash hash = new SimpleHash("md5", password, salt + tmp_salt, 2);
		return new String[]{hash.toHex(),tmp_salt};
	}
	
	/**
	 * 解密
	 * @param salt
	 * @return
	 */
	public static String decipherPasswd(String password,String salt){
		
		SimpleHash hash = new SimpleHash("md5", password, salt, 2);
		
		return hash.toHex();
	}	
    
	
	public final static String getMD5(String pwd) {  
        //用于加密的字符  
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中  
            byte[] btInput = pwd.getBytes();  
               
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
               
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要  
            mdInst.update(btInput);  
               
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文  
            byte[] md = mdInst.digest();  
               
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {   //  i = 0  
                byte byte0 = md[i];  //95  
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5   
                str[k++] = md5String[byte0 & 0xf];   //   F  
            }  
               
            //返回经过加密后的字符串  
            return new String(str);  
               
        } catch (Exception e) {  
            return null;  
        }  
    }  
    
    /**
     * 测试代码，建议保留
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
//			System.out.println(MD5Util.MD5("20121221").equals("1F69B3D54C2F95A014EA3CC131A34D5B"));
//			System.out.println(MD5Util.MD5("加密"));
//
//			String tmp[] = generatePasswd("admin","admin");
//			System.out.println(tmp[0]+"----"+tmp[1]);
//
//			String s = "admin"+"f69f8b36c9307b652966351bad4422fe";
//

//			String pwd = decipherPasswd("123123","8ea1668dccf43917097faf9fcdd54a86");
//			System.out.println(pwd);
//			String ss = MD5("123456");
//			
//			System.out.println(ss.toLowerCase());
//        	String pwd[] = MD5Util.generatePasswd("123456", "admin");
//        	System.out.println(pwd[0]+"----"+pwd[1]);
        	
//        	Member [id=28, loginname=18101339953, password=3d1a0b7cccf66035a4a9620905ae8466, salt=8ea1668dccf43917097faf9fcdd54a86, realName=伦利, idCardNo=150429199004030919, mobile=18101339953, gender=1, birthDate=Tue Apr 03 00:00:00 CST 1990, province=150000, city=null, email=lun.li@163.com, memberLevel=1, openAcctStatus=1, openAcctDate=null, openAuthStatus=1, openAuthDate=null, lastLoginDate=null, lastLoginAddress=null, identStatus=0, emailStatus=0, mobileStatus=0, memberHead=http://118.26.165.217:8888/group1/M00/00/01/dhql2Vj_PNGAEviZAABdHiulGDg566.jpg, createDate=Fri Apr 21 13:33:28 CST 2017, createUser=1, updateUser=null, updateDate=null, memberInvestor=0, memberBorrower=0, invitationCode=c53v3MH1, invitationId=0, channelCode=0, status=null, promotionChannel=0, oldPwd=null, newPwd=null, newPwd1=null]
//        		ba7a25a647eb862658dd2e25e1dc581b -------- 123123  ------  18101339953
        	String[] pw = MD5Util.generatePasswd("贾鹏娟", "jpj123456");
        	String pw2 = MD5Util.decipherPasswd("123456", "18101339953"+"2f5e1eb4f7ebf0cba039fceb13e3cf95");
      		System.out.println(pw[0] + " ---- "+  pw[1]);
      		System.out.println(pw2);
      		
      		
//      		a0ecaeac6e396cb2f82786a7dfa08525 ---- 2f5e1eb4f7ebf0cba039fceb13e3cf95
//      		207e270a0fca217d1d3a6acf510106c4
      		
//      		a0ecaeac6e396cb2f82786a7dfa08525 ---- 2f5e1eb4f7ebf0cba039fceb13e3cf95
//      		207e270a0fca217d1d3a6acf510106c4
      		
//      	member.setPassword(pw[0]);
//    		member.setSalt(pw[1]);
//4118f449e95ef7a92ee3847736381919 ---- 2f5e1eb4f7ebf0cba039fceb13e3cf95
        	
//      		String s = MD5Util.decipherPasswd("admin", "13408678419"); //09e39cf393655c3e3dcc90b7382ea730
//      		String s2 = MD5Util.decipherPasswd("admin", "09e39cf393655c3e3dcc90b7382ea730"); 
//      		System.out.println(s);
//      		System.out.println(s2);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    
}
