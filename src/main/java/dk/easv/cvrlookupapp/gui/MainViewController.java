package dk.easv.cvrlookupapp.gui;

// Project imports
import dk.easv.cvrlookupapp.be.Cvr;

// Java imports
import dk.easv.cvrlookupapp.gui.utils.AlertHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Arrays;

public class MainViewController {

    MainViewModel model = new MainViewModel();

    @FXML private Label lblCompanyName;
    @FXML private TextField txtfieldCvrNum;
    @FXML private Label lblStatus;
    @FXML private Label lblCVR;
    @FXML private Label lblAddress;
    @FXML private Label lblFounded;
    @FXML private Label lblPhoneNum;
    @FXML private Label lblEmail;
    @FXML private Label lblFax;
    @FXML private Label lblWebsite;
    @FXML private Label lblProtected;
    @FXML private Label lblCompanyType;
    @FXML private Label lblIndustryCode;
    @FXML private Label lblStartDate;
    @FXML private Label lblEndDate;
    @FXML private Label lblOwners;
    @FXML private Label lblEmployees;

    @FXML
    private void handleSearch(ActionEvent actionEvent) {
        handleSearch();
    }

    @FXML
    private void onEnterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            handleSearch();
        }
    }

    private void handleSearch() {
        if (txtfieldCvrNum.getText().isBlank())
            return;

        String cvrNumber = txtfieldCvrNum.getText();

        if (cvrNumber == null || cvrNumber.trim().isEmpty()) {
            AlertHelper.showError("Error", "CVR number cannot be null or empty.");
            txtfieldCvrNum.clear();
            return;
        }

        String trimmedCvr = cvrNumber.trim();
        if (!trimmedCvr.matches("\\d+")) {
            AlertHelper.showError("Error", "CVR number must contain only digits.");
            txtfieldCvrNum.clear();
            return;
        }
        if (trimmedCvr.length() != 8) {
            AlertHelper.showError("Error", "CVR number must be exactly 8 digits long.");
            txtfieldCvrNum.clear();
            return;
        }


        try {
            Cvr company = model.getCvrByNumber(cvrNumber);

            lblCompanyName.setText(company.getName());
            lblStatus.setText(company.getStatus());
            lblCVR.setText("CVR: " + company.getVat());
            lblAddress.setText(company.getAddress() + ", " + company.getZipcode() + " " + company.getCity());
            lblFounded.setText(company.getStartdate());

            // Contact Info
            lblPhoneNum.setText("Tlf. nr.: " + company.getPhone());
            lblEmail.setText("Email: " + company.getEmail());
            lblFax.setText("Fax: " + company.getFax());
            lblWebsite.setText("Website: " + company.getWebsite());

            // Company details
            lblProtected.setText("Reklamebeskyttelse: " + company.getProtection());
            lblCompanyType.setText("Virksomhedstype: " + company.getCompanytype() + ", " + company.getCompanydesc());
            lblIndustryCode.setText("Branchekode: " + company.getIndustrycode() + ", " + company.getIndustrydesc());
            lblStartDate.setText("Startdato: " + company.getStartdate());
            lblEndDate.setText("Slutdato: " + company.getEnddate());

            // Ownership
            lblOwners.setText("Ejer(e): " + Arrays.toString(company.getOwners()).replace("[", "").replace("]", ""));
            lblEmployees.setText("Antal ansatte: " + company.getEmployees());

        } catch (Exception e) {
            AlertHelper.showError("Error", "Unable to search this CVR number. " + e.getMessage());
        }
    }
}
