将外置属性配置在application.properties文件中，在Bean中直接使用@Value注解

中文乱码：
传统方式是增加编码过滤器
@Bean
public Filter characterEncodingFilter() {
  CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
  characterEncodingFilter.setEncoding("UTF-8");
  characterEncdoingFilter.setForceEncoding(true);
  return characterEncodingFilter;
}

但是SpringBoot 默认是支持UTF-8编码格式的
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true

HttpEncodingAutoConfiguration：
@Bean
@ConditionalOnMissingBean(CharacterEncodingFilter.class)
public CharacterEncodingFilter characterEncodingFilter() {
  CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
  filter.setEncoding(this.properties.getCharset().name());
  filter.setForceRequestEncoding(this.properties.shouldForce(Type.REQUEST));
  filter.setForceResponseEncoding(this.properties.shouldForce(Type.RESPONSE));
  return filter;
}

默认情况下forceRequestEncoding、forceResponseEncoding是false的
故需要设置spring.http.encoding.force=true 或者分别设置spring.http.encoding.force-request=true、spring.http.encoding.force-response=true

但以上方式均无法解决application.properties属性文件中自定义属性值的中文乱码
因为SpringBoot properties文件的加载是通过PropertiesPropertySourceLoader类进行加载的
该类支持xml文件和properties文件，对xml文件是支持UTF-8的，对于properties文件将调用Java Properties类的load方法进行读取
而load方法默认的编码是ISO 8859-1，无法进行设置

若一定要在properties文件中使用中文，需要使用Unicode escapes字符集

还有一点说明，因为SpringBoot会自动加载配置很多环境下的资源文件
特别是此处若使用user.name，是极易和系统环境变量

demo-configuration-02讲述更优雅的解决自定义属性中文乱码方案