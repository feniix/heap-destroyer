package com.twg.devinfra;

import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/*
 * @author Nicolas Seara
 */

public class HeapDestroyerServlet extends HttpServlet {

    private ArrayList<Dummy> trashBin = new ArrayList<Dummy>();
    private static final long serialVersionUID = 1L;
    private static Logger LOG = LoggerFactory.getLogger(HeapDestroyerServlet.class);
    
    @Override
    public void init() throws ServletException {
        final long MEGABYTE = 1024L * 1024L;
        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.
        // Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        LOG.info("MAX HEAP SIZE IN MEGABYTES IS: {}", heapMaxSize / MEGABYTE);

        for (int i = 0; true; i++) {
            Dummy obj = new Dummy();
            Dependency dep = new Dependency();
            Master mas = new Master();

            dep.setMas(mas);

            obj.setName("Object number " + i);
            obj.setDep(dep);
            obj.setMas(new Master());
            obj.setMoreGarbage(trashBin);

            Dummy obj2 = new Dummy();
            Dependency dep2 = new Dependency();
            Master mas2 = new Master();

            dep2.setMas(mas2);

            obj2.setName("Object number " + i);
            obj2.setDep(dep2);
            obj2.setMas(new Master());
            obj2.setMoreGarbage(trashBin);

            Dummy obj3 = new Dummy();
            Dependency dep3 = new Dependency();
            Master mas3 = new Master();

            dep2.setMas(mas3);

            obj3.setName("Object number " + i);
            obj3.setDep(dep3);
            obj3.setMas(new Master());
            obj3.setMoreGarbage(trashBin);

            trashBin.add(obj);
            trashBin.add(obj2);
            trashBin.add(obj3);

            LOG.info("FREE Heap Size in Megabytes: {}", Runtime.getRuntime().freeMemory() / MEGABYTE);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
    }
}
