package com.demo.mgnt.config.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig {
    // 页面标题
    private String title;
    // 描述
    private String description;
    // 版本号
    private String version;
    private String license;
    private String licenseUrl;

    @Bean
    public Docket swaggerDocket(){
        return new Docket(DocumentationType.SPRING_WEB)
                .apiInfo(apiInfo())
                .groupName("defaultName").select()
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .version(version)
                .description(description)
                .license(license)
                .licenseUrl(licenseUrl)
                .build();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }
}
