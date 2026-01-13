package dk.easv.cvrlookupapp.bll;

// Project imports
import dk.easv.cvrlookupapp.be.Cvr;
import dk.easv.cvrlookupapp.dal.BackendClient;
import dk.easv.cvrlookupapp.dal.IBackendClient;

public class CvrManager {

    IBackendClient iBackendClient = new BackendClient();

    public Cvr getCvrByNumber(String cvrNumber) throws Exception {
        return iBackendClient.getCvrByNumber(cvrNumber);
    }

}
