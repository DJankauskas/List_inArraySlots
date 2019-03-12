/**
 * Test list features.
 */

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UserOfList {
    public static void main(String[] args) {

        try {

            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);

            unsafe.allocateMemory(2000000000L);

            while (true) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
