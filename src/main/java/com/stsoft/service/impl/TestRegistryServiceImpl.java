package com.stsoft.service.impl;

import org.springframework.stereotype.Service;

import com.stsoft.service.TestRegistryService;

@Service("testRegistryService")
public class TestRegistryServiceImpl implements TestRegistryService
{
    public String hello(String name)
    {
        return "hello" + name;
    }
}