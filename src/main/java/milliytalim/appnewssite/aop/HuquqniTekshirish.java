package milliytalim.appnewssite.aop;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HuquqniTekshirish {
    String huquq();
}
