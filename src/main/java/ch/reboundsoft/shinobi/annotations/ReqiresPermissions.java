package ch.reboundsoft.shinobi.annotations;

/**
 *
 * @author rma
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface ReqiresPermissions {
    String[] value();
}
