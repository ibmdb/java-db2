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

package com.ibm.db2.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="db2")
public class Db2ConfigurationProperties {

	/** Db2 server name */
	private String serverName;
	
	/** Db2 port number */
	private String portNumber;
	
	/** Db2 user */
    private String user;

    /** Db2 password */
    private String password;

    /** Db2 database name */
    private String databaseName;
    
    /** Db2 traceFile name */
    private String traceFile; 
    /** Db2 traceFile Level */
    private String traceLevel;
    /** Db2 traceFile Option */
    private String traceOption;
    /** Db2 traceFile Size */
    private String traceFileSize;
    /** Db2 traceFile Count */
    private String traceFileCount;
    /** Db2 enableSysplexWLB */
    private String enableSysplexWLB;
   
    
    
	public String getEnableSysplexWLB() {
		return enableSysplexWLB;
	}

	public void setEnableSysplexWLB(String enableSysplexWLB) {
		this.enableSysplexWLB = enableSysplexWLB;
	}

	public String getTraceFile() {
		return traceFile;
	}

	public void setTraceFile(String traceFile) {
		this.traceFile = traceFile;
	}

	public String getTraceLevel() {
		return traceLevel;
	}

	public void setTraceLevel(String traceLevel) {
		this.traceLevel = traceLevel;
	}

	public String getTraceOption() {
		return traceOption;
	}

	public void setTraceOption(String traceOption) {
		this.traceOption = traceOption;
	}

	public String getTraceFileSize() {
		return traceFileSize;
	}

	public void setTraceFileSize(String traceFileSize) {
		this.traceFileSize = traceFileSize;
	}
	
    public String getTraceFileCount() {
		return traceFileCount;
	}

	public void setTraceFileCount(String traceFileCount) {
		this.traceFileCount = traceFileCount;
	}
	
	/** Db2 Jcc Global Property File to specify Db2 Jcc driver properties*/
    private String globalPropertyFile;
    
	
	public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return this.serverName;
    }
    
    
    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getPortNumber() {
        return this.portNumber;
    }

    
    public void setUser(String user) {
        this.user = user;
    }
    
    public String getUser() {
        return this.user;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }


	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}


	public String getGlobalPropertyFile() {
		return globalPropertyFile;
		
	}

	public void setGlobalPropertyFile(String globalPropertyFile) {
    	if(globalPropertyFile != null && !globalPropertyFile.trim().isEmpty()){
    		System.setProperty ("db2.jcc.propertiesFile", globalPropertyFile);
		}
		this.globalPropertyFile = globalPropertyFile;
	}
	
}



