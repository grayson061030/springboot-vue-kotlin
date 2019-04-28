package com.example.kboot

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer

@Configuration
class RestRepositoryConfigurator : RepositoryRestConfigurer {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?) {
        super.configureRepositoryRestConfiguration(config)
//        config.exposeIdsFor(Todo)
    }
}