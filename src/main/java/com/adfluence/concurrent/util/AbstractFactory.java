/**
 * #(@) AbstractFactory.java Aug 16, 2006
 */
package com.adfluence.concurrent.util;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;
import java.util.Map;

/**
 * Abstract factory class.
 *
 * @author Andreas Keldenich
 */
public abstract class AbstractFactory implements ObjectFactory {

    /**
     * max number of threads in the pool
     */
    public static final String CONFIG_MAX_THREADS = "maxThreads";
    /**
     * min number of threads in the pool
     */
    public static final String CONFIG_MIN_THREADS = "minThreads";
    /**
     * length of the queue
     */
    public static final String CONFIG_QUEUE_LENGTH = "queueLenght";

    protected Map<Name, AbstractManager> managers = new Hashtable<Name, AbstractManager>();

    /**
     * Get an integer config value.
     *
     * @param name  config value name
     * @param value config value
     * @return integer value
     */
    protected int getValue(String name, String value) throws NamingException {
        int x = 0;
        try {
            x = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NamingException("Value " + name + " must be an integer.");
        }
        if (x < 0 || x > 100) {
            throw new NamingException("Value " + name + " out of range [0..100]");
        }
        return x;
    }


}
