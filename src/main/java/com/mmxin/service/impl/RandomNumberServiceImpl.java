package com.mmxin.service.impl;


import com.mmxin.service.RandomNumberService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author : mmxin
 * @className : RedomNumberServiceImpl
 * @date : 2018/11/3 11:43
 */
@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    char[] number = {'1','2','3','4','5','6','7','8','9','0'};

    @Override
    public String redomNumber() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i=0; i< 6; i++){
            int index = random.nextInt(10);
            stringBuffer.append(number[index]);
        }
        return stringBuffer.toString();
    }
}
