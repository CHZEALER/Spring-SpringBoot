# Spring-SpringBoot

# Spring
# xml方式依赖注入
```
<!--setter方式注入 -->
<bean id="HelloworldService" class="cn.com.taiji.spring_framwork.service.HelloworldService">
		<property name="name" value="yangye"/>
</bean>
<!--构造器方式注入 -->
<bean id="HelloworldService" class="cn.com.taiji.spring_framwork.service.HelloworldService">
	<constructor-arg type="String" value="constructor"></constructor-arg>
</bean>
<!--注入两个自定义bean -->
<bean id="aotherBean" class="cn.com.taiji.spring_framwork.bean.anotherBean">
		<property name="name" value="aoherBean"></property>
</bean>
<bean id="otherBean" class="cn.com.taiji.spring_framwork.bean.otherBean">
		<property name="name" value="other"></property>
</bean>
<bean id="exampleBean" class="cn.com.taiji.spring_framwork.bean.exampleBean">
		<property name="anotherBean" ref="aotherBean"></property>
		<property name="otherBean" ref="otherBean"></property>
		<property name="i" value="333"></property>
</bean>
```

# 注解注入
```
//第一个bean
@Repository
public class FirstBean {
	@Value("FirstBean")
	private String name;
	public void say() {
		System.out.println("my name is "+ name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
//第二个bean
@Repository
public class SecondBean {
	@Value("SecondBean")
	private String name;
	public void say() {
		System.out.println("my name is " + name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
//被注入
@Repository
public class exampleBean2 {
	@Inject
	private FirstBean FirstBean;
	@Autowired
	private SecondBean SecondBean;
	@Value("999")
	private int i;
}
```
# java方式注入
```
@Configuration
@ComponentScan("cn.com.taiji.spring_framwork")//扫描的包
public class SampleConfig {
	//一个bean
	@Bean
	public anotherBean anotherBean() {
		anotherBean anotherBean = new anotherBean();
		anotherBean.setName("First");
		return anotherBean;
	}
	//另一个bean
	@Bean 
	public otherBean otherBean() {
		otherBean otherBean = new otherBean();
		otherBean.setName("Second");
		return otherBean;
	}
	//被注入的bean
	@Bean
	public exampleBean exampleBean() {
		exampleBean exampleBean = new exampleBean();
		exampleBean.setAnotherBean(anotherBean());
		exampleBean.setOtherBean(otherBean());
		exampleBean.setI(587);
		return exampleBean;		
	}
}
```
# SpringBoot
```
运行springboot项目
	ide运行
	mvn package打包后，在target目录下java -jar运行
	maven插件：mvn spring-boot:run

标准包结构
com
 +- example
 	+- myproject
		 +- Application.java
		 |
		 +- domain
		 | 	+- Customer.java
		 | 	+- CustomerRepository.java
		 |
		 +- service
		 | 	+- CustomerService.java
		 |
		 +- web
 			+- CustomerController.java

spring-boot-devtools 
		<!-- spring-boot-devtools 热部署 热启动 -->
		<!-- 项目开发过程中————不用频繁进行重启项目的工作 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional> <!-- 控制 -->
		</dependency>


Lombok插件
	在项目中使用Lombok可以减少很多重复代码的书写。比如说getter/setter/toString等方法的编写。
	@Data 注解在  类  上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
		（@Data集合了@ToString、@EqualsAndHashCode、@Getter/@Setter、@RequiredArgsConstructor）
	@NonNull 该注解用在  属性或构造器  上，Lombok会生成一个非空的声明，可用于校验参数，能帮助避免空指针。
	@Cleanup 该注解能帮助我们自动调用close()方法，很大的简化了代码。
	@NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor 无参构造器、部分参数构造器、全参构造器。Lombok没法实现多种参数构造器的重载。
	


外部配置文件加载顺序优先级
1–file:./config/                 jar包同级目录（target）下的config文件夹
2–file:./		    application .yml或application.properties直接放于同级目录下
3–classpath:/config/   
4–classpath:/
```
#SpringBootAdmin
```
  一种图形化的用于监控基于 Spring Boot 的应用
  Spring Boot Admin 是由服务端和客户端组成
  Spring Boot Admin 提供了很多功能，如显示 name、id 和 version，显示在线状态，Loggers 的日志级别管理，Threads 线程管理，Environment 管理等。
  ```
