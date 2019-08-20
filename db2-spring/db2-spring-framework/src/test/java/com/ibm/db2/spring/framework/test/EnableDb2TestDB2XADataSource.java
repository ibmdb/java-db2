/*
 * Copyright © 2018 IBM Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.ibm.db2.spring.framework.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import javax.sql.XADataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.db2.jcc.DB2XADataSource;
import com.ibm.db2.spring.framework.EnableDb2;


public class EnableDb2TestDB2XADataSource {

	
    private AnnotationConfigApplicationContext context;
    
    private static XADataSource mockXADataSource = mock(DB2XADataSource.class);
    
    @Before
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext();
    }

    @After
    public void cleanup() {
        if (this.context != null) {
            this.context.close();
        }
    }

    
    
    @EnableDb2
    @Configuration
    protected static class MockDb2XADataSourceConfig {
        @Bean
        public XADataSource getXADataSource() {
            return mockXADataSource;
        }
    }
    
    
    
    @Test
    public void xaDataSourceCreation() {
    	this.context.register(MockDb2XADataSourceConfig.class);
    	TestPropertyValues.of("db2.serverName=localhost", "db2.portNumber=50000")
        .and("db2.databaseName=SAMPLE").and("db2.user=db2admin").and("db2.password=abcd_abcd_01")
        .applyTo(this.context);    	
    	
    	this.context.refresh();
    	
    	DB2XADataSource xaDataSource = this.context.getBean(DB2XADataSource.class);
    	
        assertNotNull(xaDataSource);
    }
    

}
