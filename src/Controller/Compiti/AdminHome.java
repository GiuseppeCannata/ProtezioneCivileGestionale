package Controller.Compiti;

import Model.Volontario;
import View.BasicFrameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminHome extends MCHome{

    public AdminHome(BasicFrameView frame, Volontario UtenteLoggato) {

        super(frame, UtenteLoggato);
        getMcHomeview().VisibilitaResetButton(true);

        getMcHomeview().VisibilitaResetCompitiButton(true);
        getMcHomeview().VisibilitaResetRuoliButton(true);

        AdminHomeListener();
    }

    private void AdminHomeListener(){

        JButton ResetMC = getMcHomeview().getResetMCButton();
        ResetMC.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            Admin controller;
            controller = new Admin();
            controller.ResetMC(getBasicframe());

            }
        });

        JButton ResetCompiti = getMcHomeview().getResetCompitiButton();
        ResetCompiti.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(getBasicframe().OpotionalMessage("Resettare tutti i compiti ?")==0) {
                    Admin controller;
                    controller = new Admin("compiti");
                    controller.ResetAction(getUtenteloggato());
                }

            }
        });

        JButton ResetRuoli = getMcHomeview().getResetRuoliButton();
        ResetRuoli.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(getBasicframe().OpotionalMessage("Resettare tutti i ruoli ?")==0) {
                    Admin controller;
                    controller = new Admin("ruoli");
                    controller.ResetAction(getUtenteloggato());
                }

            }
        });
    }
}
