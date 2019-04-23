package eoms.cn.commons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import eoms.cn.commons.component.UidService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UidTEST {
    @Autowired
    private UidService uidService;
    
    @Test
    public void testUid() {
        for(int i = 0;i<100;i++) {
            long temp = uidService.genId();
            System.out.println("id servce" +temp);
            System.out.println("id servce" +uidService.explainId(temp).toString());
        }
    }
    
}
