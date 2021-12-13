package com.lgd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
///swagger-ui.html
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("lgd-test1");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("lgd-test2");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("lgd-test3");
    }

    @Bean
    public Docket createRestApi(Environment environment) {
        //获取要显示的swagger的环境
        Profiles profiles=Profiles.of("dev","test");

        //获取当前项目环境是否为指定环境
        Boolean flag=environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //设置分组
                .groupName("lgd")
                //是否启用Swagger,false则不能浏览器访问
                .enable(flag)
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口

                //指定要扫描的包
                /*
                any() // 扫描所有，项目中的所有接口都会被扫描到
                none() // 不扫描接口
                // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                withMethodAnnotation(final Class<? extends Annotation> annotation)
                // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                withClassAnnotation(final Class<? extends Annotation> annotation)
                basePackage(final String basePackage) // 根据包路径扫描接口
                 */
                ////为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.lgd.controller"))
                .paths(PathSelectors.any())
                //过滤路径
//                .paths(PathSelectors.ant("/lgd/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("lgd","https://www.zust.edu.cn","2709296991@qq.com");
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("lgd学习swagger")
                .contact(contact)
                .termsOfServiceUrl("https://www.zust.edu.cn")
                .version("1.0")
                .build();
    }
}
