/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tkv.formatter;

import com.tkv.pojo.Tourtypes;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Admin
 */
public class TourtypesFormatter implements Formatter<Tourtypes>{

    @Override
    public String print(Tourtypes t, Locale locale) {
        return String.valueOf(t.getTypeid());
    }

    @Override
    public Tourtypes parse(String tpId, Locale locale) throws ParseException {
        Tourtypes tp= new Tourtypes();
        tp.setTypeid(Integer.parseInt(tpId));
        
        return tp;
    }
    
}
