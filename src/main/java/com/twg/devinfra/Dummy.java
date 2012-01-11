package com.twg.devinfra;


import java.util.ArrayList;
import java.util.Collection;
/*
 * @author Nicolas Seara
 */
public class Dummy {

    private String name;
    private Dependency dep = new Dependency();
    private Master mas = new Master();
    private Collection moreGarbage = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dependency getDep() {
        return dep;
    }

    public void setDep(Dependency dep) {
        this.dep = dep;
    }

    public Master getMas() {
        return mas;
    }

    public void setMas(Master mas) {
        this.mas = mas;
    }

    public Collection getMoreGarbage() {
        return moreGarbage;
    }

    public void setMoreGarbage(Collection moreGarbage) {
        this.moreGarbage = moreGarbage;
    }
}
