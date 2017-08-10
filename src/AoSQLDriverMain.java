import aosqldriver.AoSQLConnector;
/**
 *
 * @author amharb
 */
public class AoSQLDriverMain {

    public static void main(String[] args) throws Exception {
        AoSQLConnector conn = new AoSQLConnector();
        conn.connect();
        System.out.println(conn.toString());
        System.out.println(conn.test());
        System.out.println("after test");
    }

}
