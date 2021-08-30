package commands;



import com.mysql.cj.Session;
import connection.Connector;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class GetAccountAction {

    Logger logger = Logger.getRootLogger();

    Connector connector = new Connector();
    ArrayList<String> accountData = new ArrayList<>();


    public ArrayList<String> getAccountData(String login){

        logger.info("getAcc: account extraction initiated. Send to DB: " + login);

        accountData = connector.idFromLoginQuery(login);

        logger.info("getAcc: account extracted with parameters: ");
        for (String one:accountData) {
            logger.info(one);

        }

        return accountData;
    }
}
