/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.reboundsoft.shinobi.authstore.realm;

import ch.reboundsoft.shinobi.authstore.ds.RealmDataSource;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ninja.utils.NinjaProperties;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rmaire
 */
@Singleton
public class IniRealmFactory implements ShinobiRealm {

    private static final transient Logger log = LoggerFactory.getLogger(IniRealmFactory.class);

    private final IniRealm realm;

    @Inject
    public IniRealmFactory(NinjaProperties ninjaProperties) {
        realm = new IniRealm("classpath:shiro.ini");
        
    }

    @Override
    public IniRealm getRealm() {
        log.info("Shinobi ini realm created");
        return realm;
    }

}
