/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.reboundsoft.shinobi;

import ch.reboundsoft.shinobi.authstore.AuthStore;
import ch.reboundsoft.shinobi.authstore.DefaultAuthStoreImpl;
import ch.reboundsoft.shinobi.helpers.LifecycleCookieToken;
import ch.reboundsoft.shinobi.authstore.realm.IniRealmFactory;
import ch.reboundsoft.shinobi.authstore.realm.ShinobiRealm;
import ch.reboundsoft.shinobi.authstore.secman.ShinobiSecurityManager;
import ch.reboundsoft.shinobi.authstore.secman.ShinobiSecurityManagerImpl;
import com.google.inject.AbstractModule;

/**
 *
 * @author rmaire
 */
public class ShinobiIniModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthStore.class).to(DefaultAuthStoreImpl.class);
        bind(ShinobiRealm.class).to(IniRealmFactory.class);
        bind(ShinobiSecurityManager.class).to(ShinobiSecurityManagerImpl.class);
        bind(LifecycleCookieToken.class);
    }
}
