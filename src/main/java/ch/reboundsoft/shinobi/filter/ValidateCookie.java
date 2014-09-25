package ch.reboundsoft.shinobi.filter;

import ch.reboundsoft.shinobi.helpers.LifecycleCookieToken;
import com.google.inject.Inject;
import ninja.Context;
import ninja.Filter;
import ninja.FilterChain;
import ninja.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateCookie implements Filter {

    private static final transient Logger log = LoggerFactory.getLogger(ValidateCookie.class);

    LifecycleCookieToken validator;

    @Inject
    public ValidateCookie(LifecycleCookieToken validator) {
        this.validator = validator;
    }
    
    

    @Override
    public Result filter(FilterChain chain, Context context) {
        
        String cookieID = context.getSession().get("validation-id");
        String cycleID = Integer.toString(validator.id);
        
        if (cookieID == null) {

            log.info("No validation id, setting new...");

            context.getSession().put("validation-id", cycleID);

        } else if (!cookieID.equals( cycleID )){
            log.info("Validation id does not match. Cookie value: "+cookieID+", Server value: "+cycleID+". Clearing session");
            context.getSession().clear();
            context.getSession().put("validation-id", cycleID);
        } else {
            log.info("Validation ID matches. Value: "+cycleID);
        }

        return chain.next(context);
    }
}
