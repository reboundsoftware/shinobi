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
            log.error(ex.toString());
        }

        ds = new BoneCPDataSource();
        ds.setJdbcUrl(ninjaProperties.get("shinobi.db.url"));
        ds.setUsername(ninjaProperties.get("shinobi.db.name"));
        ds.setPassword(ninjaProperties.get("shinobi.db.password"));
    }

    @Override
    public DataSource getDataSource() {
        log.info("Shinobi DataSource created");
        return ds;
    }
}
