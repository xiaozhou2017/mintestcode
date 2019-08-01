package com.example.demo.service;

import com.example.demo.ExtraUtils.KeysArr;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;

@Service
public class DemoService  extends Comcalculate{
    //to-do calculate
    @Override
    public  ArrayList<String> doexcute(String orgindigitstr) {

        this.verifyinput(orgindigitstr);
        String[] digits=orgindigitstr.split(",");
        StringBuilder targetdigitsstr=new StringBuilder(); // target string
        for(String d: digits){
            int i=Integer.parseInt(d);
            if(KeysArr.keyboard.length>i){
                targetdigitsstr.append(d);
            }
        }
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder current = new StringBuilder();
        int index = 0;
        dohelper(index, targetdigitsstr, res, current, KeysArr.keyboard);
        return res;
    }

    private static void dohelper(int index, StringBuilder digits, ArrayList<String> res, StringBuilder current, String[] keyboard) {
        if (index == digits.length()) { // break this foreach
            res.add(current.toString());
            return;
        }
        int num = digits.charAt(index) - '0';//get ASSCI num
        for (int i = 0; i < keyboard[num].length(); i++) {
            current.append(keyboard[num].charAt(i));
            dohelper(index + 1, digits, res, current, keyboard); //recursive algorithm
            current.deleteCharAt(current.length() - 1);//ensure the next num  can calculated
        }
    }
    private void verifyinput(String digits){
        Assert.notNull(digits,"input can not be null");
    }


}
