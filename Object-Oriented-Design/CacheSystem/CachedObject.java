public class CachedObject implements Cacheable {
    private java.util.Date dateofExpiration = null;
    private Object identifier = null;

    public Object object = null;

    public CachedObject(Object obj, Object id, int minutesToLive) {
        this.object = obj;
        this.identifier = id;
        if (minutesToLive > 0) {
            dateofExpiration = new java.util.Date();
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(dateofExpiration);
            cal.add(cal.MINUTE, minutesToLive);
            dateofExpiration = cal.getTime();
        }
    }

    @Override
    public boolean isExpired() {
        if (dateofExpiration != null) {
            if (dateofExpiration.before(new java.util.Date())) {
                System.out.println("CachedResult is Expired!");
                return true;
            } else {
                System.out.println("CachedResult is not Expired");
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Object getIdentifier() {
        return identifier;
    }
}
