package Controller;
import java.math.BigInteger;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

public class CriptografiaMD5 {
	
    public static String md5(String senha)throws NoSuchAlgorithmException{ 
        MessageDigest md = MessageDigest.getInstance("MD5");  
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
        String sen = hash.toString(16);              
        return sen;  
    } 
    public static void main(String agrs[]) throws Exception{
    	String senha = "123";
    	System.out.println(md5(senha));
    }
    
}
