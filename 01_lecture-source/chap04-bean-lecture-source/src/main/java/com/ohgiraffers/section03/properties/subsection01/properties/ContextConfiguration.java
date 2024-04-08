package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Date;

@Configuration
/* resources 폴더 하위에 기술한 파일을 읽어오는 annotation */
@PropertySource("section03/properties/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    /* 필기.
    *   @Value
    *   ${} : 치환자(placeholder) 문법을 이용하여 properties 에 저장된
    *         key를 입력하면 value 에 해당하는 값을 꺼내올 수 있다.
    *  */

    @Value("${bread.carpbread.name}")
    private String carpBreadName;
    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;

    @Bean
    public Product carpBread() {

        return new Bread(carpBreadName, carpBreadPrice, new Date());
    }

}
