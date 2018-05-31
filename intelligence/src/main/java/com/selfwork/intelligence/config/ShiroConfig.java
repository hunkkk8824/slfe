package com.selfwork.intelligence.config;

import com.selfwork.intelligence.shiro.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * <p>
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/lo/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/errorpage/403.html");

        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/lo/**", "anon");
        filterChainDefinitionMap.put("/index", "anon");

        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/lo/logout", "logout");

        //配置权限和角色控制

        //门户
        filterChainDefinitionMap.put("/portal/add", "roles[admin]");

        //后台
        //filterChainDefinitionMap.put("/manageindex/**", "roles[admin]");

        //其他
        filterChainDefinitionMap.put("/user/**", "roles[admin]");
        filterChainDefinitionMap.put("/role/**", "roles[admin]");
        filterChainDefinitionMap.put("/resource/**", "roles[admin]");


        //数据质量管理
        filterChainDefinitionMap.put("/dataQuality/audit", "roles[admin]");
        filterChainDefinitionMap.put("/dataQuality/evaluateQuality", "roles[admin]");
        filterChainDefinitionMap.put("/dataQuality/cancelResource", "roles[admin]");


        //交换配置
        filterChainDefinitionMap.put("/exchangeConfig/save", "roles[admin]");
        filterChainDefinitionMap.put("/exchangeConfig/edit", "roles[admin]");
        filterChainDefinitionMap.put("/exchangeConfig/saveExchangeEtl", "roles[admin]");
        filterChainDefinitionMap.put("/exchangeConfig/editExchangeEtl", "roles[admin]");


//        filterChainDefinitionMap.put("/update", "roles[kljk]，perms[yyy]");




        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myShiroRealm());
        securityManager.setSessionManager(getSessionManager());
        return securityManager;
    }

    @Bean
    public SessionManager getSessionManager() {
        DefaultWebSessionManager ss = new DefaultWebSessionManager();
        ss.setGlobalSessionTimeout(1800000L);// session的失效时长，单位毫秒 30分钟
        ss.setDeleteInvalidSessions(true);//   删除失效的session
        return ss;
    }

    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     *
     * @return
     */
    @Bean
    public ShiroRealm myShiroRealm() {
        ShiroRealm myShiroRealm = new ShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }


    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));

        return hashedCredentialsMatcher;
    }
}
