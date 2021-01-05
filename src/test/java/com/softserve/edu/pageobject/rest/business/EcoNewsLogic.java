package com.softserve.edu.pageobject.rest.business;

import com.softserve.edu.pageobject.rest.data.econewsdata.FirstNewsEntity;
import com.softserve.edu.pageobject.rest.services.EcoNewsServices;

public class EcoNewsLogic {

    private EcoNewsServices ecoNewsServices;

    public EcoNewsLogic() {
        ecoNewsServices = new EcoNewsServices();
    }

    public FirstNewsEntity activateFilterButton(String filterName) {
        return ecoNewsServices.getFirstNewsEntity(filterName);
    }

}
