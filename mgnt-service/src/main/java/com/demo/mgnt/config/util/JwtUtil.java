package com.demo.mgnt.config.util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.demo.mgnt.api.userApi.reqDto.UserReqDto;
import com.demo.mgnt.api.userApi.respDto.UserRespDtp;
import com.demo.mgnt.config.exception.TokenAuthErrorException;
import com.demo.mgnt.dao.userDao.eo.UserEo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Milogenius
 * @create: 2019-07-08 10:24
 * @description:
 **/
public class JwtUtil {

    private Logger logger= LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 过期时间为一天
     * TODO 正式上线更换为15分钟
     */
    private static final long EXPIRE_TIME = 1*60*1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "tanshe";

    /**
     * 生成签名,30分钟后过期
     */
    public static <U>String sign(U u){
        System.out.println(!(u instanceof UserReqDto) || !(u instanceof UserRespDtp) || !(u instanceof UserEo));
        System.out.println(!(u instanceof UserReqDto) +"---"+ !(u instanceof UserRespDtp) +"---"+ !(u instanceof UserEo));
        if(!(u instanceof UserReqDto) || !(u instanceof UserRespDtp) || !(u instanceof UserEo)){
            return null;
        }
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create().withHeader(header).withClaim("user",JSON.toJSONString(u))
                .withExpiresAt(date).sign(algorithm);
    }


    public static void authToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(jwt.getClaim("user").asString());
        } catch (IllegalArgumentException e) {
            throw new TokenAuthErrorException(e.getMessage()+"--1");
        } catch (JWTVerificationException e) {
            throw new TokenAuthErrorException(e.getMessage()+"--2");
        }

    }

    public static Map<String,Object> getUserByToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);

        String user = jwt.getClaim("user").asString();
        return JSON.parseObject(user,HashMap.class);

    }
}