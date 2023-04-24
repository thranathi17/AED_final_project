/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import Business.Business;
import UI.InsuranceJPanels.InsuranceAgentJFrame;
import UI.PatientJPanels.PatientJFrame;
import UserAccount.UserAccount;
import javax.swing.JFrame;

/**
 *
 * @author divya
 */
public class PatientRole extends Role {
     @Override
    public JFrame createWorkArea(Business business, UserAccount useraccount) {
        return new PatientJFrame(business,useraccount);
    }
}
