在springBoot启动类加上注解@Import(DynamicDataSourceRegister.class)
@EnableTransactionManagement(order = 2,proxyTargetClass=true)


https://blog.csdn.net/qq_29597223/article/details/82119537