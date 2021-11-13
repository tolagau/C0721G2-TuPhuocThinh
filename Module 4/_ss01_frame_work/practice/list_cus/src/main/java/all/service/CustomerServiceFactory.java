package all.service;

import all.service.imp.SimpleCustomerServiceImpl;

public class CustomerServiceFactory {
    private static ICustomerService singleton;

    public static synchronized ICustomerService getInstance() {
        if (singleton == null) {
            singleton = new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}
