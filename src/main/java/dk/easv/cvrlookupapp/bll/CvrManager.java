package dk.easv.cvrlookupapp.bll;

// Project imports
import dk.easv.cvrlookupapp.be.Cvr;
import dk.easv.cvrlookupapp.dal.CvrDAO;
import dk.easv.cvrlookupapp.dal.ICvrDAO;

public class CvrManager {

    ICvrDAO iCvrDAO = new CvrDAO();

    public Cvr getCvrByNumber(String cvrNumber) throws Exception {
        return iCvrDAO.getCvrByNumber(cvrNumber);
    }

}
