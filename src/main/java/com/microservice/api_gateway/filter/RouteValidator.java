package com.microservice.api_gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> endpoints = List.of("/user/register", "/user/login","/eureka");

    public Predicate<ServerHttpRequest> isSecured =
            request -> endpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
