package org.example.BabstractDactoryPattern;

/**
 * @author: HammerRay
 * @description: 产品等级: 小米手机 华为手机
 * 产品族: 手机路由器
 * @date: 6/17/2024 11:40 PM
 */
public interface ProductFactory {
    public PhoneProduct createPhoneProduct(String brand);

    public RouterProduct createRouterProduct(String brand);
}
