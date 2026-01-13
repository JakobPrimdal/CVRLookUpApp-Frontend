package dk.easv.cvrlookupapp.dal;

// Project imports
import dk.easv.cvrlookupapp.be.Cvr;

public interface IBackendClient {

    Cvr getCvrByNumber(String cvrNumber) throws Exception;

}
