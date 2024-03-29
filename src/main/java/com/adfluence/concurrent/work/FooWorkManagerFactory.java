package com.adfluence.concurrent.work;

import de.myfoo.commonj.util.AbstractFactory;
import de.myfoo.commonj.util.ThreadPool;

import javax.naming.*;
import java.util.Enumeration;
import java.util.Hashtable;


/**
 * Factory class for <code>WorkManager</code>s.
 */
public final class FooWorkManagerFactory extends AbstractFactory {

    /**
     * Factory method that returns an instance of the requested
     * WorkManager.
     *
     * @param obj         The possibly <code>null</code> object containing location or
     *                    reference information that can be used in creating an
     *                    object.
     * @param name        The name of this object relative to <code>nameCtx</code>,
     *                    or <code>null</code> if no name is specified.
     * @param nameCtx     The context relative to which the <code>name</code>
     *                    parameter is specified, or <code>null</code> if
     *                    <code>name</code> is relative to the default initial
     *                    context.
     * @param environment The possibly <code>null</code> environment that is #
     *                    used in creating the object.
     * @return The requested WorkManager
     * @throws Exception if this object factory encountered an exception while
     *                   attempting to create an object, and no other object
     *                   factories are to be tried.
     */
    public Object getObjectInstance(Object obj, Name name, Context nameCtx,
                                    Hashtable environment) throws Exception {

        // get work manager from map
        FooWorkManager workManager = (FooWorkManager) managers.get(name);
        if (workManager == null) {
            // lazy inititalization
            int minThreads = 2;
            int maxThreads = 10;
            int queueLength = 10;
            int maxDaemons = 10;

            // get config values
            Reference ref = (Reference) obj;
            Enumeration addrs = ref.getAll();
            while (addrs.hasMoreElements()) {
                RefAddr addr = (RefAddr) addrs.nextElement();
                String addrName = addr.getType();
                String addrValue = (String) addr.getContent();

                if (addrName.equals(CONFIG_MAX_THREADS)) {
                    maxThreads = getValue(addrName, addrValue);
                } else if (addrName.equals(CONFIG_MIN_THREADS)) {
                    minThreads = getValue(addrName, addrValue);
                } else if (addrName.equals(CONFIG_QUEUE_LENGTH)) {
                    queueLength = getValue(addrName, addrValue);
                } else if (addrName.equals("maxDaemons")) {
                    maxDaemons = getValue(addrName, addrValue);
                }
            }

            // more sanity checks on config values
            if (minThreads < 1) {
                throw new NamingException("minThreads can not be < 1.");
            }
            if (minThreads >= maxThreads) {
                throw new NamingException("minThreads can not be >= maxThreads.");
            }

            // create the thread pool for this work manager
            ThreadPool pool = new ThreadPool(minThreads, maxThreads, queueLength);

            // create the work manager
            workManager = new FooWorkManager(pool, maxDaemons);
            managers.put(name, workManager);
        }

        return workManager;
    }

}
