package TTT;

import com.baizhi.cmfv.bean.Manager;
import com.baizhi.cmfv.bean.Menu;
import com.baizhi.cmfv.dao.ManagerMapper;
import com.baizhi.cmfv.dao.MenuMapper;
import com.baizhi.cmfv.service.ManagerService;
import com.baizhi.cmfv.util.Md5Token;
import com.baizhi.cmfv.util.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName CmfvTest
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/4 16:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class CmfvTest {

    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private ManagerService managerService;


}
