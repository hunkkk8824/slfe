package com.selfwork.intelligence.common;


import com.selfwork.intelligence.model.po.UserInfoPO;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 密码加密helper
 */
@Component
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();


    private String algorithmName = "md5";

    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(UserInfoPO user) {

        user.setPasswordsalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getPasswordsalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
    
    public boolean comparePassword(String password,String salt,String encryptPassword) {
    	if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(salt) && !StringUtils.isEmpty(encryptPassword)) {
	    	String newPassword = new SimpleHash(
	                algorithmName,
	                password,
	                ByteSource.Util.bytes(salt),
	                hashIterations).toHex();
	    	if (newPassword.equals(encryptPassword)) {
	    		return true;
	    	}
    	}
    	return false;
    }
    
    
//    @Test
//    public void testPassword(){
//        PasswordHelper passwordHelper = new PasswordHelper();
//        UserInfoPO userInfoPO =  new UserInfoPO();
//        userInfoPO.setPassword("1qaz2wsx");
//        passwordHelper.encryptPassword(userInfoPO);
//        System.out.print(userInfoPO);
//    }
}
