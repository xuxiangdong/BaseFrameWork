package com.stsoft.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class TestActiviti
{
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    
    @Test
    public void createTable()
    {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/xxd2?useUnicode=true&characterEncoding=utf-8");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("root");
        
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        System.out.println("流程引擎是:" + processEngine);
    }
    
    @Test
    public void deploymentProcessDefinition()
    {
        Deployment deployment = processEngine.getRepositoryService().createDeployment().addClasspathResource("diagrams/helloword.bpmn").addClasspathResource("diagrams/helloword.png").deploy();
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
        
    }
    
    @Test
    public void startProcessInstance()
    {
        String processDefinitionKey = "helloword";
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey);
        System.out.println("流程实例ID：" + processInstance.getId());
        System.out.println("流程定义ID：" + processInstance.getProcessDefinitionId());
    }
}
