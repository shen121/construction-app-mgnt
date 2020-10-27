package com.demo.mgnt.config.util;

import java.util.Random;

public class UUIDUtil {


    public static Long getUUID(){

        long timeMillis = System.currentTimeMillis();
        int random = new Random().nextInt(999);

        String uuid=String.valueOf(timeMillis)+String.valueOf(random);
        return Long.valueOf(uuid);
    }
}
