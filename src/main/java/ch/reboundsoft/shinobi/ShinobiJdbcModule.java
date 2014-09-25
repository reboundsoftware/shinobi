/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.reboundsoft.shinobi;

import ch.reboundsoft.shinobi.helpers.LifecycleCookieToken;
import ch.reboundsoft.shinobi.authstore.realm.ShinobiRealm;
import ch.reboundsoft.shinobi.authstore.realm.JdbcRealmFactory;
import ch.reboundsoft.shinobi.authstore.ds.PropertyDataSourceFactory;
import ch.reboundsoft.shinobi.authstore.ds.RealmDataSource;
import ch.reboundsoft.shinobi.authstore.AuthStore;
import ch.reboundsoft.shinobi.authstore.DefaultAuthStoreImpl;
import ch.reboundsoft.shinobi.authstore.secman.ShinobiSecurityManager;
import ch.reboundsoft.shinobi.authstore.secman.ShinobiSecurityManagerImpl;
import com.google.inject.AbstractModule;

/**
* Guice module for loading Shiro infrastructure in Ninja
*
* @author reboundsoft@gmail.com
*
*/

public class ShinobiJdbcModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AuthStore.class).to(DefaultAuthStoreImpl.class);
        bind(RealmDataSource.class).to(PropertyDataSourceFactory.class);
        bind(ShinobiRealm.class).to(JdbcRealmFactory.class);
        bind(ShinobiSecurityManager.class).to(ShinobiSecurityManagerImpl.class);
        bind(LifecycleCookieToken.class);
    }
}
