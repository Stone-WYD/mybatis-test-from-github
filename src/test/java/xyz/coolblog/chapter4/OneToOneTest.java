package xyz.coolblog.chapter4;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import xyz.coolblog.chapter4.dao.ArticleDao;
import xyz.coolblog.chapter4.model.Article;
import xyz.coolblog.chapter4.model.Author;
import xyz.coolblog.util.CalculateTimeUtil;

/**
 * OneToOneTest
 *
 * @author Tian ZhongBo
 * @date 2018-08-13 10:06:11
 */
@Rollback(false)
public class OneToOneTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "chapter4/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testOne2One() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            Article article = articleDao.findOne(1);
            Author author = article.getAuthor();

            System.out.println("\narticles info:");
            System.out.println(article);

            System.out.println("\nauthor info:");
            System.out.println(author);
        } finally {
            session.close();
        }
    }

    @Test
    public void testOne2One2() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            Article article = articleDao.findOne(1);

            System.out.println("\narticles info:");
            System.out.println(article);

            System.out.println("\n延迟加载 author 字段：");

            Author author = article.getAuthor();
            System.out.println("\narticles info:");
            System.out.println(article);
            System.out.println("\nauthor info:");
            System.out.println(author);
        } finally {
            session.close();
        }
    }

    @Test
    public void calculateTimeConsuming1(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 记录程序开始时间
            long startTime = System.nanoTime();
            // 执行需要测量耗时的代码
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            Article article = articleDao.findOne(1);
            // 记录程序结束时间
            long endTime = System.nanoTime();
            // 计算程序耗时（以毫秒为单位）
            long duration = (endTime - startTime) / 1000000;
            System.out.println("=====================================");
            System.out.println("程序耗时：" + duration + " 毫秒");
        } finally {
            session.close();
        }
    }

    /**
    * @Description: 测试一级缓存
    * @Author: Stone
    * @Date: 2023/9/19
    */
    @Test
    public void testFirstLevelCache(){
        SqlSession session = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            // 统计第一次查询执行耗时
            CalculateTimeUtil.printCalculateTime(()->{
                Author author = articleDao.findAuthor(1);
                System.out.println("\nauthor info:");
                System.out.println(author);
            });
            // 统计第二次查询执行耗时
            CalculateTimeUtil.printCalculateTime(()->{
                Author author = articleDao.findAuthor(1);
                System.out.println("\nauthor info:");
                System.out.println(author);
            });
            // 用其他 SqlSession 执行一次更新操作
            ArticleDao articleDao1 = session2.getMapper(ArticleDao.class);
            articleDao1.updateAuthorName(1);
            CalculateTimeUtil.printCalculateTime(()->{
                Author author1 = articleDao1.findAuthor(1);
                System.out.println("\nauthor info:");
                System.out.println(author1);
            });
            // 统计第三次查询执行耗时
            CalculateTimeUtil.printCalculateTime(()->{
                Author author = articleDao.findAuthor(1);
                System.out.println("\nauthor info:");
                System.out.println(author);
            });
        } finally {
            session.close();
            session2.close();
        }
    }
}
