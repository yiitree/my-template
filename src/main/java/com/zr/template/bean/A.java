package com.zr.template.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class A {

    private int a;
    private int b;

    public int get(int a){
        return a + 1;
    }

}
