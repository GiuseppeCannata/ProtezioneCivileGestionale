package View;

import javax.swing.*;
import java.util.ArrayList;


public class VolontarioDView extends JPanel{


    private JPanel Intermedio0;
    private JButton addGiuntaComunaleButton;
    private JButton archivistaButton;
    private JLabel RUOLOVOLabel;
    private JLabel COGNOMEVOLabel;
    private JLabel NOMEVOLabel;
    private JButton referenteInformaticoButton;
    private JButton cambiaButton;
    private JLabel STATOLabel;
    private JButton master_ChiefButton;
    private JTabbedPane tabbedPane1;
    private JScrollPane ScrollPaneBroadcast;
    private JScrollPane ScrollPaneMessaggi;


    public VolontarioDView() {

        archivistaButton.setVisible(false);
        referenteInformaticoButton.setVisible(false);
        addGiuntaComunaleButton.setVisible(false);
        master_ChiefButton.setVisible(false);
        setVisible(true);

    }


    public JPanel getIntermedio0() {

        return Intermedio0;

    }

    public JButton getAddGiuntaComunaleButton() {

        return addGiuntaComunaleButton;

    }


    public JButton getArchivistaButton() {

        return archivistaButton;

    }

    public JButton getReferenteInformaticoButton() {

        return referenteInformaticoButton;

    }

    public JButton getCambiaButton() {

        return cambiaButton;

    }

    public JButton getMaster_ChiefButton() {

        return master_ChiefButton;

    }


    public void setBroadcast(ArrayList<String> MESSAGGI){

        JList listBroadcast = new JList(MESSAGGI.toArray());
        ScrollPaneBroadcast.setViewportView(listBroadcast);

    }

    public void seteMessaggi(ArrayList<String> MESSAGGI){

        JList listMessaggi = new JList(MESSAGGI.toArray());
        ScrollPaneMessaggi.setViewportView(listMessaggi);

    }


    public void setRUOLOVOLabel(String testo) {

        RUOLOVOLabel.setText(testo);

    }

    public void setSTATOLabel(String testo) {

        STATOLabel.setText(testo);

    }

    public void setCOGNOMEVOLabel(String testo) {

        COGNOMEVOLabel.setText(testo);

    }

    public void setNOMEVOLabel(String testo){

       NOMEVOLabel.setText(testo);

    }

    public void VisibilitaArchivistaButton(boolean visibilita){

        archivistaButton.setVisible(visibilita);

    }

    public void VisibilitaGiuntaButton(boolean visibilita){

        addGiuntaComunaleButton.setVisible(visibilita);

    }
    public void VisibilitaReferenteInformaticoButton(boolean visibilita){

        referenteInformaticoButton.setVisible(visibilita);

    }
    public void VisibilitaMasterChiefButton(boolean visibilita){

        master_ChiefButton.setVisible(visibilita);

    }




}
