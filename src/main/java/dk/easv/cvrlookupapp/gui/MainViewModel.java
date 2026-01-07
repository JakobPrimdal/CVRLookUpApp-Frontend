package dk.easv.cvrlookupapp.gui;

// Project imports
import dk.easv.cvrlookupapp.be.Cvr;
import dk.easv.cvrlookupapp.bll.CvrManager;

public class MainViewModel {

    CvrManager cvrManager = new CvrManager();

    public Cvr getCvrByNumber(String cvrNumber) throws Exception{
        return cvrManager.getCvrByNumber(cvrNumber);
    }

}
