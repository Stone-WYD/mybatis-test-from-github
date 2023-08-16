package xyz.coolblog.chapter4;

import org.apache.ibatis.builder.ParameterExpression;
import org.junit.Test;

import java.util.Map;

/**
 * @program: mybatis-test-from-github
 * @description: ParameterExpression测试类
 * @author: Stone
 * @create: 2023-08-16 14:03
 **/
public class ParameterExpressionTest {

    @Test
    public void parameterExpressionTest(){
        String content = "age,javaType=int,jdbcType=NUMERIC,typeHandler=MyTypeHandler";
        ParameterExpression expression = new ParameterExpression(content);
        System.out.println("解析出的结果为：");
        for (Map.Entry<String, String> entry : expression.entrySet()) {
            System.out.println( "key: " + entry.getKey() + ", value: " + entry.getValue() );
        }
    }
}
