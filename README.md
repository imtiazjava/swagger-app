# swagger-app

3. 
   METHOD : GET
   URL    : http://localhost:1111/api/product/1001
   PURPOSE : To get the 1001 product details
   Client S/w : Postman





JPQL query
Native query


==========================================================================================

Validation for REST API:
--------------------------


========================================================================================
AOP
----
1. Cross-Cutting Concern:
-------------------------
Moving additional services of a project into other classes[Aspect class]  and inject or bind when ever we needed it.



I. Aspect:
----------
|-> Aspect is a class, that provide additional services to the project like tx, logging , security, etc...



class TxService{
	
	beginTx(){
    .....
	}

	commitTx(){
	  ...
	}
}


II. Advice:
----------
|-> It a method inside the Aspect class[Where actual implemenation of Aspect]
    beginTx(){
    .....
	}

	commitTx(){
	  ...
	}

	Types of Advices:
	-------------------
	I.  Before Advice : Executing advice before calling b.method()
	II. After Advice  : Executing advice after b.method finished.
	III. Around Advice
	IV. After returning Adice
	V. After Throwing Advice

III. Pointcut:
---------------
|-> It is an expression, it will select ref.method which need advices. It can never sepcify what advices.


IV. JoinPoint:
---------------
|-> It is a combination of Advices + Pointcut. It will simply connecting ref.methods
     with required advices.


 V. Target:
 -----------
 |-> It is a pure busniess class object.

 V. Proxy : This is final output(class/object) is called a proxy that contain
             both logic connected.



In order to work with  AOP we can use the following 2 approaches:

1. xml based configuration

2. annotation based using AspectJ
=========================================================================================
Swagger API Document:
----------------------
what is Swagger?
Ans:
Swagger2 is an open source project which is used to generate the REST API document
for RESTful web services.

|-> It provides a UI in order to access our RESTful web services application through
    the browser.

|-> In order to work with swagger api document we need to following steps:

Step1: Create the RESTful webservice application

Step2: Add also the following dependencies for enabling the swagger document:
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>3.0.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>3.0.0</version>
		</dependency>



Step3: We need to enable the swagger document application by using following annotation:
       @EnableSwagger2
       |-> This anntoation is define is inside the following package:
       import springfox.documentation.swagger2.annotations.EnableSwagger2;


Step4: Create the Docket bean object 

package com.itc.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ProductConfig {

	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.itc.main"))
				.paths(PathSelectors.any())//
				.build()
				.apiInfo(apiinfo());
	}

	private ApiInfo apiinfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("SPRINGBOOT-WITH-RESTAPI-SWAGGER", 
				"This is my first Swagger Application", 
				"Swagger 1.0v", 
				"http://localhost:1111/api/products", 
				new Contact("IMTIAZ","http://localhost:1111/api/products","IMTIAZ@GMAIL.COM"), 
				"Apache 2.0", 
				"https://www.apache.org");
	}
}

Step5: configure the pattern in properties file
spring.mvc.pathmatch.matching-strategy=ant-path-matcher

Step6: Perform the Unit Testing:
    |-> Open the browser and type the below url:
    
    1. http://localhost:1111/swagger-ui.html

    2.http://localhost:1111/v2/api-docs
