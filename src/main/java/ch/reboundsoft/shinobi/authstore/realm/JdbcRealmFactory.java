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
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rmaire
 */
@Singleton
public class JdbcRealmFactory implements ShinobiRealm {

    private static final transient Logger log = LoggerFactory.getLogger(JdbcRealmFactory.class);

    private final JdbcRealm realm;

    @Inject
    public JdbcRealmFactory(NinjaProperties ninjaProperties, RealmDataSource ds) {
        realm = new JdbcRealm();
        realm.setDataSource(ds.getDataSource());
        realm.setAuthenticationQuery(ninjaProperties.get("shinobi.db.authenticationQuery"));
        realm.setUserRolesQuery(ninjaProperties.get("shinobi.db.userRolesQuery"));
        realm.setPermissionsQuery(ninjaProperties.get("shinobi.db.permissionsQuery"));
        realm.setPermissionsLookupEnabled(true);
            PasswordMatcher pm = new PasswordMatcher();
            pm.setPasswordService(new DefaultPasswordService());
            realm.setCredentialsMatcher(pm);
    }

    @Override
    public JdbcRealm getRealm() {
        log.info("Shinobi jdbc realm created");
        return realm;
    }

}
