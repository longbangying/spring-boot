package com.xbang.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MybatisPlusCodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //设置输出路径
        globalConfig.setOutputDir(projectPath + "/spring-mybatis/src/main/java").setAuthor("xbang").setOpen(false);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setActiveRecord(true);
        autoGenerator.setGlobalConfig(globalConfig);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL).setDriverName("com.mysql.jdbc.Driver").setUsername("root")
                .setPassword("Soar18786611964").setUrl("jdbc:mysql://47.104.171.254:3306/number_db?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull&useSSL=false");
        autoGenerator.setDataSource(dataSourceConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.xbang.mybatis");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");
        packageConfig.setService("number.service");
        packageConfig.setServiceImpl("number.service.impl");
        packageConfig.setController("controller");
        packageConfig.setXml("xml");
        autoGenerator.setPackageInfo(packageConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(false);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);

        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        //需要生成的表名
        strategyConfig.setInclude("t_channel_info");

        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();

    }
}
