/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amer Harb
 */
import java.util.Calendar;
import javax.print.attribute.standard.DateTimeAtCompleted;
import org.neo4j.driver.v1.*;
import sun.awt.AWTAccessor;

public class AoSQLConnector {

    Driver driver;
    Session session;

    public AoSQLConnector() {
        try {
            driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "asdasd"));
            session = driver.session();

            session.run("CREATE (l:_ÅSQL:_ÅSQL_Log {log:'conncet', date:'" + System.currentTimeMillis() + "'})");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String test() {
        StatementResult result = session.run("MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title");
        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record.get("title").asString() + " " + record.get("name").asString());
        }
        return "any thing";
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
