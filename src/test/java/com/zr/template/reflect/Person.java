package com.zr.template.reflect;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends F implements I{
    private String name;
    private Integer age;
    public String address;
    protected String protectedField;
    String defaultField;
}

class F{

}

interface I{

}