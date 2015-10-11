import java.util.*;

public class CacheManager {
    private static HashMap cashedHashMap = new HashMap();
    static {
        try {
            Thread threadCleanerUpper = new Thread(new Runnable() {
                static int milliSecindSleepTime = 5000;
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println("threadCleanerUpper Scanning for Expired Objects");
                            Set keySet = cachedHashMap.keySet();
                            Iterator keys = keySet.iterator();
                            while (keys.hasNext()) {
                                Object key = heys.next();
                                Cacheable value = (Cacheable)cachedHashMap.get(key);
                                if (value.isExpired()) {
                                    cashedHashMap.remove(key);
                                }
                            }
                            Thread.sleep(this.milliSecindSleepTime);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            threadCleanerUpper.setPriority(Thread.MIN_PRIORITY);
            threadCleanerUpper.start();
        }
        public CacheManager() {

        }
        public static void putCache(Cacheable object) {
            cashedHashMap.put(object.getIdentifier(), object);
        }
        public static Cacheable getCache(object identifier) {
            Cacheable object = (Cacheable)cashedHashMap.get(identifier);
            if (object == null) {
                return null;
            }
            if (object.isExpired()) {
                cashedHashMap.remove(identifier);
                return null;
            }
            return object;
        }
    }
}
