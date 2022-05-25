import org.junit.jupiter.api.Test;
import thang.t2009m1.t2009m1java.util.ConnectionHelper;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {
    @Test
   public void test() {
       Connection connection = ConnectionHelper.getConnection();

   }
}