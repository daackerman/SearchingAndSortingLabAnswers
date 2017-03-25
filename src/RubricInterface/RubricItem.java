package RubricInterface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by daackerman on 3/22/2017.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface RubricItem {
    String category();
    String description();
    int value();
//    int order();
}
