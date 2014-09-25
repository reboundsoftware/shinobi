package ch.reboundsoft.shinobi.helpers;

import com.google.inject.Singleton;
import java.util.Random;

/**
 *
 * @author rma
 */
@Singleton
public class LifecycleCookieToken {

    public static int id;

    public LifecycleCookieToken() {
        Random rng = new Random(System.currentTimeMillis());
        id = rng.nextInt();
    }

}
