/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.reboundsoft.shinobi.authstore;

import ch.reboundsoft.shinobi.authstore.secman.ShinobiSecurityManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.HashMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rmaire
 */
@Singleton
public class DefaultAuthStoreImpl implements AuthStore {

    private static final transient Logger log = LoggerFactory.getLogger(AuthStore.class);

    private final HashMap<String, Subject> subjects;
    
    @Inject
    public DefaultAuthStoreImpl(ShinobiSecurityManager securityManager) {
        
        this.subjects = new HashMap<>();
        SecurityUtils.setSecurityManager(securityManager.getSecurityManager());
    }

    @Override
    public synchronized boolean login(String name, String password) {

        log.info("Login using default auth store");

        Subject currentUser;

        if (subjects.containsKey(name)) {
            currentUser = subjects.get(name);
        } else {
            currentUser = SecurityUtils.getSubject();
            subjects.put(name, currentUser);
        }

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);

            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
                return false;
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                return false;
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  "
                        + "Please contact your administrator to unlock it.");
                return false;
            } catch (AuthenticationException ae) {
                log.info("Strange auth error: " + ae.toString());
                return false;
            }
        }

        return true;

    }

    @Override
    public synchronized boolean logout(String name) {
        subjects.get(name).logout();
        subjects.remove(name);
        return true;
    }

    @Override
    public synchronized boolean hasRole(String name, String role) {
        return subjects.get(name) != null && subjects.get(name).hasRole(role);
    }

    @Override
    public synchronized boolean isPermitted(String name, String permission) {
        return subjects.get(name) != null && subjects.get(name).isPermitted(permission);
    }

    @Override
    public boolean isAuthenticated(String name) {
        return subjects.get(name).isAuthenticated();
    }

}
