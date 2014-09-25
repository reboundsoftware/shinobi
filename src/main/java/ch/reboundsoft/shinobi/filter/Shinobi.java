/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.reboundsoft.shinobi.filter;

import ch.reboundsoft.shinobi.authstore.AuthStore;
import ch.reboundsoft.shinobi.annotations.Authenticated;
import ch.reboundsoft.shinobi.annotations.ReqiresPermissions;
import ch.reboundsoft.shinobi.annotations.ReqiresRoles;
import com.google.inject.Inject;
import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;
import ninja.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Shinobi implements Filter {

    private static final transient Logger log = LoggerFactory.getLogger(Shinobi.class);

    public final String USERNAME = "shiro-username";

    @Inject
    AuthStore subjects;

    @Override
    public Result filter(FilterChain chain, Context context) {

        Authenticated authRequested = 
                context.getRoute()
                .getControllerMethod()
                .getAnnotation(Authenticated.class);

        ReqiresPermissions permissionsRequested = 
                context.getRoute()
                .getControllerMethod()
                .getAnnotation(ReqiresPermissions.class);

        ReqiresRoles rolesRequested = 
                context.getRoute()
                .getControllerMethod()
                .getAnnotation(ReqiresRoles.class);

        boolean isAllowed = true;
        boolean mustAuthenticate = false;

        String name = context.getSession().get(USERNAME);
        

        if (authRequested != null) {
            log.info("Authentication requested");
            if (name == null) {
                mustAuthenticate = true;
            }
        }

        if (permissionsRequested != null) {
            String[] permissions = permissionsRequested.value();
            for (String permission : permissions) {
                log.info("Request for permission: " + permission);
                isAllowed = subjects.isPermitted(name, permission);
            }
        }

        if (rolesRequested != null) {
            log.info("Roles requested:");
            String[] roles = rolesRequested.value();
            for (String role : roles) {
                log.info("Request for role: " + role);
                isAllowed = subjects.hasRole(name, role);
            }
        }

        if (mustAuthenticate) {
            return Results.redirect("/login");
        } else if (!isAllowed) {
            return Results.forbidden().html().template("/views/system/403forbidden.ftl.html");
        }

        return chain.next(context);
    }
}
