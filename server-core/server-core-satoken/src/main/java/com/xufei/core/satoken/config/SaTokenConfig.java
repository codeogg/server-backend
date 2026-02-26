package com.xufei.core.satoken.config;

import cn.dev33.satoken.dao.SaTokenDao;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import com.xufei.core.satoken.dao.PlusSaTokenDao;
import com.xufei.core.satoken.handler.SaTokenExceptionHandler;
import com.xufei.core.satoken.service.SaPermissionImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class SaTokenConfig {

    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }

    @Bean
    public StpInterface stpInterface() {
        return new SaPermissionImpl();
    }

    @Bean
    public SaTokenDao saTokenDao() {
        return new PlusSaTokenDao();
    }

    @Bean
    public SaTokenExceptionHandler saTokenExceptionHandler() {
        return new SaTokenExceptionHandler();
    }



}
