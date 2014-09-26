package ch.reboundsoft.shinobi.authstore.ds;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jolbox.bonecp.BoneCPDataSource;
import javax.sql.DataSource;
import ninja.utils.NinjaProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rma
 */
@Singleton
public class PropertyDataSourceFactory implements RealmDataSource {

    private static final transient Logger log = LoggerFactory.getLogger(PropertyDataSourceFactory.class);


    private final BoneCPDataSource ds;
    
    @Inject
    PropertyDataSourceFactory(NinjaProperties ninjaProperties){
        
        try {
            Class.forName(ninjaProperties.get("shinobi.db.driver"));
        } catch (ClassNotFoundException ex) {
            log.error("Driver not found: "+ ninjaProperties.get("shinobi.db.driver"));
            log.error(ex.toString());
        }

        ds = new BoneCPDataSource();
        ds.setJdbcUrl(ninjaProperties.get("db.connection.url"));
        ds.setUsername(ninjaProperties.get("db.connection.username"));
        ds.setPassword(ninjaProperties.get("db.connection.password"));
    }

    @Override
    public DataSource getDataSource() {
        log.info("Shinobi DataSource created");
        return ds;
    }
}
