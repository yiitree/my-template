package com.zr.template.domain.dozer;


import lombok.Data;

@Data
public class AddressVo {
    // 省
    private String province;
    // 市
    private String city;
    // 区
    private String district;
    // 详细
    private String detail;
    // 详细
    private String detailAddr;
}
