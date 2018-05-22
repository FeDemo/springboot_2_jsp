# springboot_2_jsp
springboot对jsp的支持 demo

## pom.xml  
>添加maven配置   

```xml
    <!--spring boot tomcat jsp 引入-->
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    
    <!--servlet 引入-->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
    </dependency>
    
    <!--jstl 引入-->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
```
## application.properties
>src/main/resources/application.properties  
>配置视图  

```properties
spring.mvc.view.prefix=/jsp/
spring.mvc.view.suffix=.jsp
```

## index.jsp   
>jsp页面代码

```jsp
<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
</head>

<body>
    hello ${name} <br>
</body>
</html>

```

## @Controller  
>控制层代码

```java
@Controller
public class index {

    @RequestMapping("/{name}")
    String index(@PathVariable("name") String name, Model model){
        model.addAttribute("name", name);
	    return "index";
    }

}
```

## 效果 
>页面 

![](https://raw.githubusercontent.com/FeDemo/springboot_2_jsp/master/imgs/1.png)

## 在@Controller中返回json
>@ResponseBody声明返回的是json对象
```java
@Controller
public class json {
    @RequestMapping("/json")
    @ResponseBody
    public Map json(){
        Map m=new HashMap();
        m.put("index1","str1");
        m.put("index2","str2");
        m.put("index3","str3");
        return m;
    }
}
```
