package com.ecommerce.coupon.configurations;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI ecommerceCouponApi() {
        return new OpenAPI()
                .info(new Info().title("Coupon API")
                        .description("E-Commerce Coupon service sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Coupon Api Documentation")
                        .url("https://github.com/salah-202/Coupon-Api-Spring-Boot"));
    }

}
