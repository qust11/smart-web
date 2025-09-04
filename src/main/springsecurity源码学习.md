

* SecurityBuilder 顶级父类 用于构建一个对象的 有个build方法 返回定义的泛型类对象
* WebSecurity  在实现performBuild方法时 会创建FilterChainProxy，是一个过滤器链
* HttpSecurity 在实现performBuild方法时 会创建DefaultSecurityFilterChain 是一个过滤器链


* SecurityConfigurer 配置类用于配置SecurityBuilder构建的对象
* AbstractConfiguredSecurityBuilder(继承自 AbstractSecurityBuilder,内部持有SecurityConfigurer集合) 定义了个doBuild模板方法 ，分别有beforeInit init beforeConfig config performBuild 由子类实现