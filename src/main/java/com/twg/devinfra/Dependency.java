package com.twg.devinfra;
/*
 * @author Nicolas Seara
 */
public class Dependency {

    private Master mas = new Master();

    public Master getMas() {
        return mas;
    }

    public void setMas(Master mas) {
        this.mas = mas;
    }
}
