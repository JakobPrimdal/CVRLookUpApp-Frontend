package dk.easv.cvrlookupapp.dal;

// Project imports
import dk.easv.cvrlookupapp.be.Cvr;

public interface ICvrDAO {

    Cvr getCvrByNumber(String cvrNumber) throws Exception;

}
