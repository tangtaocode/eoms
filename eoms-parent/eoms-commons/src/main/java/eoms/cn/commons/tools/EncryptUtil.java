package eoms.cn.commons.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public class EncryptUtil
{
  public static final String MD5="MD5";
  public static final String UTF8="UTF-8";
  
  /**
   *  采用加密算法加密字符串数据 转成长度为32的字符串
   * @param str
   * @param algorithm 采用的加密算法
   * @param charset 指定转化之后的字符串编码
   * @return
   */
  public static String EncryptionStr32(String str, String algorithm,String charset) {
      // 加密之后所得字节数组
      byte[] bytes = EncryptionStrBytes(str,algorithm,charset);
      return BytesConvertToHexString(bytes);
  }
  
  /**
   * 采用加密算法加密字符串数据  转成长度为32的字符串
   * @param str   需要加密的数据
   * @param algorithm 采用的加密算法
   * @return 字节数据
   */
  public static String EncryptionStr32(String str, String algorithm) {
      return EncryptionStr32(str,algorithm,"");
  }
  
  
  /**
   *  采用加密算法加密字符串数据  转成长度为16的字符串
   * @param str
   * @param algorithm 采用的加密算法
   * @param charset 指定转化之后的字符串编码
   * @return
   */
  public static String EncryptionStr16(String str, String algorithm,String charset) {
      return EncryptionStr32(str,algorithm,charset).substring(8,24);
  }
  
  /**
   * 采用加密算法加密字符串数据 转成长度为16的字符串
   * @param str   需要加密的数据
   * @param algorithm 采用的加密算法
   * @return 字节数据
   */
  public static String EncryptionStr16(String str, String algorithm) {
      return EncryptionStr32(str,algorithm,"").substring(8,24);
  }
  
  /**
   * 采用加密算法加密字符串数据
   * @param str   需要加密的数据
   * @param algorithm 采用的加密算法
   * @param charset 指定转化之后的字符串编码
   * @return 字节数据
   */
  public static byte[] EncryptionStrBytes(String str, String algorithm, String charset) {
      // 加密之后所得字节数组
      byte[] bytes = null;
      try {
          // 获取MD5算法实例 得到一个md5的消息摘要
          MessageDigest md = MessageDigest.getInstance(algorithm);
          //添加要进行计算摘要的信息
          if(null==charset||"".equals(charset)) {
              md.update(str.getBytes());
          }else{
              md.update(str.getBytes(charset));
          }
          //得到该摘要
          bytes = md.digest();
      } catch (NoSuchAlgorithmException e) {
          System.out.println("加密算法: "+ algorithm +" 不存在: ");
      } catch (UnsupportedEncodingException e) {
          System.out.println("数据加密指定的编码格式不支持: " + charset);
      }
      return null==bytes?null:bytes;
  }
  /**
   * 把字节数组转化成字符串返回
   * @param bytes
   * @return
   */
  public static String BytesConvertToHexString(byte [] bytes) {
      StringBuffer sb = new StringBuffer();
      for (byte aByte : bytes) {
          String s=Integer.toHexString(0xff & aByte);
          if(s.length()==1){
              sb.append("0"+s);
          }else{
              sb.append(s);
          }
      }
      return sb.toString();
  }

    public final static String MD5(String s) {
      char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
              'A', 'B', 'C', 'D', 'E', 'F' };
      try {
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
          }
          return new String(str);
      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
  public static String signRequest(Map<String, String> params,String secret,String rmkey) {
             // 从参数中移除签名本身
           if (params.containsKey(rmkey)) {
               params.remove(rmkey);
           }

           String[] keys = params.keySet().toArray(new String[0]);
           Arrays.sort(keys);

           StringBuilder query = new StringBuilder();
           query.append(secret);

           for (String key : keys) {
               Object value = params.get(key);
               if (!key.isEmpty() && value != null) {
                   query.append(key).append(value.toString());
               }
           }

           query.append(secret);
           String md5 = EncryptionStr32(query.toString(),MD5,UTF8);
           return md5.toUpperCase();
       }
	  public static String signRequest(Map<String, String> params,String rmkey) {
	      // 从参数中移除签名本身
	    if (params.containsKey(rmkey)) {
	        params.remove(rmkey);
	    }
	
	    String[] keys = params.keySet().toArray(new String[0]);
	    Arrays.sort(keys);
	
	    StringBuilder query = new StringBuilder();
	
	    for (String key : keys) {
	        Object value = params.get(key);
	        if (!key.isEmpty() && value != null) {
	            query.append(key).append(value.toString());
	        }
	    }

	    String md5 = EncryptionStr32(query.toString(),MD5,UTF8);
	    return md5.toUpperCase();
	}
	/**
	 * 生成 uuid， 即用来标识一笔单
	 * 
	 * @return
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}
}
