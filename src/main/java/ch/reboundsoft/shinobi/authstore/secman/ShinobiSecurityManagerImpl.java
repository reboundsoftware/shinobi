/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.reboundsoft.shinobi.authstore.secman;

import ch.reboundsoft.shinobi.authstore.realm.ShinobiRealm;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;

/**
 *
 * @author rmaire
 */
@Singleton
public class ShinobiSecurityManagerImpl implements ShinobiSecurityManager {

    private final SecurityManager securityManager;
    
    @Inject
    ShinobiSecurityManagerImpl(ShinobiRealm realm) {
        this.securityManager = new DefaultSecurityManager(realm.getRealm());
    }
    
    @Override
    public org.apache.shiro.mgt.SecurityManager getSecurityManager() {
        return securityManager;
    }
    
}
