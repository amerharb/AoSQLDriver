package aosqldriver;

/**
 *
 * @author Amer Harb
 */
import java.util.Calendar;
import javax.print.attribute.standard.DateTimeAtCompleted;
import org.neo4j.driver.v1.*;

public class AoSQLConnector {

    final private String neo4jUserName = "neo4j";
    final private String neo4jPassword = "asdasd";
    final private String neo4jServer = "bolt://localhost";

    Driver driver;
    Session session;

    public void connect() {
        driver = GraphDatabase.driver(neo4jServer, AuthTokens.basic(neo4jUserName, neo4jPassword));
        session = driver.session();

        session.run("CREATE (l:_ÅSQL:_ÅSQL_Log {log:'conncet', date:'" + System.currentTimeMillis() + "'})");

    }

    public String test() {
        String r = "";
        try {
            StatementResult result = session.run("MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title");
            while (result.hasNext()) {
                Record record = result.next();
                r += record.get("title").asString() + " " + record.get("name").asString();
            }
            System.out.println(r);

        } finally {
            return r + "/n last line";
        }
    }

    protected void finalize() {
        try {
            session.close();
            driver.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
