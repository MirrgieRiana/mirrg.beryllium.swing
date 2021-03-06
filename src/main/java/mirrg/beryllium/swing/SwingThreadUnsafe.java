package mirrg.beryllium.swing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * このメソッドはAWTイベントディスパッチャースレッドから呼び出す必要があります。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface SwingThreadUnsafe
{

}
